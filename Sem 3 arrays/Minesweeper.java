public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        // Crear una matriz de caracteres para representar el tablero
        char[][] grid = new char[m][n];

        // Inicializar el tablero con celdas vacías
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        // Colocar minas de manera aleatoria en el tablero
        int count = 0;
        while (count < k) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);

            if (grid[x][y] != '*') {
                grid[x][y] = '*';
                count++;
            }
        }

        // Calcular el número de minas vecinas para cada celda que no contiene una mina
        char[][] mineCounts = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    mineCounts[i][j] = '*';
                } else {
                    int neighborCount = 0;
                    for (int row = i - 1; row <= i + 1; row++) {
                        for (int col = j - 1; col <= j + 1; col++) {
                            if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '*') {
                                neighborCount++;
                            }
                        }
                    }
                    mineCounts[i][j] = (char) (neighborCount + '0');
                }
            }
        }

        // Imprimir el tablero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mineCounts[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
