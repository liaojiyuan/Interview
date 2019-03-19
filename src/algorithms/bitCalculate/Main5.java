/**
 * 
 */
package algorithms.bitCalculate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @date 2019年3月19日 上午9:37:49
 * @description 二叉树的序列化和反序列化
 */

public class Main5 {
	TreeNode root;

	/**
	 * A B C D E F G H I J
	 *
	 */
	public void init() {
		TreeNode aJ = new TreeNode('J', null, null);
		TreeNode aI = new TreeNode('I', null, null);
		TreeNode aH = new TreeNode('H', null, null);
		TreeNode aG = new TreeNode('G', null, null);
		TreeNode aF = new TreeNode('F', null, null);
		TreeNode aE = new TreeNode('E', null, aJ);
		TreeNode aD = new TreeNode('D', aH, aI);
		TreeNode aC = new TreeNode('C', aF, aG);
		TreeNode aB = new TreeNode('B', aD, aE);
		root = new TreeNode('A', aB, aC);
	}

	// 构造函数初始化树
	public Main5() {
		init();
	}

	// 前序遍历 序列化
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		getSerializeString(root, sb);
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public void getSerializeString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
		} else {
			sb.append(root.data + ",");
			getSerializeString(root.lchild, sb);
			getSerializeString(root.rchild, sb);
		}
	}

	// 前序遍历 反序列化
	public TreeNode deserialize(String str) {
		String[] values = str.split(",");
		Queue<String> queue = new LinkedList<>();
		for (String s : values) {
			queue.offer(s);
		}
		return reconPreOrder(queue);
	}

	public TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if ("#".equals(value)) {
			return null;
		}
		TreeNode head = new TreeNode(value.charAt(0));
		head.lchild = reconPreOrder(queue);
		head.rchild = reconPreOrder(queue);
		return head;
	}

	// 层次遍历 序列化
	public String serializeBFS(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return sb.toString();
		}
		queue.offer(root);
		TreeNode node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node != null) {
				sb.append(node.data + ",");
				queue.offer(node.lchild);
				queue.offer(node.rchild);
			} else {
				sb.append("#,");
			}
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	// 层次反序列化
	public TreeNode deserializeBFS(String strBFS) {
		TreeNode root = null;
		if (strBFS == null || strBFS.length() == 0) {
			return root;
		}
		String[] values = strBFS.split(",");
		TreeNode[] nodes = new TreeNode[values.length];
		for (int i = 0; i < values.length; i++) {
			if (!"#".equals(values[i])) {
				nodes[i] = new TreeNode(values[i].charAt(0));
			}
		}
		for (int i = 0, j = 1; j < values.length; i++) {
			if (nodes[i] != null) {
				nodes[i].lchild = nodes[j++];
				nodes[i].rchild = nodes[j++];
			}
		}
		return nodes[0];

	}

	public static void main(String[] args) {
		Main5 main = new Main5();
		String str = main.serialize(main.root);
		System.out.println(str);
		TreeNode root = main.deserialize(str);
		Main4 main4 = new Main4(root);
		System.out.println("层次遍历（借助队列）");
		main4.BFS2(main.root);
		System.out.println();

		String strBFS = main.serializeBFS(root);
		System.out.println(strBFS);

	}
}
