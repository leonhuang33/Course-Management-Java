package hw3Model;

import java.util.*;

public class Submission {
	String name;
	String answer;
	Date submissionDate;
	
	public Submission(String name, String answer) {
		this.name = name;
		this.answer = answer;
		this.submissionDate = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

}
