/**
 * 
 */
package algorithms.bitCalculate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Administrator
 * @date 2019年3月16日 下午5:45:21
 * @description 树的层次遍历
 */
// 树的节点定义
// 多叉树
class Node {

	int data;
	List<Node> children = new ArrayList<>();

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the children
	 */
	public List<Node> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Node> children) {
		this.children = children;
	}

	/**
	 * @param data
	 * @param children
	 */
	public Node(int data, List<Node> children) {
		this.data = data;
		this.children = children;
	}

}

public class Main3 {
	private Node root;

	public void init() {
		Node a10 = new Node(10, null);
		Node a9 = new Node(9, null);
		Node a8 = new Node(8, null);
		List<Node> childrenA7 = new ArrayList<>();
		childrenA7.add(a10);
		Node a7 = new Node(7, childrenA7);
		Node a6 = new Node(6, null);
		List<Node> childrenA5 = new ArrayList<>();
		childrenA5.add(a9);
		Node a5 = new Node(5, childrenA5);
		List<Node> childrenA4 = new ArrayList<>();
		childrenA4.add(a8);
		Node a4 = new Node(4, childrenA4);
		Node a3 = new Node(3, null);
		List<Node> childrenA2 = new ArrayList<>();
		childrenA2.add(a6);
		childrenA2.add(a7);
		Node a2 = new Node(2, childrenA2);
		List<Node> childrenA1 = new ArrayList<>();
		childrenA1.add(a2);
		childrenA1.add(a3);
		childrenA1.add(a4);
		childrenA1.add(a5);
		root = new Node(1, childrenA1);
	}

	// 树的层次遍历 广度优先搜索 借助队列BFS （BreadthFirstSearch）
	public void bfs() {
		init();
		Queue<Node> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()) {
			Node currentNode = list.poll(); // 获取并删除第一个元素
			System.out.println(currentNode.getData());
			List<Node> children = currentNode.getChildren();
			if (null != children) {
				children.forEach(child -> list.offer(child));
			}

		}
	}

	// 树的深度优先遍历 借助栈 DFS （DepthFirstSearch）
	public void dfs() {
		init();
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.peek();
			System.out.println(node.data);
			stack.pop();
			List<Node> children = node.getChildren();

			if (null != children) {
				Collections.reverse(children);
				children.forEach(child -> stack.push(child));
			}
		}
	}

	public static void main(String[] args) {
		new Main3().dfs();
	}

}
