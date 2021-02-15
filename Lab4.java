
/**
 * @author Hiro
 *
 *         (D) Exception handling and multi-threading applications: COMPUTER
 *         SCIENCE AND ENGINEERING 10) Write a Java program that shows the usage
 *         of try, catch, throws and finally. 12) Write a Java program that
 *         shows thread synchronization
 * 
 *         ** 11) Write a Java program that implements a multi-threaded program
 *         which has three threads. First thread generates a random integer
 *         every 1 second. If the value is even, second thread computes the
 *         square of the number and prints. If the value is odd the third thread
 *         will print the value of cube of the number. . **
 *
 */
public class Lab4 {

	class Random extends Thread {
		int randint;

		Random() {
			start();
		}

		void randInt() {
			int max = 1000;
			int min = 0;
			this.randint = (int) (Math.random() * (max - min + 1) + min);
			System.out.println(Thread.currentThread().getName() + ": " + randint);
		}

		public void run() {
			Thread t = Thread.currentThread();
			t.setName("Random Number");
			while (true) {
				randInt();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Square extends Thread {
		Random rd;

		Square(Random rd) {
			this.rd = rd;
			start();
		}

		void square(int no) {
			if (no % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + ": " + no * no);
			}
		}

		public void run() {
			Thread t = Thread.currentThread();
			t.setName("Square");
			while (true) {
				square(rd.randint);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Cube extends Thread {
		Random rd;

		Cube(Random rd) {
			this.rd = rd;
			start();
		}

		void Cube(int no) {
			if (no % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + ": " + no * no * no);
			}
		}

		public void run() {
			Thread t = Thread.currentThread();
			t.setName("Cube");
			int i = 100;
			while (i>0) {
				i--;
				Cube(rd.randint);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Lab4 lab = new Lab4(); // Multithreading
		Random rndom = lab.new Random();
		Square sqre = lab.new Square(rndom);
		Cube cube = lab.new Cube(rndom);
	}
}
