package reflect.classes;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class UmlInformation {

    /**
     *
     * @param cl a class
     * @return all the constructors as a string from the class cl
     */
    public String getConstructors(Class cl)
    {
        Object[] constructors = sortByParameters(cl.getDeclaredConstructors());
        String message = "";

        for(int place = 0; place < constructors.length; place++)
        {
            Constructor thisClass = (Constructor) constructors[place];

            String name = thisClass.getName();
            message += "    "+ Modifier.toString(thisClass.getModifiers());
            message += " "+name+"(";

            // print parameter types
            Class[] paramTypes = thisClass.getParameterTypes();
            for( int index = 0; index < paramTypes.length; index++)
            {
                if(index>0)message += ", ";
                message += paramTypes[index].getName();
            }
            message += ");"+newLine();
        }
        return message;
    }

    /**
     * makes a String of all the methods of a class
     * @param cl a class
     * @return the String of methods
     */
    public String getMethods(Class cl)
    {
        Method[] methods = (Method[]) sortByName(cl.getDeclaredMethods());
        String message = "";

        for(Method method : methods)
        {
            Class returnType = method.getReturnType();
            String name = method.getName();

            // add modifiers to message, return type and method name
            message +="    " + Modifier.toString(method.getModifiers());
            message += " " + returnType.getName() + " "+name+ "(";

            //add parameter types to message
            Class[] paramTypes = method.getParameterTypes();
            for(int i = 0; i<paramTypes.length; i++)
            {
                if(i>0) message+=", ";
                message+=paramTypes[i].getName();
            }
            message+=");"+newLine();
        }
        return message;
    }

    /**
     *
     * @param cl a class
     * @return the fields of a class
     */
    public String getFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();
        String message = "";

        for(Field f: fields)
        {
            Class type = f.getType();
            String name = f.getName();
            message += "    " + Modifier.toString(f.getModifiers());
            message += " " + type.getName()+ " " + name+ ";"+ newLine();
        }
        return message;
    }

    /**
     * makes sure the array is all of the Executable type
     * @param list the list to test
     * @return true if the list is all of the Executable type
     */
    private boolean isExecutableList(Object[] list)
    {
        for(int index= 0; index<list.length; index++)
        {
            if(!(list[index] instanceof Executable))
            {
                return false;
            }
        }
        return true;
    }


    /**
     * this checks to see if a list is all of the specified type
     * @param list to check if they are all of a Class
     * @param classImport the import for the class you want to make sure the list is all of.
     * @return true if the list is all of the specified type, false otherwise
     */
    private boolean isOfType(Object[] list, String classImport)
    {
        try {
            Class cl = Class.forName(classImport);
            cl.getComponentType();
            for (int index = 0; index < list.length; index++) {
                if (!(cl.isInstance(list[index])))
                {
                    return false;
                }
            }
            return true;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Sorts a list that is of type Executable
     * @param list the list you want sorted
     * @return the sorted array, or an array of size 0 if the list is not of type Executable, or the list if its size is less then or equal to 1
     */
    private Executable[] sortByParameters(Executable[] list)
    {
        if(list.length <= 1)
        {
            return list;
        }
        if (list.length == 2) {
            Executable first = list[0];
            Executable last = list[1];
            if (first.getParameterCount() < last.getParameterCount()) {
                return list;
            } else {
                Executable[] newObject = {list[1], list[0]};
                return  newObject;
            }
        }
        Executable pivot = list[0];
        List<Executable> first = new ArrayList<>();
        List<Executable> last = new ArrayList<>();

        for (int index = 1; index < list.length; index++) {
            Executable current = list[index];
            if (current.getParameterCount() < pivot.getParameterCount()) {
                first.add(current);
            } else if (current.getParameterCount() > pivot.getParameterCount()) {
                last.add(current);
            } else {
                first.add(current);
            }
        }
        Executable[] middle = {pivot};

        Executable[] firstArray = new Executable[first.size()];
        Executable[] lastArray = new Executable[last.size()];
        first.toArray(firstArray);
        lastArray = last.toArray(lastArray);

        return (Executable[]) combineArrays((Executable[]) combineArrays( sortByParameters(firstArray), middle), sortByParameters(lastArray));
    }

    private Executable[] sortByName(Executable[] list) {
        // simplest case
        if (list.length <= 1) {
            return list;
        } else if (list.length == 2) {
            String firstName = list[0].getName();
            String secondName = list[1].getName();
            if (firstName.compareTo(secondName) > 0) {
                Executable swap = list[0];
                list[0] = list[1];
                list[1] = swap;
            }
            return list;
        }
        //cuts the array in half if it is bigger than 3
        int half = list.length / 2;
        Executable[] first = new Executable[half];//list.length/2];
        Executable[] second = new Executable[half + list.length % 2];
        //splits the array in half
        for (int index = 0; index < list.length; index++) {
            if (index < half) {
                first[index] = list[index];
            } else {
                second[index - half] = list[index];
            }
        }
        //sort the halfs of the array
        first = sortByName(first);
        second = sortByName(second);

        // compare the lists and make them one in the correct order.
        int indexList = 0;
        int indexFirst = 0;
        int indexSecond = 0;
        while(indexList < list.length)
        {
            if(indexFirst >= first.length)
            {
                list[indexList] = second[indexSecond];
                indexSecond++;
            }
            else if(indexSecond >= second.length)
            {
                list[indexList] = first[indexFirst];
                indexFirst++;
            }
            else
            {
                if (first[indexFirst].getName().compareTo(second[indexSecond].getName()) < 0) {
                    list[indexList] = first[indexFirst];
                    indexFirst++;
                } else if (first[indexFirst].getName().compareTo(second[indexSecond].getName()) > 0) {
                    list[indexList] = second[indexSecond];
                    indexSecond++;
                }
                else
                {
                    list[indexList] = first[indexFirst];
                    indexFirst++;
                    indexList++;
                    list[indexList] = second[indexSecond];
                    indexSecond++;
                }
            }
            indexList++;
        }
        return list;
    }

    /**
     * don't use this method
     * takes two lists and add them
     * @param firstList the first array to add
     * @param lastList starts after the first array
     * @return the new array that has all the elements from both arrays keeping their order.
     */
    private Object[] combineArrays1(Object[] firstList, Object[] lastList) {
        int length = firstList.length + lastList.length;
        Object[] newList = new Object[length];

        for (int index = 0; index < firstList.length; index++)
        {
            newList[index] = firstList[index];
        }
        for(int index = 0; index<lastList.length;index++)
        {
            newList[index + firstList.length] = lastList[index];
        }
        return newList;
    }

    /**
     * combines two arrays after making sure they are the same type. they also keep their order.
     * @param firstList the list that is first in the new list
     * @param lastList the list that starts after the first list
     * @return the new list as an object which needs to be cast or a Object array with 0 elements
     */
    private Object combineArrays(Object[] firstList, Object[] lastList)
    {
        Class cl1 = firstList.getClass();
        Class cl2 = lastList.getClass();
        Class componentType1 = cl1.getComponentType();

        //cl1.isInstance(cl2)
        if(cl1.getComponentType().getName().contentEquals(cl2.getComponentType().getName()))
        {
            int newLength = firstList.length + lastList.length;
            Object newArray = Array.newInstance(componentType1, newLength);
            System.arraycopy(firstList, 0, newArray,0,firstList.length);
            System.arraycopy(lastList, 0, newArray, firstList.length, lastList.length);

            return newArray;
        }
        else
        {
            Object emptyArray = Array.newInstance(componentType1, 0);
            return emptyArray;
        }
    }

    /**
     * made to make it clear when I make a new line in a string
     * @return a new line character
     */
    private  String newLine()
    {return "\n";}
}
