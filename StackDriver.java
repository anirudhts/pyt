import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StackDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] command;

		StackImpl s = new StackImpl();
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

class StackImpl {

	private List<Integer> stack;

	StackImpl() {
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
