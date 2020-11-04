package pixLab.gui.questionsPopup;

import javax.swing.*;

public abstract class ParameterInfo<T extends JComponent , E extends JComponent> 
{
	/**
	 * question holds what to ask the user
	 */
	private T question;
	/**
	 * answerSpace is where the user gives the answer
	 */
	private E answerSpace;

	
	public ParameterInfo(T question, E answerSpace)
	{
		this.question = question;
		this.answerSpace = answerSpace;
	}
	
	
	public T getQuestion()
	{
		return question;
	}
	
	public E getAnswerSpace()
	{
		return answerSpace;
	}
	
	/**
	 * asking if the value returned by getvalidatedInput is acceptable
	 * @return true if when getValidatedInput is called it wont throw any errors, other wise false
	 */
	public abstract boolean hasValidInput();
	
	/**
	 * this should return what the user inputed
	 * @return the object constructed by the user.
	 */
	public abstract Object getValidatedInput();
	
	/**
	 * this should clear the answerSpace or reset it.
	 */
	public abstract void clearAnswerSpace();
	
	public String toString()
	{
		String info = "";
		info += question.toString()+ " ";
		info += answerSpace.toString()+ " ";
		return info;
	}
	
}
