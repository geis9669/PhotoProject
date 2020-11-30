package pixLab.gui.questionsPopup;

import javax.swing.*;

/**
 * Provides an abstract way to use any JComponent for user input
 * this class needs to be extend because it does not know enough about
 * the JComponents to get user input.
 * 
 * @author Gregory Eisert
 *
 * @param <T> the first JComponent
 * @param <E> the second JComponent
 */
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

	/**
	 * 
	 * @param question the JComponent to ask the question for the input.
	 * @param answerSpace how to enter in the input.
	 */
	public ParameterInfo(T question, E answerSpace)
	{
		this.question = question;
		this.answerSpace = answerSpace;
	}
	
	/**
	 * provides access to the question JComponent.
	 * 
	 * @return the question JComponent.
	 */
	public T getQuestion()
	{
		return question;
	}
	
	/**
	 * Provides access to the AnswerSpace (where you enter information) so 
	 * you can get the input or get the item to display.
	 * 
	 * @return the Answer Space
	 */
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
