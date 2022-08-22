package com.university;

import com.university.app.CustomQueries;
import com.university.app.DbSetup;

import java.util.Scanner;

/**
 * University Application
 *
 */
public class UniversityApp {

    public static void main( String[] args ) {

        System.out.println( "Application Started");
        new DbSetup().setUp();

        System.out.println("Select Query from the following for execution: \n" +
                " 1) View all Students.\n 2) View all Teachers \n 3) View all Courses \n 4) View all Grades \n 5) View student gpa \n 6) View get total units that a student has earned" +
                "\n 7) List grades in descending order \n 8) View all 2unit courses \n 9) Find grade for courses a student have taken \n 10) Average units earned for any course overall" +
                "\n 11) 3-way join of student,course and grade \n 12) self join on course table");

        CustomQueries queries = new CustomQueries();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                queries.viewAllStudents();
                break;
            case 2:
                queries.viewAllInstructors();
                break;
            case 3:
                queries.viewAllCourses();
                break;
            case 4:
                queries.viewAllGrades();
                break;
            case 5:
                queries.viewAllStudentsGPA();
                break;
            case 6:
                queries.viewStudentsTotalUnits();
                break;
            case 7:
                queries.viewGradesDescending();
                break;
            case 8:
                queries.viewAllTwoUnitsCourses();
                break;
            case 9:
                queries.viewStudentsGradeForAllCourses();
                break;
            case 10:
                queries.viewAverageGradeForCourse();
                break;
            case 11:
                queries.threeWayJoin();
                break;
            case 12:
                queries.selfJoinCourses();
                break;
            default :
                System.out.println("Invalid Choice");
        }
    }
}
