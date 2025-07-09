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

        String username = "";
        int numberDestroyer = 0;
        int numberCruiser = 0;
        int numberBattleship = 0;

        String welcome = "Willkommen im Spiel Schiffeversenken";

        String menuStartExit = "1: Spiel starten" + "\n" + "2: Spiel beenden" + "\n";

        String menuUsername = "Bitte geben Sie einen Username ein:";
        String menuConfirmedUsername = "Username: " + username + "bestätigen? (y/n):";

        String outputStartGame = "Neues Spiel wird gestartet." + "\n" + "Die See erwartet euch, Kapitän: " + username;

        String outputEntryColumn = "Bitte geben Sie eine Spalte ein.";
        String outputEntryRow = "Bitte geben Sie eine Reihe ein.";
        String outputEntryHorizontally = "Soll es horizontal platzier werden? (y/n):";

        String outputNoPlacmentHappend = "Platzierung fehlgeschlagen. Bitte versuchen Sie es erneut.";

        String outputAllShipPlaced = "Es sind alle Schiffe platziert";
        String outputNotAllShipPlaced = "Es sind noch nicht alle Schiffe platziert!";
        String outputCounterShipPlacedFull = "Es sind alle verfügbaren Schiffe dieser Kategorie platziert worden!";

        String outputInvalidEntry = "Ungültige Eingabe!";

        String menuConfirmExit = "Sicher das Sie das Spiel beenden wollen? (y/n)";
        String outputExit = "Spiel wird beendet!";

        System.out.println("Hello World!");


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