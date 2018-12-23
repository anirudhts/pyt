import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingPairs {
	
		
	public static void main(String[] args) {
		int input, k, numKeys, result = 0;
		Map<Integer, Integer> numberMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		for (int i = sc.nextInt(); i > 0; i--) {
			input = sc.nextInt();
			numberMap.merge(input, 1, Integer::sum);
		}
		ArrayList<Integer> keys = new ArrayList<Integer>(numberMap.keySet());

		Collections.sort(keys);
		k = sc.nextInt();
		numKeys = numberMap.size();
		if (k > 0) {
			for (int i = 0; i < numKeys - 1; i++) {
				if(numberMap.containsKey(keys.get(i)+k))
					result++;
			}
		} else {
			for (int i = 0; i < numKeys; i++) {
				if (numberMap.get(keys.get(i)) >= 2) {
					result++;
				}
			}
		}

		System.out.println(result);
	}

}
