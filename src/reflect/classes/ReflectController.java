package reflect.classes;

// notes on generices
//http://www.eecs.qmul.ac.uk/~mmh/APD/bloch/generics.pdf information on generics ?
// https://stackoverflow.com/questions/3009745/what-does-the-question-mark-in-java-generics-type-parameter-mean/3009779 another place for infromation.

import java.util.Scanner;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

import java.lang.reflect.*;
import java.lang.reflect.Modifier;
import java.lang.reflect.Executable;

//import UmlInformation;
//import reflect.view.ReflectFrame;


public class ReflectController {

    private boolean usePopup;
    private Scanner console;
//    private ReflectFrame gui;

    private UmlInformation info;

    public ReflectController(boolean usePopup){
        this.info = new UmlInformation();

//        this.gui = new ReflectFrame();
        
//        this.gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.usePopup = usePopup;
        this.console = new Scanner(System.in);
    }

/*
    public void start()
    {
        displayMessage("Start");
        gui.setVisible(true);
       
       
    }
*/

    public void start()
    {
        String answer ;
        String message = "";
        answer = askQuestion("Enter class name (example. java.util.Date):");

        try
        {
            //print class name and superclass name (if != Object)
            Class cl = Class.forName(answer);
            Class supercl = cl.getSuperclass();
            message = ("class "+answer);
            if(supercl != null && supercl!= Object.class)
                message += (" extends " + supercl.getName());

            message += "\n{\n";
            message += info.getConstructors(cl);
            message += newLine();
            message += info.getMethods(cl);
            message += newLine();
            message += info.getFields(cl);
            message += "}"+newLine();
            displayMessage(message);
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        System.exit(0);
    }

/*
    public void start()
    {
        String message = "Hello world\n";
        try
        {
            Class cl = Class.forName("java.util.Date");

            message += info.getMethods(cl);

            displayMessage(message);
        }
        catch (ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        System.exit(0);
    }

  */

    private void printArray(Object[] array)
    {
        String message = "";
        for(int index = 0; index < array.length; index++)
        {
            message += array[index];
            message += " ,";
        }
        displayMessage(message);
    }

    /**
     * made to make it clear when I make a new line in a string
     * @return a new line character
     */
    private  String newLine()
    {return "\n";}

    private void displayMessage(String message)
    {
        if(usePopup)
        {

        }
        else
        {
            System.out.println(message);
        }
    }

    private String askQuestion(String message)
    {
        if(usePopup)
        {
            return "";
        }
        else
        {
            System.out.println(message);
            return console.nextLine();
        }
    }
}
