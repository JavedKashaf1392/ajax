package in.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	///for delete we well write this query 
	 public List<Product> findByProductIdIn(Integer[] productId);
	 
		/* @Query("SELECT prod.productCategory FROM ARSHIJANPRODUCT prod group by productCategory;")*/
		/* @Query("select productCategory, count(productCategory) from Product group by productCategory")*/
		/*	 @Query("select productCategory,count(productCategory) from Product group by productCategory")
			 public List<Object[]> getCategoriesCount();*/
	 
		/*public List<Product> findByProductCategory(String productCategory);*/
		
		@Query("FROM Product WHERE active = :active AND category.id = :categoryId")
		public List<Product> findByActiveAndCategoryId(boolean active, Integer categoryId);
		
		
		@Query("FROM Product WHERE active = :active")
		public List<Product> findByActive(boolean active);

}
