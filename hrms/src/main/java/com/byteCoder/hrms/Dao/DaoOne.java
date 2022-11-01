package com.byteCoder.hrms.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.byteCoder.hrms.Dto.StudentDetails;

public interface DaoOne extends CrudRepository<StudentDetails, Integer>
{

	public StudentDetails findById(int id);

	@Query(value = "delete from emp_details where id = :id", nativeQuery = true)
	public void deleteStudentDetails(int id);
	public StudentDetails findByEmailAndPass(String email,String pass);
	
}
