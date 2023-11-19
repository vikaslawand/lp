import java.util.*;

public class fcfs {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter no of process: ");
        int n = scanner.nextInt();
        int pid[] = new int[n]; // process ids
        int art[] = new int[n]; // arrival times
        int bt[] = new int[n]; // burst or execution times
        int ct[] = new int[n]; // completion times
        int tat[] = new int[n]; // turn around times
        int wt[] = new int[n]; // waiting times
        int temp;
        float avgwt = 0, avgta = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("enter process " + (i + 1) + " arrival time: ");
            art[i] = scanner.nextInt();
            System.out.println("enter process " + (i + 1) + " brust time: ");
            bt[i] = scanner.nextInt();
            pid[i] = i + 1;
        }
        // sorting according to arrival times
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (art[j] > art[j + 1]) 
                {
                    temp = art[j];
                    art[j] = art[j + 1];
                    art[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }
        // finding completion times
        for (int i = 0; i < n; i++) 
        {
            if (i == 0) 
            {
                ct[i] = art[i] + bt[i];
            } else {
                if (art[i] > ct[i - 1]) {
                    ct[i] = art[i] + bt[i];
                } else
                    ct[i] = ct[i - 1] + bt[i];
            }

            tat[i] = ct[i] - art[i]; // turnaround time= completion time- arrival time
            wt[i] = tat[i] - bt[i]; // waiting time= turnaround time- burst time
            avgwt += wt[i]; // total waiting time
            avgta += tat[i]; // total turnaround time
        }
        System.out.println("\npid arrival brust complete turn waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + " \t " + art[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }
        scanner.close();
        System.out.println("\naverage waiting time: " + (avgwt / n)); // printing average waiting time.
        System.out.println("average turnaround time:" + (avgta / n)); // printing average turnaround time.
    }
}
