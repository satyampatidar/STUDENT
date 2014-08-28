
package com.vedisoft.sis;


import java.sql.*;
import java.io.*;
import java.util.*;

public class Course {

    static Connection conn;
    int courseid;
    String coursename;
    String coursetype;


    public Course() {
        courseid = 0;
        coursename = new String();
        coursetype = new String();
        try {
            Properties pro = new Properties();
            InputStream in = getClass().getResourceAsStream("Message.properties");
            pro.load(in);
            String userName = pro.getProperty("UserName");
            String password = pro.getProperty("Password");
            String url = pro.getProperty("url");
            Class.forName(pro.getProperty("drivername")).newInstance();
            conn = DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            System.out.println("Unable to connect to database.");
        }
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }


    public boolean add() {
        int x = 0;
        try {

            Statement stmt = conn.createStatement();
            String sql = "Insert into course (coursename ,coursetype )  values('"+getCoursename()+"','" + getCoursetype() + "')";
            int y = 0;
            y = stmt.executeUpdate(sql);
            if (y == 0) {

                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean update() {
        int y = 0;

        try {

            Statement stmt = conn.createStatement();
            String sql = "Update course set coursename='" + getCoursename() + "',coursetype='" + getCoursetype() + "' where courseid = " + getCourseid();
            y = stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        if (y == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean delete() {
        int x = 0;

        try {

            Statement stmt = conn.createStatement();
            String sql = "delete from course where courseid= " + getCourseid();
            System.out.println(sql);
            x = stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        if (x == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Vector getRecords() {
        Vector rows = new Vector();
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select * from course";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector cr = new Vector();
                cr.addElement(rs.getString(1));
                cr.addElement(rs.getString(2));
                cr.addElement(rs.getString(3));
                rows.addElement(cr);
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return rows;
    }

    public Course getRecord(int num) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select * from course Limit " + (num - 1) + ",1";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                setCourseid(rs.getInt(1));
                setCoursename(rs.getString(2));
                setCoursetype(rs.getString(3));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return this;
    }

    public int getTotal() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select * from course ";
            ResultSet rs = stmt.executeQuery(sql);
            boolean b = rs.last();
            if (b) {
                return rs.getRow();
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to Fetch total number of rows.");
        }
        return 0;
    }

    public static void main(String[] args) {
        Course c=new Course();
        System.out.println(new Course().getRecord(4).getCoursename());
    }
}
