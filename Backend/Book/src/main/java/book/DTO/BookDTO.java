package book.DTO;


public class BookDTO {
	
	private String id;

	private BookDetailsDTO volumeInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookDetailsDTO getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(BookDetailsDTO volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	
}
