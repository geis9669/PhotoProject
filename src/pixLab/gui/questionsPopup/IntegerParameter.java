package pixLab.gui.questionsPopup;

import javax.swing.*;

public class IntegerParameter extends ParameterInfo<JLabel, JTextField>
{
	private JLabel label;
	private JTextField space;

	public IntegerParameter()
	{
		super(createLabel(), createSpace());
	}
	
	private static JLabel createLabel()
	{
		return null;
	}
	
	private static JTextField createSpace()
	{
		return null;
	}

	@Override
	public boolean hasValidInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValidatedInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearAnswerSpace() {
		// TODO Auto-generated method stub
		
	}

}
