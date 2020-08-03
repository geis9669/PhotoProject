package pixLab.gui;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.*;

import javax.swing.*;

import pixLab.classes.*;

public class PixLabPanel extends JPanel
{
	
	private JButton openImageButton;
	private JComboBox<String> picturesInFolder;
	
	private Map<String, Method> methodsMap;
	
	public PixLabPanel()
	{
		super();
		methodsMap = new HashMap<>();
		
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
	
	private List<String> getPictureMethods()
	{
		List<String> methodstoReturn = new ArrayList<>();
		String className = "pixLab.classes.Picture";
		try
		{
			Class cl = Class.forName(className);
			Method[] methods = cl.getDeclaredMethods();
			
			for(Method command : methods)
			{
				Class<?> s = command.getReturnType();
//				System.out.println(command);
				if(s == void.class)
				{
					methodstoReturn.add(command.getName());
					methodsMap.put(command.getName(), command);
				}
			}
		}
		catch(ClassNotFoundException exception)
		{
			System.out.println("getPictureMethods method\n"+exception.getMessage());
		}
		return methodstoReturn; 
	}
}
