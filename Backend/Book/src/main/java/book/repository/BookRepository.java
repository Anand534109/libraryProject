package book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.data.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

@Override
	Optional<Book> findById(Long id);
	
//	Book findBybookTitleIgnoreCase(String title);
}
