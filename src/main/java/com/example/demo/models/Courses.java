package com.example.demo.models;

import java.sql.Date;

public class Courses {
    public int idCourses;
    public String courseName;
    public Date startDate;
    public int etcs;
    public String about;

    public Courses(int idCourses, String courseName, Date startDate, int etcs, String about) {
        this.idCourses = idCourses;
        this.courseName = courseName;
        this.startDate = startDate;
        this.etcs = etcs;
        this.about = about;
    }

    public Courses(String courseName, Date startDate, int etcs, String about) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.etcs = etcs;
        this.about = about;
    }

    public Courses(){}

    public int getIdCourses() {
        return idCourses;
    }

    public void setIdCourses(int idCourses) {
        this.idCourses = idCourses;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getEtcs() {
        return etcs;
    }

    public void setEtcs(int etcs) {
        this.etcs = etcs;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourses +
                ", courseName='" + courseName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", etsc=" + etcs +
                ", about='" + about + '\'' +
                '}';
    }
}
