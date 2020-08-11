package pixLab.gui;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.*;

import javax.swing.*;

import pixLab.classes.*;

public class PixLabPanel extends JPanel
{
	
	private JButton openImageButton;
	private JComboBox<String> picturesInFolder;
	
	private JList<String> changePictureMethodsDropDown;
	private Map<String, Method> methodsMap;
//	private JList<> 
	
	public PixLabPanel()
	{
		super();
		methodsMap = new HashMap<>();
		//methodsMap.add(null, null);
		
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		this.openImageButton = new JButton("open picture");
		openImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				String fileName = (String) picturesInFolder.getSelectedItem();
				Picture image = new Picture(fileName);
				
				String key = changePictureMethodsDropDown.getSelectedValue();
				Method method = methodsMap.get(key);
				if(method != null)
				{
				try {
					method.invoke(image);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
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
		
		this.changePictureMethodsDropDown = new JList<>();
		DefaultListModel<String> methodsModel = new DefaultListModel<>();
		methodsModel.addAll(getPictureMethods());
		changePictureMethodsDropDown.setModel(methodsModel);
		changePictureMethodsDropDown.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		changePictureMethodsDropDown.set
		JScrollPane changeScrollPane = new JScrollPane();
		changeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		changeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		changeScrollPane.setLocation(openImageButton.getX(), 10+openImageButton.getY()+openImageButton.getHeight());
		changeScrollPane.setSize(200,200);
		changeScrollPane.setViewportView(changePictureMethodsDropDown);
		this.add(changeScrollPane);
		
		
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
