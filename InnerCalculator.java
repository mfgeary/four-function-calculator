package calc;

/**
 * Class that stores the inputs to the calculator and manipulates them
 * to get the desired results. Functions as the memory of the calculator.
 * 
 * This code was written with help from official Java documentation and the
 * textbook "Absolute Java" by Savtich. The functionality of the calculator
 * for cases not specified in the project description is based on the 
 * four function calculator found on my iPhone 8.
 * 
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class InnerCalculator {
	
	/**
	 * Holds the first number of an equation entered into the calculator.
	 */
	private Number firstNumber;
	
	/**
	 * Holds the second number of an equation entered into the calculator.
	 */
	private Number secondNumber;
	
	/**
	 * Holds the operator of an equation entered into the calculator.
	 */
	private Operator operator;
	
	/**
	 * Indicates whether an equation has been evaluated before by
	 * the calculator; that is, indicates whether a result is 
	 * stored in firstNumber or not. This resets whenever the program
	 * is run or when the clear button is pressed.
	 */
	private boolean evaluated;	
	
	/**
	 * Adds input into calculator to the Number objects. Allows
	 * inputs to be stored and manipulated.
	 * @param c The character being added. Either a digit or an 
	 * operator
	 */
	public void addInput(char c) {
		// When '=' button is pressed for the first time
		if(evaluated == false) {
			if (firstNumber == null)
				firstNumber = new Number(0);
			if (Character.isDigit(c)) {
				if (secondNumber == null && operator == null)
					firstNumber.addDigit(c);
				else if (secondNumber == null)
					secondNumber = new Number((double)Character.getNumericValue(c));
				else
					secondNumber.addDigit(c);
			} else {
				// Operator can be changed if secondNumber is null
				if (secondNumber == null) {
					operator = new Operator(c);
				} else {
					// operator can be changed if secondNumber is null
					if (operator != null) {
					    evaluate();
					}
					operator = new Operator(c);
				}
			}
		// When '=' button has been pressed before, so something is
		// already stored in firstNumber
		} else {
			// Adds digit to number
			if (Character.isDigit(c)) {
				if (secondNumber == null && operator == null) {
					clearInput();
					addInput(c);
				} else if (secondNumber == null)
					secondNumber = new Number((double)Character.getNumericValue(c));
				else
					secondNumber.addDigit(c);
			// Adds operator
			} else {
				// operator can be changed if secondNumber is null
				if (secondNumber == null) {
					operator = new Operator(c);
				} else {
					// operator can be changed if secondNumber is null
					if (operator != null) {
					    evaluate();
					}
					operator = new Operator(c);
				}
			}
		}
	}
	
	/**
	 * Returns a String displaying the result of the input to the calculator.
	 * It displays the first number, second number, or the result of the equation.
	 * Displays the first number until an operator is input. Then displays the 
	 * second number as it is input. Finally, displays the result when the function
	 * is evaluated.
	 * @return The String value of the equation to display to the calculator screen.
	 */
	public String toString() {
		if(operator == null || secondNumber == null) {
			return firstNumber.toString();
		} else {
			return secondNumber.toString();
		}
	}
	
	/**
	 * Clears the memory of the calculator by instantiating all the instance
	 * variables to their default values.
	 */
	public void clearInput() {
		firstNumber = null;
		secondNumber = null;
		operator = null;
		evaluated = false;
	}
	
	/**
	 * Evaluates the inputed equation using the numbers and operators provided
	 * by the user. Returns an int value to indicate whether the evaluate method
	 * returns a result or encountered an error and cleared the calculator memory.
	 * @return An integer indicating whether the inputs where successfully inputed
	 * to be evaluated or not.
	 */
	public int evaluate() {
		// If there are no digits inputed, return 0.
		if (firstNumber == null) {
			return 0;
		// If no operator is inputed, return 3 since values were successfully
		// inputed but this has no effect.
		} else if (operator == null) {
			return 3;
		// If only the first number and the operator are filled, store
		// the first number to the second number and then evaluate. Thus
		// 4*= results in 16 and 5+= results in 10. Return 1 since the
		// the evaluation is successful.
		} else if (secondNumber == null) {
			secondNumber = firstNumber;
			evaluate();
			return 1;
		} else {
			// Evaluate the equation based on the inputed values and the 
			// chosen operator
			double d = 0;
			if (operator.operatorValue() == 1) {
					d = firstNumber.getNumber() + secondNumber.getNumber();
			} else if (operator.operatorValue() == 2)
					d = firstNumber.getNumber() - secondNumber.getNumber();
			else if (operator.operatorValue() == 3)
					d = firstNumber.getNumber() * secondNumber.getNumber();
			else if (operator.operatorValue() == 4)
					d = firstNumber.getNumber() / secondNumber.getNumber();
			// Sets the result as the first number and clears the rest of
			// the calculator memory. Sets evaluated to true to indicate that
			// the result is stored in firstNumber. Returns 2 to show that 
			// evaluation was successful.
			firstNumber.setNumber(d);
			firstNumber.setNumberString(firstNumber.largeSmallNumber());
			secondNumber = null;
			operator = null;
			evaluated = true;
			return 2;
		}
	}
	
	/**
	 * Change the sign of the current number. Allows for sign to be changed 
	 * at any point in the process of inputing digits.
	 */
	public void changeSign() {
		// If {+/-} is the first button pressed, create an instance of Number 
		// and store the sign value to apply to inputed number.
		if (firstNumber == null) {
			firstNumber = new Number(0);
			firstNumber.setNumberString("");
			firstNumber.setNumberString("-" + firstNumber.getNumberString());
		// Handles case where output is in scientific notation.
		} else if (firstNumber.getNumberString().contains("e") && operator == null) {
			firstNumber.changeSign();
			firstNumber.largeSmallNumber();
		// Handles case where decimal and plus minus buttons are pressed in
		// succession
		} else if (firstNumber.getNumberString().contains(".") && operator == null) {
			firstNumber.changeSignHelper();
		} else if (operator == null) {
			firstNumber.changeSign();
			firstNumber.largeSmallNumber();
		// If {+/-} is the first button pressed after operator, create an 
		// instance of Number and store the sign value to apply to inputed number.
		} else if (secondNumber == null) {
			secondNumber = new Number(0);
			secondNumber.setNumberString("");
			secondNumber.setNumberString("-" + secondNumber.getNumberString());
		} else if (secondNumber.getNumberString().contains("e")) {
			secondNumber.changeSign();
			secondNumber.largeSmallNumber();
		// Handles case where decimal and plus minus buttons are pressed in
		// succession for secondNumber
		} else if (secondNumber.getNumberString().contains(".")) {
			secondNumber.changeSignHelper();
		} else {
			secondNumber.changeSign();
			secondNumber.largeSmallNumber();
		}
	}
	
	/**
	 * Add the decimal to the number being input on the display and assure that next
	 * digits inputed follow the decimal. 
	 */
	public void addDecimal() {
		if (operator != null) {
			if (secondNumber == null)
				secondNumber = new Number(0);
			secondNumber.addDecimal();
		} else {
			if (firstNumber == null)
				firstNumber = new Number(0);
			// Creates new input when trying to add decimal to number in scientific 
			// notation.
			else if (firstNumber.getNumberString().contains("e")) {
				clearInput();
				addDecimal();
			}
			firstNumber.addDecimal();
		}
	}
}
