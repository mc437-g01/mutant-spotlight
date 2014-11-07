package br.unicamp.ic.mc437.g1.acceptance.steps.calculatescore;

import org.jbehave.core.annotations.AsParameters;
import org.jbehave.core.annotations.Parameter;

@AsParameters
public class TestSetScore {
	@Parameter(name="TEST SET")
	private int testSetId;
	
	@Parameter(name="SCORE (%)")
	private int score;

	public int getTestSetId() {
		return testSetId;
	}

	public void setTestSetId(int testSetId) {
		this.testSetId = testSetId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
