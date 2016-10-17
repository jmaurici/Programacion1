package control;

public class Hebra extends Thread {
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++)
			System.out.println(Thread.currentThread().getName() + " : " + i);
	}
}
