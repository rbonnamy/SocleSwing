package fr.diginamic.composants.ui.container;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RichardBONNAMY
 *
 */
public class Row {

	/** cols */
	private List<Col> cols = new ArrayList<>();
	
	/** Représente le numéro de la rangée de 0 pour la première à n pour la dernière */
	private int posY;
	
	/** size */
	private int size;
	
	/** spacing */
	private int spacing;
	
	/**
	 * @param col
	 */
	public void addCol(Col col) {
		this.cols.add(col);
		this.size += col.getSize();
		col.setParent(this);
		col.setPosX(cols.size());
		col.setPosY(getPosY());
	}
	
	public Col getLastCol() {
		return cols.get(cols.size()-1);
	}

	/** Getter
	 * @return the cols
	 */
	public List<Col> getCols() {
		return cols;
	}

	/** Setter
	 * @param cols the cols to set
	 */
	public void setCols(List<Col> cols) {
		this.cols = cols;
	}

	/** Getter
	 * @return the size
	 */
	public int getSize() {
		return size;
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

	public int getWidth() {
		return 0;
	}
}
