package book.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import book.DTO.BookDTO;
import book.data.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	public BookDTO toDto(Book book);
	
	public List<BookDTO> toDtoList(List<Book> book);
}
