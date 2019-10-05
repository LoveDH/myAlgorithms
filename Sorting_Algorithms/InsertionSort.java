import java.io.*;
import java.util.Scanner;

public class InsertionSort {
	int[] A;
	int n;

	public InsertionSort(int[] A, int n) {
		this.A = A;
		this.n = n;
	}

	public void sort() {
		int curPos = 1;
		while (curPos < n) {
			for (int i = 0; i < curPos; i++) {
				if (A[i] >= A[curPos]) {
					int tmp = A[curPos];
					for (int j = curPos; j > i; j--) {
						A[j] = A[j - 1];
					}
					A[i] = tmp;
				}
			}
			curPos++;
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
		InsertionSort s = new InsertionSort(A, n);
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