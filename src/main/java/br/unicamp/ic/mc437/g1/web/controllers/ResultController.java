package br.unicamp.ic.mc437.g1.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unicamp.ic.mc437.g1.entity.Result;

@Controller
public class ResultController {

	@RequestMapping("/new-result")
	public String renderNewResult (Model model) {
		return "new-result/new-result";
	}
	
	@RequestMapping("/result/{id}")
	public String renderResult (@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		
		return "result/result";
	}
	
	public Result save (Result result) {
		result.setId(1);
		
		return result;
	}

}