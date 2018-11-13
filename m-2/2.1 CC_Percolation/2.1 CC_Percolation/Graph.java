import java.io.BufferedReader;
import java.io.IOException;

public class Graph
{
	@SuppressWarnings("unused")
	private static final Object NEWLINE = null;
	int V;
	int E=0;
	String b[];
     Bag<Integer>[] adj;
     CC c;
     @SuppressWarnings("unchecked")
	public Graph(int V)
     {
    	 this.V=V;
    	 adj=(Bag<Integer>[])new Bag[V];
    	 for(int v=0;v<V;v++)
    		 adj[v]=new Bag<Integer>();
     }
     
     int V()
     {
    	 return V;
     }
     int E()
     {
    	 return E;
     }
     
     Iterable<Integer> adj(int v)
     {
    	 return adj[v];
     }
     
     public Graph(BufferedReader in) throws IOException
     {
    	 this(Integer.parseInt(in.readLine()));
    	 //int E=Integer.parseInt(in.readLine());
    	 for(int i=0;i<E;i++)
    	 {
    		 String z=in.readLine();
    		 String r[]=z.split(" ");
    		 
    		 if(r.length == 0)
    			 c.disp();
    		 
    		 int v=Integer.parseInt(r[0]);
    		 int w=Integer.parseInt(r[1]);
    		 addEddge(v,w);
    	 }
     }
     void addEddge(int v,int w)
     {
    	 if(!(v==w)&&duplicate(v,w))
    		 E++;
    	 
    	 adj[v].add(w);
    	 adj[w].add(v);
     }
     
     @SuppressWarnings("unused")
     private boolean duplicate(int v2,int w)
     {
    	 for (int w1 : adj[v2]) 
    	 {
	        if(w1==w)
	        {
	        	return false;
	        }
        }
    	 return true;
     }
     
     
}
