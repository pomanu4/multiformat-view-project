package ua.com.company.formatter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ua.com.company.model.Person;

public class PersonPDFformatter extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) model.get("users");
		
		float[] columnWidths = { 1f, 1f, 1f, 1f };
		PdfPTable table = new PdfPTable(4);
		table.setWidths(columnWidths);
		table.setWidthPercentage(90f);

		PdfPCell cell = null;
		cell = new PdfPCell(new Phrase("id"));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("name"));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("surname"));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("DoB"));
		table.addCell(cell);
		for (Person person : persons) {
			cell = new PdfPCell(new Phrase(Integer.toString(person.getP_id())));
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(person.getName()));
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(person.getSurname()));
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(person.getDate().toString()));
			table.addCell(cell);

		}

		document.addTitle("pdf format doc");
		document.add(table);
	}

}
