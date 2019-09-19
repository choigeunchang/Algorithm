import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Temp{
     
    int high;
    int low;
    public Temp() {}
    public Temp(int high, int low) {
        this.high = high;
        this.low = low;
    }
}
 
public class Main {
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(bf.readLine());
         
        Temp[] t = new Temp[n];
         
        for(int i=0; i<n; i++) {
             
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            t[i] = new Temp(l, h);
        }
     
        for(int i=0; i<n-1; i++) {
             
            for(int j=i+1; j<n; j++) {
                 
                if(t[i].low > t[j].low) {
                     
                    int temp = t[i].low;
                    t[i].low = t[j].low;
                    t[j].low = temp;
                     
                    temp = t[i].high;
                    t[i].high = t[j].high;
                    t[j].high = temp;
                }
            }
        }
 
        int count = 0;
        int i = 0, j = 0;
        for(i=0; i<n;){
             
            int temp = t[i].high;
            for(j=i+1; j<n; j++) {
                 
                if(t[j].low > temp || t[j].low > t[i].high)
                    break;
                 
                if(temp > t[j].high)
                    temp = t[j].high;
            }
            i = j;
            count++;
        }
         
        System.out.println(count);
    }
}
