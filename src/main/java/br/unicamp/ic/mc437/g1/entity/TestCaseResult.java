package br.unicamp.ic.mc437.g1.entity;

import java.util.List;

public class TestCaseResult {
	
	private Integer id;
	private String testSetResultId;
	private Integer type;
	
	private List<TestOutput> testOutputs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestSetResultId() {
		return testSetResultId;
	}
	public void setTestSetResultId(String testSetResultId) {
		this.testSetResultId = testSetResultId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<TestOutput> getTestOutputs() {
		return testOutputs;
	}
	public void setTestOutputs(List<TestOutput> testOutputs) {
		this.testOutputs = testOutputs;
	}
	
	

}
