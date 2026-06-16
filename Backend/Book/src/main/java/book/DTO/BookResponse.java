package book.DTO;

import java.util.List;

import book.data.Book;

public class BookResponse {
	List<Book> items;

	public List<Book> getItems() {
		return items;
	}

	public void setItems(List<Book> items) {
		this.items = items;
	}

	
}
