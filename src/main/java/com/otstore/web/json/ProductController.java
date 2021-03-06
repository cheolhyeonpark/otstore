package com.otstore.web.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.otstore.domain.Product;
import com.otstore.service.ProductService;

@RestController
public class ProductController {

	@Autowired ServletContext sc;
	
	@Autowired ProductService productService;
	
	@RequestMapping("file")
	public Object uploadFile(MultipartFile file) {
		
		String newfilename = UUID.randomUUID().toString();
		String path = sc.getRealPath("/files/"+newfilename);
		
        try {
            file.transferTo(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return newfilename;
	}
	
	@RequestMapping("upload")
	public Object uploadProduct(Product product) {
		return productService.insertProduct(product);
	}
	
	@GetMapping("list")
	public List<Product> selectList(Integer page, Integer category) {
		HashMap<String, Integer> map = new HashMap<>();		
		map.put("page", (page-1)*12);
		map.put("category", category);
		return productService.selectList(map);
	}
	
	@GetMapping("best")
	public List<Product> bestList() {
		return productService.bestList();
	}
	
	@GetMapping("total") 
	public int totalPage(Integer category) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("category", category);
		return productService.totalProduct(map);
	}
	
	@GetMapping("view")
	public Object viewProduct(int prodNo) {
		return productService.viewProduct(prodNo);
	}
}
