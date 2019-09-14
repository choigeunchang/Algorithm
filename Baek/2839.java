import java.util.*;

public class Main {
	
	public static void main(String[] args)
	{
		int num;
		int x=0, y=0;
		int cnt=0;
		
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		
		while(num > 0)
		{

			if(num % 5 == 0)
			{
				cnt++;
				num -= 5;
			}
			else if(num % 3 == 0)
			{
				cnt++;
				num -= 3;
			}
			else if(num > 5)
			{
				num -= 5;
				cnt++;
			}
			else
			{
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
		scan.close();
	}
}
