import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumUniqueArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input, sum = 0, curr;
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = sc.nextInt(); i > 0; i--) {
			input = sc.nextInt();
			list.add(input);
			sum += input;
		}
		Collections.sort(list);
		int len = list.size();
		int elem = list.get(0);
		int incre = 0;
		for (int i = 1; i < len; i++) {
			curr = list.get(i);
			if (curr <= elem) {
				sum+=(elem-curr)+1;
				curr+=(elem-curr)+1;
				//list.set(i, curr);				
			}
			elem = curr;
		}
		System.out.println(sum);

	}

}
