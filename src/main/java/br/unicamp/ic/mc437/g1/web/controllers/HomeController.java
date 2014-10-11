package br.unicamp.ic.mc437.g1.web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "index";
	}

}