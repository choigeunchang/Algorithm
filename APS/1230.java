import java.util.*;

public class Solution {
   
	static ArrayList<Integer> pw;
	static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

        for(int t=1; t<=10; t++) {
         
            int ori = s.nextInt();				// 원본 암호문의 길이
            pw = new ArrayList<>();				// 원본 암호문
            for(int i=0; i<ori; i++)
            	pw.add(s.nextInt());
            
            int num = s.nextInt();				// 명령어의 갯수
            for(int i=0; i<num; i++) {
            	char cmd = s.next().charAt(0);
            	switch(cmd) {
            	case 'I':
            		insert();
            		break;
            	case 'D':
            		delete();
        			break;
            	case 'A':
            		add();
            		break;
            	}
            }
            System.out.print("#" + t + " ");
            for(int i=0; i<10; i++)
            	System.out.print(pw.get(i) + " ");
            System.out.println();
        }
    }
    
    public static void insert() {
    	
    	int pos = s.nextInt();
    	int num = s.nextInt();
    	for(int i=0; i<num; i++)
    		pw.add(pos+i, s.nextInt());
    		
    }
    
    public static void delete() {
    	int pos = s.nextInt();
    	int num = s.nextInt();
    	for(int i=0; i<num; i++)
    		pw.remove(pos);
    }
    
    public static void add() {
    	int num = s.nextInt();
    	for(int i=0; i<num; i++)
    		pw.add(s.nextInt());
    }
}