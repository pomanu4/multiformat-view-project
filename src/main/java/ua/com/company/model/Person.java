package ua.com.company.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	private int p_id;

	private String name;

	private String surname;

	private LocalDate date;

	public Person(int p_id, String name, String surname, LocalDate date) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.surname = surname;
		this.date = date;
	}

	public Person() {
		super();
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", name=" + name + ", surname=" + surname + ", date=" + date + "]";
	}

}
