package Implementation.boj15686;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HyoKyungVer {
    //https://chat.openai.com/share/4da9c7a7-3f8d-427c-8696-6cd7c9244d45
    //gpt 해설글

    static int N, M, chSize, homeSize, min;
    static int[][] arr;
    static ArrayList<Point> home, chicken;
    static Point[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //5
        M= Integer.parseInt(st.nextToken()); //3

        arr = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) home.add(new Point(i,j)); // home 배열에 1인 지점(집)을 저장
                else if(arr[i][j]==2) chicken.add(new Point(i,j)); // chicken 배열에 2인 지점(치킨집)을 저장
            }
        }


        min = Integer.MAX_VALUE;
        chSize = chicken.size();
        homeSize = home.size();
        selected = new Point[M];
        combination(0,0);

        System.out.println(min);

    }

    private static void combination(int cnt, int start) {

        if(cnt==M){
//            System.out.println(Arrays.toString(selected));
            getChickenDistance();
            return;
        }

        for(int i=start; i<chSize; i++){
            selected[cnt] = chicken.get(i); //chicken 안에 있는 좌표? 불러오기?
            combination(cnt+1, i+1);
        }

    }

    private static void getChickenDistance() {

        int sum=0;

        for(int i=0;i<homeSize;i++){
            int minDis = Integer.MAX_VALUE;
            int r1 = home.get(i).x;
            int c1 = home.get(i).y;
            for(int j=0;j<M;j++){
//                System.out.println(home.get(i)+", "+ selected[j]+ ", "+( Math.abs(r1- selected[j].x) + Math.abs(c1- selected[j].y)) );
                minDis=Math.min(minDis, Math.abs(r1- selected[j].x) + Math.abs(c1- selected[j].y));
            }
            sum+=minDis;
        }
        if(min>sum) min = sum;
    }

}

