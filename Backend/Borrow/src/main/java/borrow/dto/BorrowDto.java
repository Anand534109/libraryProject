package borrow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class BorrowDto {
	
	private long userId;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9_-]{1,50}$",message="invalid book id"	)
	private String bookId;
	
	public long getUser_id() {
		return userId;
	}
	public void setUser_id(long user_id) {
		this.userId = user_id;
	}
	public String getBook_id() {
		return bookId;
	}
	public void setBook_id(String book_id) {
		this.bookId = book_id;
	}
	
	@Override
	public String toString() {
		return "BorrowDto [user_id=" + userId + ", book_id=" + bookId + "]";
	}
	
}
