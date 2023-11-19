import java.util.*;              //preemptive
 
public class SJF_pre{
	public static void main (String args[])
	{
		Scanner scanner =new Scanner(System.in);
		System.out.println ("enter no of process:");
		int n= scanner.nextInt();
		int pid[] = new int[n]; 
		int at[] = new int[n]; 
		int burst_time[] = new int[n]; 
		int completion_time[] = new int[n]; 
		int tat[] = new int[n];
		int wt[] = new int[n];  
		int flag[] = new int[n];  
		int original_bt[]= new int[n];   
	    int i, current_time=0, total=0;
	    float avgwt=0, avgta=0;
 
	    for (i=0;i<n;i++)
	    {
	    	pid[i]= i+1;
	    	System.out.println ("enter process " +(i+1)+ " arrival time:");
	    	at[i]= scanner.nextInt();
	    	System.out.println("enter process " +(i+1)+ " burst time:");
	    	burst_time[i]= scanner.nextInt();
	    	original_bt[i]= burst_time[i];
	    	flag[i]= 0;
	    }
		
	    
	    while(true)
		{
	    	int min=99,current=n;
	    	if (total==n)
	    		break;
	    	
	    	for ( i=0;i<n;i++)
	    	{
	    		if ((at[i]<=current_time) && (flag[i]==0) && (burst_time[i]<min))
	    		{	
	    			min=burst_time[i];
	    			current=i;
	    		}
	    	}
	    	if (current==n)
	    		current_time++;
	    	else
	    	{
	    		burst_time[current]--;
	    		current_time++;
	    		if (burst_time[current]==0)
	    		{
	    			completion_time[current]= current_time;
	    			flag[current]=1;
	    			total++;
	    		}
	    	}
	    }
	    for(i=0;i<n;i++)
	    {
	    	tat[i] = completion_time[i] - at[i];
	    	wt[i] = tat[i] - original_bt[i];
	    	avgwt+= wt[i];
	    	avgta+= tat[i];
	    }
	    
	    System.out.println("pid  arrival  burst  complete turn waiting");
	    for(i=0;i<n;i++)
	    {
	    	System.out.println(pid[i] +"\t"+ at[i]+"\t"+ original_bt[i] +"\t"+ completion_time[i] +"\t"+ tat[i] +"\t"+ wt[i]);
	    }
	    
	    System.out.println("\naverage tat is "+ (float)(avgta/n));
	    System.out.println("average wt is "+ (float)(avgwt/n));
	}
}
