package borrow.dto;

import java.util.List;

public class Details {
	
	private String title;

    private List<String> authors;

    private String publisher;

    private String publishedDate;

    
    private String language;

    private Images imageLinks;
    
    private String previewLink;

    private String webReaderLink;
    
    private List<String>categories;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public String getWebReaderLink() {
		return webReaderLink;
	}

	public void setWebReaderLink(String webReaderLink) {
		this.webReaderLink = webReaderLink;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

    
    
    
}
