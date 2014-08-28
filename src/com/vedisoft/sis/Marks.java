/**
 *
/**
 * @author Rohit Ahuja
 * rohitahuja@email.com
 * 9893075987
 */
//Table Creation

/*
Create Table Marks(
marksid int(7),
subjectid int(7),
studentid int(7),
marks int(7));
 */
//Package Creation
package com.vedisoft.sis;

//Importing Packages
import java.sql.*;
import java.io.*;
import java.util.*;

public class Marks {

    static Connection conn;
    int marksid;
    int subjectid;
    int studentid;
    int marks;
    Vector studentids;
    Vector students;
    Vector subjectids;
    Vector subjects;

//Constructors Definition
    public Marks() {
        marksid = 0;
        subjectid = 0;
        studentid = 0;
        marks = 0;
        studentids = new Vector();
        students = new Vector();
        subjectids = new Vector();
        subjects = new Vector();
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

    public Vector getStudedentids() {
        return studentids;
    }

    public void setStudents(Vector students) {
        this.students = students;
    }

    public Vector getSubjects() {
        return subjects;
    }

    public void setStudedentids(Vector studedentids) {
        this.studentids = studedentids;
    }

    public Vector getSubjectids() {
        return subjectids;
    }

    public Vector getStudents() {
        return students;
    }

    public void setSubjectids(Vector subjectids) {
        this.subjectids = subjectids;
    }

    public void setSubjects(Vector subjects) {
        this.subjects = subjects;
    }
//Get and Set Methods

    public int getMarksid() {
        return marksid;
    }

    public void setMarksid(int marksid) {
        this.marksid = marksid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

//Method to Add Record
    public void populate() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select subjectId, subjectName from subjects";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                subjectids.addElement(rs.getInt(1));
                subjects.addElement(rs.getString(2));
            }

            stmt = conn.createStatement();
            sql = "Select studentId, firstName ,middlename,lastname from student";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                studentids.addElement(rs.getInt(1));
                students.addElement(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean add() {
        int x = 0;

        try {

            Statement stmt = conn.createStatement();
            int sbid = ((Integer) subjectids.elementAt(subjectid)).intValue();
            int stid = ((Integer) studentids.elementAt(studentid)).intValue();
            String sql = "Insert into marks (subjectid ,studentid ,marks )  values(" + sbid + "," + stid + "," + getMarks() + ")";
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
            int sbid = ((Integer) subjectids.elementAt(subjectid)).intValue();
            int stid = ((Integer) studentids.elementAt(studentid)).intValue();
            String sql = "Update marks set subjectid=" + sbid + ",studentid=" + stid + ",marks=" + getMarks() + " where marksid = " + getMarksid();
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
            String sql = "delete from marks where marksid= " + getMarksid();
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

    public Marks getRecord(int num) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select * from marks Limit " + (num-1) + ",1";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                setMarksid(rs.getInt(1));

                int subid = rs.getInt(2);
                int index1 = subjectids.indexOf(new Integer(subid));

                setSubjectid(index1);

                int stuid = rs.getInt(3);
                int index2 = studentids.indexOf(new Integer(stuid));

                setStudentid(index2);
                setMarks(rs.getInt(4));
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
            String sql = "Select * from marks";
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

    public Vector getRecordsOne(String eno) {
        Vector rows = new Vector();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select studentid,firstname ,middlename,lastname,c.coursename,semester,dob,c.courseid from student s ,course c where s.courseid=c.courseid and enrollno='" + eno + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            int cid = 0, sid = 0;
            while (rs.next()) {
                sid = rs.getInt(1);
                Vector temp1 = new Vector();
                Vector temp2 = new Vector();
                Vector temp3 = new Vector();
                Vector temp4 = new Vector();
                temp1.addElement("Name ");
                temp1.addElement(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                temp2.addElement("Course ");
                temp2.addElement(rs.getString(5));
                temp3.addElement("Semester ");
                temp3.addElement(rs.getString(6));
                temp4.addElement("Data Of Birth ");
                temp4.addElement(rs.getString(7));
                cid = rs.getInt(8);
                rows.addElement(temp1);
                rows.addElement(temp2);
                rows.addElement(temp3);
                rows.addElement(temp4);
            }

            stmt = conn.createStatement();
            sql = "select subjectname ,marks from subjects s,marks m where s.courseid=" + cid + " and m.subjectid=s.subjectid and m.studentid=" + sid;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            Vector temp9 = new Vector();
            temp9.addElement("Subject Name ");
            temp9.addElement("Marks ");

            rows.addElement(temp9);
            while (rs.next()) {
                Vector temp = new Vector();
                temp.addElement(rs.getString(1));
                temp.addElement(rs.getString(2));
                rows.addElement(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Here One");
            return null;
        }
        return rows;
    }

    public static void main(String[] args) {
        Marks m1 = new Marks();
        System.out.println(m1.getRecordsOne("111"));

        m1.getTotal();

    }
}
/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 *
 *   Vedisoft Software & Education Services Pvt. Ltd.
 *   Plot No. 275, Zone II, M.P. Nagar,
 *   Bhopal.
 *   Phone : 0755 - 4076207, 4076208
 *   Email : contact@vedisoft.com
 *   Web : www.vedisoft.com
 */
