public class Computer {
    public void computerShooting(String[][] userBoard) {


        String fireInTheHole = "FEUER! ----- ";
        String alreadyShooted = "Dieser Bereich wurde bereits beschossen, bitte erneut versuchen.";

        int rowIndex;
        int colIndex;


        while (true) {

            colIndex = generateCoordinates();
            rowIndex = generateCoordinates();

            if (userBoard[rowIndex][colIndex].equals("|X|") || userBoard[rowIndex][colIndex].equals("|~|")) {

            } else{

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
        //generier eine zufällig Zahl zwischen 0 - 10 -> für den Index
        return (int) Math.floor(Math.random() * 10);
    }

}
