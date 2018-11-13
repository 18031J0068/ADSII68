class CC 
{
	boolean marked[];
	int id[];
	int size[];
	int count;
	
	CC(Graph G)
	{
		marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) 
        {
            if (!marked[v]) 
            {
                dfs(G, v);
                count++;
            }
        }
	}
	
	void dfs(Graph G, int v) 
	{
		marked[v] = true;
        id[v] = count;
        //System.out.println(count);
        size[count]++;
        for (int w : G.adj(v))
        {
            if (!marked[w])
            {
                dfs(G, w);
            }
        }
    }
	
	boolean connected(int v, int w)
	{
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
	
	void validateVertex(int v)
	{
        int V = marked.length;
        if (v < 1 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	int id(int v) 
	{
        validateVertex(v);
        return id[v];
    }
	
	int size(int v) 
	{
        validateVertex(v);
        return size[id[v]];
    }
	
	int count() 
	{
		//System.out.println("Return count:"+count);
        return count;
    }
	
	void disp()
	{
		if(count == 1)
			System.out.println(false);
		else
			System.out.println(true);
		
		if(count != 1)
			System.out.println(true);
		else
			System.out.println(false);
	}
}
