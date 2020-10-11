package pixLab.gui.questionsPopup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ObjectParameter<T> extends ParameterInfo<JLabel,JComboBox> {

	public ObjectParameter(String message, Class<?> classToMake) {
		super(createLabel(message), createDropDown(message, classToMake));
	}
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		label.setPreferredSize(new Dimension(100,20));// used for spacing
		return label;
	}
	
	private static JButton createButton(String title, Class<?> classToMake)
	{
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(100,20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				PopupManyQuestionsDialog popup = new PopupManyQuestionsDialog(null);
				popup.setTitle(title);
				popup.setSize(400,400);
				popup.setLocationRelativeTo(null);
				
				classToMake.getConstructors();
				Parameter[] parameters;
				
//				Object temp = classToMake.getDeclaredConstructor().newInstance(initargs); // use this method to make a new instance of that class.
				//https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
				popup.setVisible(true);
			}
		});
		// need the information about the object I am creating
		return button;
	}

	@Override
	public boolean hasValidInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getValidatedInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearAnswerSpace() {
		// TODO Auto-generated method stub
		
	}
	
}
