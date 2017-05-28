package models;

public class ConsoleBoard extends Board {

    public ConsoleBoard(int sixeX, int sixeY) {
        super(sixeX, sixeY);
    }

    @Override
    public void draw() {
        System.out.println();
        for (int y = 0; y < sixeY; y++) {
            for (int x = 0; x < sixeX; x++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Only for tests
     */
    public void drawDiagonals() {
        int rows = sixeX;
        int cols = sixeY;

        for (int c = 0; c < cols; c++) {
            for (int i = 0, j = c; i < rows && j >= 0; i++, j--) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int r = 1; r < rows; r++) {
            for (int i = r, j = cols - 1; i < rows && j >= 0; i++, j--) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
