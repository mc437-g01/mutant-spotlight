package br.unicamp.ic.mc437.g1.web.controllers.result;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import br.unicamp.ic.mc437.g1.entity.Result;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.util.XmlUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import br.unicamp.ic.mc437.g1.entity.TestCaseResult;
import br.unicamp.ic.mc437.g1.entity.TestOutput;
import br.unicamp.ic.mc437.g1.entity.TestSetResult;

@Controller
public class ResultController {

    private Logger log = LoggerFactory.getLogger(ResultController.class);

    @RequestMapping("/new-result")
	public String renderNewResult(Model model) throws IOException {

		return "new-result/new-result";
	}
    
    @Value("classpath:acceptance/step_files/test_result_1.xml")
	org.springframework.core.io.Resource testResult1Resource;

	@RequestMapping("/result/{id}")
	public String renderResult(@PathVariable String id, Model model) {
		int intId = Integer.parseInt(id);
		model.addAttribute("id", intId);
		
		//TODO: carregar TestResult e deletar código abaixo e arquivo:
		TestResult res;
		try {
			res = XmlUtils.readValue(testResult1Resource.getInputStream(), TestResult.class);
		} catch (IOException e) {
			e.printStackTrace();
			return "error50x";
		}
		
		model.addAttribute("result", res);
		
		return "result/result";
	}

	@RequestMapping(value = "/result-upload", method = RequestMethod.POST)
	public String renderResultUpload(
			@RequestParam("inputFile") MultipartFile xmlFile,
			@RequestParam("email") String email,
			@RequestParam("name") String name,
			Model model) throws IOException {
		// TODO: utilizar xmlFile e calcular número de mutantes

        log.debug("{}", xmlFile);

        TestResult testResult = XmlUtils.readValue(xmlFile.getInputStream(), TestResult.class);
        testResult.setEmail(email);
        log.debug("{}", testResult);

		model.addAttribute("mutantsKilled", 0);

		return "result-upload/result-upload";
	}
	
	@RequestMapping("/result-list")
	public String renderResultList(Model model) {
		//TODO: get result list:
		List<Result> results = new LinkedList<Result>();
		for (int i = 0; i < 10; i++) {
			Result res = new Result();
			res.setId(i);
			res.setName("Result: "+i);
			results.add(res);
		}
		
		model.addAttribute("results", results);
		
		return "result-list/result-list";
	}

	public Result save(Result result) {
		result.setId(1);

		return result;
	}

}