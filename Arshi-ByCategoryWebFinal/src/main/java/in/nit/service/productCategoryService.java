package in.nit.service;

import java.util.List;

import in.nit.model.ProductCategory;

public interface productCategoryService {
	
	public Integer saveProductCategory(ProductCategory category);
	
	List<ProductCategory> getAllCategorys();
	
	ProductCategory getOneProduct(Integer categoryId);
}
