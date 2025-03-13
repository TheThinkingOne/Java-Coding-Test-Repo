package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj5464 { // 백준 주차장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 주차공간수
        int M = Integer.parseInt(st.nextToken()); // 차량수

        int[] parkingRates = new int[N]; // 주차장 비용 배열
        int[] carWeights = new int[M]; // 차량무게 배열

        for (int i = 0; i < N; i++) {
            parkingRates[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            carWeights[i] = Integer.parseInt(br.readLine());
        }

        int[] parkingCar = new int[M + 1]; // 각 차량의 주차 위치 배열

        PriorityQueue<Integer> emptySpace = new PriorityQueue<>(); // 빈 주차 공간 큐
        Queue<Integer> waitingCars = new LinkedList<>(); // 대기 차량 큐

        // 주차 공간 초기화 (1부터 N까지)
        for (int i = 1; i <= N; i++) {
            emptySpace.add(i);
        }

        int totalCost = 0;

        for (int i = 0; i < 2 * M; i++) {
            int order = Integer.parseInt(br.readLine());

            if (order > 0) { // 차량 진입
                if (emptySpace.isEmpty()) { // 빈 주차 공간이 없으면 대기열로 보냄
                    waitingCars.add(order); // 대기중인 차량 큐에 넣기
                } else { // 빈 주차 공간이 있으면 주차
                    int parkingSpot = emptySpace.poll();
                    parkingCar[order] = parkingSpot;
                }
            } else { // 차량 출차
                order = Math.abs(order); // 차량 번호로 전환
                int parkingSpot = parkingCar[order];
                totalCost += carWeights[order - 1] * parkingRates[parkingSpot - 1];

                if (!waitingCars.isEmpty()) { // 대기 차량이 있으면 주차
                    int nextCar = waitingCars.poll();
                    parkingCar[nextCar] = parkingSpot;
                } else { // 빈 주차 공간 큐에 다시 추가
                    emptySpace.add(parkingSpot);
                }
            }
        }

        System.out.println(totalCost);
    }
}
