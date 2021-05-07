package com.ctseducare.crud;

import com.ctseducare.dao.StudentDAO;
import com.ctseducare.model.Student;

public class Delete {
  
  public static void main(String[] args) {
    try {
      StudentDAO dao = new StudentDAO();
      Student student = dao.findByName("Eros Vitor Bornatowski - changed");
      dao.remove(student);
    } catch (Exception e) {
      e.printStackTrace();
    }    
  }

}
