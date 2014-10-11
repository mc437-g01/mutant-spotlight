package br.unicamp.ic.mc437.g1.web.controllers;

import java.util.Map;

import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResultUploadController {

	@RequestMapping(value="/result-upload", method=RequestMethod.POST)
	public String getPage(
			@RequestParam("inputFile") MultipartFile xmlFile,
			Model model) {
		// TODO: utilizar xmlFile e calcular número de mutantes
		
		model.addAttribute("mutantsKilled", 0);

		return "result-upload/result-upload";
	}
}
