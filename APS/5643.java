import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
  
public class Solution {
  
    static int n;
    static final int INF = 987654321;
      
    public static void main(String[] args) throws NumberFormatException, IOException {
          
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(bf.readLine());
        for(int t=1; t<=test_case; t++) {
              
            n = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());
            int[][] arr = new int[n][n];
            // 초기화
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    arr[i][j] = (i == j) ? 0 : INF;
            }
              
            // 연결된 지점 연결
            for(int i=0; i<m; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x-1][y-1] = 1;
            }
              
            // 플로이드 워셜
            for(int k=0; k<n; k++) {
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
              
            int result = 0;
            for(int i=0; i<n; i++) {
                  
                boolean flag = true;
                for(int j=0; j<n; j++) {
                      
                    if(arr[i][j] == INF && arr[j][i] == INF) {
                          
                        flag = false;
                        break;
                    }
                }
                  
                if(flag)
                    result++;
            }
  
            bw.write("#" + t + " " + result + "\n");
            bw.flush();
        }
        bw.close();
    }
}
