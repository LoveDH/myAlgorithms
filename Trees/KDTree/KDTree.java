//add package name

import java.util.ArrayList;
import java.util.Scanner;

public class KDTree {
	Node root = new Node();
	ArrayList<Node> nodes = new ArrayList();

	// public Node treeSearch(Node t, int x) {
	// if (t == null || t.key == x)
	// return t;
	// if (x < t.key)
	// return treeSearch(t.left, x);
	// else
	// return treeSearch(t.right, x);
	// }

	public Node treeInsert(Node t, int x, int y, int d) {
		if (t == null) {
			Node r = new Node(); // make new node
			r.key1 = x;
			r.key2 = y;
			nodes.add(r); // Add node to KDTree nodes
			return r;
		} else if (t.getKey(d) == 0) { // save key values
			t.key1 = x;
			t.key2 = y;
			nodes.add(t); // Add node to KDTree nodes
			return t;
		}

		// compare key values according to depth
		int key = d % 2 == 0 ? x : y;
		if (key < t.getKey(d)) {
			t.left = treeInsert(t.left, x, y, ++d);
			return t;
		} else {
			t.right = treeInsert(t.right, x, y, ++d);
			return t;
		}
	}

	public static void main(String[] args) {
		KDTree tree = new KDTree();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < 2 * n;) {
			Node nd = tree.treeInsert(tree.root, sc.nextInt(), sc.nextInt(), 0);
			i += 2;
		}

		tree.showTree();
		sc.close();
	}

	public void showTree() {
		for (Node node : nodes) {
			String left = "", right = "";
			if (node.left != null)
				left = node.left.printNode();
			if (node.right != null)
				right = node.right.printNode();
			System.out.println(node.printNode() + " - " + left + " - " + right);
		}
	}
}

class Node {
	int key1, key2;
	Node left;
	Node right;

	public int getKey(int d) {
		if (d % 2 == 0)
			return this.key1;
		else
			return this.key2;
	}

	public String printNode() {
		String str = "(" + this.key1 + "," + this.key2 + ")";
		return str;
	}
}
