import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int T = Integer.parseInt(br.readLine());
			
			if(T > 1000000)
				return;
			
			for(int i=0; i<T; i++)
			{
				String[] num = br.readLine().split(" ");
				bw.write(Integer.parseInt(num[0])+Integer.parseInt(num[1]) + "\n");
			}

			bw.flush();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}