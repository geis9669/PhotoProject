package pixLab.gui.questionsPopup;

import javax.swing.*;

/**
 * Will return the picture that the user selected from the provided list.
 * will have the first item selected.
 * 
 * @author gregory eisert
 *
 */
public class ListParameter extends ParameterInfo<JLabel, JComboBox<Object>> {

	/**
	 * 
	 * @param question what to ask the user
	 * @param list the information the user can choose from.
	 */
	public ListParameter(String question, Object[] list) {
		super(createLabel(question), createJComboBox(list));
		//throw an error if the list has no items same with the model
	}
	
	/**
	 * 
	 * @param question what to ask the user
	 * @param model The model for the JComboBox for the user to choose from
	 */
	public ListParameter(String question, DefaultComboBoxModel<Object> model)
	{
		super(createLabel(question), createJComboBox(model));
	}
	
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		return label;
	}
	
	private static JComboBox<Object> createJComboBox(DefaultComboBoxModel<Object> model)
	{
		JComboBox<Object> comboList = new JComboBox<>();
		comboList.setModel(model);
		return comboList;
	}
	
	private static JComboBox<Object> createJComboBox(Object[] list)
	{
		JComboBox<Object> comboList = new JComboBox<>();
		DefaultComboBoxModel<Object> modelList = new DefaultComboBoxModel<>(list);
		comboList.setModel(modelList);
		return comboList;
	}

	@Override
	public boolean hasValidInput() {
		if(getAnswerSpace().getItemCount()<=0)
		{
			return false;
		}
		return true;
	}

	@Override
	public Object getValidatedInput() {
		Object item =  getAnswerSpace().getSelectedItem();
		return item;
	}

	@Override
	public void clearAnswerSpace() {
		JComboBox<Object> comboList = getAnswerSpace();
		comboList.setSelectedIndex(0);
	}

}
