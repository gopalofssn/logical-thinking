package com.gs.highest.avg.score.student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestAvgStudentTest {

  private HighestAvgStudent highestAvgStudent = new HighestAvgStudent();
  
  @Test
  public void testScnerio1() {
    String[][] students = 
           { 
            {"Dave","10"},
            {"Adam","10"},
            {"Bene","12"},
            {"Alva","12"},
            {"Ben","8"},
            {"Evan","8"},
          }; 
    assertEquals("Alva", highestAvgStudent.getHighestAvarageStudentName(students));
   }
  
  
  @Test
  public void testScnerio2() {
    String[][] students = 
           { 
            {"Dave","11"},
            {"Adam","10"},
            {"Ben","12"},
            {"Ben","8"},
            {"Evan","8"},
          }; 
    assertEquals("Dave", highestAvgStudent.getHighestAvarageStudentName(students));
   }
  
}
