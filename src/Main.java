public class Main {
    public static void main(String[] args) {


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