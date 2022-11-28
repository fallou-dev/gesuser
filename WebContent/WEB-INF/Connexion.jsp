<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="inc/header.jsp" %>
   <div id="corps">
     <h1 id="titre-principal">Authentification</h1>
	 <c:if test="${connexionFailed }">
	 <p class="erreurMessage">Login et/ou mot de passe incorrect</p>
	 </c:if>
	<form method="post" action="/gesusers/login">
	<div class="formItem">
     	<label>Login</label>
		<input type="text" name="login">
	</div>
	   <div class="formItem">
		<label>Mot de passe </label>
		<input type="password" name="motdepasse">
		</div>
		<div class="formItem">
		   <label></label>
			<input type="submit" value="Connecter">
		</div>		
	</form>
	</div>
 <%@include file="inc/footer.jsp" %>