package com.byteCoder.SatyamBoot.Controller;

import java.util.List;
import java.util.Map;

import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.byteCoder.SatyamBoot.Dto.StudentDetails;
import com.byteCoder.SatyamBoot.Dto.StudentService;
import com.byteCoder.SatyamBoot.Dto.helper;

@RestController
@CrossOrigin("*")
public class Ctrl2 {

	 @Autowired
	    private StudentService productService;

	    @PostMapping("/product/upload")
	    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
	        if (helper.checkExcelFormat(file)) {
	           

	            this.productService.save(file);

	            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	    }


	    @GetMapping("/product")
	    public List<StudentDetails> getAllProduct() {
	        return this.productService.getAllProducts();
	    }
}
