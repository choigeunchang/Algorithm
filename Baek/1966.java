import java.util.*;

class paper{
	int seq;
	int prior;
	public paper(int seq, int prior) {
		this.seq = seq;
		this.prior = prior;
	}
	
	public String toString() {
		return "(" + seq + ", " + prior + ")";
	}
}

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			LinkedList<paper> arr = new LinkedList<>();
			arr.clear();
			
			int n = s.nextInt();
			int m = s.nextInt();
			for(int i=0; i<n; i++) {
				int num = s.nextInt();
				arr.add(new paper(i, num));
			}
			
			int count = 0;
			while(!arr.isEmpty()) {				

				paper p = arr.poll();
				boolean check = true;
				for(paper i : arr) {
					
					if(p.prior < i.prior)
						check = false;
				}
				if(check) {
					count++;
					
					if(p.seq == m)
						break;
				}
				else
					arr.add(p);
			}
			
			System.out.println(count);
		}
	}
}