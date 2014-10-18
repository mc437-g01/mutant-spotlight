package br.unicamp.ic.mc437.g1.entity;

import java.util.Calendar;
import java.util.List;

public class TestResult {
	
	private Integer id;
	private Calendar date;
	private String email;
	
	private List<TestSetResult> testSetResults;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<TestSetResult> getTestSetResults() {
		return testSetResults;
	}
	public void setTestSetResults(List<TestSetResult> testSetResults) {
		this.testSetResults = testSetResults;
	}
	
	

}
