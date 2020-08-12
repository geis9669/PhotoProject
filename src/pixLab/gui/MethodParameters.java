package pixLab.gui;

import java.lang.reflect.*;
import java.util.*;

public class MethodParameters 
{
	private Method method;
	private Object[] parameters;
	
	public MethodParameters(Method method, Object[] parameters)
	{
		this.method = method;
//		this.method.invoke();
//		this.parameters = new Object[method.getParameterCount()];
		this.parameters = parameters.clone();
	}
	
	public Object invoke(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		return method.invoke(object, parameters);
	}
	
	public String toString()
	{
		String summary = "";
		summary += method.getName()+"(";
		
		Parameter[] names = method.getParameters();
		for(int index = 0; index<parameters.length; index++)
		{
			if(index != 0)
			{
				summary+= ", ";
			}
			String pName = names[index].getName();
			Object pValue = parameters[index];
			String pStringValue = "null";
			if(pValue != null)
			{
				pStringValue = pValue.toString();
			}
			summary += pName+" "+ pStringValue;
			
		}
		summary+=")";
		return summary;
	}
	
}
