public class graphtest {
    public static void main(String[] args){
        Character[] arr = {'A','B','C','D','E','F','G','H','I'};
        graph<Character> testGraph = new graph<>(9);
        testGraph.createGraph(arr);
        testGraph.addEdge(0,1);
        testGraph.addEdge(0,3);
        testGraph.addEdge(0,4);
        testGraph.addEdge(1,4);
        testGraph.addEdge(2,1);
        testGraph.addEdge(3,6);
        testGraph.addEdge(4,5);
        testGraph.addEdge(4,7);
        testGraph.addEdge(5,7);
        testGraph.addEdge(5,2);
        testGraph.addEdge(6,7);
        testGraph.addEdge(7,8);
        testGraph.addEdge(8,5);
        testGraph.breadthFirst(0);
    }
}
