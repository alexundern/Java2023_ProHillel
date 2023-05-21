public class SubGeneration {

    public static Subscriber[]generateSubArray() {

        Subscriber [] array = new Subscriber[7];

        array [0] = new Subscriber(1212, "Pushkin",
                "Oleksander", "New Jersey", "+380950000001",
                "548", 335.50, 25,
                58, 5);

        array [1] = new Subscriber(982, "Block",
                "Olexander", "New York", "+380950000012",
                "149", 125.77, 37,
                14, 5);

        array [2] = new Subscriber(123, "Tolstoy",
                "Lev", "Miami", "+380954853311",
                "447", 700.52, 50,
                55, 10);

        array [3] = new Subscriber(854, "Turgenev",
                "Ivan", "Oklahoma", "+380954854735",
                "478", 400.29, 55,
                20, 12);

        array [4] = new Subscriber(1124, "Gogol",
                "Nikolay", "Baltimore", "+380957435685",
                "723", 325.47, 36,
                40, 11);

        array [5] = new Subscriber(1214, "Bulgakov",
                "Mikhail", "Baffalo", "+380957437745",
                "653", 827.88, 45,
                50, 15);

        array [6] = new Subscriber(124, "Korolenko",
                "Vladimir", "Odessa", "+380957437745",
                "653", 827.88, 45,
                50, 15);

        return array;

    }
}
