package pixLab.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class PixLabPanel extends JPanel
{
	
	private JButton openImageButton;
	private JComboBox<String> picturesInFolder;
	
	public PixLabPanel()
	{
		super();
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		this.openImageButton = new JButton("open picture");
		openImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				String fileName = (String) picturesInFolder.getSelectedItem();
				Picture image = new Picture(fileName);
				image.explore();
			}
		});
		openImageButton.setLocation(10,10);
		openImageButton.setSize(170, 25);
		this.add(openImageButton);
		
		this.picturesInFolder = new JComboBox<>();
		DefaultComboBoxModel<String> picturesNames = new DefaultComboBoxModel<>(this.getImageNames());
		picturesInFolder.setModel(picturesNames);
		picturesInFolder.setLocation(openImageButton.getX()+openImageButton.getWidth(), openImageButton.getY());
		picturesInFolder.setSize(200, 25);
		this.add(picturesInFolder);
		/*
		 * Things that I may want
		 * A way to choose the picture - 
		 * Then also a button to open the picture -
		 * A menu to choose what to do to the picture -
		 */
	}
	
	private String[] getImageNames()
	{
		Path path = Paths.get("src\\pixLab\\images");
		ArrayList<String> paths = new ArrayList<String>();
		
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path))
		{
			for(Path filePath: stream)
			{
				String fileName = filePath.getFileName().toString();
				if(fileName.contains(".jpg"))
					paths.add(fileName);
			}
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			//
		}
		String[] pictureNames = new String[paths.size()];
		return paths.toArray(pictureNames);
	}
}
