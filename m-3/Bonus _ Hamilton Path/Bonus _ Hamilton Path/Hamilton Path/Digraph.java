import java.io.BufferedReader;
import java.io.IOException;

public class Digraph 
{
	int V;
	int E;
    Bag<Integer>[] adj;
    
 	Digraph(int V)
    {
    	 this.V=V;
    	 adj=(Bag<Integer>[])new Bag[V];
    	 for(int v=0;v<V;v++)
    	 {
    		 adj[v]=new Bag<Integer>();
    	 }
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
     
     public Digraph(BufferedReader in) throws IOException
     {
    	 this(Integer.parseInt(in.readLine()));
    	 int E = Integer.parseInt(in.readLine());
    	 
    	 for(int i=0;i<E;i++)
    	 {
    		 String z = in.readLine();
        	 
    		 String r[]=z.split(" "); 
    		 int v=Integer.parseInt(r[0]);
    		 int w=Integer.parseInt(r[1]);
    		 addEddge(v,w);
    	 }
     }
     void addEddge(int v,int w)
     {
    	
    		 E++;
    	 
    	 adj[v].add(w);
     }         
}
