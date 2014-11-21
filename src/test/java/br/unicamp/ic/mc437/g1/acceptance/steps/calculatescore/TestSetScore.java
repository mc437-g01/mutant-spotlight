package br.unicamp.ic.mc437.g1.acceptance.steps.calculatescore;

import org.jbehave.core.annotations.AsParameters;
import org.jbehave.core.annotations.Parameter;

@AsParameters
public class TestSetScore {
	@Parameter(name="TEST SET")
	private Integer testSetId;
	
	@Parameter(name="SCORE (%)")
	private Integer score;

	public Integer getTestSetId() {
		return testSetId;
	}

	public void setTestSetId(Integer testSetId) {
		this.testSetId = testSetId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

    @Override
    public String toString() {
        return "TestSetScore{" +
                "testSetId=" + testSetId +
                ", score=" + score +
                '}';
    }
}
