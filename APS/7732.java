import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=test_case; t++) {
        
        	String now = br.readLine();
        	String future = br.readLine();
        	
        	int temp_now = Integer.parseInt(now.split(":")[0]) * 3600 + Integer.parseInt(now.split(":")[1]) * 60 + Integer.parseInt(now.split(":")[2]);
        	int temp_future = Integer.parseInt(future.split(":")[0]) * 3600 + Integer.parseInt(future.split(":")[1]) * 60 + Integer.parseInt(future.split(":")[2]);
        	int sum = 0;
        	
        	if(temp_now < temp_future)
        		sum = temp_future - temp_now;
        	else
        		sum = 86400 - (temp_now - temp_future);
        	
        	StringBuilder sb = new StringBuilder();
        	if(sum/3600 <= 9)
        		sb.append("0").append(sum/3600).append(":");
        	else
        		sb.append(sum/3600).append(":");
        	
        	if((sum%3600)/60 <= 9)
        		sb.append("0").append((sum%3600)/60).append(":");
        	else
        		sb.append((sum%3600)/60).append(":");	
        	
        	if((sum%3600)%60 <= 9)
        		sb.append("0").append((sum%3600)%60);
        	else
        		sb.append((sum%3600)%60);
        	
        	System.out.println("#" + t + " " + sb.toString());
        }	
    }	
}