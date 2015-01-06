package lab1;

/* Fraction.java */

/**
 * The Fraction class implements nonnegative fractions (rational numbers).
 */
class Fraction {

	/**
	 * Computes the greatest common divisor (gcd) of the two inputs.
	 * 
	 * @param x
	 *            must be nonnegative
	 * @param y
	 *            must be nonnegative
	 * @return the gcd of x and y
	 */
	static private int gcd(int x, int y) {
		/* Replace the following line with your solution. */
		return 1;
	}

	/**
	 * Put the Fraction class through some tests.
	 * 
	 * @param argv
	 *            is not used.
	 */
	public static void main(String[] argv) {

		/* Test all four contructors and toString. */
		Fraction f0 = new Fraction();
		Fraction f1 = new Fraction(3);
		Fraction f2 = new Fraction(12, 20);
		Fraction f3 = new Fraction(f2);

		System.out.println("\nTesting constructors and toString():");
		System.out.println("The fraction f0 is " + f0.toString());
		System.out.println("The fraction f1 is " + f1); // toString is implicit.
		System.out.println("The fraction f2 is " + f2);
		System.out.println("The fraction f3 is " + f3
				+ ", which should equal f2");

		/* Test the add method. */
		System.out.println("\nTesting add:");

		/*
		 * Fraction sumOfTwo = _______________; // Sum of f1 and f2. Fraction
		 * sumOfThree = ______________; // Sum of f0, f1, and f2.
		 * 
		 * System.out.println("The sum of " + f1 + " and " + f2 + " is " +
		 * sumOfTwo); System.out.println("The sum of " + f0 + ", " + f1 +
		 * " and " + f2 + " is " + sumOfThree);
		 */

		/* Test the methods used in Part III. */
		System.out.println("\nTesting changeNumerator and fracs:");

		f3.changeNumerator(7);
		System.out.println("Now f3 is " + f3 + ", which should be 7/20");
		System.out.println("The total number of Fraction objects is "
				+ f3.fracs());

		/* Test gcd function (static method). */
		System.out.println("\nTesting gcd:");
		System.out.println("The gcd of 2 and 10 is: " + Fraction.gcd(2, 10));
		System.out.println("The gcd of 15 and 5 is: " + Fraction.gcd(15, 5));
		System.out.println("The gcd of 24 and 18 is: " + Fraction.gcd(24, 18));
		System.out.println("The gcd of 10 and 10 is: " + Fraction.gcd(10, 10));
		System.out
				.println("The gcd of 21 and 400 is: " + Fraction.gcd(21, 400));
	}

	/* private fields within a Fraction. */
	private int numberOfFractions = 0;

	private int numerator;

	private final int denominator;

	/**
	 * Constructs a Fraction 0/1.
	 */
	public Fraction() {
		this.numberOfFractions++;
		this.numerator = 0;
		this.denominator = 1;
	}

	/**
	 * Copies the Fraction "original".
	 */
	public Fraction(Fraction original) {
		this.numberOfFractions++;
		this.numerator = 0;
		this.denominator = 1;
	}

	/**
	 * Constructs a Fraction n/1.
	 * 
	 * @param n
	 *            is the numerator. Must be nonnegative.
	 */
	public Fraction(int n) {
		this(n, 1);
	}

	/**
	 * Constructs a Fraction n/d.
	 * 
	 * @param n
	 *            is the numerator. Must be nonnegative.
	 * @param d
	 *            is the denominator. Must be positive.
	 */
	public Fraction(int n, int d) {
		if (n < 0) {
			System.out.println("Fatal error:  Negative numerator.");
			System.exit(0);
		}
		if (d < 1) {
			System.out.println("Fatal error:  Nonpositive denominator.");
			System.exit(0);
		}
		this.numberOfFractions++;
		this.numerator = n;
		this.denominator = d;
	}

	/**
	 * Return the sum of two fractions.
	 * 
	 * @param f2
	 *            is the Fraction to be added.
	 * @return the result of adding f2 to this Fraction.
	 */
	public Fraction add(Fraction f2) {
		Fraction r = new Fraction((this.numerator * f2.denominator)
				+ (f2.numerator * this.denominator), this.denominator
				* f2.denominator);
		return r;
	}

	/**
	 * Replaces this Fraction's numerator with a new value.
	 * 
	 * @param numerator
	 *            is the new numerator. Must be nonnegative.
	 */
	public void changeNumerator(int numerator) { // DO NOT CHANGE THIS
													// SIGNATURE!
		// Fix the bug that prevents this method from working correctly.
		if (numerator < 0) {
			System.out.println("Fatal error:  Negative numerator.");
			System.exit(0);
		}
		this.numerator = numerator;
	}

	/**
	 * Returns the number of Fraction objects in existence.
	 * 
	 * @return the number of Fraction objects in existence.
	 */
	public int fracs() { // DO NOT CHANGE THIS SIGNATURE!
		// Fix the bug that prevents this method from working correctly.
		return this.numberOfFractions;
	}

	/**
	 * Converts this Fraction to a string format: "numerator/denominator."
	 * Fractions should be printed in reduced form (part of your assignment is
	 * to make this true).
	 * 
	 * @return a String representation of this Fraction.
	 */
	@Override
	public String toString() {
		int thisGcd = Fraction.gcd(this.numerator, this.denominator);

		return ((this.numerator / thisGcd) + "/" + (this.denominator / thisGcd));
	}
}