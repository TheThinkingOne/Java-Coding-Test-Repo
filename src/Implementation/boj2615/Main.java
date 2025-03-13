//package Implementation.boj2615;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int[] dx = {0,1,1,-1}; //가로, 세로, 오른쪽대각선, 왼쪽대각선
//    static int[] dy= {1,0,1,1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int[][] myMap = new int[21][21];
//
//        for (int i=0; i<20; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j=0; j<20; j++) {
//                myMap[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i=0; i<20; i++) {
//            for (int j=0; j<20; j++) {
//                if (myMap[i][j]==0) continue;
//                for (int dir=0; dir<4; dir++) {
//
//                    boolean isOk = true;
//                    int nextX = i;
//                    int nextY = j;
//
//                    if(nextX <0 || nextX>=20 || nextY <0 || nextY>=20 || myMap[i][j] != myMap[nextX][nextY]) {
//                        isOk = false;
//                        break;
//                    }
//
//                    }
//                    if(isOK){
//                        System.out.println(myMap[i][j]);
//                        System.out.println(i+" "+j);
//                        return;
//                    }
//
//                }
//            }
//        }
//        System.out.println(0);
//
//    }
//}









