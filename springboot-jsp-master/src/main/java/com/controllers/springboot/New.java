package com.controllers.springboot;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@RestController
@ComponentScan("com.models.dto")
@EnableJpaRepositories("com.models.dto")
@EntityScan(basePackageClasses = Person.class)
@RequestMapping("/personForm.htm")
@SessionAttributes("person")
public class New {
	// private IDummyService dummyService;
	private final String SAVE_ACTION = "Save";
	private final String PARAM_ACTION = "action";
	private final String PERSON_ATTRIBUTE = "person";
	private final String PERSON_ID = "personId";
	private final String PERSON_FORM = "personForm";
	private final String PERSON_DISPLAY = "redirect:personDisplay.htm";

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam(value = PERSON_ID, required = false) Integer id) {
		Person pesho = new Person();
		pesho.setName("Pesho");
		pesho.setId(1);
		pesho.setAge(15);
		pesho.setAddress("Dame");
		if (id == null) {
			return "personForm";
		} else {
			// return this.dummyService.retrievePerson(id);
			return "redirect:/person-form";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute(PERSON_ATTRIBUTE) Person person, BindingResult result, SessionStatus status,
			@RequestParam(PARAM_ACTION) String request) {
		if (SAVE_ACTION.equals(request)) {
			if (result.hasErrors()) {
				return PERSON_FORM;
			} else {
				status.setComplete();
				return PERSON_DISPLAY;
			}
		} else {
			status.setComplete();
			return PERSON_DISPLAY;
		}
	}
}