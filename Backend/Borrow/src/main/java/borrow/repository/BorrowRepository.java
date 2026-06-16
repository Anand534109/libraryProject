package borrow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import borrow.data.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {
	@Query("select b.bookId from Borrow b where b.userId = :userId")
	List<String> findAllBookIdByUserId(@Param("userId")long id);
}
