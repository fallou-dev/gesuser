<%@include file="inc/header.jsp" %>
 <div id="corps">
<h1 id="titre-principal">Ajout utilisateur</h1>
   <p class="messageBox ${status ? 'succes' : 'erreur' }">${statusMessage}</p>
   <form action="" method="post">
 
    <div class="formItem">
    <label>Prenom</label>
    <input type="text" name="prenom" ><br>
    <span class="erreur">${erreurs.nom}</span>
    </div>
    <div class="formItem">
    <label>Nom</label>
    <input type="text" name="nom" ><br>
     <span class="erreur">${erreurs.prenom }</span>
    </div>
    <div class="formItem">
    <label>Login</label>
    <input type="text" name="login" ><br>
     <span class="erreur">${ erreurs.login}</span>
    </div>
    <div class="formItem">
    <label>Passsword</label>
    <input type="text" name="password"><br>
     <span class="erreur">${erreurs.password }</span>
    </div>
    <div class="formItem">
    <label>Passsword (confirmation)</label>
    <input type="text" name="passwordBis"><br>
     <span class="erreur">${erreurs.passwordBis }</span>
    </div>
    <div class="formItem">
    <label></label>
    <input type="submit" value="Ajouter" >
    </div>
  </form>  
  </div>
<%@include file="inc/footer.jsp" %>