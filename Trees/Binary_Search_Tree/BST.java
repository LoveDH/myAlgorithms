// add package name

import java.util.ArrayList;
import java.util.Scanner;

public class BST {
	Node root = new Node();
	ArrayList<Node> nodes = new ArrayList<Node>();

	public Node treeSearch(Node t, int x) {
		if (t == null || t.key == x)
			return t;
		if (x < t.key)
			return treeSearch(t.left, x);
		else
			return treeSearch(t.right, x);
	}

	public Node treeInsert(Node t, int x) {
		if (t == null) { // 신규 노드 생성하기
			Node r = new Node(); // 신규 Node를 생성하기
			r.key = x; // r.left = null; r.right = null;
			nodes.add(r); // BST의 노도 목록에 추가하기
			return r;
		} else if (t.key == 0) { // 빈 노드(즉, root)에 key값 저장하기
			t.key = x;
			nodes.add(t); // BST의 노도 목록에 추가하기
			return t;
		}

		if (x < t.key) {
			t.left = treeInsert(t.left, x);
			return t;
		} else {
			t.right = treeInsert(t.right, x);
			return t;
		}
	}

	public static void main(String[] args) {
		BST tree = new BST();
		Scanner sc = new Scanner(System.in);
		int[] num = { 30, 20, 25, 40, 10, 35 };

		System.out.println("========Before Delete=========\n");
		for (int i = 0; i < num.length; i++) {
			Node nd = tree.treeInsert(tree.root, num[i]);
		}
		tree.showTree();

		System.out.print("\nNode to delete : ");
		int delete = sc.nextInt();
		System.out.println("\n========After Delete=========\n");
		Node node_to_delete = tree.treeSearch(tree.root, delete);
		Node node_parent = new Node();

		if (node_to_delete.key != tree.root.key) {
			for (Node node : tree.nodes) {
				if (node.left == null && node.left == null)
					continue;
				else if (node.left == null && node.right != null) {
					if (node.right.key == node_to_delete.key)
						node_parent = node;
				} else if (node.left != null && node.right == null) {
					if (node.left.key == node_to_delete.key)
						node_parent = node;
				} else {
					if (node.left.key == node_to_delete.key || node.right.key == node_to_delete.key) {
						node_parent = node;
					}
				}
			}
		}
		tree.treeDelete(tree.root, node_to_delete, node_parent);
		for (int i = tree.nodes.size() - 1; i >= 0; i--) {
			if (tree.nodes.get(i).key == node_to_delete.key) {
				tree.nodes.remove(i);
				break;
			}
		}
		tree.showTree();
		sc.close();
	}

	public void showTree() {
		for (Node node : nodes) {
			int left = 0, right = 0;
			if (node.left != null)
				left = node.left.key;
			if (node.right != null)
				right = node.right.key;
			System.out.println(node.key + " - " + left + " - " + right);
		}
	}

	public void treeDelete(Node t, Node r, Node p) {
		if (r == t)
			t = deleteNode(t);
		else if (r == p.left)
			p.left = deleteNode(r);
		else
			p.right = deleteNode(r);
	}

	public Node deleteNode(Node r) {
		if (r.left == null && r.right == null)
			return null;
		else if (r.left == null && r.right != null)
			return r.right;
		else if (r.left != null && r.right == null)
			return r.left;
		else {
			Node s = r.right, parent = null;
			while (s.left != null) {
				parent = s;
				s = s.left;
			}
			r.key = s.key;
			if (s == r.right)
				r.right = s.right;
			else
				parent.left = s.right;
			return r;
		}
	}
}
