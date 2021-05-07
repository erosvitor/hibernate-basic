package com.ctseducare.crud;

import java.util.List;

import com.ctseducare.dao.StudentDAO;
import com.ctseducare.model.Student;

public class Select {
  
  public static void main(String[] args) {
    try {
      StudentDAO dao = new StudentDAO();
      List<Student> students = dao.findAll();
      for (Student student : students) {
        System.out.println(student.getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
