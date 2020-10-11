package pixLab.gui.questionsPopup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ObjectParameter<T> extends ParameterInfo<JLabel,JComboBox> {

	public ObjectParameter(String message, Class<?> classToMake) {
		super(createLabel(message), createDropDown(message, classToMake));
	}

	@Override
	public boolean hasValidInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getValidatedInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearAnswerSpace() {
		// TODO Auto-generated method stub
		
	}
	
}
