package in.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name ="JavedProduct")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@NotBlank(message="Product name should not be empty!!")
	@Column(name = "PRODUCT_NAME")
	private String productName;

		@NotNull(message="Product Price should not be empty!!")
	@Column(name = "PRODUCT_PRICE")
	private double productPrice;


	@Column(name = "PRODUCT_QUANTITY")
	private double productQyt;

	@Column(name = "PRODUCT_DISCOUNT")
	private double discount;

	private boolean active=true;

	@Column(name = "IMAGE_URL")
	private String image;

	
	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductCategory category;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String description;

	@Column(name = "FINAL_PRICE")
	private double finalPrice;

	@Column(name = "PRODUCT_SIZE")
	private float size;

	@Column(name = "PRODUCT_TAX")
	private double tax;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;

}
