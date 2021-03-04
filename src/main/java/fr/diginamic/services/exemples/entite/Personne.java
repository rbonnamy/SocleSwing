package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.diginamic.composants.annotations.HtmlEntete;
import fr.diginamic.composants.annotations.HtmlTable;

/** Représente une personne avec juste un nom et un prénom.
 * @author RichardBONNAMY
 *
 */
@Entity
@Table(name="personnes")
@HtmlTable(id="table01", cssClass = "table")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** nom */
	@HtmlEntete(nom = "Nom")
	private String nom;
	
	/** prenom */
	@HtmlEntete(nom = "Prénom")
	private String prenom;

	/** Constructeur par défaut INDISPENSABLE pour JPA
	 * 
	 */
	public Personne() {
		super();
	}

	/** Constructeur
	 * @param nom nom
	 * @param prenom prénom
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
