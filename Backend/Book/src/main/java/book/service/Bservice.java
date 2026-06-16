package book.service;

import java.util.List;

import book.DTO.CoverPageDTO;
import book.DTO.FilePathDTO;
import book.data.Book;

public interface Bservice {
	public Book findBookById(Long id);
//	public Book findByTitle(String title);
	public void saveBook(Book book);
	public List<Book> allBooks();
	public List<CoverPageDTO> getCoverPage();
	public FilePathDTO getPath(long id);
}
