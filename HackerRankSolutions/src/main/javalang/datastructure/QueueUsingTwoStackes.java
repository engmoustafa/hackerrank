package javalang.datastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QueueUsingTwoStackes {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] arg) {
		//Read the number of operations
		int t = scanner.nextInt();
		int action,value;
		MyQueue myQueue = new MyQueue();
		StringBuilder buffer = new StringBuilder();
		while( t-- > 0) {
			action = scanner.nextInt();
			switch(action) {
			case 1:
				value = scanner.nextInt();
				myQueue.enqueue(value);
				break;
			case 2:
				myQueue.dequeue();
				break;
			case 3:
				buffer.append(myQueue.getHead()).append("\r\n");
				break;
			}
		}
		System.out.println(buffer.toString());
	}
	static class MyQueue{
		private MyStack<Integer> leftStack;
		private MyStack<Integer> rightStack;
		private boolean rightFilled;
		public MyQueue() {
			leftStack = new MyStack();
			rightStack = new MyStack();
		}
		public Integer getHead() {
			if(rightFilled) {
				return rightStack.get(rightStack.size()-1);
			}else {
				return leftStack.get(0);
			}
			
		}
		public void enqueue(Integer value) {
			if(rightFilled) {
				/*Integer tempValuue ;
				while(rightStack.size()>0) {
					tempValuue = rightStack.pop();
					leftStack.push(tempValuue);
				}*/
				//Collections.reverse(rightStack);
				//rightStack.reverse();
				//leftStack.addAllReversed(rightStack);
				//rightStack.clear();
				leftStack.exchangeData(rightStack);

				rightFilled = false;
			}
			leftStack.push(value);
			
		}
		public Integer dequeue() {
			if(!rightFilled) {
				/*Integer tempValuue ;
				while(leftStack.size()>0) {
					tempValuue = leftStack.pop();
					rightStack.push(tempValuue);
				}*/
				//Collections.reverse(leftStack);
				//leftStack.reverse();
				//rightStack.addAllReversed(leftStack);
				//leftStack.clear();
				rightStack.exchangeData(leftStack);
				rightFilled = true;
				
			}
			return rightStack.pop();
		}
	}
	static class MyStack<T> {
		List<T> myData;
		
		public MyStack(){
			myData = new ArrayList();
		}
		T pop(){
			T value = myData.get(myData.size()-1);
			myData.remove(myData.size()-1);
			return value;
		}
		void push(T element) {
			myData.add(element);
		}
		void reverse() {
			Collections.reverse(myData);
		}
		void clear() {
			myData.clear();
		}
		boolean  addAll(MyStack<T> newData) {
			return myData.addAll(newData.myData);
		}
		boolean  addAllReversed(MyStack<T> newData) {
			for(int i=newData.myData.size()-1;i>=0;i--) {
				myData.add(newData.myData.get(i));
			}
			return true;
		}
		void exchangeData(MyStack otherStack) {
			Collections.reverse(otherStack.myData);
			this.myData = otherStack.myData;
			otherStack.myData = new ArrayList();
		}
		int size() {
			return myData.size();
		}
		T get(int index) {
			return myData.get(index);
		}
	}
	
	
}
