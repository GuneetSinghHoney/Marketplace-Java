<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ page import="DAO.Product" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function myfunction(){alert("Product Added to Cart !");}
</script>

</head>
<body style="background-color: #c0392b">
<center>
<%
if(request.getAttribute("flag").equals("T")){ %>
<h1 style="color: white;"> Product Added to Cart !</h1>
<%}
%> 
<hr>
<div style="position: static;overflow: auto">
<div style="background-color: #FFEB3B;position: relative;float: left;">

 
	<img src="images/aa.jpg"/>
 
</div>
<div>
 <form action="checkout" method="get">
		<input type="image" style="height: 100;width: 200px" src="images/checkout.png">
	</form>
</div>

</div>
<%

 ArrayList<Product> arr = (ArrayList<Product>) request.getAttribute("products");
for(Product prod:arr)
{
%>
<hr><br>
<div style="position: static;overflow: auto">
<div style="position: relative;float: left;">

	<img style="height: 200px;width: 200px;border: highlight;border-left-width: 1cm;" src="images/<%=prod.getId()%>.png"/>

</div>


<div style="margin-top:10px;background-color:#e74c3c ;font-size: 20px;font: 200;font-family: monospace;color: white;align-content: flex-start;"> 
<table>
<tr>
<td><b>Name:</b></td> <td><i><%=prod.getName()%></i></td>
</tr>
<tr>
<td><b>SKU:</b></td> <td><i><%=prod.getSKU()%></i></td>
</tr>
<tr>
<td><b>In stock:  </b></td> <td><i><%=prod.getNumberInstock()%></i></td>
</tr>
<tr>
<td><b>Price: </b></td><td> <i><%=prod.getUnitPrice()%></i></td>
</tr>
<tr>
<td><b>Description:</b></td><td> <i><%=prod.getDescription()%></i></td>
</tr>
<tr>
<td><b>Availability:</b></td><td> <i><%=prod.isAvailable()%></i></td>
</tr>
</table>
<%if(prod.isAvailable()==true) {%>

<form action="base" method="post">
<input type="hidden" onclick="myfunction()" value="<%=prod.getId()%>" name="id" />
<input type="submit" value="Add to Cart">
</form>
<%} else{ %>
<h2 style="color: red"> SOLD OUT</h2>
<%} %>
</div>
</div>
 <br>
<%} %>
</center>
</body>
</html>