package DFS_BFS.boj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BFS {
    static int Computer;
    static ArrayList<Integer>[] MyMap;
    static boolean[] Visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Computer = Integer.parseInt(br.readLine());
        int Connected = Integer.parseInt(br.readLine());

        MyMap = new ArrayList[Computer + 1];
        for (int i = 1; i <= Computer; i++) {
            MyMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < Connected; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int stop = Integer.parseInt(input[1]);
            MyMap[start].add(stop);
            MyMap[stop].add(start);
        }

        Visited = new boolean[Computer + 1];
        BFS(1);
        System.out.println(count - 1);
    }

    public static void BFS(int here) {
        ArrayList<Integer> Queue = new ArrayList<>();
        Queue.add(here);
        Visited[here] = true;

        while (!Queue.isEmpty()) {
            here = Queue.remove(0);
            count++;

            for (int next : MyMap[here]) {
                if (!Visited[next]) {
                    Queue.add(next);
                    Visited[next] = true;
                }
            }
        }
    }
}

