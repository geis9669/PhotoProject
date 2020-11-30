package pixLab.gui.questionsPopup;

import javax.swing.*;
import pixLab.classes.Picture;
/**
 * Will return the picture that the user selected from the provided list.
 * 
 * @author gregory eisert
 *
 */
public class PictureParameter extends ParameterInfo<JLabel, JComboBox<String>> {

	public PictureParameter(String question, String[] list) {
		super(createLabel(question), createJComboBox(list));
	}
	
	public PictureParameter(String question, DefaultComboBoxModel<String> model)
	{
		super(createLabel(question), createJComboBox(model));
	}
	
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		return label;
	}
	
	private static JComboBox<String> createJComboBox(DefaultComboBoxModel<String> model)
	{
		JComboBox<String> comboList = new JComboBox<>();
		comboList.setModel(model);
		return comboList;
	}
	
	private static JComboBox<String> createJComboBox(String[] list)
	{
		JComboBox<String> comboList = new JComboBox<>();
		DefaultComboBoxModel<String> modelList = new DefaultComboBoxModel<>(list);
		comboList.setModel(modelList);
		return comboList;
	}

	@Override
	public boolean hasValidInput() {
		return true;
	}

	@Override
	public Object getValidatedInput() {
		String pictureName = (String) getAnswerSpace().getSelectedItem();
		Picture picture = new Picture(pictureName);
		return picture;
	}

	@Override
	public void clearAnswerSpace() {
		JComboBox<String> comboList = getAnswerSpace();
		comboList.setSelectedIndex(0);
	}

}
