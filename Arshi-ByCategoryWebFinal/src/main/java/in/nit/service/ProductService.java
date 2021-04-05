package in.nit.service;

import java.util.List;

import in.nit.model.Product;

public interface ProductService {
	
	public Integer saveProduct(Product product);
	
	/*public List<Product> getAllProductsByCategory(String productCategory);*/
	
	public List<Product> getAllProducts();
	
	boolean deleteProduct(Integer cid);

	public Product getOneProduct(Integer id);
	
	
	public boolean deleteWelcomeByIds(Integer[] ids);

	/*boolean deleteProduct(Integer id);*/
	

}
