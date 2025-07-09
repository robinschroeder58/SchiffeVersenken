public class Map {

    public void createMap(String[][] board, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = "| |";
            }
        }
    }
}

