package com.university.app;

import java.sql.*;


public class DbSetup {

    private final Connection connection;

    public DbSetup(){
        this.connection = DbConnection.getInstance().getDbConnection();
    }

    public void setUp() {

        createTables();
        insertQueries();
        createViews();
        DbConnection.getInstance().closeConnection();
    }

    /**
     * Creating the tables
     * */
    public void createTables() {

        try {

            Statement stmt = connection.createStatement();
            // Drop Existing Tables If exists
            stmt.execute(QueriesConstants.DROP_GRADE_TABLE);
            stmt.execute(QueriesConstants.DROP_COURSE_TABLE);
            stmt.execute(QueriesConstants.DROP_STUDENT_TABLE);
            stmt.execute(QueriesConstants.DROP_TEACHER_TABLE);

            stmt.execute(QueriesConstants.CREATE_STUDENT_TABLE);
            stmt.execute(QueriesConstants.CREATE_TEACHER_TABLE);
            stmt.execute(QueriesConstants.CREATE_COURSE_TABLE);
            stmt.execute(QueriesConstants.CREATE_GRADE_TABLE);
            stmt.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert data into tables
     * */
    public void insertQueries() {

        //Insert into Students table
        int[] studentId = {1594401, 1594402, 1594403, 1594404, 1594405, 1594406, 1594407, 1594408, 1594409, 1594410};
        String[] fname = {"ALBERT", "CLARK", "PREETI", "HARSHINEE", "JUSTIN", "PIYUSH", "KAUSTUB", "ZAC","BENITA","NOLITA"};
        String[] lname = {"EINSTEIN", "KENT", "KUMARI", "CHITTI", "COLE","BAG", "KUMAR", "KARAT", "REGO","REGO"};
        String[] email = {"aeinstein@scu.edu", "ckent@scu.edu", "pbhosale@scu.edu", "hchitti@scu.edu", "jcole@scu.edu", "pbagasd@scu.edu", "kpimpaasdrkar@scu.edu", "zkarat@scu.edu", "brego@scu.edu", "nrego@scu.edu"};

        for(int i=0; i<studentId.length; i++) {
            try{
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO STUDENT(STUDENT_ID, STUDENT_FIRST_NAME, STUDENT_LAST_NAME, STUDENT_EMAIL) VALUES (?, ?, ?, ?)");
                stmt.setInt(1, studentId[i]);
                stmt.setString(2, fname[i]);
                stmt.setString(3, lname[i]);
                stmt.setString(4, email[i]);
                stmt.execute();
                stmt.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        System.out.println("Students Added");

        //Insert into Teachers table
        int[] teacherId = {9994401, 9994402, 9994403, 9994404, 9994405, 9994406, 9994407, 9994408, 9994409, 9994410};
        String[] teacherFirstName = {"AHMED", "ALEX", "WEIJIANG", "ALBUS", "KEVYAN", "YUAN", "VALERIE", "ZAC","BENITA","NOLITA"};
        String[] teacherLastName = {"EZZAT", "WANG", "SHANG", "DUMBLEDORE", "MOATAGHED","WANG", "FRIZZLE", "KARAT", "REGO","GANTI"};
        String[] teacherEmail = {"aezzat@scu.edu", "awang@scu.edu", "wshang@scu.edu", "adumbledore@scu.edu", "kmoataghed@scu.edu", "ywang@scu.edu", "vfrizzle@scu.edu",
                    "zkarat@scu.edu", "brego@scu.edu", "nganti@scu.edu"};
        for(int i=0; i<studentId.length; i++) {
            try{
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO TEACHER(TEACHER_ID, TEACHER_FIRST_NAME, TEACHER_LAST_NAME, TEACHER_EMAIL) VALUES (?, ?, ?, ?)");
                stmt.setInt(1, teacherId[i]);
                stmt.setString(2, teacherFirstName[i]);
                stmt.setString(3, teacherLastName[i]);
                stmt.setString(4, teacherEmail[i]);
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Instructors Added");

        //Insert into Courses in table
        int[] cid = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
        String[] name = {"DBMS", "OS", "DAA", "CN", "CA", "ADBMS", "ML", "MAD","AWP","NET"};
        int[] cunits = {4, 4, 4, 4, 4, 4, 4, 2, 2, 2};
        int[] csize = {30, 10, 25, 15, 30, 20, 25, 20, 30, 35};
        String[] cdesc = {"LEARNING ABOUT SQL AND DB", "LEARNING ABOUT PARALLELISM AND CONCURRENCY", "LEARNING ABOUT DESIGN AND ANALYSIS OF ALGORITHMS", "LEARNING ABOUT NETWORK TOPOLOGY AND PROTOCOLS", "EARNING ABOUT MICROPROCESSORS AND ARCHITECTURE", "LEARNING ABOUT NO SQL AND QUERY OPTIMIZATION, INDEXING", "INTRODUCTION TO MACHINE LEARNING", "LEARNING ABOUT ANDROID STUDIO AND JAVA", "LEARNING ABOUT ADVANCED WEB TECHNOLOGIES WITH RUBY", "LEARNING ABOUT NETWORKS"};
        int[] tid = {9994401, 9994402, 9994403, 9994404, 9994405, 9994402, 9994403, 9994404, 9994405, 9994406};

        for(int i=0; i<cid.length; i++) {
            try{
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO COURSE(COURSE_ID, COURSE_NAME, COURSE_UNITS_MAX, COURSE_MAX_SIZE, COURSE_DESCRIPTION, TEACHER_ID) VALUES (?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, cid[i]);
                stmt.setString(2, name[i]);
                stmt.setInt(3, cunits[i]);
                stmt.setInt(4, csize[i]);
                stmt.setString(5, cdesc[i]);
                stmt.setInt(6, tid[i]);
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Courses Added");

        //Insert into Grade table
        int[] courseId = {101, 103, 102, 105, 104, 106, 107, 108, 109, 110, 101, 102, 103, 104, 105, 105};
        int[] studentIds = {1594401, 1594402, 1594402, 1594403, 1594404, 1594404, 1594403, 1594405, 1594406,
                1594406, 1594407, 1594401, 1594409, 1594405, 1594407, 1594410};
        double[] units = {3.8, 3.5, 3.4, 3.4, 3.7, 3.2, 3.5, 3.4, 3.4, 3.7, 3.2, 3.7, 4.0, 3.4, 3.7, 4.0};
        // int count = cid.length;
        for(int i=0; i<courseId.length; i++) {
            try{
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO GRADE(COURSE_ID, STUDENT_ID, UNITS_EARNED) VALUES (?, ?, ?)");

                stmt.setInt(1, courseId[i]);
                stmt.setInt(2, studentIds[i]);
                stmt.setDouble(3, units[i]);
                stmt.execute();
                stmt.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        System.out.println("Grades Added");
    }

    public void createViews() {

        String studentGpaView = "CREATE or replace VIEW student_gpa AS\n" +
                "SELECT student_id, student_first_name, student_last_name,\n" +
                "student_email,\n" +
                "(SUM(units_earned) / SUM(COURSE_UNITS_MAX)) * 4 AS gpa\n" +
                "FROM student\n" +
                "NATURAL JOIN grade\n" +
                "NATURAL JOIN course\n" +
                "GROUP BY student_id, student.student_first_name,\n" +
                "student.student_last_name, student.student_email";

        try {
            PreparedStatement stmt = connection.prepareStatement(studentGpaView);
            stmt.execute();
            stmt.close();
        }catch (SQLException e) { e.printStackTrace(); }
        System.out.println("STUDENT_GPA VIEW Created");
    }
}
