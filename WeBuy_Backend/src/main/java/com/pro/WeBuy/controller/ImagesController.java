package com.pro.WeBuy.controller;

import com.pro.WeBuy.repository.ProductRepository;
import com.pro.WeBuy.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class ImagesController {
	private ProductRepository productRepository;

    public ImagesController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
    	
        Product p=productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/SpringAngAssets/products/"+p.getImgURL()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Product p=productRepository.findById(id).get();
       p.setImgURL(file.getOriginalFilename());
       Files.write(Paths.get(System.getProperty("user.home")+"/SpringAngAssets/products/"+p.getImgURL()),file.getBytes());
       productRepository.save(p);
    }
}
