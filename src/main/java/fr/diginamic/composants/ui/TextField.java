package fr.diginamic.composants.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

import fr.diginamic.composants.ui.container.Input;

/** Champ de type texte pour saisir une information quelconque
 * @author RichardBONNAMY
 *
 */
public class TextField extends Input {
	
	/** Valeur saisie par l'utilisateur */
	private String value;
	
	/** textField */
	private JTextField textField;

	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 */
	public TextField(String label, String name) {
		super(label, name);
		this.value="";
		setWidth(200);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param value valeur du champ de saisie
	 */
	public TextField(String label, String name, String value) {
		super(label, name);
		this.value = value;
		textField = new JTextField();
		textField.setText(value);
		setWidth(200);
	}
	

	@Override
	public JComponent convert() {
		JTextField textField = new JTextField();
		textField.setText(value);
		return textField;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(JComponent component) {
		this.value=((JTextField)component).getText();
	}

	@Override
	public InputType getType() {
		return InputType.TEXTFIELD;
	}

	@Override
	public int getHeight() {
		return (int)textField.getPreferredSize().getHeight();
	}


	
}
