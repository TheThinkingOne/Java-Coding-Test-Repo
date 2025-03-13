package Implementation.boj21608;

//package week12;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HyoKyungVer {

    static int N;
    static int[][] arr;
    static int[][] position;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};
    static Map<Integer, Point> map;
    static int[] order;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N*N+1][4];
        order = new int[N*N];
        StringTokenizer st;
        for(int i=0;i<N*N;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            order[i] = k;
            for(int j=0;j<4;j++){
                arr[k][j] = Integer.parseInt(st.nextToken());
            }
        }

        position = new int[N][N];
        map = new HashMap<>();

        for(int i=0;i<N*N;i++){
            getManyFriendSeats(order[i]);
//            System.out.println(Arrays.deepToString(position));
        }
        int result=getSatisfaction();
        System.out.println(result);


    }


    //1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    private static void getManyFriendSeats(int k) {
        int max=0;
        int[][] count = new int[N][N];
        for(int i=0;i<4;i++){
            int now = arr[k][i];
            if(map.containsKey(now)){
                Point prefer = map.get(now);

                for(int d=0;d<4;d++){
                    int nextX = prefer.x+dx[d];
                    int nextY = prefer.y+dy[d];
                    if(nextX<0 || nextX>=N || nextY<0 || nextY>=N || position[nextX][nextY]!=0) continue;
                    count[nextX][nextY]++;
                    if(count[nextX][nextY]>max) max =count[nextX][nextY];
                }
            }
        }

        getSeat(max, count,  k);
    }

    private static void getSeat(int max, int[][] count, int k) {

        //1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        int maxEmpty=0;
        int si=N, sj=N;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(count[i][j]==max){

                    int tmpEmpty=0;
                    for(int d=0;d<4;d++){
                        int nextX = i+dx[d];
                        int nextY = j+dy[d];
                        if(nextX<0 || nextX>=N || nextY<0 || nextY>=N || position[nextX][nextY]!=0) continue;
                        tmpEmpty++;
                    }

                    if(tmpEmpty>maxEmpty && position[i][j]==0){
                        maxEmpty=tmpEmpty;
                        si=i;
                        sj=j;
                        // 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
                    }else if(tmpEmpty==maxEmpty){
                        if( (si>i || (si==i && sj>j)) && position[i][j]==0){
                            si=i;
                            sj=j;
                        }
                    }

                }
            }
        }

        position[si][sj] = k;
        map.put(k, new Point(si, sj));
    }


    private static int getSatisfaction() {

        int result =0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                int now = position[i][j];
                int count=0;
                for(int d=0;d<4;d++){
                    int nextX = i+dx[d];
                    int nextY = j+dy[d];
                    if(nextX<0 || nextX>=N || nextY<0 || nextY>=N ) continue;

                    int near = position[nextX][nextY];

                    for(int k=0;k<4;k++){
                        if(near == arr[now][k])count++;
                    }
                }

                if(count>=1) result+= Math.pow(10, count-1);


            }
        }

        return result;

    }
}

