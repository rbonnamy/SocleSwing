package fr.diginamic.services.exemples;

import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.Application;
import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.services.exemples.daos.PersonneDao;
import fr.diginamic.services.exemples.entite.Personne;

/**
 * Classe de service associée à l'exemple 5
 * 
 * @author RichardBONNAMY
 *
 */
public class Exemple5Service extends MenuService {

	/** personneDao */
	private PersonneDao personneDao;

	/**
	 * Constructeur
	 * 
	 */
	public Exemple5Service() {
		
		EntityManager em = Application.emf.createEntityManager();
		
		personneDao = new PersonneDao(em);
		personneDao.init();
	}

	@Override
	public void traitement() {

		// Exemple
		List<Personne> personnes = personneDao.getPersonnes();

		console.clear();
		console.println("<h1 class='bg-green'><center>Liste des clients</center></h1>");

		String html = "<table class='table' cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Nom</td><td>Prénom</td></tr>";
		for (Personne personne : personnes) {
			html += "<tr>" + "  <td><a class='btn-blue' href='modifier(" + personne.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href='supprimer(" + personne.getId()
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + "  <td width='150px'>"
					+ personne.getNom() + "</td>" + "  <td width='150px'>" + personne.getPrenom() + "</td>" + "</tr>";
		}
		html += "</table>";

		console.println(html);
		console.print("Ajouter un client",
				"<a class='btn-blue' href='ajouter()'><img width=25 src='images/plus-blue.png'></a>");
	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur l'icone +
	 */
	public void ajouter() {
		// On commence par créér le formulaire vide
		Form form = new Form();

		// On ajoute au formulaire 2 champs de type texte.
		form.addInput(new TextField("Nom:", "nom"));
		form.addInput(new TextField("Prénom:", "prenom"));

		// Création d'un validator qui stocke les règles de gestion
		Exemple5AjoutValidator formValidator = new Exemple5AjoutValidator();
		boolean validation = console.input("Ajout d'une nouvelle personne", form, formValidator);
		if (validation) {
			
			Personne nvPersonne = new Personne(form.getValue("nom"), form.getValue("prenom"));
			personneDao.inserer(nvPersonne);
			
			traitement();
		}
	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de modification
	 * dans la table des clients.
	 * 
	 * @param id identifiant du client à modifier.
	 */
	public void modifier(Long id) {

		Personne personne = personneDao.getPersonne(id);

		// On commence par créér le formulaire vide
		Form form = new Form();

		// On ajoute au formulaire 2 champs de type texte pour permettre de modifier le
		// nom et le prénom du client
		form.addInput(new TextField("Nom:", "champ1", personne.getNom()));
		form.addInput(new TextField("Prénom:", "champ2", personne.getPrenom()));

		// Les règles métier sont vérifiées dans le validator
		Exemple5FormValidator validator = new Exemple5FormValidator();

		boolean valide = console.input("Modification du client " + personne.getPrenom() + " " + personne.getNom(), form,
				validator);
		if (valide) {
			String nvNom = form.getValue("champ1");
			String nvPrenom = form.getValue("champ2");
			personne.setNom(nvNom);
			personne.setPrenom(nvPrenom);

			personneDao.modifier(personne);

			traitement();
		}
	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de suppression
	 * dans la table des clients
	 * 
	 * @param id identifiant du client à supprimer.
	 */
	public void supprimer(Long id) {
		boolean result = console.confirm("Suppression de l'item " + id,
				"Confirmez-vous la suppression de l'item n°" + id);
		if (result) {
			personneDao.supprimer(id);
			traitement();
		}
	}

}
