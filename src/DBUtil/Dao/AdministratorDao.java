package DBUtil.Dao;

import model.Administrator;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministratorDao {
    public static Administrator login(Connection con, Administrator stu)throws Exception
    {
        Administrator resultUser = null;
        String sql = "select * from administrator where id = ? and pwd = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,stu.getId());
        ps.setString(2,stu.getPwd());
        ResultSet rs = ps.executeQuery();
//如果查询到了该学生的记录，就会实例化这个学生
        if (rs.next()) {
            resultUser = new Administrator();
            resultUser.setId(rs.getString("id"));
            resultUser.setName(rs.getString("name"));
            resultUser.setPwd(rs.getString("pwd"));
            resultUser.setSex(rs.getString("sex"));
        }
        return resultUser;
    }
    public static int find(Connection con, Administrator stu)throws Exception
    {
        Administrator resultUser = null;
        String sql = "select * from administrator where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,stu.getId());
        ResultSet rs = ps.executeQuery();
//如果查询到了该学生的记录，就会实例化这个学生
        if (rs.next()) {
            return 1;
        }
        return 0;
    }
    public static void update(Connection con, Administrator stu)throws Exception
    {
        String sqls=" insert into administrator values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sqls);
        ps.setString(1,stu.getId());
        ps.setString(2,stu.getName());
        ps.setString(3,stu.getSex());
        ps.setString(5,stu.getPwd());
        ps.setString(4, stu.getBirthday());
        ps.setString(6,stu.getMajor());
        ps.setString(7,stu.getInstitute());
        ps.executeUpdate();

    }
    public static void refresh(Connection coon, Administrator stu)throws Exception
    {
        String sql = "update administrator set name = ?, sex = ?, birthday = ?, pwd = ?, Major = ?, institute = ? ,,where id = ?";
        PreparedStatement ps = coon.prepareStatement(sql);
        ps.setString(1,stu.getName());
        ps.setString(2,stu.getSex());
        ps.setString(3,stu.getBirthday());
        ps.setString(4,stu.getPwd());
        ps.setString(5,stu.getMajor());
        ps.setString(6,stu.getInstitute());

        ps.executeUpdate();

    }
    public static void delete(Connection con, String id)throws Exception
    {
        String sql = "delete from administrator where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();

    }
}
