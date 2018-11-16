import java.util.Stack;

public class DepthFirstOrder 
{
	boolean marked[];
	Stack<Integer> reversePost;
	
	
	public DepthFirstOrder(Digraph G) 
	{
		marked = new boolean[G.V()];
		reversePost = new Stack<Integer>();
		for(int v = 0;v < G.V();v++)
		{
			if(!marked[v])
			{
				dfs(G,v);
			}
		}
	}
	
	void dfs(Digraph G,int v)
	{
		marked[v] = true;
		for(int w: G.adj(v))
		{
			//System.out.println(w);
			if(!marked[w])
			{
				dfs(G,w);
			}
		}
		reversePost.push(v);
	}
	
	boolean isConnected(int v,int w,Digraph G)
	{
		//System.out.println(G.adj[1]);
		for(int w1 : G.adj(v))
		{
			if(w1 == w)
			{
				return true;
			}
		}
		return false;
	}
	
	Iterable<Integer> reversePost()
	{
		//System.out.print(reversePost+" ");
		return reversePost;
	}
	
	void display(Digraph G)
	{
		int[] A;
		int n=reversePost.size();
		A = new int[n];
		
		for(int i = 0;i < n;i++)
		{
			A[i] = reversePost.pop();
			//System.out.print(A[i]+" ");
		}
		
		for(int i=0;i<n-1;i++)
		{
			
				if(!isConnected(A[i],A[i+1],G))
				{
					System.out.println("False");
					System.exit(0);;
				}
			
			
		}
		System.out.println("True");
	}
	
}
