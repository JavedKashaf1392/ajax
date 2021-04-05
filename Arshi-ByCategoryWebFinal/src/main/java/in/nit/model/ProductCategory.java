package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="JavedCategory")
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer id;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="IMAGE_URL")
	private String imageUrl;
	
	@Column(name="ACTIVE")
	private boolean active=true;

}
