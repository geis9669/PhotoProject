package pixLab.classes;

import java.lang.reflect.*;
import java.util.*;

public class PictureMyFunTests
{
    private static String classs = "pixLab.classes.Picture";
    private static final Picture originalPicture = new Picture("beach.jpg");
    
    public static void main(String[] args)
    {
        ArrayList<Method> methodsToCall = (ArrayList<Method>) getMethods();

        originalPicture.explore();

        printMethods(methodsToCall);
        displayMessage("\n");

        List<String> catagories = new ArrayList<>();
        catagories.add("Blue");
        catagories.add("Green");
        catagories.add("Red");
        sortByGroups(methodsToCall, catagories);

        methodsToCall.add(null);
        methodsToCall.add(null);
        methodsToCall.add(null);

        printMethods(methodsToCall);

        List<Method[]> combinationMethods = getCombinations(methodsToCall, 3);

        printMethods(combinationMethods);
        
        //callCombinationMethods(combinationMethods);
        
//        callMethods(methodsToCall);
        
    }

    /**
     * this sorts the things in the method list if they contain a string in message and it is a pattern
     * @param list the list you want sorted
     * @param categories the things you want each spot to be at.
     */
    private static void sortByGroups(List<Method> list, List<String> categories) {
        List<Method> newList = new ArrayList<>();

        while(list.size() > 0) {
            for(int item = 0; item < categories.size(); item++) {
                int index = 0;
                boolean found = false;

                while(!found && index < list.size()) {
                    if(list.get(index).getName().contains(categories.get(item))) {
                        newList.add(list.remove(index));
                        found = true;
                    }
                    else {
                        index++;
                    }
                }

                if(!found){
                    newList.addAll(list);
                    list.clear();
                }
            }
        }

        list.addAll(newList);
    }

    /**
     * calls the imputed method combinations and prints the results
     * @param list the list of arrays that have valid methods to call on picture objects.
     */
    private static void callCombinationMethods(List<Method[]> list)
    {
        for(int index =0; index<list.size(); index++)
        {
            Picture myPicture = new Picture(originalPicture.getHeight(),originalPicture.getWidth());
            myPicture.copy(originalPicture, 0, 0);
            String title = "";
            for(Method toCall : list.get(index))
            {
                if(toCall != null)
                {
                    try
                    {
                        toCall.invoke(myPicture);
                        title += toCall.getName()+", ";
                    }
                    catch(Exception e)
                    {
                        displayMessage(e.getMessage());
                    }
                }
                else
                {
                    title+="null, ";
                }
                
            }
            title+= " #"+index;
            myPicture.setTitle(title);
            myPicture.explore();
        }
        
    }

    /**
     * assumes the list is in groups of 3 like red, green, blue then repeats
     * @param list the list to make combinations out of.
     * @return the list of arrays that are the combinations.
     */
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

    /**
     * this will get all the combinations of the items in the list of the groupSize
     * @param list the list that has repeating values to make combinations of
     * @param groupSize how big the groups are
     * @return the combinations it found
     */
    public static ArrayList<Method[]> getCombinations(ArrayList<Method> list, int groupSize)
    {
        return getCombinations(list, groupSize, 1, new Method[groupSize]);
    }

    // does it need to be a list of method could it just be a list?
    private static ArrayList<Method[]> getCombinations(ArrayList<Method> list, int groupSize, int loop, Method[] currentList)
    {
        ArrayList<Method[]> results = new ArrayList<>();

        for(int index = loop-1; index<list.size(); index+= groupSize )
        {
            if(loop >= groupSize)
            {
                //loop -1 tells me the place where I put the item.
                currentList[loop-1] = list.get(index);
                results.add(currentList.clone());// should be a copy of the array.
            }
            else
            {
                currentList[loop-1] = list.get(index);
                results.addAll(getCombinations(list,groupSize,loop+1,currentList));
                //Method[] innerList = {list.get(index), getCombinations(list, groupSize, loop + 1)};
            }
        }
        return results;
        // returning the object at the current place
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
    private static void printMethods(ArrayList<Method> list)
    {
        String message = "";
        for(Method print:list)
        {
            if(print!= null) {
                message += print.getName() + "\n";
                //displayMessage(print.getName());
            }else{
                message += "null \n";
                //displayMessage("null");
            }
        }
        displayMessage(message);
    }


    /**
     * this will print all the methods in the array
     * @param list the arrays of Method objects you want printed.
     */
    private static void printMethods(List<Method[]> list)
    {
        String message = "";
        for(Method[] methods: list)
        {
            for(Method method: methods)
            {
                if(method!=null)
                {
                    message += method.getName();
                }else {
                    message += "null";
                }
                message+= ", ";
            }
            message+="\n";
        }
        displayMessage(message);
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
