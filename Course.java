package hw3Model;

import java.util.*;

public class Course {
	int id;
	String name;
	int assignmentNum;
	List<Assignment> assignmentEntries;

	public Course(int id, String name) {
		this.id = id;
		this.name = name;
		this.assignmentNum = 0;
		this.assignmentEntries = new ArrayList<Assignment>();
	}
	
	public void addAssignment(Assignment assignment) {
		this.assignmentEntries.add(assignment);
		this.assignmentNum++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAssignmentNum() {
		return assignmentNum;
	}

	public void setAssignmentNum(int assignmentNum) {
		this.assignmentNum = assignmentNum;
	}

	public List<Assignment> getAssignmentEntries() {
		return assignmentEntries;
	}

	public void setAssignmentEntries(List<Assignment> assignmentEntries) {
		this.assignmentEntries = assignmentEntries;
	}

}
