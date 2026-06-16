package book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import book.DTO.BookDTO;
import book.DTO.BookResponse;
import book.data.Book;
import book.mapper.BookMapper;

@Service

@PropertySource("classpath:book.properties")
public class GoogleBookService {
	
	@Autowired
	private BookMapper bookMapper;
//	Book book = new Book();
	@Value("${Api.Key}")
	private String apiKey;

	public BookResponse getBooks(String query,int max,int index){
		WebClient web = WebClient.builder()
						.baseUrl("https://www.googleapis.com")
						.build();
		
		return web.get()
				.uri(uriBuilder ->uriBuilder.path("books/v1/volumes")
						.queryParam("q",query)
						.queryParam("maxResults",max)
						.queryParam("startIndex",index)
						.queryParam("key",apiKey)
						.build()
					)
				.retrieve()
				.bodyToMono(BookResponse.class)
				.block();
		
	}
	
	
	public Book getOneBook(String id){
		WebClient web = WebClient.builder()
						.baseUrl("https://www.googleapis.com")
						.build();
		
		return web.get()
				.uri(uriBuilder ->uriBuilder.path("/books/v1/volumes/{id}")
						.queryParam("key",apiKey)
						.build(id)
					)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
		
	}
	
	
	public List<BookDTO>bookDto(List<String>ids){
		List<Book> books = new ArrayList<>();
		for(String id:ids) {
			books.add(getOneBook(id));
		}
		return bookMapper.toDtoList(books);
	}
}
