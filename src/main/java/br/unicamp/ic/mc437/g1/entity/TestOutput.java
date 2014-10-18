package br.unicamp.ic.mc437.g1.entity;

public class TestOutput {
	
	private Integer id;
	private Integer testCaseId;
	private Boolean dead;
	private Integer deadIndex;
	private String evalFailed;
	private String mutantKey;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(Integer testCaseId) {
		this.testCaseId = testCaseId;
	}
	public Boolean getDead() {
		return dead;
	}
	public void setDead(Boolean dead) {
		this.dead = dead;
	}
	public Integer getDeadIndex() {
		return deadIndex;
	}
	public void setDeadIndex(Integer deadIndex) {
		this.deadIndex = deadIndex;
	}
	public String getEvalFailed() {
		return evalFailed;
	}
	public void setEvalFailed(String evalFailed) {
		this.evalFailed = evalFailed;
	}
	public String getMutantKey() {
		return mutantKey;
	}
	public void setMutantKey(String mutantKey) {
		this.mutantKey = mutantKey;
	}
	
	

}
