package com.ctseducare.queries;

import java.util.List;

import com.ctseducare.dao.StudentDAO;
import com.ctseducare.model.Student;

public class Queries {

  public static void main(String[] args) {

    StudentDAO dao = new StudentDAO();

    //----------------------------------------------------------------------------------------------------
    // Find student by name
    //----------------------------------------------------------------------------------------------------
    {
    Student student = dao.findByNameSQLVersion("Beltrano Cunha");
    System.out.println(student.getName());
    System.out.println("");
    }
    
    //----------------------------------------------------------------------------------------------------
    // Total of students
    //----------------------------------------------------------------------------------------------------
    {
    long totalStudents = dao.getTotalCriteriaVersion();
    System.out.println("Total of students: " + totalStudents);
    System.out.println("");
    }
    
    //----------------------------------------------------------------------------------------------------
    // Students with first letter equals to 'B'
    //----------------------------------------------------------------------------------------------------
    {
    List<Student> students = dao.findByInitialLetterCriteriaVersion("B");
    for (Student student : students) {
      System.out.println(student.getName());
    }
    System.out.println("");
    }
  }

}
