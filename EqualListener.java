package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class for the equal button. Displays the result of
 * an operation based on previous inputs.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class EqualListener implements ActionListener {
	
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
	 * with the equal button.
	 * @param face The outward display of the calculator.
	 * @param inner The inward storage of the inputed information.
	 */
	public EqualListener(CalculatorFace face, InnerCalculator inner) {
		this.face = face;
		this.inner = inner;
	}
	
	/**
	 * Evaluates the result of the previously entered inputs, and displays the
	 * results. Displays 0 and clears the memory if inputs are missing.
	 * @param a The event of the button being pressed.
	 */
	public void actionPerformed(ActionEvent a) {
		// Evaluates result of previous inputs. Stores 0 if the inputs
		// were invalid
		int i = inner.evaluate();
		
		// Displays the result if inputs were valid or displays 0 a number 
		// or an operator were not input.
		if (i != 0) {
			face.writeToScreen(inner.toString());
		} else {
			face.writeToScreen("0");
		}
	}
}