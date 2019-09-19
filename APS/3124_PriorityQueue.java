import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Node implements Comparable<Node>{
        int des;
        int len;
         
        public Node() {}
        public Node(int des, int len) {
            this.des = des;
            this.len = len;
        }
         
        @Override
        public String toString() {
            return "des=" + des + ", len=" + len;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.len, o.len);
        }
    }
     
    static ArrayList<Node>[] list;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());
         
        for(int t=1; t<=test_case; t++) {
             
            String[] input_val = bf.readLine().split(" ");
            int n = Integer.parseInt(input_val[0]);
            int m = Integer.parseInt(input_val[1]);
            list = new ArrayList[n+1];
             
            for(int i=0; i<=n; i++)
                list[i] = new ArrayList<>();
             
            for(int i=0; i<m; i++) {
                 
                String str = bf.readLine();
                StringTokenizer st = new StringTokenizer(str);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, weight));
                list[end].add(new Node(start, weight));
            }
             
            PriorityQueue<Node> queue = new PriorityQueue<>();
            boolean[] visited = new boolean[n+1];
            queue.addAll(list[1]);
            visited[1] = true;
            int point = 1;
            long total = 0;
            while(point < n) {
                 
                Node node = queue.poll();
                if(!visited[node.des]) {
                     
                    queue.addAll(list[node.des]);
                    point++;
                    visited[node.des] = true;
                    total += node.len;
                }
            }
            System.out.println("#" + t + " " + total);
        }
    }
}
