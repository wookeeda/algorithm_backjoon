package hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

        int n = container[0].length;

        long[] numberOfBallByType = new long[n];
        long[] capacityPerContainer = new long[n];

        // 1. 각 개수 세고,
        // 2. 컨테이너 용량도 구하고
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                capacityPerContainer[i] += container[i][j];
                numberOfBallByType[j] += container[i][j];
            }
        }

        // 공 개수와 컨테이너 용량이 같아야 됨.
        Arrays.sort(numberOfBallByType);
        Arrays.sort(capacityPerContainer);

        for (int i = 0; i < n; i++) {
            if (numberOfBallByType[i] != capacityPerContainer[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static void printCnt(int[] numberOfBallByType, int[] capacityPerContainer) {
        System.out.println("=====\n볼 갯수");
        for (int i = 0; i < numberOfBallByType.length; i++) {
            System.out.println("ball[i]: " + numberOfBallByType[i]);
        }

        System.out.println("=====\n컨테이너 용량");
        for (int i = 0; i < capacityPerContainer.length; i++) {
            System.out.println("container[i]: " + capacityPerContainer[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            System.out.println(result);
        }


        scanner.close();
    }
}
