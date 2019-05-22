package main.java.Serivce;

import java.util.List;
import java.util.ArrayList;

class MyStack {
    private List<Integer> list;// 设置存储整型的数组

    public MyStack() {
        // 调用构造器创建一个ArrayList对象，用List<Integer>接收
        list = new ArrayList<Integer>();
    }

    // 判空操作
    public boolean isEmpty() {
        return list.isEmpty();
        /*
         * if(list.isEmpty())
         * return true;
         * else return false;
         */
    }

    // 入栈的操作方法
    public void push(int value) {
        list.add(value);
    }

    // 出栈的操作方法
    public int pop() {
        if (isEmpty())
            // 先判定是否为空
            throw new ArrayIndexOutOfBoundsException("栈中无元素，无法出栈！！！");
        else
            return list.remove(list.size() - 1);// 否则返回尾部的元素(相当于顶元素)
    }

    // 获取栈顶元素
    public int top() {
        if (!isEmpty())
            // 判定栈是否为空
            return list.get(list.size() - 1);
        else
            // 抛出索引越界的异常
            throw new ArrayIndexOutOfBoundsException("此时栈中没有元素！！！");
    }

    // 遍历栈里面的内容(可省略)
    @Override
    public String toString() {
        return "Stack" + list;
    }
}

public class MyStackDemo{
    public static void main(String[] args) {
        // 导入自己编写的栈：org.yy.domain.Stack;
        MyStack s = new MyStack();// 创建一个栈对象
        // 创建数组(入栈数多的话，可以减少一下代码量)
        int[] nums = new int[] { 1, 2, 3, 4 };
        // foreach迭代:依次插入1，2，3，4元素
        for (int value : nums) {
            s.push(value);
        }
        System.out.println(s);// 打印栈中的元素

        // 出栈操作,并用popValue进行记录
        int popValue = s.pop();
        System.out.println(popValue);// 打印出栈的元素
        System.out.println(s);
        System.out.println(s.top());// 栈顶元素，打印栈顶元素

        // 进行连续出栈操作
        System.out.print("出栈顺序：");
        for (int i = 0; i < 3; i++) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();

        // 此时栈中无元素
        // System.out.println(s.pop());//无法出栈，抛出异常
        // System.out.println(s.top());//没有元素，抛出异常
    }

}



