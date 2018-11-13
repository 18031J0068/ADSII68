import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Matrix {
	 int a[][];
	 String[] b;
	 
	 public Matrix (BufferedReader in,int s1,int s2) throws IOException
	 {
	
	// int E=Integer.parseInt(in.readLine());
		 super();
			a = new int[s1][s2];
			for(int i = 0;i<s1;i++)
			{
				for(int j = 0;j<s2;j++)
				{
					a[i][j]=0;
				}
			}
	 String a=in.readLine();
	
	 StringTokenizer st=new StringTokenizer(a,",");
	  b=new String[st.countTokens()];
	 int j=0;
	 while(st.hasMoreTokens())
	 {
	 	b[j++]=st.nextToken();
	 	
	 }
	 for(int i=0;i<s1;i++)
	 {
	 	String z=in.readLine();
	 	String r[]=z.split(" ");
	 	int v=Integer.parseInt(r[0]);
	 	//System.out.println(r[0]+ " nknddfad"+r[1]);
	 	int w=Integer.parseInt(r[1]);
	 	insert(v,w);
	 }
	 }
	
	public void insert(int n,int m)
	{
               if(n!=m)

             {
		a[n][m]=1;
		a[m][n]=1;
                }
else
return;
	}
	public void display(int n,int m)
	{
		int count=0;
		for(int i=0;i<n;i++)
    	{
    		int j=0;
    		for(;j<m;j++)
    		{
    			if(a[i][j]==0)
    				count++;	
    		}
    	}
		if(count!=a.length)
    	{
    		int i=0; 
    	for(i=0;i<n-1;i++)
    	{
    		int j=0;
    		for(;j<n;j++)
    		{
    			System.out.print(a[i][j]+" ");
    		}
    		
    		System.out.println();
    	}
    	int k=0;
    	for(k=0;k<n-1;k++)
		{
			System.out.print(a[i][k]+" ");
		}
		System.out.print(a[i][k]);
    	}
    	else
    		{System.out.println("No edges");}
    	
    }
}