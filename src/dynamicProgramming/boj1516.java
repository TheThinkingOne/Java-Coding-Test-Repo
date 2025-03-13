package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1516 {

    static int N;
    static ArrayList<Integer> bldgList;
    static ArrayList<Integer> currentBldglist;
    //static int currentBldg;
    static int firstBldg;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bldgList = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            br = new BufferedReader(new InputStreamReader(System.in));
            currentBldglist = new ArrayList<>();
            int time = Integer.parseInt(br.readLine());
            System.out.println(time);
//            int tier = Integer.parseInt(st.nextToken());
//            DFS(time, tier);
            //System.out.println(time);
            //System.out.println(tier);
        }
    }

//    public static void DFS(int time, int tier) {
//        if (tier == -1) {
//            firstBldg = time;
//            count += 1;
//            System.out.println(firstBldg);
//
//        } else if (tier != 1) {
//            if (tier == 1) {
//                currentBldg = firstBldg + time;
//                count += 1;
//                System.out.println(currentBldg);
//            } else if (tier > 1) {
//                if (tier == count) {
//
//                }
//            }
//        }
//
//    }
}
