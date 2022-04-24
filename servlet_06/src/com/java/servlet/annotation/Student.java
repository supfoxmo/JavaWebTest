package com.java.servlet.annotation;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String interest;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(interest, student.interest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, interest);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", interest='" + interest + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Student(String name, int age, String interest) {
        this.name = name;
        this.age = age;
        this.interest = interest;
    }
}
