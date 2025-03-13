package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14889_HyoKyungVer {

    static int N;
    static int[][] arr;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team = new boolean[N];
        comb(0,0);
        System.out.println(min);

    }

    private static void comb(int start, int cnt) {

        if(cnt==N/2) { // 어차피 절반만 선택하면 됨
            //  System.out.println(Arrays.toString(team));
            int teamA=0, teamB=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j || team[i]!=team[j]) continue; // 사람이 같거나
                    if(team[i])
                        teamA+= arr[i][j];
                    else teamB+= arr[i][j];
                }
            }

            int diff = Math.abs(teamA-teamB);
            if(min>diff)min = diff;
            return;
        }

        for(int i=start; i<N; i++){

            team[i] = true;
            comb(i+1, cnt+1);
            team[i] = false;

        }

    }


}
