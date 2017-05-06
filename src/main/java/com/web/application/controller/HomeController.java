package com.web.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goToEmployeeList() {
		System.out.println("Default URL");
		return new ModelAndView(
				"redirect:" + new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
						.append(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_LIST).toString());
	}
}
