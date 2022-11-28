<%@ page import="beans.Utilisateur" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp"/>
<script src="<c:url value='/js/script.js'/>"></script>


 <div id="corps">
<h1 id="titre-principal">Liste des utilisateurs</h1>
<c:choose>
	<c:when test="${empty utilisateurs }">
	   <div class="info">
		<p >La liste des utilisateurs est vide</p>
	  </div>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>ID</th>
		    <th>Prenom</th>
		    <th>Nom</th>
		    <th>Login</th>
		    <th>Password</th>
		    <th colspan="2">Actions</th>
		  </tr>
		  	<c:forEach var="utilisateur" items="${utilisateurs }">
		  		<tr>
		    	  <td><c:out value="${utilisateur.id }" /></td>
		    	  <td><c:out value="${utilisateur.nom}" /></td>
		    	  <td><c:out value="${utilisateur.prenom }" /></td>
		    	  <td><c:out value="${utilisateur.login }" /></td>
		    	  <td><c:out value="${utilisateur.password }" /></td>
		    	  <td> <a href="update?id=${utilisateur.id }">Modifier</a>  </td>
		    	  <td><a href="Delete?id=${utilisateur.id }" onclick="return confirmerSuppression()">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
 <%@include file="inc/footer.jsp" %>
