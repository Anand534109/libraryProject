package book.DTO;

public class FilePathDTO {
	private long id;
	private String filepath;
	
	
	public FilePathDTO(long id, String filepath) {
		this.id = id;
		this.filepath = filepath;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
