package hackerRank;

import java.util.Scanner;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {

        long maxMachineDay = 0;
        for (long machine : machines) {
            if (maxMachineDay < machine) {
                maxMachineDay = machine;
            }
        }
        int machineCnt = machines.length;

        long maxDay = (long) (Math.floor(goal * 1.0 / machineCnt) * maxMachineDay);
        long day = maxDay / 2;

        long left = 0;
        long right = maxDay;
        while (right - left > 1) {
            long now = (left + right) / 2;

            long cnt = getProductionCountAtDay(machines, now);
            if (cnt < goal) {
                left = now;
            } else {
                right = now;
            }

        }
        return right;
    }

    private static long getProductionCountAtDay(long[] machines, long day) {
        long sum = 0;
        for (long machine : machines) {
            sum += day / machine;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(ans);

        scanner.close();
    }
}
