package pixLab.gui;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PixLabFrame extends JFrame
{
	private PixLabPanel panel;
	
	public PixLabFrame()
	{
		super();
		
		panel = new PixLabPanel(this);
		this.setContentPane(panel);

		this.setTitle("ChangeImage");
		this.setSize(600,400);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(100,100));
		
		this.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent event)
        	{
        		System.exit(0);
        	}
        });
		
		this.setVisible(true);
	}

}
