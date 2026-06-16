package borrow.services;

import java.util.List;

import borrow.data.Borrow;

public interface BorrowService {
	public List<String> findBorrowById(long id);
	public void saveBorrow(Borrow borr);
}
