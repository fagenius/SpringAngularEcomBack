package org.sid.ligthecommerce;

import net.bytebuddy.utility.RandomString;
import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"org.sid"})
@EnableJpaRepositories("org.sid.dao")
@EntityScan("org.sid.entities")
public class LigthEcommerceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(LigthEcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Permet d'exposer l'id en envoyant les données au format JSON
		repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);

		categoryRepository.save(new Category(null,"Ordinateur", null, null,null));
		categoryRepository.save(new Category(null,"Printers", null, null,null));
		categoryRepository.save(new Category(null,"Smart phone", null, null,null));

		Random rnd = new Random();

		categoryRepository.findAll().forEach(c->{
			for (int i = 0; i < 10; i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCurrentprice(100+rnd.nextInt(10000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				p.setPhotoName("unknown.png");
				productRepository.save(p);
			}
		});
	}
}
