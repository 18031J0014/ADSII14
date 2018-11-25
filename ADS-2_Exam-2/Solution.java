

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


class Matrix
{
	int V;
	int mat[][];
	Matrix(int V)
	{
		this.V=V;
		mat=new int [V][V];
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				mat[i][j]=0;
	}
	public void addMatrix(int i,int j,int weight)
	{
		mat[i][j]=weight;
		mat[j][i]=weight;
	}
}
class ShortestPath 
{ 
	int V;
    int No_Parent=-1;
    ShortestPath(int v)
    {
    	this.V=v;
    }
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
      
        int min = Integer.MAX_VALUE, min_index=-1;
        
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    
   
    void printSolution(int dist[], int n,int dest) 
    { 
      //  System.out.println("Vertex   Distance from Source"); 
       int count=0;
        for (int i = 0; i < V; i++) {
            //System.out.println(dist[i]); 
        
        	if(i==dest&&dist[i]!=Integer.MAX_VALUE)
        	{
        		count++;
        		System.out.println((float)dist[i]);
        	}
        }
        if(count==0)
        {
        	System.out.println("No Path Found.\r\n" + "");
        }
    } 
   
    
    void dijkstra(int graph[][], int src,int dest) 
    { 
        int dist[] = new int[V];  
        Boolean sptSet[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        }
        dist[src] = 0; 
        int [] Parents=new int [V];
        Parents[src]=No_Parent;
      
        for (int count = 0; count < V-1; count++) 
        { 
        	int u = minDistance(dist, sptSet); 
        	sptSet[u] = true; 
            for (int v = 0; v < V; v++) 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        printSolution(dist, V,dest); 
    }
}

class Edge 
{
@Override
	public String toString() {
		return  v + "-" + w + " " + (float)weight +"0000"+"  ";
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
		{   System.out.print(i +": ");
		 for(int j=adjacentList[i].size()-1;j>=0;j--)
		 {
			System.out.print(adjacentList[i].get(j));
		 }
		 System.out.println();
		 
	 }
	 
 }
}
/*class Shortest{
	 public void dijkstra_GetMinDistances(int sourceVertex,int dest,int vertices){

         boolean[] SPT = new boolean[vertices];
        
         int [] distance = new int[vertices];

         for (int i = 0; i <vertices ; i++) {
             distance[i] = Integer.MAX_VALUE;
         }
         
         PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>()
         {
             @Override
             public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                 //sort using distance values
                 int key1 = p1.getKey();
                 int key2 = p2.getKey();
                 return key1-key2;
             }
         });
        
         distance[0] = 0;
         Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
        
         pq.offer(p0);

         
         while(!pq.isEmpty()){
             //extract the min
             Pair<Integer, Integer> extractedPair = pq.poll();

             
             int extractedVertex = extractedPair.getValue();
             if(SPT[extractedVertex]==false) {
                 SPT[extractedVertex] = true;

                 
                 LinkedList<Edge> list = adjacencylist[extractedVertex];
                 for (int i = 0; i < list.size(); i++) {
                     Edge edge = list.get(i);
                     int destination = edge.destination;
                     if (SPT[destination] == false) {
                         
                         int newKey =  distance[extractedVertex] + edge.weight ;
                         int currentKey = distance[destination];
                         if(currentKey>newKey){
                             Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                             pq.offer(p);
                             distance[destination] = newKey;
                         }
                     }
                 }
             }
         }
        
         printDijkstra(distance, sourceVertex,dest,vertices);
     }

     public void printDijkstra(int[] distance, int sourceVertex,int dest,int vertices){
         //System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
         for (int i = 0; i <vertices ; i++) {
         	if(i==dest) {
             System.out.println(distance[i]);}
         }
         
     }

}*/
public class Solution{
	

	public static void main (String args[])
	{
		Scanner s=new Scanner(System.in);
		int vertices=s.nextInt();
		int edges=s.nextInt();
		Graph g=new Graph(vertices+1);
		for(int i = 0;i<edges;i++)
		{
			int n1=s.nextInt();
			int n2=s.nextInt();
			int n3=s.nextInt();
			g.addEdge(n1, n2, n3);
			
		}
		String st=s.nextLine();
		System.out.println(st);
		String str=s.nextLine();
		
		switch(str)
		{
		case "Graph":
			g.display();
		break;
		/*case "DirectedPaths":Shortest sh=new Shortest();
								int x=s.nextInt();
								int y=s.nextInt();
									
								sh.dijkstra_GetMinDistances(x, y, vertices);
							break;*/
		case "ViaPaths":break;
		}
	}

}

