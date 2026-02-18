package com.nature.studentroomapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table") // java class change to database table
public class Student
{
    @PrimaryKey(autoGenerate = true)  //create the ID intial student
    private int id;
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    // Getters and Setters
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}