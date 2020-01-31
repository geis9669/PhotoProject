package pixLab.classes;

import java.lang.reflect.*;
import java.util.*;

public class PictureMyFunTests
{
    private static String classs = "pixLab.classes.Picture";
    private static final Picture originalPicture = new Picture("beach.jpg");
    
    public static void main(String[] args)
    {
        List<Method> methodsToCall = getMethods();
        printMethods(methodsToCall);
        
        originalPicture.explore();
        
        methodsToCall.add(null);
        methodsToCall.add(null);
        methodsToCall.add(null);
        
        List<Method[]> combinationMethods = getCombinations(methodsToCall);
        
        callCombinationMethods(combinationMethods);
        
//        callMethods(methodsToCall);
        
        //List<Method> methodCombinations = methodsToCall;
        
    }
    
    private static void callCombinationMethods(List<Method[]> list)
    {
        
        for(int index =0; index<list.size(); index++)
        {
            Picture myPicture = new Picture(originalPicture.getHeight(),originalPicture.getWidth());
            myPicture.copy(originalPicture, 0, 0);
            for(Method toCall : list.get(index))
            {
                if(toCall != null)
                {
                    try
                    {
                        toCall.invoke(myPicture);
                    }
                    catch(Exception e)
                    {
                        displayMessage(e.getMessage());
                    }
                }
                
            }
            myPicture.explore();
        }
        
    }
    
    private static List<Method[]> getCombinations(List<Method> list)
    {
        //List<List<Method>> results = new ArrayList<>();
        List<Method[]> results = new ArrayList<>();
        
        for(int first = 0; first<list.size();first+=3)
        {
            for(int second = 1; second<list.size(); second+=3)
            {
                for(int third = 2; third<list.size(); third+= 3)
                {
                    Method[] innerList = {list.get(first),list.get(second),list.get(third)};
                    results.add(innerList);
                }
            }                        
        }
               
        return results;
    }
    
    
    private static void callMethods(List<Method> methodsToCall)
    {
        for(int index = 0; index<methodsToCall.size(); index++)
        {
            try
            {
                Picture myPicture = new Picture(originalPicture.getHeight(),originalPicture.getWidth());
                myPicture.copy(originalPicture, 0, 0);
                
                methodsToCall.get(index).invoke(myPicture);
                myPicture.explore();              
            }
            catch(Exception e)
            {
                displayMessage(e.getMessage());
            }
        
        }
    }
    
    /*
     * this will print all thats in the list to the display
     */
    private static void printMethods(List<Method> list)
    {
        for(Method print:list)
        {
            displayMessage(print.getName());
        }
    }
    
    //extract all the methods that I want to do
    private static List<Method> getMethods()
    {
        List<Method> toReturn = new ArrayList<>() ;
        try
        {
            Class cl = Class.forName(classs);
            
            Method[] methods = cl.getDeclaredMethods();
            
            for(Method command: methods)
            {
                String commandName = command.getName();
                if((commandName.contains("Red")||commandName.contains("Blue")||commandName.contains("Green"))
                        && (commandName.contains("max") || commandName.contains("zero") && (command.getParameterCount() == 0)))
                {
                    toReturn.add(command);
                }
            }
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return toReturn;
    }
    
    
    private static void displayMessage(String message)
    {
        System.out.println(message);
    }
}
