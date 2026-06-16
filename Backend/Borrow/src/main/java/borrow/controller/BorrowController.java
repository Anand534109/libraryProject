package borrow.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import borrow.data.Borrow;
import borrow.dto.BookDTO;
import borrow.dto.BorrowDto;
import borrow.jwt.JwtUtil;
import borrow.services.BorrowService;

@RestController
public class BorrowController {
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/demo")
	public String demo() {
		return " this is demo path";
	}
	
//	@PostMapping("/test")
//	public ResponseEntity<String> test() {
//
//	    System.out.println("TEST ENDPOINT HIT");
//
//	    return ResponseEntity.ok("success");
//	}
	
	@GetMapping("/borrow/fav")
	public List<BookDTO> borrowData(@CookieValue("jwtToken") String token) {
		long userId = jwtUtil.extractId(token);
		List<String> booksId = borrowService.findBorrowById(userId);
		WebClient webClient = WebClient.builder()
				.baseUrl("http://localhost:8083/Book")
				.build();
		
		List<BookDTO> books =webClient.post()
				.uri("/by-ids")
				.bodyValue(booksId)
				.header("Cookie","jwtToken="+token)
				.retrieve()
				.bodyToFlux(BookDTO.class)
				.collectList()
				.block();	
		return books;
	}
	
	@PostMapping("/demo/add")
	public ResponseEntity<?> add(@CookieValue("jwtToken") String token,@RequestBody BorrowDto borr){

		
		long userId = jwtUtil.extractId(token);
//		
		Borrow borrow = new Borrow();
		borrow.setUserId(userId);
		borrow.setBookId(borr.getBook_id());
		borrow.setDate(LocalDate.now());
//		
		System.out.print(borrow);
		borrowService.saveBorrow(borrow);
//		
		return ResponseEntity.ok().body("data added");
	}
}
