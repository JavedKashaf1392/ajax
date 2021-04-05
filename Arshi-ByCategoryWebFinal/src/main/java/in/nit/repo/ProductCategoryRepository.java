package in.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
	
	@Query("FROM ProductCategory WHERE active = :active")
	List<ProductCategory> findByActive(boolean active);
	

	@Query("SELECT p.imageUrl FROM ProductCategory p where p.id = :id ")
	public String findImageUrlById(Integer id);

}
