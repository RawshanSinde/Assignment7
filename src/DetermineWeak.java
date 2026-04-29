import java.util.Stack;

public class DetermineWeak {
    public static boolean isWeaklyConnected(int[][] matrix) {
        //number of vertices in graph
        int n = matrix.length;
        //keeps track of which vertices has already been visited
        boolean[] visited = new boolean[n];
        //stack stores vertices we still need to check
        Stack<Integer> vertexStack = new Stack<>();
        //start search at vertex 0
        vertexStack.push(0);

        while (vertexStack.size() > 0) {
            //take one vertex out of stack to examine it
            int curVertex = vertexStack.pop();
            //only investigate vertex if it hasn't been visited before
            if (!visited[curVertex]) {
                //mark this current vertex as visited
                visited[curVertex] = true;
                //check every other vertex to see if it connects to curVertex
                for (int i = 0; i < n; i++) {
                    //matrix[curVertex][i] == 1 means edge exists from curVertex to i (& vice versa)
                    //weakly connected means direction doesn't matter so either direction connected is enough
                    if ((matrix[curVertex][i] == 1 || matrix[i][curVertex] == 1) && !visited[i]) {
                        //save vertex i to visit later
                        vertexStack.push(i);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            //if any vertex was not vistied, graph is not weakly connected
            if (!visited[i]) {
                return false;
            }
        }
        //all vertices were vistied so graph is weakly connected
        return true;
    }
}