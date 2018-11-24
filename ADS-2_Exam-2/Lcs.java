import java.util.ArrayList;
import java.util.Scanner;

class Edge 
{
@Override
	public String toString() {
		return  " "+v + "-" + w + "  " + (float)weight +"0000"+"  ";
	}
public final int v; int w;
public final double weight;
public Edge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
public int v()
{
	return v; 
}
public int w()
{ 
	return w; 
}
public double weight()
{ 
	return  weight; 
}

}
class Graph
{
	private int V,count=0;;
	private ArrayList<Edge>[] adjacentList;
	public Graph(int V)
	{
		this.V = V;
		adjacentList = (ArrayList<Edge>[]) new ArrayList[V+1];
		for (int v = 0; v <=V; v++)
 		adjacentList[v] = new ArrayList<Edge>();
	}
	public void addEdge(int s,int d,double weight)
	{
		count++;
		Edge e=new Edge(s,d,weight);
		Edge e1=new Edge(s,d,weight);
	  	int v = e.v();
	  	int w=e.v();
	  	int x=e.w();
	  	adjacentList[v].add(e);
	  	adjacentList[x].add(e1);
	}
	public Iterable<Edge> adj(int v)
	{ 
		return adjacentList[v];
	}
	public int V()
	{
	  return V;
	}
	public void display()
	{
		System.out.println(V-1+" vertices "+count+" edges");
		for(int i = 0;i<V-1;i++)
		{   System.out.print(i +" :");
		 for(int j=adjacentList[i].size()-1;j>=0;j--)
		 {
			System.out.print(adjacentList[i].get(j));
		 }
		 System.out.println();
		 
	 }
	 
 }
 
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner s=new Scanner(System.in);
		int n1=s.nextInt();
		int n2=s.nextInt();
		Graph g=new Graph(n1+1);
		for(int i = 0;i<n2;i++)
		{
			int n11=s.nextInt();
			int n12=s.nextInt();
			int n13=s.nextInt();
			g.addEdge(n11, n12, n13);
			
		}
		String st=s.nextLine();
		String caseToGo=s.nextLine();
		
		//String caseToGo = null;
		switch (caseToGo) {
		case "Graph":g.display();
			//Print the Graph Object.
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}