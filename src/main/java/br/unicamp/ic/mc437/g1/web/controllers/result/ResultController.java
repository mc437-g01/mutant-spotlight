package br.unicamp.ic.mc437.g1.web.controllers.result;

import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;
import br.unicamp.ic.mc437.g1.model.service.ScoreService;
import br.unicamp.ic.mc437.g1.util.XmlUtils;

import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Controller
public class ResultController {

    private Logger log = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private TestResultDAO testResultDAO;

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/new-result")
    public String renderNewResult(Model model) throws IOException {

        return "new-result/new-result";
    }

    @RequestMapping("/result/{id}")
    public String renderResult(@PathVariable String id, Model model) {
    	String response = "error/error";
    	
    	if (NumberUtils.isDigits(id)) {
    		TestResult testResult = testResultDAO.findById(Integer.parseInt(id));
    		
    		if (testResult != null) {
    			response = renderResult(testResult, model);
    		}
    	}
    	
    	return response;
    }

    private String renderResult(TestResult testResult, Model model) {
        model.addAttribute("id", testResult.getId());

        model.addAttribute("result", testResult);

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
        if (testResult == null) {
            return "error/invalid-file-error";
        }

        scoreService.calculateScore(testResult);

        testResult.setEmail(email);
        testResult.setName(name);
        log.debug("{}", testResult);

        testResult = testResultDAO.save(testResult);

        model.addAttribute("mutantsKilled", 0);

        return renderResult(testResult, model);
    }

    @RequestMapping("/result-list")
    public String renderResultList(Model model,
    		@RequestParam(value = "criteria", required = false) String criteria) {
    	model.addAttribute("criteria", Objects.toString(criteria, ""));
        model.addAttribute("results", testResultDAO.list(criteria));

        return "result-list/result-list";
    }

}