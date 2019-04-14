package main.java.Serivce;

import java.util.ArrayList;
import java.util.List;

public class MyQueueDemo{
	public static void main(String[] args) {
		MyQueue q = new MyQueue();//创建MyQueue对象

		int[] nums = new int[] { 5, 3, 9, 7 };
		// foreach迭代:依次入队5,3,9,7元素
		for (int value : nums) {
			q.enQueue(value);
		}
		System.out.println(q);// 打印栈中的元素

		if (!q.isEmpty())
			System.out.println(q.Front());
		//出队操作
		q.deQueue();
		if (!q.isEmpty()) {
			System.out.println(q.Front());//打印队首元素
		}

		q.deQueue();
		if (!q.isEmpty()) {
			System.out.println(q.Front());
		}

		q.enQueue(8);
		System.out.println(q);
	}
}
class MyQueue {

	// 存储元素
	private List<Integer> list;

	// 构造器
	public MyQueue() {
		list = new ArrayList<Integer>();
	}

	// 向队列插入一个元素。如果成功插入则返回真。
	public boolean enQueue(int x) {
		list.add(x);
		return true;
	};

	// 队列中删除元素。如果成功删除则返回真
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		// 先进先出的模式
		// 比如队列有 1 2 3 4
		// 移除1后，整个list左移一个单位
		list.remove(list.get(0));
		return true;
	}

	// 获取队首元素
	public int Front() {
		// 通过list.get(0)获取首个元素的值
		return list.get(0);
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		// 当list.size()<0时，即此时队列没有元素
		return  list.size()<0;
	}

	@Override
	public String toString() {
		return "MyQueue" + list;
	}
}