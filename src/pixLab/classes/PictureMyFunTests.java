package pixLab.classes;

import java.lang.reflect.*;
import java.util.*;

public class PictureMyFunTests
{
    String classs = "Picture";

    public static void main(String[] args)
    {
        
    }
    
    //extract all the methods that I want to do
    private String[] getMethods()
    {
        List<Method> toReturn = new ArrayList<>() ;
       
        try
        {
            Class cl = Class.forName(classs);
            
            Method[] methods = cl.getDeclaredMethods();
            
            for(Method command: methods)
            {
                String commandName = command.getName();
                if(commandName.contains("Red")||commandName.contains("Blue")||commandName.contains("Green"))
                {
                    
                }
            }
            
            
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        
        return null;
    }
}
