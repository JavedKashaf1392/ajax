<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<h2>this is the category</h2>
<div >
<h2 id="response"></h2>
</div>

<form action="/productCategorySave" method="post" modelAttribute="category" id="form">
<table>
<tr>
<th><label>Product Name</label></th>
<td><input type="text"  name="categoryName" id="categoryName"/></td>
</tr>

<tr>
<th><label>Product Description</label></th>
<td><input type="text" name="description" id="description"/></td>
</tr>


<tr>
<th><label>Enter your image</label></th>
<td><input type="text"  name="imageUrl" id="imageUrl"/></td>
</tr>



<tr>
<td><button type="submit" id="butt">Save</button></td>
</tr>


</table>
</form>


<h2>${productId}</h2>
<script type="text/javascript">
$(document).ready(function () {

$("#form").submit(function (event) {

    //stop submit the form, we will post it manually.
    event.preventDefault();

    fire_ajax_submit();

});

});

function fire_ajax_submit() {

var search = {};
search["categoryName"] = $("#categoryName").val();
search["description"] = $("#description").val();
search["imageUrl"] = $("#imageUrl").val();


alert(JSON.stringify(search));

$.ajax({
    type: "POST",
    contentType: "application/json",
    url: "productCategorySave",
    data: JSON.stringify(search),
    dataType: 'html',
    
    success: function(data) {
    $("#response").append(data);
    console.log(data);
    console.log("hello")
    alert(data)
 },
  
    error: function (e) {
    alert('respone back is error')
    },
    
    
});

};


</script>

</body>
</html>