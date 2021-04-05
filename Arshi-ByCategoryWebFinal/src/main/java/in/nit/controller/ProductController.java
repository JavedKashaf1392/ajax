package in.nit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Product;
import in.nit.model.ProductCategory;
import in.nit.repo.ProductCategoryRepository;
import in.nit.repo.ProductRepository;
import in.nit.service.ProductService;
import in.nit.service.productCategoryService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService prdService;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private ProductCategoryRepository repo;
	
	@Autowired
	private productCategoryService ctagService;
	
	@GetMapping("/addProduct")
	public String formLoad(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		List<ProductCategory> categories=ctagService.getAllCategorys();
		model.addAttribute("categories",categories);
		
		
		return "AddProduct";
		
	}
	
	@PostMapping(value="/SaveProduct")
	public String SaveProduct(@Valid @ModelAttribute Product product,Model model,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			/*model.addAttribute("msg","Your Prodcut Added Successfully");*/
			System.out.println("this is errors methods");
			return "errors";
		}
		else {
			Integer id=prdService.saveProduct(product);
			model.addAttribute("msg","Your Prodcut"+id+"Added Successfully");
	return "redirect:/addProduct";
		}
		
	}
	
	@GetMapping("/viewAll")
	public String getAllProducts(HttpServletRequest req,Model model) {
		
		String productCategory="";
		String prodStr=req.getParameter("productCategory");
		
		if(prodStr==null) {
			List<Product> product1=prdService.getAllProducts();
			 List<ProductCategory> categorylist=ctagService.getAllCategorys();
			 
				List<Product> prod= prodRepo.findByActive(true);
				model.addAttribute("list1",prod);
			 
			 System.out.println(categorylist);
			if(!product1.isEmpty()) {
				model.addAttribute("product", product1);
				model.addAttribute("categorylist",categorylist);
				return "viewProduct";
		}
			
		
		}
		else{
			if( prodStr!=null &&  !prodStr.equals("")) {
				productCategory=prodStr;
		   }
			/*List<Product> product=prdService.getAllProductsByCategory(productCategory);*/
			List<ProductCategory> categorylist=ctagService.getAllCategorys();
			/*	System.out.println(product+"this is produc method");
				model.addAttribute("product", product);*/
			model.addAttribute("categorylist",categorylist);
			return "viewProduct";
		}
		return "viewProduct";
		
}
	
	
/*@RequestMapping("/category/{id}/products")
public List<Product> getProductsByCategoryId(@PathVariable int id){
	return prodRepo.findByActiveAndCategoryId(true, id);
}*/
	
	
	
	
	
	
	
	
	
	
	///-------------------------------singel delete------------------------------------------------///
	@RequestMapping(value = "deletebatchs/{ids}", method = RequestMethod.GET)
			String deleteProduct1(@PathVariable Integer ids,Model model) {
			 boolean isDeleted=prdService.deleteProduct(ids);
			 
			 if(isDeleted) {
				 return "redirect:/viewAll";
			 }
			return null;	 
			}
	
	
	
	
	@RequestMapping(value = "deletebatch/{ids}", method = RequestMethod.GET)
	String deleteProduct(@PathVariable Integer[] ids,Model model) {
	 boolean isDeleted=prdService.deleteWelcomeByIds(ids);
	 if(isDeleted) {
		 return "redirect:/viewAll";
	 }
	return null;	 
	}
				



@RequestMapping("/editrecors/{ids}")
public String showEdit(
		@PathVariable("ids")Integer id,
		Model model
		) 
{
	//load Model class object from DB by using Id
	Product p=prdService.getOneProduct(id);
	//send to UI as Form Backing object
	model.addAttribute("product", p);
	
	return "AddProduct";
}


@RequestMapping(value= {"/show/category/{categoryId}"})
public String showCategoryProduct(@PathVariable(required = false)Integer categoryId,Model model) {
	//get one product
	if(categoryId==0) {
		
		List<Product> prod= prodRepo.findByActive(true);
		model.addAttribute("list1",prod);
		 List<ProductCategory> categorylist=ctagService.getAllCategorys();
		 
			/* Integer catego=1;
				String image11 = repo.findImageUrlById(catego);
				model.addAttribute("imageOne", image11);*/
		 
		 model.addAttribute("categorylist",categorylist);
		 return "viewProduct";
	}
	
	else {
		ProductCategory category=ctagService.getOneProduct(categoryId); 
		List<Product> list1=prodRepo.findByActiveAndCategoryId(true,categoryId);
		
		 List<ProductCategory> categorylist=ctagService.getAllCategorys();
		 model.addAttribute("categorylist",categorylist);
		 Integer catego=1;
			String image11 = repo.findImageUrlById(catego);
			model.addAttribute("imageOne", image11);
		 
		
		model.addAttribute("category",category);
		model.addAttribute("list1",list1);
		System.out.println(list1);
		return "viewProduct";
		
	}
	
}
}








	
