package ua.com.company.formatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;

import ua.com.company.model.Person;

public class RssPersonFormatter extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
		feed.setTitle("wery good title from metedata");
		feed.setLink("http://www.ukr.net");
		feed.setDescription("test discription");
	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Person person = (Person) model.get("user");

		List<Item> itemContainer = new ArrayList<>();
		Item item = new Item();
		item.setAuthor("pomanu4");
		item.setTitle("titli from feed body");
		item.setLink("https://www.google.com.ua");
		item.setPubDate(new Date());

		Content content = new Content();
		content.setType("text/html");
		content.setValue("<h4>" + person.getName() + "</h4>");

		item.setContent(content);
		itemContainer.add(item);
		return itemContainer;
	}

}
