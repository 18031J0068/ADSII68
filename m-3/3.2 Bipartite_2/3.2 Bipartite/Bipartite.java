
public class Bipartite {
boolean[] color;
boolean[] marked;
boolean  isBipartite =true;
Stack<Integer> c;
public Bipartite(Graph g)
{
	marked =new boolean[g.V()];
	color =new boolean[g.V()];
	for(int v=0;v<g.V();v++)
	{
		if(!marked[v])
			dfs(g,v);
	}
}
void dfs(Graph g,int v)
{
	marked[v]=true;
	for(int w:g.adj(v))
	{
		if(!marked[v])
		{	
			color[w]=!color[v];
			dfs(g,w);
	     }
		else if(color[w]==color[v])
		{
			 isBipartite = false;
			/*c = new Stack<Integer>();
            for (int x = v; x != w;) {
                c.push(x);
            }
            c.push(w);*/
			 System.out.println("Graph is bipartite");
			 System.exit(0);
		}
	
	}	
}
boolean isbp()
{
	return isBipartite;
}
void display()
{
	
		System.out.println("Graph is not a bipartite");
}
}
