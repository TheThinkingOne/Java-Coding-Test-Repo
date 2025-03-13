package swea.swea10993;

import java.util.*;
import java.io.*;

public class Solution_google
{

    public static int T, N;
    public static double x, y, s;
    public static City[] city;
    public static double[][] influence;
    public static int[] ans;

    public static int findParent(int n) {
        if(ans[n] == n || ans[n] == -1 || ans[n] == -2) return n;
        return findParent(ans[n]);
    }

    public static void solution() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    influence[i][j] = -1;
                    continue;
                }
                double dx = city[i].x - city[j].x;
                double dy = city[i].y - city[j].y;
                influence[i][j] = city[i].s / ((dx * dx) + (dy * dy));
            }
        }

        for(int j = 1; j <= N; j++) {
            boolean flag = false;
            double max = -1;
            int cnt = 0;
            for(int i = 1; i <= N; i++) {
                if(city[j].s < influence[i][j]) {
                    flag = true;
                    max = Math.max(max, influence[i][j]);
                }
            }
            for(int i = 1; i <= N; i++) {
                if(i != j && max == influence[i][j]) {
                    cnt++;
                }
            }
            if(cnt >= 2) {
                ans[j] = -2;
            } else if (cnt == 1) {
                for(int i = 1; i <= N; i++) {
                    if(i != j && max == influence[i][j]) {
                        ans[j] = i;
                        break;
                    }
                }
            } else {
                ans[j] = -1;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(ans[i] == -1 || ans[i] == -2) continue;
            ans[i] = findParent(i);
        }
    }

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            ans = new int[N + 1];
            city = new City[N + 1];
            influence = new double[N + 1][N + 1];

            for(int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x = Double.parseDouble(st.nextToken());
                y = Double.parseDouble(st.nextToken());
                s = Double.parseDouble(st.nextToken());
                city[i] = new City(x, y, s);
                ans[i] = '0';
            }
            solution();
            System.out.print("#" + test_case + " ");
            for(int i = 1; i < ans.length; i++) {
                if(ans[i] == -1) {
                    System.out.print("K ");
                } else if(ans[i] == -2) {
                    System.out.print("D ");
                } else {
                    System.out.print(ans[i] + " ");
                }
            }
            System.out.println();

        }

    }

    public static class City {
        public double x;
        public double y;
        public double s;

        public City(double x, double y, double s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}
