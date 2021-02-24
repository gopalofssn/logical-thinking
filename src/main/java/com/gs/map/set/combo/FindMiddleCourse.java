package com.gs.map.set.combo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given prerequisites courses in 2D array, 0th position course should be completed before taking 1st position course.
 * write algorith to get middle course.
 * 
 * @author Gopal Selvaraj
 *
 */
public class FindMiddleCourse {

  public String findMiddleCourse(String[][] prereqsCourses) {
    
    if(prereqsCourses == null || prereqsCourses.length == 0) {
      return new String();
    }
    
    Map<String, String> currentPreviousCourseMap = new HashMap<String, String>();
    Set<String> previousCourseSet = new HashSet<String>();
    
    buildCurrentPreviousCourseMapAndPreviousCourseSet(prereqsCourses, currentPreviousCourseMap,
        previousCourseSet);
    
    String course = findStartCourse(currentPreviousCourseMap, previousCourseSet);
    
    if(course.isEmpty()) {
      return course;
    }
    
    int counter = currentPreviousCourseMap.size() / 2;
    
    while(counter > 0) {
      course = currentPreviousCourseMap.get(course);
      counter--;
    }
    
    return course;
  }

  private String findStartCourse(Map<String, String> currentPreviousCourseMap,
      Set<String> previousCourseSet) {
    
    for(Map.Entry<String, String> entry : currentPreviousCourseMap.entrySet()) {
      String currentCourse = entry.getKey();
      if(!previousCourseSet.contains(currentCourse)) {
        return currentCourse;
       }
    }
    return new String();
    
  }

  private void buildCurrentPreviousCourseMapAndPreviousCourseSet(String[][] prereqsCourses,
      Map<String, String> currentPreviousCourseMap, Set<String> previousCourseSet) {
    
    for(String[] prereqsCourse : prereqsCourses) {
      String prev = prereqsCourse[0];
      String current = prereqsCourse[1];
      currentPreviousCourseMap.put(current, prev);
      previousCourseSet.add(prev);
    }
    
  }
  
}
