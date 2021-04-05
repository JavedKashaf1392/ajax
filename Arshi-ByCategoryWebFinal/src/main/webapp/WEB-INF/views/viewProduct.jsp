<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    
       
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
   <s:url var="image" value="/imges"></s:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    
   <!--  format submitted to controller -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function() {
            $('#prodId').on('change', function() {
                this.form.submit();
            });
        });
        </script>
        
        <!-- Check alls records --> 
        <script type="text/javascript" language="JavaScript">
        function checkall(){
    var checked = $('input:checkbox[id^="bulkwelcome_"]');
    if($('input.checkall').is(':checked')) {
    	var x = window.confirm("Are you sure to want to Select these All ChecksBoxes!!!?");
        if(x && checked.length > 0){
            $('.bulkwelcome').each(function(){
                this.checked = true;
            });
        }
    } else {
        if(checked.length > 0){
            $('.bulkwelcome').each(function(){
                this.checked = false;
            });
        }
    }
}
      </script> 
      
       <!--  slecect one one rows -->
      <script type="text/javascript" language="JavaScript">
      function deleterecords() {
    	    var ids = $('input:checkbox:checked.bulkwelcome').map(function () {
    	                  return this.value;
    	                 }).get();
    	     
    	    if(ids.length == 0){
    	        alert("Please select at least one record");
    	        return false;
    	    }
    	     
    	    var x = window.confirm("Are you sure to want to delete these records ?");
    	    if (x && (ids.length > 0)) {
    	        window.location = "/deletebatch/"+ids;
    	    }
    	}
      </script>     
      
        <!-- --------------------------edit is her  -->
        
         <script type="text/javascript" language="JavaScript">
        function editrecords() {
            var ids = $('input:checkbox:checked.bulkwelcome').map(function () {
                          return this.value;
                         }).get();
            if(ids.length == 0){
                alert("Please select at least one record");
                return false;
            }
           /*  var x = window.confirm("Are you sure you want to edit this record?"); */
            if ((ids.length > 0)) {
                window.location = "editrecors/"+ids;
            }
        }
         </script>
         
        <!-- edit is end here and we are working for edit -->  
        </head>
        <h2>${err}</h2>
        
          
      <p class="lead">Shop Name</p>
                <div class="list-group">
                <a href="/show/category/0"  class="list-group-item">view All</a>
                
               
            
                
                
                
                
        
        
        
<body align="center">
	<form action="viewAll">
	<table align="center">
	<tr>
	<td>
	<select name="productCategory" id="prodId">
	<option value="">--Select--</option>
	<option value="Milk">Milk</option>
	<option value="Organic">Organic</option>
	<option value="InOrganic">InOrganic</option>
	</select>
	</td>
	</tr>
	</table>
	</form>
<br>



<tr>
  <th><input type="checkbox" name="checkall" class="checkall" id="checkall" onclick="checkall()" />All</th>

		
			<%-- <c:forEach items="${product}" var="v" varStatus="index">
					<tr> <td><img  src="<%=request.getContextPath()%>/imges/${v.image}" height="100" width="150" ></td>
					<td>
                <input type="checkbox" name="bulkwelcome" class="bulkwelcome"
                id="bulkwelcome_${v.productId}" value="${v.productId}"/>&nbsp;
					${v.productName}
					${v.productPrice}
					${v.productQyt}
				    ${v.discount}
					
					${v.finalPrice}
					${v.size}
					${v.tax}
					<td> <img src="${image}/${v.image}" width="100" height="100"></td></tr>
			</c:forEach><br> --%>
			
			
			<c:forEach items="${list1}" var="v" varStatus="index">
					<tr> <td><img  src="<%=request.getContextPath()%>/imges/${v.image}" height="100" width="150" ></td>
					<td>
                <input type="checkbox" name="bulkwelcome" class="bulkwelcome"
                id="bulkwelcome_${v.productId}" value="${v.productId}"/>&nbsp;
					${v.productName}
					${v.productPrice}
					${v.productQyt}
				    ${v.discount}
					
					${v.finalPrice}
					${v.size}
					${v.tax}
					<td> <img src="${image}/${v.image}" width="100" height="100"></td></tr>
			</c:forEach><br>
			
			
		
	<br>
	<div align="center"><input class="btn btn-warning"  type="button" value="Delete" name="delete" id="delete" onclick="deleterecords();">&nbsp;
	 <input class="btn btn-danger" type="button" value="Edit" name="edit"  onclick="editrecords()"></div>
</body>
</html>