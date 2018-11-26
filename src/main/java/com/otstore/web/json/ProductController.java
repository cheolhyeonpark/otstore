package com.otstore.web.json;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductController {

	@Autowired ServletContext sc;
	
	@RequestMapping("file")
	public Object uploadFile(MultipartFile file) {
		
		String newfilename = UUID.randomUUID().toString();
		String path = sc.getRealPath("/files/"+newfilename);
		
        try {
            file.transferTo(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return path;
	}
}
