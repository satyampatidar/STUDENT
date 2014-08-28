/**
 *
/**
 * @author Rohit Ahuja
 * rohitahuja@email.com
 * 9893075987
 */
//Table Creation

/*
Create Table Student(
studentid int(7),
enrollno varchar(20),
firstname varchar(20),
middlename varchar(20),
lastname varchar(20),
address varchar(20),
mobile varchar(20),
email varchar(20),
semester int(7),
dob date,
courseid int(7));
 */
//Package Creation
package com.vedisoft.sis;

//Importing Packages
import java.sql.*;
import java.util.*;
import java.io.*;

public class Student {

    static Connection conn;
    Vector ids;
    Vector courses;
    int studentid;
    String enrollno;
    String firstname;
    String middlename;
    String lastname;
    String address;
    String mobile;
    String email;
    int semester;
    String dob;
    int courseid;

//Constructors Definition
    public Student() {
        studentid = 0;
        enrollno = new String();
        firstname = new String();
        middlename = new String();
        lastname = new String();
        address = new String();
        mobile = new String();
        email = new String();
        semester = 0;
        dob = new String();
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

    public void setIds(Vector ids) {
        this.ids = ids;
    }

    public void setCourses(Vector courses) {
        this.courses = courses;
    }

    public Vector getIds() {
        return ids;
    }

    public Vector getCourses() {
        return courses;
    }
//Get and Set Methods

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getEnrollno() {
        return enrollno;
    }

    public void setEnrollno(String enrollno) {
        this.enrollno = enrollno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
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
            String sql = "Insert into student (enrollno ,firstname ,middlename ,lastname ,address ,mobile ,email ,semester ,dob ,courseid )  values('" + getEnrollno() + "','" + getFirstname() + "','" + getMiddlename() + "','" + getLastname() + "','" + getAddress() + "','" + getMobile() + "','" + getEmail() + "'," + getSemester() + ",'" + getDob() + "'," + cid + ")";
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
            String sql = "Update student set enrollno='" + getEnrollno() + "',firstname='" + getFirstname() + "',middlename='" + getMiddlename() + "',lastname='" + getLastname() + "',address='" + getAddress() + "',mobile='" + getMobile() + "',email='" + getEmail() + "',semester=" + getSemester() + ",dob='" + getDob() + "',courseid=" + cid + " where studentid = " + getStudentid();
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
            String sql = "delete from student where studentid= " + getStudentid();
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

    public Student getRecord(int num) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select * from student Limit " + (num - 1) + ",1";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                return null;
            } else {
                setStudentid(rs.getInt(1));
                setEnrollno(rs.getString(2));
                setFirstname(rs.getString(3));
                setMiddlename(rs.getString(4));
                setLastname(rs.getString(5));
                setAddress(rs.getString(6));
                setMobile(rs.getString(7));
                setEmail(rs.getString(8));
                setSemester(rs.getInt(9));
                setDob(rs.getString(10));

                int cid = rs.getInt(11);
                int index = ids.indexOf(new Integer(cid));

                setCourseid(index);
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
            String sql = "Select * from student ";
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

    public Vector getRecords(String name) {
        Vector rows = new Vector();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT  * FROM student where  firstname like '%" + name + "%' or middlename like '%" + name + "%' or lastname like '%" + name + "%'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Vector temp = new Vector();
                temp.addElement(rs.getString(2));
                temp.addElement(rs.getString(3));
                temp.addElement(rs.getString(4));
                temp.addElement(rs.getString(5));
                temp.addElement(rs.getString(6));
                temp.addElement(rs.getString(7));
                temp.addElement(rs.getString(8));
                temp.addElement(rs.getString(9));
                temp.addElement(rs.getString(10));
                int i = ids.indexOf(rs.getInt(11));
                Course c = new Course();
                c = c.getRecord(i);
                System.out.println(i);
                temp.addElement(rs.getInt(11));
                rows.addElement(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Here One");
            return null;
        }
        return rows;
    }

    public Vector getColumns(int cid) {
        Vector columns = new Vector();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select subjectname from subjects where courseid=" + cid;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            columns.addElement("");
            while (rs.next()) {
                columns.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return columns;
    }

    public Vector getRecordsOne(int cid, int sem) {
        Vector rowss = new Vector();
        try {

            Statement stmt = conn.createStatement();
            String sql = "select studentid,firstname,middlename,lastname from student where courseid=" + cid + " and semester=" + sem;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector rows = new Vector();
                int sid = rs.getInt(1);
                rows.addElement(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                stmt = conn.createStatement();
                String sql1 = "select subjectid from subjects where courseid=" + cid;
                ResultSet rs1 = stmt.executeQuery(sql1);
                while (rs1.next()) {
                    stmt = conn.createStatement();
                    String sql2 = "select marks from marks where subjectid=" + rs1.getInt(1) + " and studentid=" + sid;
                    ResultSet rs2 = stmt.executeQuery(sql2);
                    rs2.next();
                    rows.addElement(rs2.getString(1));
                }
                rowss.add(rows);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Here One");
            return null;
        }
        return rowss;
    }

    public Vector getColumns() {
        Vector columns = new Vector();
        columns.add("Enrollment No");
        columns.add("First Name");
        columns.add("Middle Name");
        columns.add("Last Name");
        columns.add("Address");
        columns.add("Mobile");
        columns.add("Email");
        columns.add("Semester");
        columns.add("Date Of Birth");
        columns.add("Course");
        return columns;
    }

    public static void main(String[] args) {
        Student ss = new Student();

        System.out.println(ss.getColumns(5));
        System.out.println(ss.getRecordsOne(5, 3));
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
