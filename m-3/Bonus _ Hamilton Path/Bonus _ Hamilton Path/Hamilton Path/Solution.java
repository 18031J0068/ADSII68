import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution 
{

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Digraph G = new Digraph(br);
		DepthFirstOrder df = new DepthFirstOrder(G);
		df.reversePost();
		df.display(G);

	}

}
