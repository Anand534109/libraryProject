package book.DTO;

public class CoverPageDTO {
	private long Id;
	private String coverPage;
	
	public CoverPageDTO(long id,String cover) {
		this.Id = id;
		this.coverPage=cover;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCoverPage() {
		return coverPage;
	}
	public void setCoverPage(String coverPage) {
		this.coverPage = coverPage;
	}
	
	
	@Override
	public String toString() {
		return "CoverPageDTO [Id=" + Id + ", coverPage=" + coverPage + "]";
	}

}
