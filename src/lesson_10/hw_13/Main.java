package lesson_10.hw_13;

import lesson_10.hw_13.coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add("Alex");
        orderBoard.add("Ivan");
        orderBoard.add("Olya");
        orderBoard.add("Katya");
        orderBoard.add("Nikita");

        orderBoard.draw();

        orderBoard.deliver();
        orderBoard.deliver();

        orderBoard.draw();

        orderBoard.deliver(3);
        orderBoard.deliver(5);

        orderBoard.draw();
    }
}
