package student;

public class Student {
	private final String name;
	private int totalMark;
	private int totalSubjects;

	public Student(String name) {
		this.name = name;
		this.totalMark = 0;
		this.totalSubjects = 0;
	}
	
	public int getTotalMark() {
		return totalMark;
	}
	
	public int getTotalSubjects() {
		return totalSubjects;
	}

	public String getName() {
		return name;
	}

	public void addMark(int mark){
		totalMark += mark;
		totalSubjects++;
	}

	public float averageMark(){
		if(totalSubjects == 0) return -1;
		return (float)totalMark / (float)totalSubjects;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", totalMark=" + totalMark + ", totalSubjects=" + totalSubjects + "]";
	}
	
}
