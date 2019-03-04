
public class Rational {
	int numerator;
	int denominator;
	
	Rational(int num, int denom) {
		numerator = num;
		denominator = denom;
	}

	Rational(int num) {
		numerator = num;
		denominator = 1;
	}

	public Rational add(Rational r) {
		int num = (this.numerator * r.denominator) + (this.denominator * r.numerator);
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}

	public Rational subtract(Rational r) {
		int num = (this.numerator * r.denominator) - (r.numerator * this.denominator);
		int den = (this.denominator * r.denominator);
		return new Rational(num, den);
	}
	public Rational divide( Rational r)
	{
		int num = (this.numerator * r.denominator);
		int den =(this.denominator * r.numerator);
		return new Rational(num,den);
	}
	public Rational multiply(Rational r)
	{
		int num = (this.numerator * r.numerator);
		int den = (this.denominator * r.denominator);
		return new Rational(num, den);
	}
	public boolean equals(Rational r) {
		r.simplify(r);
		this.simplify(this);
		if (numerator == r.numerator && denominator == r.denominator) {
			return true;
		}
		return false;
	}
	public boolean isLessThan(Rational r) {
		this.simplify(this);
		r.simplify(r);
		if ((this.numerator * r.denominator) < (r.numerator * this.denominator)) {
			return true;
		}
		return false;
	}

	public Rational simplify(Rational r) {					
		int g = gcd(r.numerator, r.denominator);
		int num = r.numerator/g;
		int den = r.denominator/g;
		return new Rational(num, den);
	}

	public int gcd(int p, int q) {
		 while (q != 0) {
	            int temp = q;
	            q = p % q;
	            p = temp;
	        }
	        return p;
	}

	@Override
	public String toString() {
		return "" + numerator +"/" + denominator;
	}
}
