<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="DAO.ProductArrayDAO" %>
    <%@ page import="DAO.database" %>
    <%@ page import="DAO.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image:images/bg.png"> 
<center>
<%
ArrayList<Integer> arr;
try{
 arr = (ArrayList<Integer>) request.getSession().getAttribute("cart");
}
catch(Exception e){
	arr = new ArrayList<Integer>();
}
 ProductArrayDAO obj = database.getInstance().getProducts();
 
 for(int i: arr)
 {
	 Product prod = obj.getProduct(i);
%>
<div style="position: static;overflow: auto;margin-left: 120px">
<div style="margin-top:10px;background-color:#e74c3c ;font-size: 20px;font: 200;font-family: monospace;color: white;position: relative;float: left;"> 
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
<td><b>Availability:</b></td><td> <i><%=prod.isAvailable()%></i></td>
</tr>
<tr>
<td><b>Details:</b></td><td> <i><%=prod.getDescription()%></i></td>
</tr>
</table>
</div>
<div style="position: relative;float: right;margin-right: 400px;margin-top: 50px">
Select Quantity:  
  <select name="Quantity">
  
  <%for(int x=1;x<=prod.getNumberInstock();x++){ %>
    <option><%=x%></option>
   <%} %>
  </select>
</div>

</div>
<hr>
<%} %>
<form action="checkout" method="post">
<input type="submit" value="Pay Now">
</form>
</center>
</body>
</html>