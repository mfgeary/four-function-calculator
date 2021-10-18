package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class for all digits and operators. Store input
 * to calculator memory and displays the most recent number or the result
 * of an operation.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class NumberOperatorListener implements ActionListener {
	
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
	 * Character displayed on the button. Represents a digit or an operation.
	 */
	private char c;
	
	/**
	 * Constructor for class that instantiates the outward display of the
	 * calculator and the inward back-end functionality associated
	 * with the button pressed and the character as the char displayed
	 * on the button.
	 * @param face The outward display of the calculator.
	 * @param inner The inward storage of the inputed information.
	 * @param c The character displayed on the button representing the digit
	 * or operation.
	 */
	public NumberOperatorListener(CalculatorFace face, InnerCalculator inner, char c) {
		this.face = face;
		this.c = c;
		this.inner = inner;
	}
	
	/**
	 * Adds input to the memory of the calculator and displays the most recent number or
	 * the result of an operation. Input and display based on the button pressed.
	 * @param a The event of the button being pressed.
	 */
	public void actionPerformed(ActionEvent a) {
		inner.addInput(c);
		face.writeToScreen(inner.toString());
	}

}