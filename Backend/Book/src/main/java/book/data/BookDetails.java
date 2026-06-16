package book.data;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class BookDetails {

	 private String title;

	    private List<String> authors;

	    private String publisher;

	    private String publishedDate;

	    @Column(length = 5000)
	    private String description;

	    private String isbn10;

	    private String isbn13;

	    private int pageCount;

	    private String language;

	    private double averageRating;

	    private int  ratingsCount;

	    private String maturityRating;

	    @Embedded
	    private Images imageLinks;

	    private String previewLink;

	    private String infoLink;

	    private String webReaderLink;

	    private String saleability;
	    
	    private List<String>categories;

	    private Boolean isEbook;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getAuthors() {
			return authors;
		}

		public void setAuthors(List<String> author) {
			this.authors = author;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getPublishedDate() {
			return publishedDate;
		}

		public void setPublishedDate(String publishedDate) {
			this.publishedDate = publishedDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIsbn10() {
			return isbn10;
		}

		public void setIsbn10(String isbn10) {
			this.isbn10 = isbn10;
		}

		public String getIsbn13() {
			return isbn13;
		}

		public void setIsbn13(String isbn13) {
			this.isbn13 = isbn13;
		}

		public int getPageCount() {
			return pageCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public double getAverageRating() {
			return averageRating;
		}

		public void setAverageRating(double averageRating) {
			this.averageRating = averageRating;
		}

		public int getRatingsCount() {
			return ratingsCount;
		}

		public void setRatingsCount(int ratingsCount) {
			this.ratingsCount = ratingsCount;
		}

		public String getMaturityRating() {
			return maturityRating;
		}

		public void setMaturityRating(String maturityRating) {
			this.maturityRating = maturityRating;
		}

		public Images getImageLinks() {
			return imageLinks;
		}

		public void setImageLinks(Images imageLinks) {
			this.imageLinks = imageLinks;
		}

		public String getPreviewLink() {
			return previewLink;
		}

		public void setPreviewLink(String previewLink) {
			this.previewLink = previewLink;
		}

		public String getInfoLink() {
			return infoLink;
		}

		public void setInfoLink(String infoLink) {
			this.infoLink = infoLink;
		}

		public String getWebReaderLink() {
			return webReaderLink;
		}

		public void setWebReaderLink(String webReaderLink) {
			this.webReaderLink = webReaderLink;
		}

		public String getSaleability() {
			return saleability;
		}

		public void setSaleability(String saleability) {
			this.saleability = saleability;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		public Boolean getIsEbook() {
			return isEbook;
		}

		public void setIsEbook(Boolean isEbook) {
			this.isEbook = isEbook;
		}
	    
	    
	    
}
