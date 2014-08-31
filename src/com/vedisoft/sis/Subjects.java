//Table Creation

/*
Create Table Subjects(
subjectid int(7),
subjectcode varchar(20),
subjectname varchar(20),
semester int(7),
courseid int(7));
 */
//Package Creation
package com.vedisoft.sis;

//Importing Packages
import java.sql.*;
import java.io.*;
import java.util.*;

public class Subjects {

    static Connection conn;
    int subjectid;
    String subjectcode;
    String subjectname;
    int semester;
    int courseid;
    Vector ids;
    Vector courses;

//Constructors Definition
    public Subjects() {
        subjectid = 0;
        subjectcode = new String();
        subjectname = new String();
        semester = 0;
        courseid = 0;
        ids = new Vector();
        courses = new Vector();
        try {
            Properties pro = new Properties();
            InputStream in = getClass().getResourceAsStream("Message.properties");
            pro.load(in);
            String userName = pro.getProperty("UserName");
            String password = pro.getProperty("Password");
            String url = pro.getProperty("url");
            Class.forName(pro.getProperty("drivername")).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            populate();
        } catch (Exception e) {
            System.out.println("Unable to connect to database.");
        }
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public Vector getIds() {
        return ids;
    }

    public Vector getCourses() {
        return courses;
    }

    public void setIds(Vector ids) {
        this.ids = ids;
    }

    public void setCourses(Vector courses) {
        this.courses = courses;
    }

    public void populate() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select CourseId, CourseName from course";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ids.addElement(rs.getInt(1));
                courses.addElement(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//Method to Add Record
    public boolean add() {
        int x = 0;
        try {
            Statement stmt = conn.createStatement();

            int cid = ((Integer) ids.elementAt(courseid)).intValue();

            String sql = "Insert into subjects (subjectcode ,subjectname ,semester ,courseid )  values('" + getSubjectcode() + "','" + getSubjectname() + "'," + getSemester() + "," + cid + ")";
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
            int cid = ((Integer) ids.elementAt(courseid)).intValue();
            String sql = "Update subjects set subjectcode='" + getSubjectcode() + "',subjectname='" + getSubjectname() + "',semester=" + getSemester() + ",courseid=" + cid + " where subjectid = " + getSubjectid();
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
            String sql = "delete from subjects where subjectid= " + getSubjectid();
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

    public Vector getRecords(int id) {
        Vector rows = new Vector();
        try {
            Statement stmt = conn.createStatement();
            int cid = ((Integer) ids.elementAt(id)).intValue();
            String sql = "SELECT  subjectcode ,subjectname ,semester FROM subjects where  courseid=" + cid;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector temp = new Vector();
                temp.addElement(rs.getString(1));
                temp.addElement(rs.getString(2));
                temp.addElement(new Integer(rs.getInt(3)));
                rows.addElement(temp);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Here One");
            return null;
        }
        return rows;
    }

    public Subjects getRecord(int num) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select * from subjects Limit " + (num - 1) + ", 1";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                setSubjectid(rs.getInt(1));
                setSubjectcode(rs.getString(2));
                setSubjectname(rs.getString(3));
                setSemester(rs.getInt(4));
                int sid = rs.getInt(5);
                int index = ids.indexOf(new Integer(sid));
                setCourseid(index);
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
            String sql = "Select * from subjects ";
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

    public Vector getRecordsOne(int cid) {
        Vector rows = new Vector();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT  subjectcode ,subjectname ,semester FROM subjects p, course c where p.courseid=c.courseid and c.courseid=" + cid;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Vector temp = new Vector();
                temp.addElement(rs.getString(1));
                temp.addElement(rs.getString(2));
                temp.addElement(new Integer(rs.getInt(3)));
                rows.addElement(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Here One");
            return null;
        }
        return rows;
    }

    public Vector getColumns() {
        Vector columns = new Vector();
        columns.add("Subject Code");
        columns.add("Subject Name");
        columns.add("Semester");
        return columns;
    }

    public Vector getRecordsTwo() {
        Vector rows = new Vector();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT  * from course";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                int cid = rs.getInt(1);
                String cname = rs.getString(2);
                Vector columns = new Vector();
                columns.add(cname);
                columns.add(new String());
                columns.add(new String());
                columns.add(new String());
                columns.add(new String());
                rows.add(columns);
                Statement stmt1 = conn.createStatement();
                String sql1 = "select subjectcode ,subjectname ,semester FROM subjects where courseid=" + cid;
                System.out.println(sql1);
                ResultSet rs1 = stmt1.executeQuery(sql1);
                while (rs1.next()) {
                    String scode = rs1.getString(1);
                    String sname = rs1.getString(2);
                    int sem = rs1.getInt(3);

                    Vector columns1 = new Vector();
                    columns1.add(new String());
                    columns1.add(scode);
                    columns1.add(sname);
                    columns1.add(new Integer(sem));
                    rows.add(columns1);
                }
                stmt1.close();
                rs1.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Here One");
            return null;
        }
        return rows;
    }

    public Vector getColumnsOne() {
        Vector columns = new Vector();
        columns.add("Course Name");
        columns.add("Subject Code");
        columns.add("Subject Name");
        columns.add("semester");
        return columns;
    }

    public static void main(String[] args) {
        Subjects ss = new Subjects();
     //   System.out.println(ss.getRecordsOne(5));
System.out.println(""+ss.getIds());
}
}
