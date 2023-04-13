package com.pro.WeBuy;

import com.pro.WeBuy.model.Category;
import com.pro.WeBuy.model.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class WeBuyApplication implements CommandLineRunner {
	@Autowired
	private com.pro.WeBuy.repository.ProductRepository productRepository;
	@Autowired
	private com.pro.WeBuy.repository.CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(WeBuyApplication.class, args);
		Category c = new Category();
	}

	@Override
	public void run(String... args) throws Exception {
/*
		repositoryRestConfiguration.exposeIdsFor(com.pro.WeBuy.model.Product.class, Category.class, User.class);

		categoryRepository.save(new Category(null,"Shirts",null,null,null));
		categoryRepository.save(new Category(null,"Jeans",null,null,null));
		categoryRepository.save(new Category(null,"Sleepwear",null,null,null));
		categoryRepository.save(new Category(null,"Jackets",null,null,null));

		Random rnd=new Random();
		categoryRepository.findAll().forEach(c->{
		for (int i = 0; i <10 ; i++) {
			com.pro.WeBuy.model.Product p=new com.pro.WeBuy.model.Product();
			p.setName(RandomString.make(18));
			p.setPrice(100+rnd.nextInt(10000));
			p.setAvailable(rnd.nextBoolean());
			p.setPromotion(rnd.nextBoolean());
			p.setSelected(rnd.nextBoolean());
			p.setCategory(c);
			p.setImgURL("default.jpg");
			productRepository.save(p);
			}
		});

 */
	}
}
