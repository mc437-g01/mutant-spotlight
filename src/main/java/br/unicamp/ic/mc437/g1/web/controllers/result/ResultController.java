package br.unicamp.ic.mc437.g1.web.controllers.result;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.unicamp.ic.mc437.g1.entity.Result;
import br.unicamp.ic.mc437.g1.entity.TestCaseResult;
import br.unicamp.ic.mc437.g1.entity.TestOutput;
import br.unicamp.ic.mc437.g1.entity.TestResult;
import br.unicamp.ic.mc437.g1.entity.TestSetResult;
import br.unicamp.ic.mc437.g1.model.dao.TestResultDAO;
import br.unicamp.ic.mc437.g1.util.XmlUtils;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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

@Controller
public class ResultController {

    private Logger log = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private TestResultDAO testResultDAO;

    @RequestMapping("/new-result")
	public String renderNewResult(Model model) throws IOException {

		return "new-result/new-result";
	}

    @RequestMapping("/result/{id}")
    public String renderResult(@PathVariable Integer id, Model model) {
        return renderResult(testResultDAO.findById(id), model);
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
        
        int dead;
        int total;
        int score;
        Map<String,Boolean> mapDead = new HashMap<String,Boolean>();
        for (TestSetResult testSetResult:testResult.getTestSetResults()){
        		dead = 0;
        		total = 0;
        		for ( TestCaseResult testCaseResult:testSetResult.getTestCaseResults()){
        				for(TestOutput testOutput:testCaseResult.getTestOutputs()){
        					if ( testOutput.getDead()){
        						dead++;
        						mapDead.put(testOutput.getMutantKey(), testOutput.getDead());
        					}
        					else{
        						if (!mapDead.containsKey(testOutput.getMutantKey())){
        							mapDead.put(testOutput.getMutantKey(), testOutput.getDead());
        						}
        					}
        					total++;
        				}	
        		}
        		score = dead*100/total;
        		testSetResult.setScore(score);
        }
        dead = 0;
        for (Boolean it:mapDead.values()){
        	if(it)
        		dead++;
        }
        total = mapDead.size();
        score = dead*100/total;
        
        testResult.setScore(score);
        
       

        testResult.setEmail(email);
        testResult.setName(name);
        log.debug("{}", testResult);

        testResult = testResultDAO.save(testResult);

		model.addAttribute("mutantsKilled", 0);

		return renderResult(testResult, model);
	}
	
	@RequestMapping("/result-list")
	public String renderResultList(Model model) {
		model.addAttribute("results", testResultDAO.list());
		
		return "result-list/result-list";
	}
	

		
		
	}
	
}