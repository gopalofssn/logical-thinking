package com.gs.map.set.combo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMiddleCourseTest {

  private FindMiddleCourse findMiddleCourse = new FindMiddleCourse();
  
  @Test
  public void testScnerio1() {
    String[][] prereqsCourses1 = {
        {"Foundations of Computer Science", "Operating Systems"},
        {"Data Structures", "Algorithms"},
        {"Computer Networks", "Computer Architecture"}, 
        {"Algorithms", "Foundations of Computer Science"},
        {"Computer Architecture", "Data Structures"},
        {"Software Design", "Computer Networks"}
    };
    
    assertEquals(findMiddleCourse.findMiddleCourse(prereqsCourses1), "Data Structures");
  }
  
  @Test
  public void testScnerio2() {
    String[][] prereqsCourses2 = {
        {"Data Structures", "Algorithms"},
        {"Algorithms", "Foundations of Computer Science"},
        {"Foundations of Computer Science", "Logic"}
    };
    
    assertEquals(findMiddleCourse.findMiddleCourse(prereqsCourses2), "Foundations of Computer Science");
  }
  
  @Test
  public void testScnerio3() {
    String[][] prereqsCourses3 = {
        {"Data Structures", "Algorithms"}
    };
    
    assertEquals(findMiddleCourse.findMiddleCourse(prereqsCourses3), "Algorithms");
  }
  
}
