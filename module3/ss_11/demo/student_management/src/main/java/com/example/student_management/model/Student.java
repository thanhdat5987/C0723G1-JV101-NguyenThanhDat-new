package com.example.student_management.model;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private int point;
    private int classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Student(int id, String name, boolean gender, int point, int classId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
        this.classId = classId;
    }

    public Student() {
    }
}
