package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class for the {+/-} button. Changes the sign of the 
 * number being input when pressed.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class PlusMinusListener implements ActionListener {
	
	/**
	 * The outward GUI display of the calculator. Can be any object of the
	 * CalculatorFace interface.
	 */
	private CalculatorFace face;
	
	/**
	 * Stores the input as inner values of the calculator. Allows the inputs to
	 * be manipulated where only the results are displayed.
	 */
	private InnerCalculator inner;
	
	/**
	 * Constructor that instantiates the outward display of the
	 * calculator and the inward back-end functionality associated
	 * with the clear button.
	 * @param face The outward display of the calculator.
	 * @param inner The inward storage of the inputed information.
	 */
	public PlusMinusListener(CalculatorFace face, InnerCalculator inner) {
		this.face = face;
		this.inner = inner;
	}
	
	/**
	 * Changes the sign of the number currently being inputed and displays the
	 * change to the screen of the calculator.
	 * @param a The event of the button being pressed.
	 */
	public void actionPerformed(ActionEvent a) {
		inner.changeSign();
		face.writeToScreen(inner.toString());
	}

}