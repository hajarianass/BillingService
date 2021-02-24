package main;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import main.FeignServices.Customer;
import main.FeignServices.CustomerService;
import main.FeignServices.InventoryService;
import main.FeignServices.Product;
import main.dao.BillRepository;
import main.dao.ProductItemRepository;
import main.entities.Bill;
import main.entities.ProductItem;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			BillRepository billRepository, 
			ProductItemRepository productItemRepository,
			CustomerService customerService,
			InventoryService inventoryService) {
		return args -> {
			Customer c1=customerService.findCustomerById(1L);
			Product p1=inventoryService.findProductById(1L);
			System.out.println("================================================================");
			System.err.println(c1);
			System.out.println("================================================================");
			System.err.println(p1);
			System.out.println("================================================================");
			Bill bill1 = billRepository.save(new Bill(null, new Date(), c1.getId(),null, null));
			
			PagedModel<Product> products=inventoryService.findAllProducts();
			products.getContent().forEach(
					p->{
						productItemRepository.save(new ProductItem(null, p.getId(),null, p.getPrice(), 20, bill1));
					}
					);
			
			
		};
	}

}
