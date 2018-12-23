import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StackDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] command;

		StackLinkedList s = new StackLinkedList();
		for (int i = sc.nextInt(); i >=0; i--) {
			command = sc.nextLine().split(" ");
			switch (command[0]) {
			case "push":
				s.push(Integer.parseInt(command[1]));
				s.top();
				break;
				
			case "pop":
				s.pop();
				s.top();
				break;

			case "inc":
				s.inc(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				s.top();
				break;
			}
		}
	}
}
class Node{
	private int data;
	private Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}

class StackLinkedList{
	private Node top;
	private int size;
	
	StackLinkedList(){
		top = null;
		size =0 ;
	}
	
	public void push(int data){
		Node newNode = new Node(data);
		if(top == null){
			top = newNode;
		}else{
			newNode.setNext(top);
			top=newNode;
		}
		size++;
	}
	public void pop(){
		if(size == 0){
			return;
		}else {
			Node popNode = top;
			top = popNode.getNext();
			size--;
		}
	}
	public void top() {
		if (size == 0) {
			System.out.println("EMPTY");
		} else {
			System.out.println(top.getData());
		}
	}
	
	public void inc(int indexFrom, int val){
		if (indexFrom > size) {
			System.out.println("WRONG INPUT");
		} else {
			Node iter = top;
			int i = size;
			while(iter!=null){
				if(i <= indexFrom){
					iter.setData(iter.getData() + val);
				}
				iter = iter.getNext();
				i--;
			}
		}
	}
}

class StackArrayListImpl {

	private List<Integer> stack;

	StackArrayListImpl() {
		stack = new ArrayList<Integer>();
	}

	public void push(int item) {
		stack.add(0, item);
	}

	public void top() {
		if (stack.size() == 0) {
			System.out.println("EMPTY");
		} else {
			System.out.println(stack.get(0));
		}
	}

	public String pop() {
		if (stack.size() == 0) {
			return "EMPTY";
		} else {
			return Integer.toString(stack.remove(0));
		}
	}

	public void inc(int indexFrom, int val) {
		int length = stack.size();
		if (indexFrom > length) {
			System.out.println("WRONG INPUT");
		} else {
			for (int i = length - indexFrom; i < length; i++) {
				stack.set(i, stack.get(i) + val);
			}
		}
	}

}
