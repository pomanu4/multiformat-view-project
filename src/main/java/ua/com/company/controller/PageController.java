package ua.com.company.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.company.daoImitation.Imitation;
import ua.com.company.model.Person;
import ua.com.company.model.Persons;

@Controller
public class PageController {

	@RequestMapping(method = RequestMethod.GET, path = { "/" })
	public String showIndex() {

		return "index";
	}

	@RequestMapping(method = RequestMethod.GET, path = { "model" })
	public String showModel(Model model) {
		List<Person> persons = Imitation.getContainer();
		model.addAttribute("users", persons);

		return "model";
	}

	@RequestMapping(method = RequestMethod.GET, path = { "xml/model" })
	public String showXML(Model model) {
		Persons persons = new Persons(Imitation.getContainer());
		model.addAttribute("users", persons);

		return "model";
	}

}
