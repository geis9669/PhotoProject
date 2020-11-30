package pixLab.gui.questionsPopup;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Provides a way to get String input from the user. 
 * 
 * @author Gregory Eisert
 *
 */
public class StringParameter extends ParameterInfo<JLabel, JTextField>
{

	/**
	 * Constructs the JComponents for user input.
	 * 
	 * @param question what to ask the user.
	 */
	public StringParameter(String question) {
		super(createLabel(question), createAnswerSpace());
	}
	
	private static JLabel createLabel(String message)
	{
		JLabel label = new JLabel(message);
		label.setPreferredSize(new Dimension(100,20));// used for spacing
		return label;
	}
	
	private static JTextField createAnswerSpace()
	{
		KeyAdapter StringValidator = new KeyAdapter() {
			public void keyPressed(KeyEvent key)
			{
				JTextField field = (JTextField) key.getSource();
				
				char keyPressed = key.getKeyChar();
				
				if(keyPressed != KeyEvent.VK_ENTER)
				{
					field.setEditable(true);
				}
				else
				{
					field.setEditable(false);
				}
			}
		};
		
		JTextField textField = new JTextField("", 20);
		textField.addKeyListener(StringValidator);
		textField.setPreferredSize(new Dimension(100,20));// used for spacing
		return textField;
	}

	@Override
	public boolean hasValidInput() {
		return  getAnswerSpace().getText() != null;
	}

	@Override
	public Object getValidatedInput() {
		String answer = getAnswerSpace().getText();
		return answer;
	}

	@Override
	public void clearAnswerSpace() {
		getAnswerSpace().setText("");
	}

}
