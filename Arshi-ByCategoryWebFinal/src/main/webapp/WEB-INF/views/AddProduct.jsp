<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">  
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
  <link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="./views/css/jquery-ui.css">

<script
  src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
  integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
  crossorigin="anonymous"></script>
  
  
  <style>
.container {
	max-width: 540px;
	padding:10px;
	padding-left:10px;
	padding-right:10px;
	width: 500px;
	border: 1px solid blue;
	border-radius: 7px;
	box-shadow: 5px 17px 10px #956d6d;
	background: #fff;
}

.text-info {
	color: #17a2b8 !important;
	font-weight: bold;
}

.back {
	background-color: #e4ead8;
}
.fieldContainer {
    position: relative;
   /*  margin-bottom: 5px; */
}
label.error {
    position: absolute;
     right: 1px;
    top: -0.3px;
    border: solid 1px red;
    background: lightgray;
    box-shadow: 0px 2px 6px rgba(0, 0, 0, .7);
    padding: 1px 2px;
}
.error {
		color: red;
		font-style: italic;
	}
  </style>
  
  
   <script type="text/javascript">
  // Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[id='adding']").validate({
	 
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      productName: "required",
      productPrice: "required",
      isAvailable:"required",
      image:"required",
      productQyt:"required",
      description:"required",
     /*  email: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      }, */

      productPrice:{
    	  required: true,
          },

      productQyt:{
    	  required: true,
          },
          Serial:{
        	  required: true,
              minlength: 7
              },

          
          
       size: {
        required: true,
      } ,
      productCategory: {
          required: true
      },
    },
    // Specify validation error messages
    messages: {
    	productName: "Please enter Product Name",
    	productPrice: "Please enter Product Price",
      isAvailable:"product should be available",
      required:"product should be available",
      image:"image should be place here",
      description:"Its optiona based on you ",

      size: {
        required: "Please provide size here",
       
      }, 
      

     

      productQyt:{
    	  required: "Please provide your quantity here",
         
          },

          Serial:{
        	  required: "pleaen enter Serial Number",
              minlength: "max lenth is 7 digits"
              },
          
          productCategory: "Select Atleast  One Category"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
  </script>

<!-- <script type="text/javascript">
$('#Serial').keypress(function(e){
	console.log(e);
	console.log(typeof(e.which));
	if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
		return false;
	 }	
	else  if (e.which != 8 && e.which != 0 && (e.which <= 57 &&  e.which >= 48)) {
	var zzn1=$('#Serial').val();
			console.log(e);
		if(event.keyCode!='8'){
			console.log("jtkakasm");
			if(zzn1.length==6){
				$('#Serial').val(zzn1+'-');
				}
			else if(zzn1.length==3){
				$('#Serial').val(zzn1+'-');
			}
		}
	}
});

}); -->

  </script>
  
  
  
  
</head>
<body>
<h2>Welcome to product</h2>
</body>
<h2>${msg}</h2>
<a href="/viewAll">View App Products</a>
<div class="form">
<div class="container" align="left">
  <form:form id="" action="SaveProduct" modelAttribute="product" method="POST">
  
  
  <div class="fieldContainer">
  <label for="productName" class="text-info">Product Name</label>
  <form:input path="productName" cssClass="form-control"/>
  <form:errors path="productName" cssClass="error"></form:errors>
  
   </div>


 

  
 <div class="fieldContainer">
  <label for="productPrice" class="text-info">Product Price</label>
  <form:input path="productPrice" cssClass="form-control"  placeholder="Enter Your Price"/> </div>
     
 <div class="fieldContainer">
 <label for="productPrice" class="text-info">Product Quntity</label>
  <form:input path="productQyt"  cssClass="form-control"   placeholder="write your Quantity"/> </div>
  

  
    
<div class="fieldContainer">
  <label for="description" class="text-info">Description</label>
  <form:input path="description" cssClass="form-control" placeHolder="Add your Descriptions here"/>
  <form:errors path="description" cssClass="error"></form:errors>
   </div>

  
<div class="fieldContainer">
   <label for="image" class="text-info">Product Image</label>
  <form:input path="image" cssClass="form-control"/> </div>

  
    
<div class="fieldContainer">
     <label for="image" class="text-info">Product Size</label>
  <form:input path="size"  cssClass="form-control" placeholder="provide just 10 items"/> </div>

    
    
    <div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category</label>
							<div class="col-md-8">
								<form:select class="form-control" id="categoryId"
									path="category" items="${categories}"
									itemLabel="categoryName" itemValue="id">
								</form:select>
								
								
								
		
    
    
   
    
    
    <br>
   <div class="fieldContainer"><button class="btn btn-primary" type="submit">Add Product</button></div>
   

  </form:form>
  </div>
  </div>



</html>