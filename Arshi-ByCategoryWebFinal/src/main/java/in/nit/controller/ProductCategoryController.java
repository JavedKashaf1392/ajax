package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ProductCategory;
import in.nit.service.productCategoryService;

@Controller
public class ProductCategoryController {
	
	@Autowired
	private productCategoryService ctagService;
	
	
	@RequestMapping("/productCategory")
	public String loadFormProduct(Model model) {
		ProductCategory category=new ProductCategory();
		model.addAttribute("category", category);
		return "ProductCategory";
		
	}
		@PostMapping("/productCategorySave")
		@ResponseBody
		public  String handleCategorySubmission(@RequestBody ProductCategory category) {
			ctagService.saveProductCategory(category);
			System.out.println(category);
			
			return "data is here"+category;
			
		}
	
}
