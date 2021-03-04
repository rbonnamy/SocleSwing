package fr.diginamic.services.exemples;

import java.awt.Color;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;

public class Exemple7Service extends MenuService {

	@Override
	public void traitement() {

		console.clear();
		console.println("<h1 class='bg-turquoise'><center>Titre avec fond bleu clair</center></h1>");

		// On commence par créér le formulaire vide
		Form form = new Form();
		
		form.addInput(new TextField("Nom:", "nom"));
		form.addInput(new TextField("Prénom:", "prenom", false));
		
		// Création d'un validator qui stocke les règles de gestion
		Exemple6FormValidator validator = new Exemple6FormValidator();
		
		// La méthode suivante permet d’afficher le formulaire.
		// La méthode retourne false si l’utilisateur a cliqué sur Annuler, sinon 
		// retourne true
		boolean valide = console.input("Demande d'informations", form, validator);

		// Récupéation des informations saisies
		if (valide) {
			console.print("Vous vous <b>appelez</b> ").println("<span style='color:red'>"+form.getValue("nom")+" "+form.getValue("prenom")+"</span>");
		}
	}

	public void modifier(Long id) {
		console.println("Modification de l'item " + id, Color.GREEN);
	}

	public void supprimer(Long id) {
		console.println("Suppression de l'item " + id, Color.RED);
	}

}
