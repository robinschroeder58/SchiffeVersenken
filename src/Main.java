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