package main.java.Serivce;

import java.util.Stack;

/**
 *
 * @author Y-yan
 * 这里利用两个工具类的Stack来实现一个队列
 * MyQueue、MyStack是自己编写的队列和栈
 * 也可以用MyStack来实现,只需调用其中的pop()和push()相互操作
 */

public class Stack_to_Queue {
	public static void main(String[] args) {
		TwoStackForQueue queue = new TwoStackForQueue();
		//入队元素：1 2 3 5 6
		int[] nums = new int[] {1,2,3,5,6};
		for(int node : nums) {
			queue.enQueue(node);
		}
		System.out.println(queue);//打印两个栈中的元素

		//出队：即移除1，队列变为2 3 5 6
		int m = queue.deQueue();
		System.out.println(m);//打印出队元素：1
		System.out.println(queue);//观察两个栈的情况

		//再入队一个元素 8
		//队列变为2 3 5 6 8
		queue.enQueue(8);
		System.out.println(queue);//观察两个栈的情况
	}

}
class TwoStackForQueue{

	/*
	 * 1，思路：将元素先依次进入栈stack1，再从栈1依次弹出到栈2，
	 * 			然后弹出栈stack2顶部的元素(整个过程类似队列的先进先出)
	 * 2，在两个栈之间操作时需要判断两个栈中元素情况：
	 *  	 判断：进队列时，需要判断栈2是否为空(含有元素)，如果不空则将栈2全部元素依次弹出回到栈1;
	 *				出队列时，将栈1元素全部弹到栈2中，直到栈1为空。
	 */
	Stack<Integer> stack1 = new Stack<Integer>();//栈1
	Stack<Integer> stack2 = new Stack<Integer>();//栈2

	//入队操作：在栈1中模拟
	public void enQueue(int node) {
		while (!stack2.isEmpty())
			//栈2不为空，就将栈2元素依次弹出并进入栈1
			stack1.push(stack2.pop());
		stack1.push(node);
	}
	//出队操作：栈2中进行
	public int deQueue() {
		while (!stack1.isEmpty())
			//栈1不为空，就将栈1元素依次弹出并进入栈2
			stack2.push(stack1.pop());
		//用m记录队列的出队值(即栈2弹出的顶元素)
		int m = stack2.pop();
		return m;

	}
	@Override
	public String toString() {
		return "Queue [stack1=" + stack1 + ", stack2=" + stack2 + "]";
	}
}

