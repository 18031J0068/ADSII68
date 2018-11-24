import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution 
{
    class Node implements Comparable<Node> 
    {
        int vertice;
        int weight;

        Node(int vertice, int weight) 
        {
            this.vertice = vertice;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o)
        {
            return this.weight - o.weight;
        }
    }

    public class AdjList 
    {
        ArrayList<Node> nodes;
    }

    public class Graph 
    {
        int V;
        AdjList[] adjLists;
    }


    Graph createGraph(int v) 
    {
        Graph graph = new Graph();
        graph.V = v;
        graph.adjLists = new AdjList[v];
        
        for (int i = 0; i < v; i++) 
        {
            AdjList adjList = new AdjList();
            adjList.nodes = new ArrayList<Node>(); 
            graph.adjLists[i] = adjList;
        }
        return graph;
    }

    void addEdge(Graph graph, int src, int dest, int weight) 
    {
        Node srcNode = new Node(src, weight);
        Node destNode = new Node(dest, weight);
        
        graph.adjLists[src].nodes.add(destNode);
        graph.adjLists[dest].nodes.add(srcNode);
    }

    void printGraph(Graph graph,int v,int e)
    {
    	System.out.println(v+" vertices "+e+" edges");
        for (int i = 0; i < graph.V; i++)
        {
            System.out.print(i + ": ");
            for (Node n : graph.adjLists[i].nodes) 
            {
                System.out.print(" "+i+"-"+n.vertice+" "+n.weight+".00000");
            }
            System.out.println();
        }
    }

    void getPrims(Graph graph) 
    {
        Node weight[] = new Node[graph.V];
        int parent[] = new int[graph.V];
        boolean mstSet[] = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
        	weight[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
            mstSet[i] = false;
        }
        
        weight[0].weight = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.addAll(Arrays.asList(weight));
        int sum = 0;
        
        while (q.size() > 1) 
        {
        	
            Node u = q.remove();
           
            mstSet[u.vertice] = true;
            
            for (Node n : graph.adjLists[u.vertice].nodes)
            {
            	
                if (mstSet[n.vertice] == false && n.weight < weight[n.vertice].weight) 
                {
                	
                	q.remove(weight[n.vertice]); 
                    weight[n.vertice].weight = n.weight;
                    
                    sum = sum + weight[n.vertice].weight;
                    
                    parent[n.vertice] = u.vertice;
                    q.add(weight[n.vertice]);
                   
                 }
         

            }
            
        }
        print_mst(weight,parent,graph,sum);

    }
    void directedPath(Graph g,int src,int dest)
    {
    	getPrims(g);
    }
    public void print_mst(Node[] weight,int[] parent,Graph g,int sum) 
    {
        System.out.println(sum);
    }

    public static void main(String[] args) throws NumberFormatException, IOException 
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int V = Integer.parseInt(br.readLine());
        
        Solution p = new Solution();
        Graph g = p.createGraph(V);
        
        int e = Integer.parseInt(br.readLine());
        int weight;
        
        for(int i = 0;i < e;i++)
        {
        	String edge = br.readLine();
        	String[] edge1 = edge.split(" ");
        	int to = Integer.parseInt(edge1[0]);
        	int from = Integer.parseInt(edge1[1]);
        	weight = Integer.parseInt(edge1[2]); 
        	p.addEdge(g, to, from, weight);
        }
        
        String ch = br.readLine();
        
        switch(ch)
        {
        	case "Graph" 		: 	p.printGraph(g,V,e);
        							System.out.println();
        							p.getPrims(g);
        							break;
        							
        	case "DirectedPaths" :	String srde = br.readLine();
        							String[] srde1 = srde.split(" ");
        							int src = Integer.parseInt(srde1[0]);
        							int dest = Integer.parseInt(srde1[1]);
        							p.directedPath(g, src, dest);
        							break;
        }
        

    }
}
