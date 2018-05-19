package ua.com.company.daoImitation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ua.com.company.model.Person;

public class Imitation {

	public static List<Person> getContainer() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(12, "john", "doe", LocalDate.of(2001, 2, 1)));
		persons.add(new Person(6, "jeni", "qwer", LocalDate.of(2003, 5, 5)));
		persons.add(new Person(7, "rob", "asdf", LocalDate.of(1987, 7, 22)));
		persons.add(new Person(33, "dak", "hjkl", LocalDate.of(1999, 8, 12)));
		return persons;
	}

}
