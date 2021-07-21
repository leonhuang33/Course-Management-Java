package hw3Model;

import java.util.*;

public class Assignment {
	int id;
	String name;
	int submissionNum;
	List<Submission> submissionEntries;
	Date submissionDate;

	public Assignment(int id, String name) {
		this.id = id;
		this.name = name;
		this.submissionNum = 0;
		this.submissionEntries = new ArrayList<Submission>();
		this.submissionDate = null;
	}

	public void addSubmission(Submission submission) {
		this.submissionEntries.add(submission);
		this.submissionNum++;
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

	public int getSubmissionNum() {
		return submissionNum;
	}

	public void setSubmissionNum(int submissionNum) {
		this.submissionNum = submissionNum;
	}

	public List<Submission> getSubmissionEntries() {
		return submissionEntries;
	}

	public void setSubmissionEntries(List<Submission> submissionEntries) {
		this.submissionEntries = submissionEntries;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

}
