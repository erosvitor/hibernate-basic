package com.ctseducare.crud;

import com.ctseducare.dao.StudentDAO;
import com.ctseducare.model.Student;

public class Update {

  public static void main(String[] args) {
    try {
      StudentDAO dao = new StudentDAO();
      Student student = dao.findByName("Eros Vitor Bornatowski");
      student.setName("Eros Vitor Bornatowski - changed");
      dao.update(student);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
