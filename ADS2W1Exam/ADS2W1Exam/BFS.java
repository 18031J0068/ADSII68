import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

class BFS 
{
	int V;
	ArrayList<Integer> graph[];
	
	@SuppressWarnings("unchecked")
	BFS(int v) 
	{
		V = v;
		graph = new ArrayList[v+1];
		
		for(int i = 1;i <= v;i++)
		{
			graph[i] = new ArrayList<Integer>();
		}
	}
	
	void addEdge(int x,int y)
	{
		graph[x].add(y);
		graph[y].add(x);
	}

	int getConnectedNodes(ArrayList<Integer> graph[],int vertex, int m)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.length+1];
		int[] dist = new int[graph.length+1];
		
		for(int i = 0;i<= graph.length;i++)
		{
			System.out.print(dist[i]+" ");
		}
		
		q.add(vertex);
		
		visited[vertex] = true;
		
		int count = 0;
		
		while(!q.isEmpty())
		{
			int v = q.poll();
			System.out.println("V = "+v);
			
			if(dist[v] == m)
			{
				break;
			}
			
			ListIterator<Integer> it = graph[v].listIterator();
			
			while(it.hasNext())
			{
				int n = it.next().intValue();
				
				if(!visited[n])
				{
					q.add(n);
					visited[n] = true;
					dist[n] = dist[v] + 1;
					if(dist[n] == m)
					{
						count++;
					}
				}
			}
		}
		return count;
	}


}
