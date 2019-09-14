import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	
	static char tank;
	static int x, y;
	static int h, w;
	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			arr = new char[h][w];
			x = 0;
			y = 0;
			for(int i=0; i<h; i++) {
				
				str = bf.readLine();
				for(int j=0; j<w; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '>' || arr[i][j] == '<') {
						x = i;
						y = j;
						tank = arr[i][j];
					}
				}
			}
			
			int n = Integer.parseInt(bf.readLine());
			str = bf.readLine();
			
			for(int i=0; i<str.length(); i++) {
				
				char com = str.charAt(i);
				switch(com) {
				case 'S':
					Shoot();
					break;
				case 'U':
					Up();
					break;
				case 'R':
					Right();
					break;
				case 'L':
					Left();
					break;
				case 'D':
					Down();
					break;
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<h; i++) {
				
				for(int j=0; j<w; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
		}
	}
	
	static void Up() {
		
		tank = '^';
		arr[x][y] = tank;
		if(range(x-1, y) && arr[x-1][y] == '.') {
			char temp = arr[x-1][y];
			arr[x-1][y] = arr[x][y];
			arr[x][y] = temp;
			x--;
		}
	}
	
	static void Down() {
		
		tank = 'v';
		arr[x][y] = tank;
		if(range(x+1, y) && arr[x+1][y] == '.') {
			char temp =  arr[x+1][y];
			arr[x+1][y] =  arr[x][y];
			arr[x][y] = temp;
			x++;
		}
	}
	
	static void Right() {
		
		tank = '>';
		arr[x][y] = tank;
		if(range(x, y+1) && arr[x][y+1] == '.') {
			char temp =  arr[x][y+1];
			arr[x][y+1] =  arr[x][y];
			arr[x][y] = temp;
			y++;
		}
	}
	
	static void Left() {
		
		tank = '<';
		arr[x][y] = tank;
		if(range(x, y-1) && arr[x][y-1] == '.') {
			char temp = arr[x][y-1];
			arr[x][y-1] = arr[x][y];
			arr[x][y] = temp;
			y--;
		}
	}
	
	static void Shoot() {
		
		switch(tank) {
		case '<':
			for(int i=y-1; i>=0; i--) {
				if(arr[x][i] == '#')
					break;
				else if(arr[x][i] == '*') {
					arr[x][i] = '.';
					break;
				}
			}
			break;
		case '>':
			for(int i=y+1; i<w; i++) {
				if(arr[x][i] == '#')
					break;
				else if(arr[x][i] == '*') {
					arr[x][i] = '.';
					break;
				}
			}
			break;
		case 'v':
			for(int i=x+1; i<h; i++) {
				if(arr[i][y] == '#')
					break;
				else if(arr[i][y] == '*') {
					arr[i][y] = '.';
					break;
				}
			}
			break;
		case '^':
			for(int i=x-1; i>=0; i--) {
				if(arr[i][y] == '#')
					break;
				else if(arr[i][y] == '*') {
					arr[i][y] = '.';
					break;
				}
			}
			break;
		}
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<h && y<w;
	}
}