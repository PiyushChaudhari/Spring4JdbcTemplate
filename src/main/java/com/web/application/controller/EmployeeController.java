package com.web.application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.application.model.Employee;
import com.web.application.service.EmployeeService;

@RequestMapping(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_CREATE, method = RequestMethod.GET)
	public ModelAndView create() {
		System.out.println("Employee Create");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", new Employee());

		return new ModelAndView(new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
				.append(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_CREATE).toString(), model);

	}

	@RequestMapping(value = com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_SAVE, method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("employee") Employee employee,
			final RedirectAttributes redirectAttributes) {
		System.out.println("Employee save");
		employeeService.save(employee);
		redirectAttributes.addFlashAttribute("success", "Employee save successfully.");
		return new ModelAndView(
				"redirect:" + new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
						.append(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_LIST).toString());

	}

	@RequestMapping(value = com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_EDIT, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Integer id) {
		System.out.println("Employee edit");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", employeeService.get(id));

		return new ModelAndView(
				new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER).append("/edit").toString(),
				model);

	}

	@RequestMapping(value = com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_UPDATE, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("employee") Employee employee,
			final RedirectAttributes redirectAttributes) {
		System.out.println("Employee update");
		employeeService.update(employee);
		redirectAttributes.addFlashAttribute("success", "Employee update successfully.");
		return new ModelAndView(
				"redirect:" + new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
						.append(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_LIST).toString());

	}

	@RequestMapping(value = com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_DELETE, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
		System.out.println("Employee delete");
		employeeService.delete(id);
		redirectAttributes.addFlashAttribute("success", "Employee delete successfully.");
		return new ModelAndView(
				"redirect:" + new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
						.append(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_LIST).toString());

	}

	@RequestMapping(value = com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_LIST, method = RequestMethod.GET)
	public ModelAndView list() {
		System.out.println("Employee List");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeService.list());

		return new ModelAndView(new StringBuilder(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER)
				.append(com.web.application.config.UrlMapping.EMPLOYEE_CONTROLLER_LIST).toString(), model);

	}
}
