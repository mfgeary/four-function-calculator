package calc;

/**
 * Class to store the operator inputed by the user of the
 * calculator. Meant to be used with four function 
 * calculator where +, -, *, and / are the only
 * operators inputed.
 * @author Marion Geary
 * CSCI 245, Wheaton College, Fall 2021
 * September 27, 2021
 */
public class Operator {
	
	private char symbol;

	/**
	 * Constructor to store the operator based on the
	 * character inputed.
	 * @param sym The symbol of the operator inputed.
	 */
	public Operator(char sym) {
		this.symbol = sym;
	}
	
	/**
	 * Get the operator stored in the object as a char.
	 * @return The char of the operator.
	 */
	public char getOperator() {
		return symbol;
	}
	
	/**
	 * Set the operator to a desired char. 
	 * @param sym The desired char to set as the operator.
	 */
	public void setOperator(char sym) {
		this.symbol = sym;
	}
	
	/*
	 * Return Operator as a String.
	 * @return The String value of the operator.
	 */
	public String toString() {
		return Character.toString(symbol);
	}
	
	/**
	 * Return the Operator as an int where + is 1,
	 * - is 2, * is 3, and / is 4. Used to easily 
	 * compare the value of the operator as an int.
	 * @return The int value associated with the 
	 * Operator.
	 */
	public int operatorValue() {
		if (this.symbol == '+')
			return 1;
		else if (this.symbol == '-')
			return 2;
		else if (this.symbol == '*')
			return 3;
		else if (this.symbol == '/')
			return 4;
		else
			return 0;
	}

}
