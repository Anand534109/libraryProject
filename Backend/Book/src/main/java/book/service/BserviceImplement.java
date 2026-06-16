package book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.DTO.CoverPageDTO;
import book.DTO.FilePathDTO;
import book.data.Book;
import book.repository.BookRepository;

@Service
public class BserviceImplement  implements Bservice{
	@Autowired
	private BookRepository bookRepo;

	
	
	@Override
	public Book findBookById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

//	@Override
//	public Book findByTitle(String title) {
//		
////		return bookRepo.findBybookTitleIgnoreCase(title);
//	}

	@Override
	public void saveBook(Book book) {
		bookRepo.save(book);	
	}

	@Override
	public List<Book> allBooks() {
		List<Book> list = bookRepo.findAll();
		return list;
	}


	@Override
	public List<CoverPageDTO> getCoverPage() {
		return null;
//		List<Book> book = bookRepo.findAll(PageRequest.of(0,4)).getContent();
//		return book.stream().map(b->new CoverPageDTO(b.getBookId(),b.getCoverPage())).toList();
	}

	@Override
	public FilePathDTO getPath(long id) {
		return null;
//		Book book = findBookById(id);
//		return new FilePathDTO(book.getBookId(),book.getPath());
	}


}
