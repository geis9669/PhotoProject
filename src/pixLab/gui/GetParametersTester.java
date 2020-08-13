package pixLab.gui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GetParametersTester {
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
			button.setMaximumSize(new Dimension(50,50));
			buttons[bindex] = button;
		}
		
		JComponent[] textBoxes = new JComponent[SIZE];
		for(int tindex = 0; tindex<textBoxes.length; tindex++)
		{
			JTextField enterField = new JTextField("", 50);
	        enterField.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent enterPress)
	            {
	            	
	            }
	        });
	        enterField.setText("BOX " + tindex);
	        enterField.setMaximumSize(new Dimension(50,50));
	        textBoxes[tindex] = enterField;
		}
		
		
		JPanel panel = new GetParametersPanel(buttons,textBoxes);
		frame.add(panel);
		frame.setTitle("Parameters");
		frame.setVisible(true);
	}

}
