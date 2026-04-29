public class DrawGraph {
    public static void buildGraph(String s) {
        //guard if input string is empty
        if (s.length() == 0) {
            System.out.println("Empty graph");
            return;
        }
        //split input into vertex names
        String[] vertices = s.split(" ");
        //number of vertices
        int n = vertices.length;
        //adjacency matrix
        int[][] matrix = new int[n][n];
        //build edges using formula
        for (int i = 0; i < n; i++) {
            //right child index
            int right = (2 * i + 1) % n;
            //left child index
            int left = (2 * i + 2) % n;
            //add edge i to left or right, respectively
            matrix[i][right] = 1;
            matrix[i][left] = 1;
        }
        //print header row in correct format
        System.out.printf("%6s", "");
        for (int i = 0; i < n; i++) {
            System.out.printf("%6s", vertices[i]);
        }
        System.out.println();
        //print matrix rows in correct format
        for (int i = 0; i < n; i++) {
            System.out.printf("%6s",vertices[i]);
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d",matrix[i][j]);
            }

            System.out.println();
        }
    }
}
