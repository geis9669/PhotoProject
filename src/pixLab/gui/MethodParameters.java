package pixLab.gui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	
}
