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
    	 adj=(Bag<Integer>[])new Bag[V+1];
    	 for(int v=1;v<=V;v++)
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
    	 String z = in.readLine();
    	 
    	 if(z == null)
    	 {
    		 System.out.println("false");
    		 System.exit(0);
    	 }
    	 
    	 while(z != null)
    	 {
    		 if(z.equals(""))
    		 {
    			 return;
    		 }
    		 String r[]=z.split(" ");
    		 int v=Integer.parseInt(r[0]);
    		 int w=Integer.parseInt(r[1]);
    		 addEddge(v,w);
    		 z = in.readLine();
    	 }
     }
     void addEddge(int v,int w)
     {
    	
    		 E++;
    	 
    	 adj[v].add(w);
    	 adj[w].add(v);
     }     
}
