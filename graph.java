import java.util.*;
public class graph<T>{
    private boolean edges[][];
    private T labels[];
    public graph(int n){
        boolean[][] tempEdges = new boolean[n][n];
        @SuppressWarnings("unchecked")
        T[] tempVertices = (T[]) new Object[n];
        edges = tempEdges;
        labels = tempVertices;
    }
    public int[] neighbors(int vertex){
        int count = 0;
        for(int i=0; i<labels.length; i++){
            if(edges[vertex][i]){
                count++;
            }
        }
        int[] neighbors = new int[count];
        count = 0;
        for(int i=0; i<labels.length; i++){
            if(edges[vertex][i]){
                neighbors[count++] = i;
            }
        }
        return neighbors;
    }

    public void addEdge(int source, int target){
        edges[source][target] = true;
    }
    public T getLabel(int vertex){
        return labels[vertex];
    }
    public boolean isEdge(int source, int target){
        return edges[source][target];
    }
    public void removeEdge(int source, int target){
        edges[source][target] = false;
    }
    public void setLabel(int vertex, T newLabel){
        labels[vertex] = newLabel;
    }
    public int size(){
        return labels.length;
    }
    public void createGraph(T[] names){
        for(int i=0; i<names.length; i++){
            labels[i] = names[i];
            for(int j=0; j<names.length; j++){
                edges[i][j] = false;
            }
        }
    }
    public Queue<T> breadthFirst(int origin){
        Queue<T> order = new LinkedList<T>();
        Queue<Integer> vertexQueue = new LinkedList<Integer>();
        int current = origin;
        vertexQueue.add(origin);
        while(!vertexQueue.isEmpty()){
            for(int i=0; i<labels.length; i++){
                if(edges[current][i]){
                    vertexQueue.add(i);
                }
            }
            if(!order.contains(labels[vertexQueue.remove()]))
                order.add(labels[current]);
            if(!vertexQueue.isEmpty())
                current = vertexQueue.peek();
        }
        while(!order.isEmpty()){
            System.out.println(order.remove());
        }
        return order;
    }
}