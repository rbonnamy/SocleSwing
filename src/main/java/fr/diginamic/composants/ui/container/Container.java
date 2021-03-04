package fr.diginamic.composants.ui.container;

import java.util.ArrayList;
import java.util.List;

public class Container {

	private List<Row> rows = new ArrayList<>();
	
	public List<Input> getInputs(){
		
		List<Input> inputs = new ArrayList<>();
		for (Row r: rows) {
			for (Col c: r.getCols()) {
				inputs.addAll(c.getInputs());
			}
		}
		return inputs;
	}
	
	public Row getLastRow() {
		return rows.get(rows.size()-1);
	}

	public int getWidth() {
		
		int width=0;
		for (Row row: rows) {
			if (row.getWidth()>width) {
				width = row.getWidth();
			}
		}
		return width;
	}
	
	public int getHeight() {
		
		int width=0;
		for (Row row: rows) {
			if (row.getWidth()>width) {
				width = row.getWidth();
			}
		}
		return width;
	}
	

	/** Ajout d'une rangée
	 * @param row rangée
	 */
	public void addRow(Row row) {
		row.setPosY(rows.size());
		rows.add(row);
	}
	
	/** Getter
	 * @return the rows
	 */
	public List<Row> getRows() {
		return rows;
	}

	/** Setter
	 * @param rows the rows to set
	 */
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	
	
}
