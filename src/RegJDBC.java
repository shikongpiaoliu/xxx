import java.sql.*;
import java.io.*;
import java.util.*;


public class RegJDBC {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/"+"shujukuming"+"?useUnicode=true&characterEncoding=utf8";
    private static String username="root";
    private static String password="114514";/*密码*/


    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void insert(String username,String password){
        String sql="insert into users (username,password) values (?,?)";
        Connection conn=getConnection();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectById(String id){
        String sql="select * from users where id = ?";
        Connection conn=getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("id: "+resultSet.getString("id")+"   username:"+ resultSet.getString("username")+"   password:"+ resultSet.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public  List selectByUsername(String username){
        List wenjuans=new ArrayList();
        String sql="select * from wenjuans where username = ?";
        Connection conn=getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                title wenjuan=new title();
                wenjuan.settitle(resultSet.getString("title"));
                wenjuans.add(wenjuan);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wenjuans;
    }

    public static void update(String id,String newPassword) {
        String sql="update users SET password = ? where id = ?";
        Connection conn=getConnection();
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(String id){
        String sql="delete from users where id = ? ";
        Connection conn=getConnection();
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void truncate(){//忘了这是干什么的了（删除表数据）
        String sql="TRUNCATE TABLE users";
        Connection conn=getConnection();
        PreparedStatement preparedStatement=null;
        try{
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getCount(){
        int count = 0;
        String sql="select count(*) from users";
        Connection conn=getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            preparedStatement=conn.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(""+count);
        return 0;
    }

    public static String getUsername(String id) {
        String sql="select * from users where id = ?";
        Connection conn=getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getString("username");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    public static String getPassword(String id) {
        String sql="select * from users where id = ?";
        Connection conn=getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getString("password");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    public static String getPasswordByUsername(String username) {
        String sql="select * from users where username = ?";
        Connection conn=getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("password");
            }
            else
                return "1";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    class title{
        public String title;
        public void settitle(String title){
            this.title=title;
        }
    }
}
