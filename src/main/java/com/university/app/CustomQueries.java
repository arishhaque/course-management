package com.university.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomQueries {

    private final Connection connection;

    public CustomQueries(){
        this.connection = DbConnection.getInstance().getDbConnection();
    }

    public void viewAllStudents() {

        System.out.println("SELECT * FROM student");
        System.out.println("Student data: id - firstname - lastname - email");
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM student"); ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                int student_id = rs.getInt(1);
                String student_first_name = rs.getString(2);
                String student_last_name = rs.getString(3);
                String student_email = rs.getString(4);
                String output = "Student #%d: %d - %s - %s - %s";
                System.out.println(String.format(output, ++count, student_id, student_first_name, student_last_name, student_email));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }


    public void viewAllInstructors() {
        System.out.println("SELECT * FROM teacher");
        System.out.println("Teacher data: id - firstname - lastname - email");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM teacher"); ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                int teacher_id = rs.getInt(1);
                String teacher_first_name = rs.getString(2);
                String teacher_last_name = rs.getString(3);
                String teacher_email = rs.getString(4);
                String output = "Teacher #%d: %d - %s - %s - %s";
                System.out.println(String.format(output, ++count, teacher_id, teacher_first_name, teacher_last_name, teacher_email));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void viewAllCourses() {

        System.out.println("SELECT * FROM course");
        System.out.println("Course data: id - name - course units - course max size - description - teacher assigned");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM course");
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                int course_id = rs.getInt(1);
                String course_name = rs.getString(2);
                int course_units = rs.getInt(3);
                int course_size = rs.getInt(4);
                String course_desc = rs.getString(5);
                int teacher_id = rs.getInt(6);
                String output = "Course #%d: %d - %s - %s - %s"; System.out.println(String.format(output, ++count, course_id, course_name,
                    course_units, course_size, course_desc, teacher_id));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }


    public void viewAllGrades() {

        System.out.println("SELECT * FROM Grade");
        System.out.println("Grade data: course id - student id - units earned");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM grade");
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                int course_id = rs.getInt(1);
                int student_id = rs.getInt(2);
                Double units_earned = rs.getDouble(3);
                String output = "Grade #%d: %d - %d - %f";
                System.out.println(String.format(output, ++count, course_id, student_id, units_earned));
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void viewAllStudentsGPA() {

        System.out.println("SELECT * FROM student_gpa");
        System.out.println("Student gpa data: id - firstname - lastname - email - gpa");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM student_gpa");
            ResultSet rs = stmt.executeQuery(); int count = 0;
            while (rs.next()) {
                int student_id = rs.getInt(1);
                String student_first_name = rs.getString(2);
                String student_last_name = rs.getString(3);
                String student_email = rs.getString(4);
                double gpa = rs.getDouble(5);
                String output = "Student #%d: %d - %s - %s - %s - %f";
                System.out.println(String.format(output, ++count, student_id, student_first_name, student_last_name, student_email, gpa));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void viewStudentsTotalUnits() {

        System.out.println("SELECT student_id, SUM(units_earned) AS total_units_earned FROM student NATURAL JOIN grade WHERE student_id = 1594402 GROUP BY student_id");
        System.out.println("id - units earned");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT student_id, SUM(units_earned) AS total_units_earned FROM student NATURAL JOIN grade WHERE student_id = 1594402 GROUP BY student_id");
            ResultSet rs = stmt.executeQuery(); int count = 0;
            while (rs.next()) {
                int student_id = rs.getInt(1);
                double units_earned = rs.getDouble(2);
                String output = "Student #%d: %d - %f";
                System.out.println(String.format(output, ++count, student_id, units_earned));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void viewGradesDescending() {

        System.out.println("SELECT * FROM grade ORDER BY units_earned DESC"); System.out.println("Grade data: course id - student id - units earned");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM grade ORDER BY units_earned DESC");
            ResultSet rs = stmt.executeQuery(); int count = 0;
            while (rs.next()) {

                int course_id = rs.getInt(1);
                int student_id = rs.getInt(2);
                double units_earned = rs.getDouble(3);
                String output = "Grade #%d: %d - %d - %f";
                System.out.println(String.format(output, ++count, course_id, student_id, units_earned));
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void viewAllTwoUnitsCourses() {

        System.out.println("SELECT * FROM course WHERE COURSE_UNITS_MAX = 2");
                System.out.println("Course data: id - name - course units - course max size - description - teacher assigned");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM course WHERE COURSE_UNITS_MAX = 2");
            ResultSet rs = stmt.executeQuery(); int count = 0;
            while (rs.next()) {
                int course_id = rs.getInt(1);
                String course_name = rs.getString(2);
                int course_units = rs.getInt(3);
                int course_size = rs.getInt(4);
                String course_desc = rs.getString(5);
                int teacher_id = rs.getInt(6);
                String output = "Course #%d: %d - %s - %s - %s";
                System.out.println(String.format(output, ++count, course_id, course_name, course_units, course_size, course_desc, teacher_id));
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void viewStudentsGradeForAllCourses() {

        System.out.println("SELECT course_id, course_name FROM course WHERE course_id IN (SELECT course_id FROM grade WHERE student_id = 1594402)");
        System.out.println("Course data: id - name");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT course_id, course_name FROM course WHERE course_id IN (SELECT course_id FROM grade WHERE student_id = 1594402)");
            ResultSet rs = stmt.executeQuery(); int count = 0;
            while (rs.next()) {
                int course_id = rs.getInt(1);
                String course_name = rs.getString(2);
                String output = "Course #%d: %d - %s";
                System.out.println(String.format(output, ++count, course_id, course_name));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void viewAverageGradeForCourse() {

        System.out.println("SELECT course_id, course_name, AVG((units_earned/course_units_max) * 4) AS average_units_earned FROM course NATURAL JOIN grade WHERE course_id = 103 \n" +
                "GROUP BY course_id, course_name");
        System.out.println("Course data: id - name - average_earned_units");
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT course_id, course_name, AVG((units_earned/course_units_max) * 4) AS average_units_earned FROM course NATURAL JOIN grade GROUP BY course_id, course_name");
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                int course_id = rs.getInt(1);
                String course_name = rs.getString(2);
                double avg_units_earned = rs.getDouble(3);
                String output = "Course #%d: %d - %s - %.2f";
                System.out.println(String.format(output, ++count, course_id, course_name, avg_units_earned));
            }
        }catch (SQLException e) { e.printStackTrace(); }

    }

    // 3-way join of student,course and grade
    public void threeWayJoin() {

        System.out.println("select student_id, student_first_name, student_last_name, course_id, course_name from student natural join grade natural join course");
        System.out.println("Student data: id - firstname - lastname - course id - course name - units earned");
        try {
            PreparedStatement stmt = connection.prepareStatement("select student_id, student_first_name, student_last_name, course_id, course_name, units_earned from student natural join course natural join grade");
            ResultSet rs = stmt.executeQuery(); int count = 0;
            while (rs.next()) {
                int student_id = rs.getInt(1);
                String student_first_name = rs.getString(2);
                String student_last_name = rs.getString(3);
                int course_id = rs.getInt(4);
                String course_name = rs.getString(5);
                int units_earned = rs.getInt(6);
                String output = "Student #%d: %d - %s - %s - %d - %s - %d";
                System.out.println(String.format(output, ++count, student_id, student_first_name, student_last_name, course_id, course_name, units_earned)); }
        }
        catch (SQLException e) { e.printStackTrace(); }
    }


    public void selfJoinCourses() {

        System.out.println("select c2.* from course c1 inner join course c2 on c1.course_units_max = c2.course_units_max where c1.course_id = 101");
        System.out.println("Course data: id - name - course units - course max size - description - teacher assigned");
        try {
            PreparedStatement stmt = connection.prepareStatement("select c2.* from course c1 inner join course c2 on c1.course_units_max = c2.course_units_max where c1.course_id = 101");
            ResultSet rs = stmt.executeQuery();
            int count = 0; while (rs.next()) {
                int course_id = rs.getInt(1);
                String course_name = rs.getString(2);
                int course_units = rs.getInt(3);
                int course_size = rs.getInt(4);
                String course_desc = rs.getString(5);
                int teacher_id = rs.getInt(6);
                String output = "Course #%d: %d - %s - %s - %s";
                System.out.println(String.format(output, ++count, course_id, course_name, course_units, course_size, course_desc, teacher_id)); }
        }catch (SQLException e) { e.printStackTrace(); }
    }


}
