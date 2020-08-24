package pixLab.gui;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.*;

import javax.swing.*;

import pixLab.classes.*;
import pixLab.gui.questionsPopup.*;

public class PixLabPanel extends JPanel
{
	private Frame frame;
	
	private final int BUFFER = 10;
	
	private JButton openImageButton;
	private JComboBox<String> picturesInFolder;
	
	private JList<String> changePictureMethodsDropDown;
	private Map<String, Method> methodsMap;
	
	private JButton addButton;
	private JButton removeButton;
	private JButton clearButton;
	// button to move an item in the list
	private JList<MethodParameters> choosenMethods;
	DefaultListModel<MethodParameters> choosenModel;
	
	public PixLabPanel(Frame ownerFrame)
	{
		super();
		this.frame = ownerFrame;
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
				
				for(int index = 0; index < choosenModel.getSize(); index++)
				{
					MethodParameters method = choosenModel.get(index);
					System.out.println(method.toString());
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
				}
				
				image.explore();
			}
		});
		openImageButton.setLocation(BUFFER, BUFFER);
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
		changePictureMethodsDropDown.setSelectedIndex(0);
//		changePictureMethodsDropDown.set
		JScrollPane changeScrollPane = new JScrollPane();
		changeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		changeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		changeScrollPane.setLocation(openImageButton.getX(), 10+openImageButton.getY()+openImageButton.getHeight());
		changeScrollPane.setSize(200,200);
		changeScrollPane.setViewportView(changePictureMethodsDropDown);
		this.add(changeScrollPane);
		
		this.addButton = new JButton("Add Effect");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				String key = changePictureMethodsDropDown.getSelectedValue();
				Method method = methodsMap.get(key);
				
				Object[] parameterValues = new Object[method.getParameterCount()];
				Parameter[] parameters = method.getParameters();
				
				if(parameterValues.length != 0)
				{
//					for(int index = 0; index<parameterValues.length; index++)
//					{
//						// needs to make the validation here then send it to the popup
//						String question = "";
//						question += parameters[index].getName();
//						String answer = JOptionPane.showInputDialog(addButton.getParent(), question);
//						//code to get the parameters
//						if(answer == null || answer.equals(""))//check if the user canceled filling out the info
//						{
//							return;
//						}
//						parameterValues[index] = answer;
//					}
					PopupManyQuestionsDialog popup = new PopupManyQuestionsDialog(frame);
					popup.setTitle(method.getName());
					popup.setSize(400,400);
					popup.setLocationRelativeTo(frame);
					
					for(int index = 0; index< parameters.length; index++)
					{
						String message = parameters[index].getName();
						ParameterInfo test = new IntegerParameter(message);
						
						popup.add(test);
					}
					
					popup.setVisible(true);
					
					parameterValues = (Object[]) popup.getValidatedInput();
					if(parameterValues == null)
					{
						return;
					}
				}
				
				choosenModel.addElement(new MethodParameters(method, parameterValues));
			}
		});
		addButton.setLocation(changeScrollPane.getX()+changeScrollPane.getWidth()+BUFFER, changeScrollPane.getY()+BUFFER);
		addButton.setSize(100,25);
		this.add(addButton);
		
		this.removeButton = new JButton("Remove Effect");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				int index = choosenMethods.getSelectedIndex();
				if(index > -1)
					choosenModel.remove(index);
			}
		});
		removeButton.setMargin(new Insets(2,2,2,2));
		removeButton.setLocation(addButton.getX(), addButton.getY()+addButton.getHeight() + BUFFER);
		removeButton.setSize(addButton.getSize());
		this.add(removeButton);
		
		this.clearButton = new JButton("Clear Effects");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				String message = "Confirm Clear";
				String title = "Confirm";
				int option = JOptionPane.showConfirmDialog(clearButton.getParent(), message, title, JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.OK_OPTION)
					choosenModel.clear();
			}
		});
		clearButton.setMargin(new Insets(2,2,2,2));
		clearButton.setLocation(addButton.getX(), removeButton.getY()+removeButton.getHeight()+BUFFER);
		clearButton.setSize(addButton.getSize());
		this.add(clearButton);
		
		this.choosenMethods = new JList<>();
		choosenModel = new DefaultListModel<>();
		choosenMethods.setModel(choosenModel);
		choosenMethods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane choosenScrollPane = new JScrollPane();
		choosenScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		choosenScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		choosenScrollPane.setLocation(addButton.getX()+addButton.getWidth()+BUFFER,changeScrollPane.getY());
		choosenScrollPane.setSize(changeScrollPane.getSize());
		choosenScrollPane.setViewportView(choosenMethods);
		this.add(choosenScrollPane);
		
		/*
		 * Things that I may want
		 * A way to choose the picture - 
		 * Then also a button to open the picture -
		 * A menu to choose what to do to the picture -
		 */
	}
	
	/**
	 * this method gets all the names of the images that it can currently load
	 * @return a array of the names that can be loaded.
	 */
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
			String errorStatement ="";
		}
		String[] pictureNames = new String[paths.size()];
		return paths.toArray(pictureNames);
	}
	
	/**
	 * this method is used to get the methods that it can call on an image to change that image
	 * @return the methods you can call on a image
	 */
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
				if(s == void.class)
				{
					String parameters = "(";
					
					Parameter[] items = command.getParameters();
					for(int it = 0; it<items.length; it++)
					{
						parameters += items[it].getType().getSimpleName() + " ";
						parameters += items[it].getName() + " ";
					}
					
					parameters+=")";
					String commandParamName = command.getName()+""+parameters;
					methodstoReturn.add(commandParamName);
					methodsMap.put(commandParamName, command);
				}
			}
		}
		catch(ClassNotFoundException exception)
		{
			System.out.println("getPictureMethods method\n"+exception.getMessage());
			//if it can't find that class then do nothing?
			String errorStatement = "Could not find the class to get the methods to change the pictures\n";
			errorStatement += "";
		}
		return methodstoReturn; 
	}
}
