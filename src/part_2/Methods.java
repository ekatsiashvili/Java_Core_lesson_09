package part_2;

public class Methods {
	double a;
	double b;

	public Methods(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	void newException(double a, double b) throws IllegalAccessException, ArithmeticException, MyException {
		if (a<0 & b<0)
			throw new IllegalArgumentException("a<0 and b<0");

		else if (a == 0 & b != 0)
			throw new ArithmeticException("a=0 and b!=0");

		else if (a != 0 & b == 0)
			throw new ArithmeticException("a!=0 and b=0");

		else if (a == 0 & b == 0)
			throw new IllegalAccessException("a=0 and b=0");

		else if (a>0 & b>0)
			throw new MyException("a>0 and b>0");

	}
	double plus(double a, double b) throws IllegalAccessException, ArithmeticException, MyException {
		newException(a,b);
		return a + b;
	}

	double minus(double a, double b) throws IllegalAccessException, ArithmeticException, MyException {
		newException(a,b);
		return a - b;
	}



	double dobutok(double a, double b) throws IllegalAccessException, ArithmeticException, MyException {
		newException(a,b);
		return a * b;
	}

	double dilenya(double a, double b) throws IllegalAccessException, ArithmeticException, MyException {
		newException(a,b);
		return a / b;

	}
}