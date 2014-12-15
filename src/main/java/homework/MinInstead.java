package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MinInstead {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int length = 0;
		int[] arr  = null;
        while(true) {
            length = Integer.parseInt(br.readLine());
            arr    = new int[length];
            String[] arrStr = br.readLine().split("\\s");
            for (int i = 0; i < arrStr.length && i <length; i ++ ) {
            	arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(minInstead(arr));
        }  
	}

	public static int minInstead(int[] arr) {
		int minInsteadCount = 0;
		int length = arr.length;
		
		int[][] flag = new int[length][length];
		
		Map<Integer, Integer> inversionCounts = new HashMap<Integer, Integer>();
		
		/*compute inversions*/
		for (int i = 0; i < length; i ++) {
			int count = 0;
			
			for (int j = 0; j < length; j ++) {
				if ((i < j && arr[i] > arr[j]) || (i > j && arr[i] < arr[j]) ) {
					flag[i][j] = 1;
					count ++;
				} else {
					flag[i][j] = 0;
				}
			}
			
			if (count > 0) {
				inversionCounts.put(i, count);
			}
		}
		
		/*compute min instead count*/
		while (inversionCounts.size() > 0) {
			minInsteadCount ++;
			Integer maxValue = -1;
			Integer maxIndex = -1;
			
			for (Integer index : inversionCounts.keySet()) {
				if (inversionCounts.get(index) > maxValue) {
					maxValue = inversionCounts.get(index);
					maxIndex = index;
				}
			}
			
			inversionCounts.remove(maxIndex);
			
			for (int i = 0; i < length; i ++) {
				if (flag[maxIndex][i] == 1) {
					if (inversionCounts.containsKey(i)) {
						int remains = inversionCounts.get(i) - 1;
						if (remains <= 0) {
							inversionCounts.remove(i);
						} else {
							inversionCounts.put(i, remains);
						}
					}
				}
			}
		}
		
		
		return minInsteadCount;
		
//		int result = 0;
//        
//        for (int i = 1; i < arr.length; i ++) {
//            if (arr[i-1] > arr[i]) {
//                result ++;
//            }
//        }
//        
//        return result;
	}
}
