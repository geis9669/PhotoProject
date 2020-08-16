package pixLab.gui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GetParametersDialog {
	public static void main(String[] args)
	{
		final int SIZE = 5;
		
		JComponent[] buttons = new JComponent[SIZE];
		for(int bindex = 0; bindex<buttons.length; bindex++)
		{
			JButton button = new JButton("Clear Effects");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent click)
				{
					String message = "Confirm Clear";
					String title = "Confirm";
					int option = JOptionPane.showConfirmDialog(button.getParent(), message, title, JOptionPane.YES_NO_OPTION);
				}
			});
			button.setMargin(new Insets(2,2,2,2));
			//button.setMaximumSize(new Dimension(50,50));
			buttons[bindex] = button;
		}
		
		JComponent[] textBoxes = new JComponent[SIZE];
		for(int tindex = 0; tindex<textBoxes.length; tindex++)
		{
			JTextField enterField = new JTextField("", 40);
	        enterField.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent enterPress)
	            {
	            	
	            }
	        });
	        enterField.setText("BOX " + tindex);
	        //enterField.setMaximumSize(new Dimension(50,50));
	        textBoxes[tindex] = enterField;
		}
		
		JDialog questions = new JDialog();
		questions.add(new GetParametersPanel(buttons, textBoxes));
		questions.setSize(500,500);
		questions.setVisible(true);
	}

}
