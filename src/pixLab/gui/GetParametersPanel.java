package pixLab.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class GetParametersPanel extends JPanel 
{
	
	private JComponent[] questionList;
	private JComponent[] enterBoxList;
	private JScrollPane pageScroller;
	private JButton doneButton;
	private JButton cancelButton;
	private final int ROW_HEIGHT = 50;
	private final int BUFFER = 10;
	
	//assuming the lengths of the boxes are the same size
	public GetParametersPanel(JComponent[] questions, JComponent[] enterBoxes)
	{
		super();
		this.questionList = questions.clone();
		this.enterBoxList = enterBoxes.clone();
		
		Box vBoxQ = Box.createVerticalBox();
		Box vBoxE = Box.createVerticalBox();
		for(int index = 0; index<questionList.length && index<enterBoxList.length;index++)
		{
			vBoxQ.add(questionList[index]);
			vBoxQ.add(Box.createVerticalStrut(BUFFER));
			
			vBoxE.add(enterBoxList[index]);
			vBoxE.add(Box.createVerticalStrut(BUFFER));
		}
		
		Box hBox = Box.createHorizontalBox();
		hBox.add(vBoxQ);
		hBox.add(Box.createHorizontalStrut(BUFFER));
		hBox.add(vBoxE);
		
		this.pageScroller = new JScrollPane();
		pageScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pageScroller.add(hBox);
		pageScroller.setPreferredSize(new Dimension(600, 500));
		//add(hBox, BorderLayout.CENTER);
//		add(pageScroller, BorderLayout.CENTER);
		
		this.doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		this.cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
	
	public Object[] getParameters(String[] questions, JComponent[] enterBoxes)
	{
		
		
		Object[] info = new Object[0];
		
		return info;
	}
}
