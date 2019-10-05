import java.io.*;
import java.util.Scanner;

public class HeapSort {

	int[] A;
	int n;

	public HeapSort(int[] A, int n) {
		this.A = A;
		this.n = n;
	}

	public static void main(String[] args) throws FileNotFoundException {
		double start = System.currentTimeMillis(); // current time

		System.setIn(new FileInputStream("data//1000.txt")); // load file
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of values
		int[] A = new int[n]; // create array
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt(); // get values from the file
		}

		HeapSort hs = new HeapSort(A, n); // create heapsort object
		hs.sort();
		hs.printAry();

		System.out.println();
		System.out.println("execution time :: " + (System.currentTimeMillis() - start) + "(ms)");
		sc.close();
	}

	private void sort() {
		buildHeap(); // make the array to heap
		for (int i = n - 1; i >= 1; i--) {
			int tmp = A[i];
			A[i] = A[0];
			A[0] = tmp; // exchange first and last
			heapify(0, i - 1); // make it heap
		}
	}

	private void buildHeap() {
		for (int i = n / 2; i >= 0; i--) {
			heapify(i, n - 1);
		}
	}

	private void heapify(int k, int n) {
		int left = 2 * k + 1, right = 2 * k + 2, smaller;
		// the leaf node's index
		if (right <= n) {
			if (A[left] < A[right]) {
				smaller = left;
			} else {
				smaller = right;
			}
		} else if (left <= n) {
			smaller = left;
		} else
			return;

		// if leaf node is smaller than his root node, change it.
		if (A[smaller] < A[k]) {
			int temp = A[smaller];
			A[smaller] = A[k];
			A[k] = temp;
			heapify(smaller, n);
		}

	}

	// print the array
	private void printAry() {
		for (int i = n - 1; i >= 0; i--) {
			System.out.println(A[i] + " ");
		}
	}

}