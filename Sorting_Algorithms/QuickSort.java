import java.io.*;
import java.util.Scanner;

public class QuickSort {
	int[] A;
	int n;

	public QuickSort(int[] A, int n) {
		this.A = A;
		this.n = n;
	}

	public void sort(int start, int end) {
		if (start < end) {
			int pos = (start + end) / 2;
			sort(start, pos);
			sort(pos + 1, end);
			merge(start, pos, end);
		}
	}

	public void merge(int start, int pos, int end) {
		int[] tmp = new int[n];
		int t = 0;
		int i = start;
		int j = pos + 1;
		while (i <= pos && j <= end) {
			if (A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else
				tmp[t++] = A[j++];
		}

		while (i <= pos)
			tmp[t++] = A[i++];
		while (j <= end)
			tmp[t++] = A[j++];

		i = start;
		t = 0;
		while (i <= end)
			A[i++] = tmp[t++];
	}

	public static void main(String[] args) throws FileNotFoundException {

		double time = System.currentTimeMillis(); // current time

		System.setIn(new FileInputStream("data//100.txt")); // load file
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of values
		int[] A = new int[n]; // create array
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt(); // get values from the file
		}

		int start = 0;
		QuickSort s = new QuickSort(A, n);
		s.sort(start, s.n - 1);
		s.print();

		System.out.println();
		System.out.println("execution time :: " + (System.currentTimeMillis() - time) + "(ms)");
		sc.close();
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(A[i] + " ");
		}
	}

}