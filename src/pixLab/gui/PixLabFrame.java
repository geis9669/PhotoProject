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
		
		panel = new PixLabPanel();
		this.setContentPane(panel);
		
		this.setSize(400,400);
		this.setResizable(true);
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
