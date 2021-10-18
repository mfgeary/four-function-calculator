package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class for the clear button 'C' on the calculator. 
 * Clears all the values stored in the calculator when the button is pressed.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class ClearListener implements ActionListener {
	
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
	public ClearListener(CalculatorFace face, InnerCalculator inner) {
		this.face = face;
		this.inner = inner;
	}
	
	/**
	 * Clears the stored input in the inner calculator and resets the 
	 * display to 0. Acts as a reset button for the calculator.
	 * @param a The event of the button being pressed.
	 */
	public void actionPerformed(ActionEvent a) {
		inner.clearInput();
		face.writeToScreen("0");
	}

}