package pixLab.gui.questionsPopup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * This is a frame for when you want the user to enter input
 * to display any questions you have to give this class 
 * ParamterInfo objects.
 * 
 * @author Gregory Eisert
 *
 */
public class PopupManyQuestionsDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object[] inputedValues;
	
	private int value;
	public final int UNINITIALIZED = 0;
	public final int CANCEL = 1;
	public final int DONE = 2;
	
	private List<ParameterInfo<? extends JComponent, ? extends JComponent>> qAndA;
	
	private JPanel interactPanel;
	private JScrollPane pageScroller;
	
	private JButton doneButton;
	private JButton cancelButton;
	
	private final int BUFFER = 10;

	/*
	 * make a class that holds a question, a place to enter info, and a generic way to get it.
	 */
	/**
	 * constructs a popup frame but does not show it.
	 * 
	 * @param ownerFrame the frame you want this frame to appear in front of.
	 */
	public PopupManyQuestionsDialog(Frame ownerFrame)
	{
		super(ownerFrame, true);
		qAndA = new ArrayList<>();
		value = UNINITIALIZED;
		
		this.pageScroller = new JScrollPane();
		pageScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pageScroller.setPreferredSize(new Dimension(590, 400));
		add(pageScroller, BorderLayout.NORTH);
		
		this.doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				boolean validInput = true;
				int index = 0;
				while(validInput && index<qAndA.size())
				{
					validInput = qAndA.get(index).hasValidInput();
					index+= 1;
				}
				if(validInput)
				{
					value = DONE;
					setVisible(false);
				}
				else
				{
					String message = "";
					message += "Missing input or invalid input\n on line " + index;
					String title = "Not Done";
					JOptionPane.showMessageDialog(PopupManyQuestionsDialog.this, 
							message,
							title,
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		this.cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				closeWindow_Cancel();
			}
		});
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent closeWindow)
			{
				closeWindow_Cancel();
			}
		});
		
		Box bottomBox = Box.createHorizontalBox();
		bottomBox.add(doneButton);
		bottomBox.add(Box.createHorizontalStrut(BUFFER));
		bottomBox.add(cancelButton);
		//add(bottomBox, BorderLayout.SOUTH);
		
		Box vBoxAll = Box.createVerticalBox();
		vBoxAll.add(pageScroller);
		vBoxAll.add(bottomBox);
		add(vBoxAll, BorderLayout.CENTER);
		
	}
	
	/**
	 * when the user presses cancel on the popup window.
	 */
	private void closeWindow_Cancel()
	{
		value = CANCEL;
		setVisible(false);
		for(ParameterInfo<? extends JComponent, ? extends JComponent> item:qAndA)
		{
			item.clearAnswerSpace();
		}
	}

	/**
	 * Provides a way to enter what inputs you need from the user.
	 * 
	 * @param qAndA is a class that is a child of ParameterInfo.
	 */
	public void add(ParameterInfo<? extends JComponent, ? extends JComponent> qAndA)
	{
		this.qAndA.add(qAndA);
		upDateQuestionsPanel();
	}

	/**
	 * updates the panel that holds all the boxes to display to the user
	 */
	private void upDateQuestionsPanel() {
		Box vBoxQ = Box.createVerticalBox();
		Box vBoxE = Box.createVerticalBox();
		for(int index = 0; index<qAndA.size();index++)
		{
			if(index != 0)
			{
				vBoxQ.add(Box.createVerticalStrut(BUFFER/2));
				vBoxE.add(Box.createVerticalStrut(BUFFER/2));
				vBoxQ.add(Box.createVerticalGlue());
				vBoxE.add(Box.createVerticalGlue());
			}
			vBoxQ.add(qAndA.get(index).getQuestion());
			vBoxE.add(qAndA.get(index).getAnswerSpace());
		}
		
		Box hBox = Box.createHorizontalBox();
		hBox.add(vBoxQ);
		hBox.add(Box.createHorizontalStrut(BUFFER));
		hBox.add(vBoxE);
		interactPanel = new JPanel();
		interactPanel.setBackground(Color.CYAN);
		interactPanel.add(hBox, BorderLayout.CENTER);
		pageScroller.setViewportView(interactPanel);
	}
	

	/**
	 * this gets the entered information from each of the input boxes
	 * and then clears those boxes
	 * @return an object array of the entered information in the same order as 
	 *         the input boxes, or null if the cancel button was pressed or if 
	 *         the window was closed, or the popup has never been opened up.
	 */
	public Object getValidatedInput() {
		if(value == DONE)
		{
			inputedValues = new Object[qAndA.size()];
			for(int index = 0; index<qAndA.size(); index++)
			{
				inputedValues[index] = qAndA.get(index).getValidatedInput();
				qAndA.get(index).clearAnswerSpace();
			}
			value = this.UNINITIALIZED;
		}
		else
		{
			inputedValues = null;
		}
		return inputedValues;
	}

}
