// package Arrays_03;

public class Minesweeper {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] matrix = new int[m][n];

        int minesPlaced = 0;
        while (minesPlaced < k) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);

            if (matrix[x][y] != -1) {
                matrix[x][y] = -1;
                minesPlaced++;
            }
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) continue;

                int count = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] == -1) {
                        count++;
                    }
                }
                matrix[i][j] = count;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) System.out.print("*  ");
                else System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
