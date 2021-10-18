package calc;
import java.lang.Character;
import java.lang.String;

/**
 * Class to store the numbers inputed into the calculator. Stores the
 * digits inputed as a double and an accompanying String. Allows for 
 * inputs to be easily manipulated.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class Number {
	
	/**
	 * Stores the double value of the number input into the calculator.
	 */
	private double number;
	
	/**
	 * The String version of the number inputed into the calculator. Used
	 * to display to the calculator face.
	 */
	private String numberString;
	
	/**
	 * Constructor that takes a double and stores it to the class 
	 * as a double and a String. The String will display as an int
	 * if the decimal value is 0. Do not use scientific notation for num.
	 * @param num The initial number desired for this instance of Number.
	 */
	public Number(double num) {
		this.number = num;
		// String display as an int if the decimal value is 0. Ex. 26.0
		// becomes the String "26"
		if (Math.floor(number) == Math.ceil(number)) {
			numberString = Double.toString(number);
			int i = numberString.indexOf('.');
			numberString = numberString.substring(0, i);
		} else {
			numberString = Double.toString(this.number);
		}
	}
	
	/**
	 * Adds a digit to the number stored in the Number object. The
	 * digit is inputed as a character.
	 * @param c The char being added as a digit to the end of the number.
	 */
	public void addDigit(char c) {
		if (!(numberString.toString().length() >= 15) && !(numberString.contains("e"))) {
			this.numberString = numberString + c;
			this.number = Double.parseDouble(numberString);
		}
	}
	
	/**
	 * Adds decimal to the inputed number. Allows for double to be
	 * inputed into the calculator.
	 */
	public void addDecimal() {
		if (!numberString.contains("."))
			numberString = numberString + ".";
	}
	
	/**
	 * Change the sign of the number and store the change in the
	 * associated numberString.
	 */
	public void changeSign() {
		//if(!(numberString.contains("e"))) {
			this.number = -1 * this.number;
			if ((Math.floor(number) == Math.ceil(number)) && !((number > 9999999.0) || (number <= 0.0001 
					&& number > 0) || (number < -9999999.0) || (number >= -0.0001 && number < 0))) {
				numberString = Double.toString(number);
				int i = numberString.indexOf('.');
				numberString = numberString.substring(0, i);	
			} else if ((number > 9999999.0) || (number <= 0.0001 
					&& number > 0) || (number < -9999999.0) || (number >= -0.0001 && number < 0)) {;
				numberString = Double.toString(this.number);
			} else {
				numberString = Double.toString(this.number);
			}
		//}
	}
	
	/**
	 * Handles special case of changeSign() function where decimal
	 * and plus minus buttons are pressed in succession.
	 */
	public void changeSignHelper() {
		if(!(numberString.contains("e"))) {
			if (numberString.contains("-")) {
				numberString = toString().substring(1);
			} else {
				numberString = "-" + toString();
			}
		}
	}
	/**
	 * Displays the inputed values as a String. 
	 * @return String holding the value of the number.
	 */
	public String toString() {
		// Removes leading zero on non-decimal numbers.
		if(numberString.length() > 1 && numberString.charAt(0) == '0' && !(numberString.charAt(1) == '.')) {
			numberString = numberString.substring(1);
			return numberString;
		} else {
			return numberString;
		}
	}
	
	/**
	 * Set the value of the object Number. Update the double and String of the object.
	 * @param num The desired number for the object to contain.
	 */
	public void setNumber(double num) {
		this.number = num;
		if (Math.floor(number) == Math.ceil(number)) {
			numberString = Double.toString(number);
			if (!numberString.contains("e")) {
				int i = numberString.indexOf('.');
				if (i != -1) {
					numberString = numberString.substring(0, i);	
				}
			}
		} else
			numberString = Double.toString(this.number);
	}
	
	/**
	 * Get the value of the Number as a double.
	 * @return The value of the Number as a double.
	 */
	public double getNumber() {
		return this.number;
	}
	
	/**
	 * Get the String value of the Number. Does not account for all special cases like 
	 * toString(). Use toString() for official display in calculator. 
	 * @return String value of the stored number.
	 */
	public String getNumberString() {
		return this.numberString;
	}

	/**
	 * Set the value of the String associated with the Number.
	 * @param string The desired value of the String associated with the Number.
	 */
	public void setNumberString(String str) {
		this.numberString = str;
	}
	
	/**
	 * Rounds decimal values to display correct on the screen. Only makes changes to the
	 * String numberString - number is unaltered.
	 */
	public void round() {
		if (numberString.length() > 15 && numberString.substring(0, 13).contains(".")) {
			int i = Character.getNumericValue(numberString.charAt(15));
			int j = Character.getNumericValue(numberString.charAt(14));
			if (i > 5) {
				j = j + 1;
				numberString = numberString.substring(0, 14) + Integer.toString(j);
			} else {
				numberString = numberString.substring(0, 15);
			}
		}
	}
	
	/**
	 * Correctly displays numbers using scientific notation if they are too large or small.
	 * Handles cases where rounding is needed.
	 * @return String Returns the updated value of numberString.
	 */
	public String largeSmallNumber() {
		if (number > 9999999.0 || (number <= 0.0001 && number > 0) || 
				(number < -9999999.0 || (number >= -0.0001 && number < 0))) {
			numberString = String.format("%e", number);
		} else {
			round();
		}
		return numberString;
	}

}