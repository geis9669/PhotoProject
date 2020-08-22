package pixLab.gui;

import javax.swing.*;

public class TextBoxQuestion extends ParameterInfo<JLabel,JTextField>
{

	public TextBoxQuestion(JLabel question, JTextField answerSpace) {
		super(question, answerSpace);
	}

	@Override
	public Object getValidatedInput() {
		String answer = getAnswerSpace().getText();
		int number = Integer.parseInt(answer);
		return number;
	}

	@Override
	public void clearAnswerSpace() {
		getAnswerSpace().setText("");
	}

	@Override
	public boolean hasValidInput() {
		String answer = getAnswerSpace().getText();
		try
		{
			int number = Integer.parseInt(answer);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}

}
