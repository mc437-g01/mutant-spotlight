package br.unicamp.ic.mc437.g1.web.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unicamp.ic.mc437.g1.entity.Result;

public class ResultControllerTest {
	
	private ResultController controller;
	
	@Before
	public void setUp () {
		controller = new ResultController();
	}

	@Test
	public void testSave () {
		Result result = new Result();
		
		result.setUploader("Someone");
		result.setFileContent("Some content");
		
		result = controller.save(result);
		
		assertNotNull(result.getId());
	}

}
