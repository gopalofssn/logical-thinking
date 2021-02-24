package student;

import java.util.*;

// Time : O(n)
// Space : O(n)
public class HighestAvgStudent {

	private String highest(String[][] students) {
		Map<String, Student> studentByName = new HashMap<>();
		for(String[] student : students){
			String name = student[0].trim();
			int mark = Integer.parseInt(student[1].trim());
			studentByName.putIfAbsent(name, new Student(name));
			studentByName.get(name).addMark(mark);
		}
		
		Collection<Student> studentsList = studentByName.values();
		Student topper = new Student("Dummy");
		topper.addMark(Integer.MIN_VALUE);
		for(Student student : studentsList){
			float topperAvgMark =  topper.averageMark();
			float studentAvgMark = student.averageMark();
			if(studentAvgMark == topperAvgMark){
				String topperName  = topper.getName();
				String studentName = student.getName();
				if(studentName.compareTo(topperName) < 0){
					topper = student;
				}
			}
			if(studentAvgMark > topperAvgMark){
				topper = student;
			}
		}
		
		return topper.getName();
	}
	public static void main(String[] args) {
		String[][] students = 
			   { 
				{"Dave","-10"},
				{"Adam","-10"},
				{"Ben","-12"},
				{"Charles","-11"},
				{"Ben","-8"},
				{"Evan","-8"},
		      };		
		System.err.println("Highest Avg Student - " + new HighestAvgStudent().highest(students));
	}
}
