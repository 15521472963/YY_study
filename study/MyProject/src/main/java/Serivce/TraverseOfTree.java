package main.java.Serivce;

import java.util.Stack;

class TreeNode {
	//二叉树的结构
	public int val;//结点值
	public TreeNode left;//左子树
	public TreeNode right;//右子树

	public TreeNode(int x) {
		//构造方法
		val = x;
	}
}
public class TraverseOfTree {
	public static void main(String[] args) {
		TreeNode Node1 = new TreeNode(8);
		TreeNode Node2 = new TreeNode(4);
		TreeNode Node3 = new TreeNode(10);
		TreeNode Node4 = new TreeNode(3);
		TreeNode Node5 = new TreeNode(6);
		TreeNode Node6 = new TreeNode(9);
		TreeNode Node7 = new TreeNode(12);
		//手动建立二叉树：
		/*
		 * 		  8
		 * 		/   \
		 * 	   4	 10
		 * 	 /  \	 /  \
		 *  3	 6	 9   12
		 */
		Node1.left = Node2; Node1.right = Node3;
		Node2.left = Node4; Node2.right = Node5;
		Node3.left = Node6; Node3.right = Node7;
		Node4.left = null; Node4.right = null;
		Node5.left = null; Node5.right = null;
		Node6.left = null; Node6.right = null;
		Node7.left = null; Node7.right = null;

		//递归方式
		System.out.print("先序遍历：");
		PreOrder_RecTraverse(Node1);//先序遍历
		System.out.println();

		System.out.print("中序遍历：");
		InOrder_RecTraverse(Node1) ;//中序遍历
		System.out.println();

		System.out.print("后序遍历：");
		LastOrder_RecTraverse(Node1);//后序遍历
		System.out.println("\n");

		//非递归(用栈实现)
		preOrderByStack(Node1);//先序遍历

		inOrderByStack(Node1);//中序遍历

		posOrderByStack(Node1);//后序遍历
	}

	// 递归 实现先序遍历:根->左->右(debug观察带调用过程)
	static void PreOrder_RecTraverse(TreeNode treeNode) {
		// 先打印根结点的值
		// 遍历左边的子树(左子树+右子树) 一开始根节点为8，开始遍历8左边的子树
		// 遍历右边的子树(左子树+右子树) 8左边的子树遍历完后，遍历右边的子树
		if (treeNode != null) {
			System.out.print(treeNode.val + " ");
			if (treeNode.left != null)
				// 判断结点treeNode的左子树是否为空，不为空
				// 将结点置为treeNode -> treeNode.left
				PreOrder_RecTraverse(treeNode.left);// 遍历所有的左子树
			if (treeNode.right != null)
				// 左子树遍历完后,遍历所有右子树()
				PreOrder_RecTraverse(treeNode.right);
		}

	}

	// 递归中序遍历:左->根->右(思想类似先序遍历 只是print 结点的val顺序问题)
	static void InOrder_RecTraverse(TreeNode treeNode) {
		if (treeNode != null) {
			if (treeNode.left != null)
				InOrder_RecTraverse(treeNode.left);
			System.out.print(treeNode.val + " ");
			if (treeNode.right != null)
				InOrder_RecTraverse(treeNode.right);
		}
	}

	// 递归后序遍历：左->右->根(跟先序遍历、中序遍历思想类似)
	static void LastOrder_RecTraverse(TreeNode treeNode) {
		if (treeNode != null) {
			if (treeNode.left != null)
				LastOrder_RecTraverse(treeNode.left);
			if (treeNode.right != null)
				LastOrder_RecTraverse(treeNode.right);
			System.out.print(treeNode.val + " ");
		}

	}

	// 非递归：利用栈来实现先序遍历,先将左子树点不断的压入栈，直到null，再然后处理栈顶节点的右子树。
	public static void preOrderByStack(TreeNode treeNode) {
		System.out.print("先序遍历：");
		// 建立一个栈,里面存放的二叉树TreeNode(先进后出)
		Stack<TreeNode> stack = new Stack<>();
		while (treeNode != null || !stack.isEmpty()) {
			// 将左子树结点不断入栈 直到null
			while (treeNode != null) {
				// 先访问打印结点的值
				System.out.print(treeNode.val + " ");
				// 然后入栈
				stack.push(treeNode);
				treeNode = treeNode.left;// 将treeNode指向treeNode.left
			}
			// 栈不空的情况下，进行以下操作
			// 处理右子树结点
			if (!stack.isEmpty()) {
				// 根据先序遍历的规则,若某结点没左子树，将其弹出
				treeNode = stack.pop();
				// 访问弹出结点的右子树，若为空，又回到弹栈操作
				treeNode = treeNode.right;// 将treeNode指向treeNode.right
			}
		}
		System.out.println();
	}

	// 非递归：利用栈实现中序遍历
	// 思路和先序遍历类似, 只是访问打印是在全部左子树处理直到null的时候出栈并访问。
	public static void inOrderByStack(TreeNode treeNode) {
		System.out.print("中序遍历：");
		Stack<TreeNode> stack = new Stack<>();
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) {
				stack.push(treeNode);
				treeNode = treeNode.left;
			}
			// 左子树进栈完毕
			// 接下来进行访问，弹栈操作
			if (!stack.isEmpty()) {
				treeNode = stack.pop();
				System.out.print(treeNode.val + " ");
				treeNode = treeNode.right;
			}
		}
		System.out.println();
	}

	// 非递归：利用两个栈实现后续遍历(相对复杂一些)
	// 思路：要保证根结点在左孩子和右孩子访问之后才能访问
	public static void posOrderByStack(TreeNode treeNode) {
		System.out.print("后序遍历:");
		if (treeNode != null) {
			// 先判断传入的treeNode结点是否为空
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(treeNode);//将treeNode结点push入栈1
			while (!s1.isEmpty()) {
				//s1不为空进行出栈
				treeNode = s1.pop();//将treeNode 指向出栈的树结点
				s2.push(treeNode);//入栈2操作
				//s1入栈为左孩子，右孩子
				//s1出栈入栈2，即为右孩子、左孩子(保证遍历的顺序)
				if (treeNode.left != null) {
					s1.push(treeNode.left);
				}
				if (treeNode.right != null) {
					s1.push(treeNode.right);
				}
			}
			while (!s2.isEmpty()) {
				//依次打印栈2弹出的元素
				System.out.print(s2.pop().val + " ");
			}
		}
		System.out.println();
	}
}
