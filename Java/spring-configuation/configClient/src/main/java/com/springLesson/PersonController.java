package com.springLesson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

	@Value("${name}")
	String name;
	
	@Value("${age}")
	long age;
	
	@RequestMapping("/person")
	public String getPerson(Model m) {
		m.addAttribute("name", name);
		m.addAttribute("age", age);
		return "person";
	}
}
