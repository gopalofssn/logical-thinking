package com.gs.highest.avg.score.student;

import java.util.*;

// Time : O(n)
// Space : O(n)
public class HighestAvgStudent {

  public String getHighestAvarageStudentName(String[][] students) {

    if (students == null || students.length == 0) {
      throw new IllegalArgumentException("Student list is empty or null");
    }

    Map<String, Student> studentByNameMap = buildStudentByStudentNameMap(students);

    return topperFinderUtil(studentByNameMap);
  }

  private String topperFinderUtil(Map<String, Student> studentByNameMap) {

    Student topper = new Student("Dummy");

    for (Map.Entry<String, Student> entry : studentByNameMap.entrySet()) {
      Student currentStudent = entry.getValue();

      if (currentStudent.hasHighestAverageScoreThan(topper)) {
        topper = currentStudent;
      }

    }

    return topper.getName();
  }

  private Map<String, Student> buildStudentByStudentNameMap(String[][] students) {
    Map<String, Student> studentByNameMap = new HashMap<String, Student>();

    for (String[] student : students) {
      String name = student[0].trim();
      int mark = Integer.parseInt(student[1].trim());
      studentByNameMap.putIfAbsent(name, new Student(name));
      studentByNameMap.get(name).addMark(mark);
    }

    return studentByNameMap;
  }

}
