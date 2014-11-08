package br.unicamp.ic.mc437.g1.acceptance.steps.visualizegraph;

import org.jbehave.core.annotations.AsParameters;
import org.jbehave.core.annotations.Parameter;

@AsParameters
public class TestCaseRow {
	@Parameter(name = "TEST CASE")
    private String testCase;

    @Parameter(name = "GREEN%")
    private String percentage;
    
    public String getTestCase() {
    	return testCase;
    }
    
    public void setTestCase(String testCase) {
    	this.testCase = testCase;
    }
    
    public void setPercentage(String percentage) {
    	this.percentage = percentage;
    }
    
    public String getPercentage() {
    	return percentage;
    }
}
