package rest.projet.apirest.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection= "employee")

public class Employee {

    @Id
    private ObjectId id;
    private String nom;
    private String prenom;
    private String domaine;
    private String email;

    

    /**
     * @return int return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * @return String return the domaine
     */
    public String getDomaine() {
        return domaine;
    }

    /**
     * @param domaine the domaine to set
     */
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    
    /**
     * @return String return the email
     */
    public String getEmail() {
		return email;
	}

    /**
     * @param domaine the email to set
     */
	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public String toString() {
        return "Employee [ id"+ id + ", nom=" + nom + ", prenom=" + prenom + ", domaine=" + domaine +", email" + email + "]";
      }

	
}