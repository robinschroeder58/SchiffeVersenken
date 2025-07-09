public class Map {

    String dash = "---------------------------------";

    public void createMap(String[][] board, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = "| |";
            }
        }
    }

    public void printMap(String[][] map) {
        String[] col = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",};

        System.out.println(dash);
        //Überschrift
        System.out.print("   ");
        for (String tmp : col) {
            System.out.print(" " + tmp + " ");
        }
        System.out.println();

        //Zeilennummerierung
        for (int i = 0; i < map.length; i++) {
            if (i + 1 < 10) {
                System.out.print(" " + (i + 1) + " ");
            } else {
                System.out.print((i + 1) + " ");
            }
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println(dash);
    }
}

