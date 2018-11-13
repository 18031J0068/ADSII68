import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution 
{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Graph G = new Graph(br);
		CC c = new CC(G);
		
		c.disp();
		c.disp1();
	}

}
