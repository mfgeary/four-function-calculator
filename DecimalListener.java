package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class for the decimal button. Writes a decimal to the
 * screen and converts the input to a double when the decimal button
 * is pressed.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class DecimalListener implements ActionListener {
	
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
	 * with the decimal button.
	 * @param face The outward display of the calculator.
	 * @param inner The inward storage of the inputed information.
	 */
	public DecimalListener(CalculatorFace face, InnerCalculator inner) {
		this.face = face;
		this.inner = inner;
	}
	
	/**
	 * Writes decimal to screen and changes stored value to a double. Allows
	 * future digits to be part of the decimal values.
	 * @param a The event of the button being pressed.
	 */
	public void actionPerformed(ActionEvent a) {
			inner.addDecimal();
			face.writeToScreen(inner.toString());
		}

}