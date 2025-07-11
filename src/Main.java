import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map map = new Map();

        int size = 10;
        String[][] userBoard = new String[size][size];
        String[][] computerBoard = new String[size][size];

        map.createMap(userBoard, size);
        map.createMap(computerBoard, size);

        Computer pc1 = new Computer();

        String username = "";
        int numberDestroyer = 0;
        int numberCruiser = 0;
        int numberBattleship = 0;

        String symbolDestroyer = "|Z|";
        String symbolCruiser = "|K|";
        String symbolBattleship = "|B|";

        int numberComputerDestroyer = 0;
        int numberComputerCruiser = 0;
        int numberComputerBattleship = 0;

        int destroyerLength = 2;
        int cruiserLength = 3;
        int battleshipLength = 4;

        boolean placeable = true;

        String welcome = "Willkommen im Spiel Schiffeversenken";

        String menuStartExit = "1: Spiel starten" + "\n" + "2: Spiel beenden" + "\n";

        String menuUsername = "Bitte geben Sie einen Username ein:";
        String menuConfirmedUsername = "Username: " + username + "bestätigen? (y/n):";

        String outputStartGame = "Neues Spiel wird gestartet." + "\n" + "Die See erwartet euch, Kapitän: " + username;

        String outputEntryColumn = "Bitte geben Sie eine Spalte ein.";
        String outputEntryRow = "Bitte geben Sie eine Reihe ein.";
        String outputEntryHorizontally = "Soll es horizontal platziert werden? (y/n):";

        String menuPlaying = "1: Schießen" + "\n" + "2: Karte ansehen" + "\n" + "3: Spiel beenden";

        String outputNoPlacmentHappend = "Platzierung fehlgeschlagen. Bitte versuchen Sie es erneut.";

        String outputAllShipPlaced = "Es sind alle Schiffe platziert";
        String outputNotAllShipPlaced = "Es sind noch nicht alle Schiffe platziert!";
        String outputCounterShipPlacedFull = "Es sind alle verfügbaren Schiffe dieser Kategorie platziert worden!";

        String outputInvalidEntry = "Ungültige Eingabe!";

        String menuConfirmExit = "Sicher das Sie das Spiel beenden wollen? (y/n)";
        String outputExit = "Spiel wird beendet!";

        while (true) {

            System.out.println(welcome);
            System.out.println(menuStartExit);

            int entryMenu = scanner.nextInt();
            scanner.nextLine();

            switch (entryMenu) {
                case 1:
                    while (true) {
                        System.out.println(menuUsername);
                        String entryUsername = scanner.nextLine();
                        entryUsername = entryUsername.trim();
                        username = entryUsername;

                        if (!entryUsername.isEmpty()) {
                            System.out.println(menuConfirmedUsername);
                            String confirmUsername = scanner.nextLine().toLowerCase();

                            if (confirmUsername.equals("y")) {
                                System.out.println(outputStartGame);
                                break;
                            } else if (confirmUsername.equals("n")) {
                                System.out.println("Erneuter Versuch.");
                            } else {
                                System.out.println(outputInvalidEntry);
                            }
                        } else {
                            System.out.println("Username darf nicht leer sein.");
                        }
                    }

                    while (true) {
                        map.printMap(userBoard);
                        if (numberDestroyer == 4 && numberCruiser == 2 && numberBattleship == 1) {
                            System.out.println(outputAllShipPlaced);
                        }
                        System.out.println(getMenuShipPlacement(numberDestroyer, numberCruiser, numberBattleship));
                        System.out.println();

                        int entryPlaceShip = scanner.nextInt();
                        scanner.nextLine();

                        switch (entryPlaceShip) {
                            case 1:
                                if (numberDestroyer >= 0 && numberDestroyer < 4) {
                                    //Spalte
                                    System.out.println(outputEntryColumn);
                                    String entryColumn = scanner.nextLine();
                                    entryColumn = entryColumn.toUpperCase().trim();

                                    //Reihe
                                    System.out.println(outputEntryRow);
                                    int entryRow = scanner.nextInt();
                                    scanner.nextLine();

                                    //Horizontal
                                    System.out.println(outputEntryHorizontally);
                                    String entryHorizontal = scanner.nextLine();
                                    entryHorizontal = entryHorizontal.toUpperCase().trim();

                                    //Übergabe an Funktion zum Prüfen des Platzes und platzieren des Schiffes.

                                    placeable = placeShip(userBoard, entryColumn, entryRow, entryHorizontal, destroyerLength, symbolDestroyer);

                                    if (placeable) {
                                        numberDestroyer++;
                                    } else {
                                        System.out.println(outputNoPlacmentHappend);
                                    }
                                } else {
                                    System.out.println(outputCounterShipPlacedFull);
                                }
                                break;
                            case 2:
                                if (numberCruiser >= 0 && numberCruiser < 2) {
                                    //Spalte
                                    System.out.println(outputEntryColumn);
                                    String entryColumn = scanner.nextLine();
                                    entryColumn = entryColumn.toUpperCase().trim();

                                    //Reihe
                                    System.out.println(outputEntryRow);
                                    int entryRow = scanner.nextInt();
                                    scanner.nextLine();

                                    //Horizontal
                                    System.out.println(outputEntryHorizontally);
                                    String entryHorizontal = scanner.nextLine();
                                    entryHorizontal = entryHorizontal.toUpperCase().trim();

                                    //Übergabe an Funktion zum Prüfen des Platzes und platzieren des Schiffes.
                                    placeable = placeShip(userBoard, entryColumn, entryRow, entryHorizontal, cruiserLength, symbolCruiser);

                                    if (placeable) {
                                        numberCruiser++;
                                    } else {
                                        System.out.println(outputNoPlacmentHappend);
                                    }
                                } else {
                                    System.out.println(outputCounterShipPlacedFull);
                                }
                                break;
                            case 3:
                                if (numberBattleship >= 0 && numberBattleship < 1) {
                                    //Spalte
                                    System.out.println(outputEntryColumn);
                                    String entryColumn = scanner.nextLine();
                                    entryColumn = entryColumn.toUpperCase().trim();

                                    //Reihe
                                    System.out.println(outputEntryRow);
                                    int entryRow = scanner.nextInt();
                                    scanner.nextLine();

                                    //Horizontal
                                    System.out.println(outputEntryHorizontally);
                                    String entryHorizontal = scanner.nextLine();
                                    entryHorizontal = entryHorizontal.toUpperCase().trim();

                                    //Übergabe an Funktion zum Prüfen des Platzes und platzieren des Schiffes.
                                    placeable = placeShip(userBoard, entryColumn, entryRow, entryHorizontal, battleshipLength, symbolBattleship);

                                    if (placeable) {
                                        numberBattleship++;
                                    } else {
                                        System.out.println(outputNoPlacmentHappend);
                                    }
                                } else {
                                    System.out.println(outputCounterShipPlacedFull);
                                }
                                break;
                            case 4:
                                if (numberDestroyer == 4 && numberCruiser == 2 && numberBattleship == 1) {

                                    pc1.computerPlaceShips(computerBoard);

                                    while (true) {
                                        System.out.println(menuPlaying);
                                        int entryGameplay = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (entryGameplay) {
                                            case 1:
                                                shooting(map, computerBoard, userBoard, scanner);
                                                pc1.computerShooting(userBoard);
                                                showBoardOverview(map, userBoard, computerBoard);
                                                break;
                                            case 2:
                                                showBoardOverview(map, userBoard, computerBoard);
                                                break;
                                            case 3:
                                                System.out.println(menuConfirmExit);
                                                String confirmExit = scanner.nextLine();
                                                if (confirmExit.equals("y")) {
                                                    System.out.println(outputExit);
                                                    System.exit(0);
                                                }
                                                break;
                                            default:
                                                System.out.println(outputInvalidEntry);
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println(outputNotAllShipPlaced);
                                }
                                break;
                            case 5:
                                showBoardOverview(map, userBoard, computerBoard);
                                break;
                            case 6:
                                System.out.println(menuConfirmExit);
                                String confirmExit = scanner.nextLine();
                                if (confirmExit.equals("y")) {
                                    System.out.println(outputExit);
                                    System.exit(0);
                                }
                                break;
                            default:
                                System.out.println(outputInvalidEntry);
                                break;
                        }
                    }
                case 2:
                    System.out.println(menuConfirmExit);
                    String confirmExit = scanner.nextLine();
                    if (confirmExit.equals("y")) {
                        System.out.println(outputExit);
                        System.exit(0);
                    }
                    System.out.println(outputExit);
                    System.exit(0);

                default:
                    System.out.println(outputInvalidEntry);
                    break;
            }
        }
    }

    public static String getMenuShipPlacement(int numberDestroyer, int numberCruiser, int numberBattleship) {

        return
                "1: Zerstörer platzieren: " + numberDestroyer + "/4" + "\n" +
                        "2: Kreuzer platzieren: " + numberCruiser + "/2" + "\n" +
                        "3: Schlachtschiff platzieren: " + numberBattleship + "/1" + "\n" +
                        "4: Bestätige Schiffeplatzierung" + "\n" +
                        "5: Karte ansehen" + "\n" +
                        "6: Spiel beenden";
    }

    public static void showBoardOverview(Map map, String[][] userBoard, String[][] computerBoard) {
        System.out.println("EIGENE KARTE:");
        map.printMap(userBoard);
        System.out.println("COMPUTER KARTE:");
        map.printMap(computerBoard);
    }

    public static boolean confirmPlace(String[][] board, String column, int row, String horizontal, int shipLength) {

        String outputNoPlace = "Das Schiff kann hier nicht platziert werden";
        String outputPlaceAlreadyOccupied = "Hier ist bereits ein Schiff platziert";

        int colIndex = column.charAt(0) - 'A';
        int rowIndex = row - 1;
        int size = board.length;

        if (horizontal.equals("Y")) {
            if (colIndex + shipLength > size) {
                System.out.println(outputNoPlace);
                return false;
            }
            for (int i = 0; i < shipLength; i++) {
                if (!board[rowIndex][colIndex + i].equals("| |")) {
                    System.out.println(outputPlaceAlreadyOccupied);
                    return false;
                }
            }
        } else { // Vertikal
            if (rowIndex + shipLength > size) {
                System.out.println(outputNoPlace);
                return false;
            }
            for (int i = 0; i < shipLength; i++) {
                if (!board[rowIndex + i][colIndex].equals("| |")) {
                    System.out.println(outputPlaceAlreadyOccupied);
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean placeShip(String[][] userBoard, String column, int row, String horizontal, int shipLength, String shipSymbol) {

        int colIndex = column.charAt(0) - 'A';
        int rowIndex = row - 1;

        boolean placeable = false;

        placeable = confirmPlace(userBoard, column, row, horizontal, shipLength);

        if (placeable) {

            if (horizontal.equals("Y")) {
                for (int i = 0; i < shipLength; i++) {
                    userBoard[rowIndex][colIndex + i] = shipSymbol;
                }
            } else {
                for (int i = 0; i < shipLength; i++) {
                    userBoard[rowIndex + i][colIndex] = shipSymbol;
                }
            }
            return true;
        }
        return false;
    }

    public static void shooting(Map map, String[][] computerBoard, String[][] userBoard, Scanner scanner) {

        String dash = "---------------------------------";

        String outputNeedCoordinates = "Erbitte um Koordinaten!";

        String outputEntryColumn = "Bitte geben Sie eine Spalte ein:";
        String outputEntryRow = "Bitte geben Sie eine Reihe ein:";

        String alreadyShooted = "Dieser Bereich wurde bereits beschossen, bitte erneut versuchen.";

        String fireInTheHole = "FEUER! ----- ";

        while (true) {
            System.out.println(outputNeedCoordinates);
            // Spalte
            System.out.println(outputEntryColumn);
            String entryColumn = scanner.nextLine().toUpperCase().trim();
            int colIndex = entryColumn.charAt(0) - 'A';

            // Reihe
            System.out.println(outputEntryRow);
            int entryRow = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            int rowIndex = entryRow - 1;

            if (computerBoard[rowIndex][colIndex].equals("|X|") || computerBoard[rowIndex][colIndex].equals("|~|")) {
                System.out.println(alreadyShooted);
                showBoardOverview(map, userBoard, computerBoard);
            } else if (computerBoard[rowIndex][colIndex].equals("|Z|") || computerBoard[rowIndex][colIndex].equals("|K|") || computerBoard[rowIndex][colIndex].equals("|B|")) {
                computerBoard[rowIndex][colIndex] = "|X|";
                System.out.println("TREFFER!!! : " + entryColumn + " " + entryRow + "!");
                showBoardOverview(map, userBoard, computerBoard);
                System.out.println(dash);
            } else {
                computerBoard[rowIndex][colIndex] = "|~|";
                System.out.println("Daneben: " + entryColumn + " " + entryRow + ".");
                break;
            }
        }

        System.out.println(fireInTheHole);

        if (validGameBoard(computerBoard)) {
            System.exit(0);
        }
    }

    public static boolean validGameBoard(String[][] gameBoard){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {

                if (gameBoard[i][j].equals("|Z|") || gameBoard[i][j].equals("|K|") || gameBoard[i][j].equals("|B|")){
                    return false;
                }
            }
        }
        System.out.println("Alle Schiffe zerstört – Sieg!");
        return true;
    }

    public static boolean validUserInput(char colIndex, int rowIndex){
        if (colIndex < 'A' || colIndex >= 'J' || rowIndex < 0 || rowIndex >= 10){
            System.out.println("Ungültige Koordinaten!");
            return false;
        }
        return true;
    }
}
