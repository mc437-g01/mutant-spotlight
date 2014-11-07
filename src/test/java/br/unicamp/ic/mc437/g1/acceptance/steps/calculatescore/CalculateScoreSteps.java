package br.unicamp.ic.mc437.g1.acceptance.steps.calculatescore;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.unicamp.ic.mc437.g1.acceptance.Steps;

@Steps
public class CalculateScoreSteps {
	@Given("there is the test $testId in the system")
	@Pending
	public void givenThereIsTheTestInTheSystem(int testId) {
		// TODO
	}

	@Given("the test list page loaded")
	@Pending
	public void givenTheTestListPageLoaded() {
		// TODO
	}

	@Then("the system redirects to result show page")
	@Pending
	public void thenTheSystemRedirectsToResultShowPage() {
		// TODO
	}

	@Then("the calculated score for test result is $score%")
	@Pending
	public void thenTheCalculatedScoreForTestResultIs(int score) {
		// TODO
	}

	@When("I choose a test")
	@Pending
	public void whenIChooseATest() {
		// TODO
	}

	@Then("show the calulated scores for test sets")
	@Pending
	public void thenShowTheCalulatedScoresForTestSets() {
		// TODO
	}

	@When("I choose the test $testId")
	@Pending
	public void whenIChooseTheTest(int testId) {
		// TODO
	}

	@Then("show the calculated score for test result")
	@Pending
	public void thenShowTheCalculatedScoreForTestResult() {
		// TODO
	}

	@Then("the calulated scores for test sets is:$rows")
	@Pending
	public void thenTheCalulatedScoresForTestSetsIs(
			List<TestSetScore> testSetScores) {
		// TODO
	}
}