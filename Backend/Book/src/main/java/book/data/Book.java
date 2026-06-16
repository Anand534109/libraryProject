	package book.data;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private long bookId;
	    private String id; 
	    @Embedded
	    private BookDetails volumeInfo;
	    
		public long getBookId() {
			return bookId;
		}
		public void setBookId(long bookId) {
			this.bookId = bookId;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public BookDetails getVolumeInfo() {
			return volumeInfo;
		}
		public void setVolumeInfo(BookDetails volumeInfo) {
			this.volumeInfo = volumeInfo;
		}

	   

		
	
	
	
}

