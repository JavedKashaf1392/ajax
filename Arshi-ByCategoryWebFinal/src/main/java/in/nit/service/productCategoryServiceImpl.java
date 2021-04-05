package in.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.ProductCategory;
import in.nit.repo.ProductCategoryRepository;

@Service
public class productCategoryServiceImpl implements productCategoryService{
	
	@Autowired
	private ProductCategoryRepository ctagRepo;

	

	@Override
	public List<ProductCategory> getAllCategorys() {
		return ctagRepo.findAll();
	}

	//get one record of category
	@Override
	public ProductCategory getOneProduct(Integer categoryId) {
		ProductCategory category=null;
	Optional<ProductCategory> opt=ctagRepo.findById(categoryId);
	if(opt.isPresent()) {
		category=opt.get();
	}
		return category;
	}



	@Override
	public Integer saveProductCategory(ProductCategory category) {
		return ctagRepo.save(category).getId();
	}
	


	

}
