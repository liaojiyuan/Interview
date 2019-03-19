/**
 * 
 */
package algorithms.bitCalculate;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Administrator
 * @date 2019年3月18日 下午5:12:35
 * @description 二叉树深度优先遍历三种方法（前序，中序，后续） 递归和非递归
 */
class TreeNode {
	char data;
	TreeNode lchild;
	TreeNode rchild;

	/**
	 * @param data
	 * @param lchild
	 * @param rchild
	 */
	public TreeNode(char data, TreeNode lchild, TreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public TreeNode(char data) {
		this(data, null, null);
	}
}

public class Main4 {
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
	public Main4() {
		init();
	}

	public Main4(TreeNode root) {
		this.root = root;
	}

	// 访问节点
	public void visit(TreeNode node) {
		System.out.print(node.data + " ");
	}

	public void preOrder(TreeNode root) {
		if (null != root) {
			visit(root);
			preOrder(root.lchild);
			preOrder(root.rchild);
		}

	}

	public void inOrder(TreeNode root) {
		if (null != root) {
			inOrder(root.lchild);
			visit(root);
			inOrder(root.rchild);
		}
	}

	public void postOrder(TreeNode root) {
		if (null != root) {
			postOrder(root.lchild);
			postOrder(root.rchild);
			visit(root);
		}
	}

	// 二叉树的深度优先遍历方法（和先序遍历结果一样）
	public void DFSPreOrder(TreeNode root) {
		if (root == null)
			return;
		TreeNode node = null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			node = stack.pop();
			visit(node);
			if (node.rchild != null) {
				stack.push(node.rchild);
			}
			if (node.lchild != null) {
				stack.push(node.lchild);
			}
		}
	}

	// 非递归，前序遍历
	public void nonRecursivePreOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				visit(node);
				stack.push(node);
				node = node.lchild;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.rchild;
			}
		}
	}

	// 非递归中序遍历
	public void nonRecursiveInOrder(TreeNode root) {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.lchild;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				visit(node);
				node = node.rchild;
			}
		}
	}

	// 非递归后续遍历 （借用一个栈）
	public void nonRecursivePostOrder(TreeNode root) {
		TreeNode node = root;
		// 访问根节点时判断其右子树是够被访问过
		TreeNode preNode = null;
		Stack<TreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			// 把当前节点的左侧节点全部入栈
			while (node != null) {
				stack.push(node);
				node = node.lchild;
			}
			if (!stack.isEmpty()) {
				TreeNode tmp = stack.peek().rchild;
				// 一个根节点被访问的前提是：无右子树或者右子树已经访问过了
				if (tmp == null || tmp == preNode) {
					node = stack.pop();
					visit(node);
					preNode = node;
					node = null;
				} else {
					node = tmp;
				}
			}
		}
	}

	// 非递归后续遍历（借用两个栈）
	public void nonRecursivePostOrderByTwoStacks(TreeNode root) {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				output.push(node);
				node = node.rchild;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.lchild;
			}
		}
		while (!output.isEmpty()) {
			visit(output.pop());
		}
	}

	// 层次遍历 借助队列
	public void BFS(TreeNode root) {
		if (null == root) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode node = null;
		queue.addFirst(root);
		while (!queue.isEmpty()) {
			node = queue.pollFirst();
			visit(node);
			if (node.lchild != null) {
				queue.addLast(node.lchild);
			}
			if (node.rchild != null) {
				queue.addLast(node.rchild);
			}
		}
	}

	// 层次遍历 借助队列
	public void BFS2(TreeNode root) {
		if (null == root) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addFirst(root);
		TreeNode node = null;
		TreeNode last = root; // 当前行的最右一个元素
		TreeNode nlast = null; // 下一行的最右一个元素
		int level = 1;
		System.out.print("第" + level + "层");
		while (!queue.isEmpty()) {
			node = queue.pollFirst();
			visit(node);
			if (node.lchild != null) {
				queue.addLast(node.lchild);
				nlast = node.lchild;
			}
			if (node.rchild != null) {
				queue.addLast(node.rchild);
				nlast = node.rchild;
			}
			if (node == last && !queue.isEmpty()) {
				level++;
				System.out.println();
				System.out.print("第" + level + "层");
				last = nlast;
			}
		}
	}

	public static void main(String[] args) {
		Main4 main = new Main4();
		System.out.println("前序遍历(递归)");
		main.preOrder(main.root);
		System.out.println();
		System.out.println("前序遍历(非递归)");
		main.nonRecursivePreOrder(main.root);
		System.out.println();
		System.out.println("中序遍历(递归)");
		main.inOrder(main.root);
		System.out.println();
		System.out.println("中序遍历(非递归)");
		main.nonRecursiveInOrder(main.root);
		System.out.println();
		System.out.println("后序遍历(递归)");
		main.postOrder(main.root);
		System.out.println();
		System.out.println("后序遍历(非递归)");
		main.nonRecursivePostOrder(main.root);
		System.out.println();
		System.out.println("层次遍历（借助队列）");
		main.BFS(main.root);
		System.out.println();
		System.out.println("层次遍历（借助队列）");
		main.BFS2(main.root);
		System.out.println();
	}

}
