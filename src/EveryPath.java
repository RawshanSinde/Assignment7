public class EveryPath {
    public static void printCycle(int[][] matrix) {
        //number of vertices in graph
        int n = matrix.length;
        //check if cycle is found
        boolean found = false;
        //pick first vertex
        for (int a = 0; a < n; a++) {
            //pick second vertex
            for (int b = 0; b < n; b++) {
                //pick third vertex
                for (int c = 0; c < n; c++) {
                    //pick fourth vertex
                    for (int d = 0; d < n; d++) {
                        //ensure all 4 vertoces are different
                        if (a != b && a != c && a != d && b != c && b != d && c != d) {
                            //check if edges exist to form the cycle
                            if (matrix[a][b] != 0 && matrix[b][c] != 0 && matrix[c][d] != 0 && matrix[d][a] != 0) {
                                //avoid printing the same cycle multiple times
                                if (a < b && a < c && a < d) {
                                    System.out.println(a + " --> " + b + " --> " + c + " --> " + d + " --> " + a);
                                    found = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No cycle");
        }
    }
}
