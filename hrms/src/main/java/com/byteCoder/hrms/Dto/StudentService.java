package com.byteCoder.hrms.Dto;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.byteCoder.hrms.Dao.DaoOne;

@Service
public class StudentService 
{
	@Autowired
    private DaoOne productRepo;

    public void save(MultipartFile file) {

        try {
            List<StudentDetails> products = helper.convertExcelToList(file.getInputStream());
            this.productRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<StudentDetails> getAllProducts() {
        return (List<StudentDetails>) this.productRepo.findAll();
    }

}
