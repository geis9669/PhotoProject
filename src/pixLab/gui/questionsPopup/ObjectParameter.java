package pixLab.gui.questionsPopup;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

import javax.swing.*;

/*
 * Currently I need to figure out if I can use a custom list model that
 * will display what I want and return the constructor.
 * https://www.codejava.net/java-se/swing/create-custom-gui-for-jcombobox
 * https://stackoverflow.com/questions/43106351/creating-a-custom-table-model-to-provide-data-from-arraylist
 * 
 * still need to finish implementing this class
 * 
 * Object temp = classToMake.getDeclaredConstructor().newInstance(initargs); // use this method to make a new instance of that class.
 * https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
 */

/**
 * A generic class to create objects from the user.
 * 
 * @author gregory
 *
 * @param <T> The type of data that the class will return.
 */
public class ObjectParameter<T> extends ParameterInfo<JLabel,JComboBox<Constructor>> {
	private T input;

	 * 
	 */
	private static JComboBox<?> createDropDown(String title, Class<?> classToMake)
	{
		Constructor<?>[] constructors = classToMake.getConstructors();
//		String[] cNames = new String[constructors.length];
//		for(int index = 0; index<cNames.length; index++)
//		{
//			cNames[index] = constructors[index].getName();
//		}
		
		JComboBox<Constructor> boxOptions = new JComboBox<>();
		DefaultComboBoxModel<Constructor> modelList = new DefaultComboBoxModel<>(constructors);
		boxOptions.setModel(modelList);
		
		boxOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent selected)
			{
				PopupManyQuestionsDialog popup = new PopupManyQuestionsDialog(null);
				popup.setTitle(title);
				popup.setSize(400,400);
				popup.setLocationRelativeTo(null);
				
				Constructor<?> construct = (Constructor<?>) modelList.getSelectedItem();
				Parameter[] parameters = construct.getParameters();
				for(int index = 0; index< parameters.length; index++)
				{
					String type = parameters[index].getType().getSimpleName();
					String message = type +" "+ parameters[index].toString();//getName();
					ParameterInfo option;
					if(type.equals("int"))
					{
						option = new IntegerParameter(message);
					}
					else
					{
						Class<?> c = parameters[index].getType();//gets the class
						option = new ObjectParameter<>(message,c);
					}
					
					popup.add(option);
				}
				
				popup.setVisible(true);
				

			}
		});
	
	/**
	 * Creates a label for the user to read about the button.
	 * @param message what to tell the user
	 * @return a JLabel
	 */
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		label.setPreferredSize(new Dimension(100,20));// used for spacing
		return label;
	}
	
	/**
	 * 
	 * @param classToMake the java class that you want constructed.
	 * @return a JComboBox of all the constructors.
	 */
	private static JComboBox<Constructor> createDropDown(Class<?> classToMake)
	{
		Constructor<?>[] constructors = classToMake.getConstructors();
		JComboBox<Constructor> boxOptions = new JComboBox<>();
		DefaultComboBoxModel<Constructor> modelList = new DefaultComboBoxModel<>(constructors);
		boxOptions.setModel(modelList);
		
		return boxOptions;
	}

	@Override
	public boolean hasValidInput() {
		if(input != null)
			return true;
		return false;
	}

	@Override
	public T getValidatedInput() {
		return input;
	}

	@Override
	public void clearAnswerSpace() {
		input = null;
	}
	
}
