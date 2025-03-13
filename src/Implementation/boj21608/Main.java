package Implementation.boj21608;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] favorList;
    static int[][] myMap;
    static int[] order;
    static Map<Integer, Point> map;
    static int firstKid;
    static int N;
    //static ArrayList<Integer> deployedStudent = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        favorList = new int[N * N+1][4]; // 각 학생들이 좋아하는 번호의 정보 담는 리스트
        //int[][] infoList02 = new int[N*N][5];
        order = new int[N*N]; // 학생의 번호를 담는 리스트 order

        StringTokenizer st;
        for (int i = 0; i < N * N; i++) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 각 줄마다 맨 앞자리 수(학생의 번호)
            order[i] = k;
            for (int j = 0; j < 4; j++) {
                //int num = Integer.parseInt(st.nextToken());
                favorList[k][j] = Integer.parseInt(st.nextToken()); // 각 학생마다 좋아하는 학생들의 번호정보 favorList 에 저장
            }
            //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            //1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            //2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        }
        myMap = new int[N][N]; // 정보대로 학생들 배치하는 myMap
        map = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            getFriendSeats(order[i]);
        }
        int result = getSatisfaction();
        System.out.println(result);
    }

    public static void getFriendSeats(int k) {
        int max = 0;
        int[][] count = new int[N][N];
        for (int i=0; i<4; i++) {
            int now = favorList[k][i];
            if (map.containsKey(now)) {
                Point perfer = map.get(now);

                for (int dir=0; dir<4; dir++) {
                    int nextX = perfer.x + dx[dir];
                    int nextY = perfer.y + dy[dir];
                    if(nextX<0 || nextX>=N || nextY<0 || nextY>=N || myMap[nextX][nextY]!=0) continue;
                    // 교실 범위 밖이거나 이미 해당 자리에 학생이 있으면 넘어감
                    count[nextX][nextY]++;
                    if(count[nextX][nextY]>max) max =count[nextX][nextY];
                }
            }
        }
        getSeat(max, count, k);
    }
    private static void getSeat(int max, int[][] count, int k) {
        //1번 조건을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        int maxEmpty=0;
        int si=N, sj=N;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(count[i][j]==max) {

                    int tempEmpty = 0;
                    for (int dir=0; dir<4; dir++) {
                        int nextX = i + dx[dir];
                        int nextY = j + dy[dir];
                        if(nextX<0 || nextX>=N || nextY<0 || nextY>=N || myMap[nextX][nextY]!=0) continue;
                        tempEmpty++;
                    }

                    if(tempEmpty>maxEmpty && myMap[i][j]==0) {
                        maxEmpty = tempEmpty;
                        si=i;
                        sj=j;
                        // 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로,
                        // 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
                    } else if(tempEmpty==maxEmpty) { // 문제 3번조건
                        if((si>i || (si==i && sj>j)) && myMap[i][j]==0) {
                            si = i;
                            sj = j;
                        }
                    }

                }
            }
        }
        myMap[si][sj] = k;
        map.put(k, new Point(si, sj));
    }

    private static int getSatisfaction() {
        int result = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int now = myMap[i][j];
                int count = 0;
                for (int dir=0; dir<4; dir++) {
                    int nextX = i + dx[dir];
                    int nextY = j + dy[dir];
                    if(nextX<0 || nextX>=N || nextY<0 || nextY>=N ) continue;

                    int nearFavor = myMap[nextX][nextY];

                    for(int k=0; k<4; k++) { // 옆의 네명 비교
                        if(nearFavor == favorList[now][k]) count++;
                    }
                }

                if(count>=1) result += Math.pow(10,count-1);

            }
        }
        return result;
    }
}
