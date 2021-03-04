package fr.diginamic.composants.ui;

import java.util.Iterator;
import java.util.Optional;

import fr.diginamic.composants.error.ErrorManager;
import fr.diginamic.composants.ui.container.Col;
import fr.diginamic.composants.ui.container.Container;
import fr.diginamic.composants.ui.container.Input;
import fr.diginamic.composants.ui.container.Row;

/** Formulaire
 * @author RichardBONNAMY
 *
 */
public class Form implements Iterable<Row> {

	/** container */
	private Container container = new Container();
	
	/** Retourne un champ de saisie à partir de son nom
	 * @param name nom du champ
	 * @return {@link Input}
	 */
	public Input getInput(String name) {
		Optional<Input> optional = container.getInputs().stream().filter(i -> i.getName().equals(name)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void addRow() {
		container.addRow(new Row());
	}
	
	public void addCol(int size) {
		container.getLastRow().addCol(new Col(size));
	}
	
	/** Ajoute un champ de saisie
	 * @param input champ de saisie
	 */
	public void addInput(Input input) {
		if (input==null) {
			ErrorManager.manage("Il est interdit d'ajouter un champ null dans le formulaire.");
		}
		else if (container.getInputs().contains(input)) {
			ErrorManager.manage("Il existe déjà un champ de saisie avec le nom "+input.getName()+" dans le formulaire.");
		}
		container.getLastRow().getLastCol().addInput(input);
	}

	/** Retourne la valeur saisie pour un champ de saisie donné
	 * @param name nom du champ de saisie
	 * @return String
	 */
	public String getValue(String name) {
		return getInput(name).getValue();
	}

	/** Retourne le nb de champs de saisie
	 * @return int
	 */
	public int size() {
		return container.getInputs().size();
	}

	@Override
	public Iterator<Row> iterator() {
		return container.getRows().iterator();
	}

	/** Getter
	 * @return the container
	 */
	public Container getContainer() {
		return container;
	}

	/** Setter
	 * @param container the container to set
	 */
	public void setContainer(Container container) {
		this.container = container;
	}
}
