package calc;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen and Marion Geary
 * CSCI 245, Wheaton College
 * September 27, 2021
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {
		// Create InnerCalculator to store the values inputed into the calculator
		// and evaluate expressions.
		InnerCalculator inner = new InnerCalculator();
		// Add action listeners for all digits and operators.
		face.addActionListener('+', new NumberOperatorListener(face, inner, '+'));
		face.addActionListener('-', new NumberOperatorListener(face, inner, '-'));
		face.addActionListener('*', new NumberOperatorListener(face, inner, '*'));
		face.addActionListener('/', new NumberOperatorListener(face, inner, '/'));
		face.addActionListener('0', new NumberOperatorListener(face, inner, '0'));
		face.addActionListener('1', new NumberOperatorListener(face, inner, '1'));
		face.addActionListener('2', new NumberOperatorListener(face, inner, '2'));
		face.addActionListener('3', new NumberOperatorListener(face, inner, '3'));
		face.addActionListener('4', new NumberOperatorListener(face, inner, '4'));
		face.addActionListener('5', new NumberOperatorListener(face, inner, '5'));
		face.addActionListener('6', new NumberOperatorListener(face, inner, '6'));
		face.addActionListener('7', new NumberOperatorListener(face, inner, '7'));
		face.addActionListener('8', new NumberOperatorListener(face, inner, '8'));
		face.addActionListener('9', new NumberOperatorListener(face, inner, '9'));
		// Add action listeners for specialized calculator buttons.
		face.addActionListener('=', new EqualListener(face, inner));
		face.addActionListener('.', new DecimalListener(face, inner));
		face.addActionListener('C', new ClearListener(face, inner));
		face.addPlusMinusActionListener(new PlusMinusListener(face, inner));
	}
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
