package br.unicamp.ic.mc437.g1.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.unicamp.ic.mc437.g1.entity.Result;

@Controller
public class ResultController {

	@RequestMapping("/new-result")
	public String renderNewResult(Model model) {
		return "new-result/new-result";
	}

	@RequestMapping("/result/{id}")
	public String renderResult(@PathVariable String id, Model model) {
		model.addAttribute("id", id);

		return "result/result";
	}

	@RequestMapping(value = "/result-upload", method = RequestMethod.POST)
	public String renderResultUpload(
			@RequestParam("inputFile") MultipartFile xmlFile, Model model) {
		// TODO: utilizar xmlFile e calcular número de mutantes

		model.addAttribute("mutantsKilled", 0);

		return "result-upload/result-upload";
	}

	public Result save(Result result) {
		result.setId(1);

		return result;
	}

}