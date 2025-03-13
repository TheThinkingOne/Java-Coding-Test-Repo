package Implementation.boj2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HyoKyungVer {

    static int[] dx = {0,1,1,-1}; //가로, 세로, 오른쪽대각선, 왼쪽대각선
    static int[] dy= {1,0,1,1};

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[21][21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1;i<20;i++){
            for(int j=1; j<20;j++){

                if(arr[i][j]==0) continue;
                for(int d=0;d<4;d++){

                    boolean success =true;
                    int nextX = i;
                    int nextY=j;
                    for(int k=0;k<4;k++){
                        nextX += dx[d];
                        nextY += dy[d];

                        if(nextX <0 || nextX>=20 || nextY <0 || nextY>=20 || arr[i][j]!= arr[nextX][nextY]){
                            // x,y 좌표가 범위내에 있는지 체크하는 if 문
                            success = false;
                            break;
                        }
                    }

                    if(success){
                        nextX+=dx[d];
                        nextY+=dy[d];
                        if( !(nextX <0 || nextX>=20 || nextY <0 || nextY>=20 || arr[i][j] != arr[nextX][nextY]))
                            success=false;
                        nextX = i-dx[d];
                        nextY=j-dy[d];
                        if( !(nextX <0 || nextX>=20 || nextY <0 || nextY>=20 || arr[i][j] != arr[nextX][nextY]))
                            success=false;
                    }

                    if(success){
                        System.out.println(arr[i][j]);
                        System.out.println(i+" "+j);
                        return;
                    }
                }
            }
        }

        System.out.println(0);

    }

}
