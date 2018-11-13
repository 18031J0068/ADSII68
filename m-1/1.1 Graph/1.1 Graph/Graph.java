import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph {
	private static final Object NEWLINE = null;
	int V;
	int E=0;
	String b[];
     Bag<Integer>[] adj;
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
int E=Integer.parseInt(in.readLine());
if(E==0)
{
	return;
}
String a=in.readLine();
StringTokenizer st=new StringTokenizer(a,",");
 b=new String[st.countTokens()];
int j=0;
while(st.hasMoreTokens())
{
	b[j++]=st.nextToken();
	//System.out.println(b[0]+","+b[1]);
}
for(int i=0;i<E;i++)
{
	String z=in.readLine();
	String r[]=z.split(" ");
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
private boolean duplicate(int v2,int w) {
	 for (int w1 : adj[v2]) {
	        if(w1==w)
	        {
	        	return false;
	        }
        }
	return true;
}
public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " vertices, " + E + " edges"+"\n");
    if(V==0||E==0)
    {
    	s.append("No edges");
        return s.toString();
    }
    for (int v = 0; v < V; v++) {
    	
        s.append(b[v] + ": ");
        //System.out.println(v);
        for (int w : adj[v]) {
        
       
         s.append(b[w]+" ");
        }
        if(v!=V-1)
        s.append("\n");
    }
    return s.toString();
}
}
