package Implementation.shortestdistance.boj1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HyoKyungVer {

    static int N,M;
    static ArrayList<Integer>[] graph;
    static int min = Integer.MAX_VALUE, minIndex;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for(int i=1;i<=N;i++){
            visit = new boolean[N+1];
            int kevin = bfs(i);
            if(min>kevin){
                min=kevin;
                minIndex=i;
            }
        }

        System.out.println(minIndex);

    }

    private static int bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        int sum=0, depth=0;
        while(!q.isEmpty()){

            int size = q.size();
            for(int s=0;s<size;s++){

                int now = q.poll();
                for(int next : graph[now]){
                    if(visit[next]) continue;
                    visit[next]=true;
                    q.add(next);
                }
                sum+= depth;
            }
            depth++;
        }
        return sum;
    }


}
