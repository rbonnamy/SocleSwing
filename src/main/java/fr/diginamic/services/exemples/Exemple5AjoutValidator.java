package fr.diginamic.services.exemples;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

/** validateur associé au formulaire
 * @author rbonn
 *
 */
public class Exemple5AjoutValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nvNom = form.getValue("nom");
		String nvPrenom = form.getValue("prenom");
		
		if (nvNom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		}
		else if (nvPrenom.trim().isEmpty()) {
			console.alert("Le prénom est obligatoire !");
			return false;
		}
		return true;
	}

}
