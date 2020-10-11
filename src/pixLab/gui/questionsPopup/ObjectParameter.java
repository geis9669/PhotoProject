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
	
	private static JComboBox<?> createDropDown(String title, Class<?> classToMake)
	{
		Constructor<?>[] constructors = classToMake.getConstructors();
		String[] cNames = new String[constructors.length];
		for(int index = 0; index<cNames.length; index++)
		{
			cNames[index] = constructors[index].getName();
			System.out.println(constructors[index].getName()+ " "+index);
		}
		
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
				
				classToMake.getConstructors();
				Parameter[] parameters;
				
				popup.setVisible(true);
			}
		});
		
		return boxOptions;
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
	
	/**
	 * this method is used to get the methods that it can call on an image to change that image
	 * @return the methods you can call on a image
	 */
	private List<String> getConstructors()
	{
		List<String> methodstoReturn = new ArrayList<>();
		String className = "pixLab.classes.Picture";
		try
		{
			Class cl = Class.forName(className);
			Method[] methods = cl.getDeclaredMethods();
			
			for(Method command : methods)
			{
				Class<?> s = command.getReturnType();
				if(s == void.class)
				{
					String parameters = "(";
					
					Parameter[] items = command.getParameters();
					for(int it = 0; it<items.length; it++)
					{
						parameters += items[it].getType().getSimpleName() + " ";
						parameters += items[it].getName() + " ";
					}
					
					parameters+=")";
					String commandParamName = command.getName()+""+parameters;
					methodstoReturn.add(commandParamName);
//					methodsMap.put(commandParamName, command);
				}
			}
		}
		catch(ClassNotFoundException exception)
		{
			System.out.println("getPictureMethods method\n"+exception.getMessage());
			//if it can't find that class then do nothing?
			String errorStatement = "Could not find the class to get the methods to change the pictures\n";
			errorStatement += "";
		}
		return methodstoReturn; 
	}

}
