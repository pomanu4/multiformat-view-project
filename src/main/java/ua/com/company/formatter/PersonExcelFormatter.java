package ua.com.company.formatter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import ua.com.company.model.Person;

public class PersonExcelFormatter extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) model.get("users");
		Sheet sheet = workbook.createSheet("user");

		int count = 0;
		Row header = sheet.createRow(count++);
		header.createCell(0).setCellValue("id");
		header.createCell(1).setCellValue("name");
		header.createCell(2).setCellValue("surname");
		header.createCell(3).setCellValue("DoB");

		for (Person person : persons) {
			Row body = sheet.createRow(count++);
			body.createCell(0).setCellValue(Integer.toString(person.getP_id()));
			body.createCell(1).setCellValue(person.getName());
			body.createCell(2).setCellValue(person.getSurname());
			body.createCell(3).setCellValue(person.getDate().toString());
		}
	}
}
