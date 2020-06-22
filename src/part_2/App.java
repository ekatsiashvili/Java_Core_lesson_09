package part_2;

public class App {
	public static void main(String[] args) {
		
		Methods m = new Methods(-675.98, 0);
				
		try {
			System.out.println(m.a + " + " + m.b + " = " + m.plus(m.a, m.b));
		} catch (Throwable e) {
			System.out.println("Exception intercepted: " + e.toString());
		}

		
		try {
			System.out.println(m.a + " - " +m.b + " = " + m.minus(m.a, m.b));
		} catch (Throwable e) {

			System.out.println("Exception intercepted: " + e.toString());
		}

		
		try {
			System.out.println(m.a + " * " + m.b + " = " + m.dobutok(m.a, m.b));
		} catch (Throwable e) {
			System.out.println("Exception intercepted: " + e.toString());
		}

		
		try {
			System.out.println(m.a + " / " + m.b + " = " + m.dilenya(m.a, m.b));
		} catch (Throwable e) {

			System.out.println("Exception intercepted: " + e.toString());

		}
		
		try {

			System.out.println(m.a + " + " + m.b + " = " + m.plus(m.a, m.b));

		} catch (Throwable e) {

			System.out.println("Exception intercepted: " + e.toString());

		}

	}
}