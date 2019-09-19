import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
    static int[] parents;
    public static void main(String[] args) throws IOException {
         
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
         
        parents = new int[n+1];
        for(int i=0; i<parents.length; i++)
            makeSet(i);
         
        for(int i=0; i<m; i++) {
             
            str = bf.readLine();
            st = new StringTokenizer(str);
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
         
        int count = 0;
        for(int i=1; i<parents.length; i++) {
             
            if(i == parents[i])
                count++;
        }
         
        System.out.println(count);
    }
 
    static void makeSet(int x) {
        parents[x] = x;
    }
     
    static int findSet(int x) {
         
        if(x == parents[x]) {
            return x;
        }
         
        parents[x] = findSet(parents[x]); 
        return parents[x];
    }
     
    static void union(int x, int y) {
         
        x = findSet(x);
        y = findSet(y);
        parents[y] = x;
    }
}
