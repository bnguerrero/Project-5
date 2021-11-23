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
    public Queue<T> depthFirst(int origin){
        Queue<T> order = new LinkedList<T>();
        Stack<Integer> vertexStack = new Stack<>();
        vertexStack.push(origin);
        order.add(labels[origin]);
        while(!vertexStack.isEmpty()){
            int topVertex = vertexStack.peek();
            for(int i=0; i<labels.length; i++){
                if(edges[topVertex][i] && !order.contains(labels[i])){
                    topVertex = i;
                    vertexStack.push(topVertex);
                    order.add(labels[topVertex]);
                    i=0;
                }
            }
            vertexStack.pop();
        }
        while(!order.isEmpty()){
            System.out.println(order.remove());
        }
        return order;
    }
    public Queue<T> breadthFirst(int origin){
        //holds traversal order
        Queue<T> order = new LinkedList<T>();
        Queue<Integer> vertexQueue = new LinkedList<Integer>();
        vertexQueue.add(origin);
        while(!vertexQueue.isEmpty()){
            int current = vertexQueue.peek();
            int[] neighbors = this.neighbors(current);
            for(int x: neighbors){
                vertexQueue.add(x);
            }
            vertexQueue.remove();
            if(!order.contains(labels[current])){
                order.add(labels[current]);
            }
        }
        while(!order.isEmpty()){
            System.out.println(order.remove());
        }
        return order;
    }
}