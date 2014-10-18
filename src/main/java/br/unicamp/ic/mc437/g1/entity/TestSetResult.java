package br.unicamp.ic.mc437.g1.entity;

import java.util.List;

public class TestSetResult {
	
	private String cod;
	private Integer testResultId;
	private Integer id;
	private String path;
	
	private List<TestCaseResult> testCaseResults;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Integer getTestResultId() {
		return testResultId;
	}
	public void setTestResultId(Integer testResultId) {
		this.testResultId = testResultId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<TestCaseResult> getTestCaseResults() {
		return testCaseResults;
	}
	public void setTestCaseResults(List<TestCaseResult> testCaseResults) {
		this.testCaseResults = testCaseResults;
	}
	
	

}
