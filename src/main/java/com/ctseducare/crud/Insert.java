package com.ctseducare.crud;

import java.time.LocalDate;

import com.ctseducare.dao.StudentDAO;
import com.ctseducare.model.Student;

public class Insert {
  
  public static void main(String[] args) {
    Student student = new Student();
    student.setName("Eros Vitor Bornatowski");
    student.setDateBirth(LocalDate.of(1975, 11, 10));

    try {
      StudentDAO dao = new StudentDAO();
      dao.insert(student);
      System.out.println("Data saved successfully!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
