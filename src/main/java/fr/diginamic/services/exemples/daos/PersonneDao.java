package fr.diginamic.services.exemples.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.db.SqlUtils;
import fr.diginamic.services.exemples.entite.Personne;

/** Classe de persistence des personnes (classe {@link Personne})
 * @author RichardBONNAMY
 *
 */
public class PersonneDao {
	
	/** entity manager */
	private EntityManager em;

	/** Constructeur
	 * @param em entity manager
	 */
	public PersonneDao(EntityManager em) {
		super();
		this.em = em;
	}

	/** Retourne une personne en fonction de son id
	 * @param id identifiant
	 * @return {@link Personne}
	 */
	public Personne getPersonne(Long id){
		return em.find(Personne.class, id);
	}
	
	/** Retourne la liste de toutes les personnes
	 * @return List de {@link Personne}
	 */
	public List<Personne> getPersonnes(){
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p", Personne.class);
		return query.getResultList();
	}
	
	/** Insérer une personne
	 * @param personne nouvelle personne
	 */
	public void inserer(Personne personne) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(personne);
		
		transaction.commit();
	}
	
	/** Modifie une personne
	 * @param personne personne avec les nouvelles données
	 */
	public void modifier(Personne personne) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Personne personneDB = getPersonne(personne.getId());
		if (personneDB!=null) {
			personneDB.setNom(personne.getNom());
			personneDB.setPrenom(personne.getPrenom());
		}
		
		transaction.commit();
		
	}

	/** Suppression de la personne dont l'id est passé en paramètre
	 * @param id identifiant de la personne
	 */
	public void supprimer(Long id) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Personne personneDB = getPersonne(id);
		if (personneDB!=null) {
			em.remove(personneDB);
		}
		transaction.commit();
	}
	
	/**
	 * Lance un script d'initialisation si la table des personnes est vide
	 */
	public void init() {
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p", Personne.class);
		List<Personne> clients = query.getResultList();
		if (clients.size()==0) {
			SqlUtils.executeFile("exemple.sql", em);
		}
	}
}
