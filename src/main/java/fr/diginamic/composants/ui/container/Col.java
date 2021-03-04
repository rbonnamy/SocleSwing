package fr.diginamic.composants.ui.container;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.composants.error.ErrorManager;

/** Colonne
 * @author RichardBONNAMY
 *
 */
public class Col {

	private Row parent;
	
	/** représente la position horizontale dans la rangée */
	private int posX;
	
	/** représente la position verticale (celle de sa rangée d'appartenance) dans le conteneur */
	private int posY;
	
	/** représente l'espace occupé par la colonne en 1/12ème (comme Boostrap) */
	private int size = 1;

	/** spacing entre inputs*/
	private int spacing = 10;
	
	/** orientation */
	private Orientation orientation = Orientation.VER;
	
	/** inputs */
	public List<Input> inputs = new ArrayList<>();

	/** Constructeur
	 * @param size taille de 1 à 12
	 */
	public Col(int size) {
		super();
		if (size>12 || size<1) {
			ErrorManager.manage("Une colonne a une taille comprise entre 1 et 12.");
		}
		this.size = size;
	}
	
	/** Ajout d'un champ dans la colonne
	 * @param input champ
	 */
	public void addInput(Input input) {
		inputs.add(input);
		input.setParent(this);
		if (orientation==Orientation.HOR) {
			input.setPosX(inputs.size());
			input.setPosY(0);
		}
		else {
			input.setPosX(0);
			input.setPosY(inputs.size());
		}
	}
	
	/** Retourne la largeur de la colonne
	 * @return int
	 */
	public int getWidth() {
		int width = 0;
		if (orientation.equals(Orientation.HOR)) {
			for (Input i: inputs) {
				width+=getSpacing()+i.getWidth();
			}
			width+=getSpacing();
		}
		else {
			for (Input i: inputs) {
				if (i.getWidth()>width) {
					width=i.getWidth();
				}
			}
			width+=2*getSpacing();
		}
		return width;
	}
	
	/** Retourne la hauteur de la colonne
	 * @return int
	 */
	public int getHeight() {
		int height = 0;
		if (orientation.equals(Orientation.HOR)) {
			for (Input i: inputs) {
				if (i.getHeight()>height) {
					height=i.getHeight();
				}
			}
			height+=2*getSpacing();
			
		}
		else {
			for (Input i: inputs) {
				height+=getSpacing()+i.getHeight();
			}
			height+=getSpacing();
		}
		return height;
	}

	/** Getter
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/** Setter
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/** Getter
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/** Setter
	 * @param orientation the orientation to set
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	/** Getter
	 * @return the inputs
	 */
	public List<Input> getInputs() {
		return inputs;
	}

	/** Setter
	 * @param inputs the inputs to set
	 */
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	/** Getter
	 * @return the spacing
	 */
	public int getSpacing() {
		return spacing;
	}

	/** Setter
	 * @param spacing the spacing to set
	 */
	public void setSpacing(int spacing) {
		this.spacing = spacing;
	}

	/** Getter
	 * @return the parent
	 */
	public Row getParent() {
		return parent;
	}

	/** Setter
	 * @param parent the parent to set
	 */
	public void setParent(Row parent) {
		this.parent = parent;
	}

	/** Getter
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/** Setter
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/** Getter
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/** Setter
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

}
