package ejer003;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		Main m = new Main();
		synchronized(m) {
			m.wait();
		}
	}
}
