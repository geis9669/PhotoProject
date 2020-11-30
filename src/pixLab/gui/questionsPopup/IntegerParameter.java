package pixLab.gui.questionsPopup;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * Provides a way of obtaining int values from the user.
 * Has error checking so they can only enter int values.
 * 
 * @author Gregory Eisert
 *
 */
public class IntegerParameter extends ParameterInfo<JLabel, JTextField>
{

	/**
	 * Provides a way to have the user enter in an int value with only 4 digits
	 * can only have positive numbers
	 * 
	 * @param message what to ask the user
	 */
	public IntegerParameter(String message)
	{
		super(createLabel(message), createSpace(4));
	}
	
	/**
	 * Provides a way to have the user enter in an int value.
	 * 
	 * @param message what to ask the user.
	 * @param numOfDigits how many digits of the int are allowed.
	 */
	public IntegerParameter(String message, int numOfDigits)
	{
		super(createLabel(message), createSpace(numOfDigits));
	}
	
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		label.setPreferredSize(new Dimension(100,20));// used for spacing
		return label;
	}
	
	private static JTextField createSpace(int numOfDigits)
	{
		KeyAdapter numValidator = new KeyAdapter() {
			public void keyPressed(KeyEvent key)
			{
				JTextField field= (JTextField) key.getSource();
				int length = field.getText().length();
				char keyPressed = key.getKeyChar();
				if(keyPressed == KeyEvent.VK_BACK_SPACE || (keyPressed >= '0' && keyPressed<='9' && length<numOfDigits))
				{
					field.setEditable(true);
					// have an error label set to not show.
				}
				else
				{
					field.setEditable(false);
					//say Enter only Numeric digits(0-9) that are less than 9999
				}
			}
		};
		JTextField textField = new JTextField("", 20);
		textField.addKeyListener(numValidator);
		textField.setPreferredSize(new Dimension(100,20));// used for spacing
		return textField;
	}

	@Override
	public boolean hasValidInput() {
		String answer = getAnswerSpace().getText();
		try
		{
			Integer.parseInt(answer);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}

	@Override
	/**
	 * this returns the entered in number or null if there is an error so call has valid input
	 * to make sure that what this returns is good
	 */
	public Object getValidatedInput() {
		String answer = getAnswerSpace().getText();
		try
		{
			return Integer.parseInt(answer);
		}
		catch(NumberFormatException e)
		{
			return null;
		}
	}

	@Override
	public void clearAnswerSpace() {
		getAnswerSpace().setText("");
	}

}
