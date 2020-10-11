package pixLab.gui.questionsPopup;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class IntegerParameter extends ParameterInfo<JLabel, JTextField>
{

	public IntegerParameter(String message)
	{
		super(createLabel(message), createSpace());
	}
	
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		label.setPreferredSize(new Dimension(100,20));// used for spacing
		return label;
	}
	
	private static JTextField createSpace()
	{
		KeyAdapter numValidator = new KeyAdapter() {
			public void keyPressed(KeyEvent key)
			{
				JTextField field= (JTextField) key.getSource();
				int length = field.getText().length();
				char keyPressed = key.getKeyChar();
				if(keyPressed == KeyEvent.VK_BACK_SPACE || (keyPressed >= '0' && keyPressed<='9' && length<4))
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
		textField.setPreferredSize(new Dimension(300,20));// used for spacing
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
