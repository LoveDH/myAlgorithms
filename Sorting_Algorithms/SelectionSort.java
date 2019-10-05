import java.io.*;
import java.util.Scanner;

public class SelectionSort {

	int[] A;
	int n;

	public SelectionSort(int[] A, int n) {
		this.A = A;
		this.n = n;
	}

	public static void main(String[] args) throws FileNotFoundException {
		double start = System.currentTimeMillis(); // current time
		System.setIn(new FileInputStream("data//100.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		SelectionSort ss = new SelectionSort(A, n);
		ss.sort();
		ss.printAry();

		System.out.println();
		System.out.println("execution time :: " + (System.currentTimeMillis() - start) + "(ms)");
		sc.close();
	}

	private void sort() {
		for (int last = n - 1; last >= 1; last--) {
			int max = A[0];
			int max_index = 0;
			for (int i = 1; i <= last; i++) {
				if (max <= A[i]) {
					max = A[i];
					max_index = i;
				}
			}
			A[max_index] = A[last];
			A[last] = max;
		}
	}

	private void printAry() {
		for (int i = 0; i < n; i++) {
			System.out.println(A[i] + " ");
		}
	}

}