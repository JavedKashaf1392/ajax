package in.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Product;
import in.nit.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository pdRepo;

	@Override
	public Integer saveProduct(Product product) {
		//10 percent discout
		double cost = product.getProductPrice();
		double discount = cost * 10 / 100;
		//8percent gst
		double gst = cost * 8 / 100;
		double lastPrice=(product.getProductPrice())*(product.getProductQyt())+(product.getProductQyt())+(product.getTax())-(product.getDiscount());

		
		// set datat to object
		product.setDiscount(discount);
		product.setTax(gst);
		product.setFinalPrice(lastPrice);
		return pdRepo.save(product).getProductId();

	}

	/*@Override
	public List<Product> getAllProductsByCategory(String productCategory) {
	
			List<Product> entities =pdRepo.findByProductCategory(productCategory);
			return entities;
	}*/
	
	@Override
	public List<Product> getAllProducts() {
			return pdRepo.findAll();
}
	
	

	@Override
	public boolean deleteProduct(Integer id) {
		pdRepo.deleteById(id);
		return true;
  
	}

	@Override
	public Product getOneProduct(Integer id) {
		Product product = null;
		Optional<Product> opt = pdRepo.findById(id);
		if (opt.isPresent()) { // avoid null pointer exception
			product = opt.get();
		}
		return product;
	}

	@Override
	public boolean deleteWelcomeByIds(Integer[] ids) {
		List<Product> list=pdRepo.findByProductIdIn(ids);
		pdRepo.deleteInBatch(list);
		return true;
	}

}
