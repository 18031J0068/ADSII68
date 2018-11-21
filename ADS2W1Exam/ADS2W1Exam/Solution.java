import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ve = br.readLine();
		String[] ve1 = ve.split(" ");
		int v = Integer.parseInt(ve1[0]);
		
		BFS b = new BFS(v);
		
		int e = Integer.parseInt(ve1[1]);
		
		for(int i = 1;i <= e;i++)
		{
			String edge = br.readLine();
			String[] edge1 = edge.split(" ");
			int x = Integer.parseInt(edge1[0]);
			int y = Integer.parseInt(edge1[1]);
			b.addEdge(x, y);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1;i <= n;i++)
		{
			String query = br.readLine();
			String[] query1 = query.split(" ");
			int vertex = Integer.parseInt(query1[0]);
			int m = Integer.parseInt(query1[1]);
			
			System.out.println(b.getConnectedNodes(b.graph, vertex, m));
		}
	}
}
