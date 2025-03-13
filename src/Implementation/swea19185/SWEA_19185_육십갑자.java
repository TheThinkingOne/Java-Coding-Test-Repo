package Implementation.swea19185;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_19185_육십갑자 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); // TC = 1
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=TC ;t++){ // t <= TC => t <= 1
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 10
            int M = Integer.parseInt(st.nextToken()); // 12

            String[] arrN = new String[N]; //갑자 저장 배열
            st = new StringTokenizer(br.readLine()); //갑자 줄 불러오기
            for(int i=0;i<N;i++){
                arrN[i] = st.nextToken(); // 갑자 하나씩 공백을 기준으로 저장
            }

            String[] arrM = new String[M+1]; //십이지 저장 배열
            st = new StringTokenizer(br.readLine()); //십이지 줄 불러오기
            for(int i=0;i<M;i++){
                arrM[i] = st.nextToken(); // 십이지 하나씩 공백을 기준으로 저장
            }

            sb.append("#"+t+" ");
            int Q = Integer.parseInt(br.readLine()); // 7

            for(int i=0;i<Q;i++){
                int Y = Integer.parseInt(br.readLine())-1; // 테스트케이스에 주어진 연도들
                sb.append(arrN[Y%N]+arrM[Y%M]+" "); //
            }

            sb.append("\n");

        }
        System.out.print(sb);

    }
}
