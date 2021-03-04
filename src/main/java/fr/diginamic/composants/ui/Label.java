package fr.diginamic.composants.ui;

import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.diginamic.composants.ui.container.Input;

public class Label extends Input{
	
	/** texte */
	private String texte;
	
	/** label */
	private JLabel label;

	public Label(String name, String texte) {
		super(null, name);
		this.texte = texte;
		this.label = new JLabel(texte);
	}

	@Override
	public JComponent convert() {
		return label;
	}

	@Override
	public String getValue() {
		return texte;
	}

	@Override
	public void setValue(JComponent value) {
		
	}
	
	/** Getter
	 * @return the width
	 */
	public int getWidth() {
		return texte.length()*10+100;
	}
	
	public int getHeight() {
		return (int)label.getPreferredSize().getHeight();
	}

	@Override
	public InputType getType() {
		return InputType.LABEL;
	}

	/** Getter
	 * @return the texte
	 */
	public String getTexte() {
		return texte;
	}

	/** Setter
	 * @param texte the texte to set
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

}
