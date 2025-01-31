package com.example.sqliteapp;

public class Student {
    int id;
    String name;
    String city;

    public Student(String city, int id, String name) {
        this.city = city;
        this.id = id;
        this.name = name;
    }
    public Student(String name,String city) {
        this.city = city;
        this.name = name;
    }

    public Student() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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
}
