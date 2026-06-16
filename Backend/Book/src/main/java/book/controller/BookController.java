package book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import book.DTO.BookDTO;
import book.DTO.BookResponse;
import book.data.Book;
import book.service.GoogleBookService;

@RestController

public class BookController {
//	@Autowired
//	private Bservice bookservice;
//	@Autowired
//	private OpenLibraryService service;
	@Autowired
	private GoogleBookService gbs;
	

	
	@GetMapping("/home")
	public String home() {
		
		return "home page";
	}
	
	@GetMapping("/googlebooks")
	public BookResponse getGoogleBook(@RequestParam("q") String query,
			@RequestParam("max") int max,
			@RequestParam("index") int index) {
		
		return gbs.getBooks(query,max,index);
	}
	
	@PostMapping("/googlebooks")
	public BookResponse getGoogleBooks(@RequestParam("q") String query,
			@RequestParam("max") int max,
			@RequestParam("index") int index) {
		
		return gbs.getBooks(query,max,index);
	}
	
	@GetMapping("/googlebooks/{query}")
	public BookResponse getGoogleBook(@PathVariable("query") String query) {
		return gbs.getBooks(query,5,0);	
	}
	
	@GetMapping("/googlebooks/findone/{id}")
	public Book getOnebook(@PathVariable("id") String id) {
		return gbs.getOneBook(id);
	}
	
	
	@PostMapping("/by-ids")
	public List<BookDTO> getBookList(@RequestBody List<String> ids){
		return gbs.bookDto(ids);
		
	}
	
	
	
	
//	@PostMapping("/AddBook")
//	public Book addBook(@RequestBody Book book) {
//		try {
//			bookservice.saveBook(book);	
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println(book);
//		return book;
//	}
//	
//	@GetMapping("/Allbook")
//	public List<Book> book() {
//		List<Book> list = bookservice.allBooks().stream().toList();
//		return list;
//		
//	}
//	
//	@GetMapping("/coverpage")
//	public List<CoverPageDTO> coverpage(){
//		return bookservice.getCoverPage();
//	}
//	
////	@GetMapping("/search")
////	public String serach(@RequestParam("q") String q) {
////		return service.searchBook(q);
////	}
//	
//	@GetMapping("/book/{id}")
//	public Book getbook(@PathVariable("id") long id) {
//		Book book= bookservice.findBookById(id);
//		return book;
//	}
//	
//	@GetMapping("/book/{id}/filepath")
//	public ResponseEntity<InputStreamResource> getBook(@PathVariable("id") long id) throws Exception {
//		FilePathDTO file = bookservice.getPath(id);
//
//		URL url = URI.create(file.getFilepath()).toURL();
//		System.out.println(url);
//		InputStream inputStream = url.openStream();
//		
//		return ResponseEntity.ok()
//				.contentType(MediaType.APPLICATION_PDF)
////				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(url)
//				.header("Content-Disposition","inline")
//				.body(new InputStreamResource(inputStream));
//	}
//	
//	
//	@GetMapping("/fils/{filename}")
//	public ResponseEntity<Resource> getFile(@PathVariable("filename") String filename) throws IOException {
//		if(filename.contains("..")){
//			return ResponseEntity.badRequest().build();
//		 }
//	    Path filePath = Paths.get("C:/Users/anand/book/cover/").resolve(filename);
//	    Resource resource = new UrlResource(filePath.toUri());
//	        
//	    if (!resource.exists()) {
//	         return ResponseEntity.notFound().build();
//	    }
//
//	        return ResponseEntity.ok()
//	        		    .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath))
//	                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
//	                .body(resource);
//	    }
	
}
