package borrow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import borrow.data.Borrow;
import borrow.repository.BorrowRepository;

@Service
public class ImplementBorrowService implements BorrowService {

	@Autowired
	private BorrowRepository borrowRepo;

	@Override
	public List<String> findBorrowById(long id){
		List<String> bookIds = borrowRepo.findAllBookIdByUserId(id);
		return bookIds;
	}

	@Override
	public void saveBorrow(Borrow borr) {
		borrowRepo.save(borr);	
	}
	
	
}
