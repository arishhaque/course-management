package com.university.app;

public class QueriesConstants {

    public static final String DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS STUDENT";

    public static final String DROP_TEACHER_TABLE = "DROP TABLE IF EXISTS TEACHER";

    public static final String DROP_COURSE_TABLE = "DROP TABLE IF EXISTS COURSE";

    public static final String DROP_GRADE_TABLE = "DROP TABLE IF EXISTS GRADE";

    public static final String CREATE_STUDENT_TABLE = "CREATE TABLE STUDENT(" +
            "STUDENT_ID INTEGER PRIMARY KEY, \n" +
            "STUDENT_FIRST_NAME VARCHAR(50) NOT NULL, \n" +
            "STUDENT_LAST_NAME VARCHAR(50) NOT NULL, \n" +
            "STUDENT_EMAIL VARCHAR(50) NOT NULL, \n" +
            "CONSTRAINT STUDENT_EMAIL_UNIQUE UNIQUE(STUDENT_EMAIL))";

    public static final String CREATE_TEACHER_TABLE = "CREATE TABLE TEACHER(\n" +
            "TEACHER_ID INTEGER PRIMARY KEY,\n" +
            "TEACHER_FIRST_NAME VARCHAR(50) NOT NULL,\n" +
            "TEACHER_LAST_NAME VARCHAR(50) NOT NULL,\n" +
            "TEACHER_EMAIL VARCHAR(50) NOT NULL, \n" +
            "CONSTRAINT TEACHER_EMAIL_UNIQUE UNIQUE(TEACHER_EMAIL))";

    public static final String CREATE_COURSE_TABLE = "CREATE TABLE COURSE(\n" +
            "COURSE_ID INTEGER PRIMARY KEY,\n" +
            "COURSE_NAME VARCHAR(50) NOT NULL,\n" +
            "COURSE_UNITS_MAX INTEGER NOT NULL,\n" +
            "COURSE_MAX_SIZE INTEGER,\n" +
            "COURSE_DESCRIPTION VARCHAR(100) NOT NULL,\n" +
            "TEACHER_ID INTEGER NOT NULL,\n" +
            "FOREIGN KEY(TEACHER_ID) REFERENCES TEACHER(TEACHER_ID), \n" +
            "CONSTRAINT min_course_units_max CHECK (course_units_max >= 0),\n" +
            "CONSTRAINT COURSE_MAX_SIZE CHECK (COURSE_MAX_SIZE >= 1))";

    public static final String CREATE_GRADE_TABLE = "CREATE TABLE GRADE(\n" +
            "COURSE_ID INTEGER NOT NULL,\n" +
            "STUDENT_ID INTEGER NOT NULL,\n" +
            "UNITS_EARNED DECIMAL,\n" +
            "CONSTRAINT PK_GRADE PRIMARY KEY(STUDENT_ID, COURSE_ID),\n" +
            "FOREIGN KEY(COURSE_ID) \n" +
            "REFERENCES COURSE(COURSE_ID),\n" +
            "FOREIGN KEY(STUDENT_ID) REFERENCES STUDENT(STUDENT_ID), \n" +
            "CONSTRAINT min_units_earned CHECK (units_earned >= 0))";

}
