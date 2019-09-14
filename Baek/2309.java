import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int[] arr = new int[9];
		int[] sel = new int[7];
		
		for(int i=0; i<9; i++)
			arr[i] = s.nextInt();
		
		combination(arr, 0, 0, sel);
	}
	
	static void combination(int[] arr, int n, int c, int[] sel) {
		
		if(c == sel.length) {
			int sum = 0;
			for(int i=0; i<7; i++)
				sum += sel[i];
			
			if(sum == 100) {
				Arrays.sort(sel);
				for(int i=0; i<7; i++)
					System.out.println(sel[i]);
			}
			
			return;			// 다 고른 것
		}
		if(n == arr.length)
			return; 		// 끝난 것
		
		sel[c] = arr[n];
		// n번째에 대해서, sel에 담고 지나가기
		combination(arr, n+1, c+1, sel);
		// n번째에 대해서, sel에 안담고 지나가기
		combination(arr, n+1, c, sel);
	}
}