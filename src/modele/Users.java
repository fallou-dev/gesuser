package modele;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import beans.Utilisateur;

public class Users {
    private Connection connexion;
    
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM utilisateur;");

            // Récupération des données
            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                
                Utilisateur utilisateur = new Utilisateur(id,nom,prenom,login,password);
                
                
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return utilisateurs;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesuser", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(nom, prenom, login, password) VALUES(?, ?,?,?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modifierUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE utilisateur SET nom= ?, prenom=?, login=?, password=? where id=? ;");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());
            preparedStatement.setInt(5, utilisateur.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void supprimerUtilisateur(int id) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM utilisateur where id=? ;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Utilisateur get(int id) {
       
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            
            PreparedStatement stmt=connexion.prepareStatement("SELECT nom,prenom,login,password FROM utilisateur where id=?;");
            stmt.setInt(1, id);
            resultat=stmt.executeQuery(); 
            // Récupération des données
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                
                Utilisateur utilisateur = new Utilisateur(nom,prenom,login,password);
                return utilisateur;
                
               
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return null;
    }
}
