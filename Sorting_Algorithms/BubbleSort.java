import java.io.*;
import java.util.Scanner;

public class BubbleSort {
	int[] A;
	int n;

	public BubbleSort(int[] A, int n) {
		this.A = A;
		this.n = n;
	}

	public void sort() {
		int len = this.n - 1;
		for (int last = len; last >= 1; last--) {
			for (int pos = 0; pos < len; pos++) {
				if (A[pos] >= A[pos + 1]) {
					int tmp = A[pos];
					A[pos] = A[pos + 1];
					A[pos + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		double start = System.currentTimeMillis(); // current time

		System.setIn(new FileInputStream("data//100.txt")); // load file
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of values
		int[] A = new int[n]; // create array
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt(); // get values from the file
		}

		BubbleSort s = new BubbleSort(A, n);
		s.sort();
		s.print();

		System.out.println();
		System.out.println("execution time :: " + (System.currentTimeMillis() - start) + "(ms)");
		sc.close();
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(A[i] + " ");
		}
	}

}