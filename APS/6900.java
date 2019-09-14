import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class Winning{
	
	String win;
	int money;
	
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Winning() {}
	public Winning(String win, int money) {
		this.win = win;
		this.money = money;
	}
}

public class Solution {
 
	static int max;
    public static void main(String[] args) throws NumberFormatException, IOException {
       
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Winning[] win = new Winning[n];
			for(int i=0; i<n; i++) {
				str = bf.readLine();
				st = new StringTokenizer(str);
				win[i] = new Winning(st.nextToken(), Integer.parseInt(st.nextToken())); 
			}
			
			String[] buy = new String[m];
			for(int i=0; i<m; i++) {
				buy[i] = bf.readLine();
			}
			
			int sum = 0;
			for(int i=0; i<n; i++) {
				
				for(int j=0; j<m; j++) {
					
					boolean flag = true;
					for(int k=0; k<8; k++) {
						
						if(win[i].getWin().charAt(k) == buy[j].charAt(k) || win[i].getWin().charAt(k) == '*') {
							
						}
						else {
							flag = false;
							break;
						}
					}
					if(flag)
						sum += win[i].getMoney();
				}
			}	
			System.out.println("#" + t + " " + sum);
		}
	}
}