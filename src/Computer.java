public class Computer {
    public void computerShooting(String[][] userBoard) {
        String fireInTheHole = "FEUER! ----- ";

        int rowIndex;
        int colIndex;


        while (true) {

            colIndex = generateCoordinates();
            rowIndex = generateCoordinates();

            if (userBoard[rowIndex][colIndex].equals("|X|") || userBoard[rowIndex][colIndex].equals("|~|")) {
                System.out.println("pc1 berechnet erneut");
            } else {

                int entryColumn = (char) ('A' + colIndex);
                int entryRow = rowIndex + 1;

                // Treffer auf Schiff
                if (userBoard[rowIndex][colIndex].equals("|Z|") || userBoard[rowIndex][colIndex].equals("|K|") || userBoard[rowIndex][colIndex].equals("|B|")) {
                    userBoard[rowIndex][colIndex] = "|X|";
                    System.out.println("Treffer bei " + entryColumn + " " + entryRow + "!");
                    // Computer darf nochmal schießen – Schleife läuft weiter
                } else {
                    // Daneben → Wasser
                    userBoard[rowIndex][colIndex] = "|~|";
                    System.out.println("Daneben bei " + entryColumn + " " + entryRow + ".");
                    break;
                }
            }
        }
        System.out.println(fireInTheHole);
    }

    public int generateCoordinates() {
        //generier eine zufällig Zahl zwischen 0 - 9 -> für den Index
        return (int) Math.floor(Math.random() * 10);
    }

    public int generateHorizontal() {
        return (int) Math.floor(Math.random() * 2);
    }

    public void computerPlaceShips(String[][] computerBoard) {

        int placedDestroyer = 0;
        int placedCruiser = 0;
        int placedBattleships = 0;
        int counter = 0;

        // Schleife bis alle Schiffe platziert sind
        while (placedDestroyer < 4 || placedCruiser < 2 || placedBattleships < 1) {
            int rowIndex = generateCoordinates();
            int colIndex = generateCoordinates();
            int horizontal = generateHorizontal();

            if (placedDestroyer < 4 && confirmPlace(computerBoard, colIndex, rowIndex, horizontal, 2)) {
                placeShip(computerBoard, colIndex, rowIndex, horizontal, 2);
                placedDestroyer++;
            } else if (placedCruiser < 2 && confirmPlace(computerBoard, colIndex, rowIndex, horizontal, 3)) {
                placeShip(computerBoard, colIndex, rowIndex, horizontal, 3);
                placedCruiser++;
            } else if (placedBattleships < 1 && confirmPlace(computerBoard, colIndex, rowIndex, horizontal, 4)) {
                placeShip(computerBoard, colIndex, rowIndex, horizontal, 4);
                placedBattleships++;
            }
            counter++;
            System.out.println(counter);
        }

    }

    public static boolean confirmPlace(String[][] computerBoard, int colIndex, int rowIndex, int horizontal, int shipLength) {

        int size = computerBoard.length;

        if (horizontal == 1) {
            if (colIndex + shipLength > size) {
                return false;
            }
            for (int i = 0; i < shipLength; i++) {
                if (!computerBoard[rowIndex][colIndex + i].equals("| |")) {
                    return false;
                }
            }
        } else { // Vertikal
            if (rowIndex + shipLength > size) {
                return false;
            }
            for (int i = 0; i < shipLength; i++) {
                if (!computerBoard[rowIndex + i][colIndex].equals("| |")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeShip(String[][] computerBoard, int colIndex, int rowIndex, int horizontal, int shipLength) {
        int size = computerBoard.length;

        // Sicherheitsprüfung (obwohl confirmPlace das schon machen sollte)
        if (horizontal == 0 && colIndex + shipLength > size) return;
        if (horizontal == 1 && rowIndex + shipLength > size) return;

        if (horizontal == 0) { // Horizontal
            for (int i = 0; i < shipLength; i++) {
                if (shipLength == 2){
                    computerBoard[rowIndex][colIndex + i] = "|Z|";
                } else if (shipLength == 3){
                    computerBoard[rowIndex][colIndex + i] = "|K|";
                }
                else if (shipLength == 4){
                    computerBoard[rowIndex][colIndex + i] = "|B|";
                }
            }
        } else { // Vertikal
            for (int i = 0; i < shipLength; i++) {
                if (shipLength == 2){
                    computerBoard[rowIndex + i][colIndex] = "|Z|";
                } else if (shipLength == 3){
                    computerBoard[rowIndex + i][colIndex] = "|K|";
                } else if (shipLength == 4){
                    computerBoard[rowIndex + i][colIndex] = "|B|";
                }
            }
        }
    }

}
