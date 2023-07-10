package general.hw_22.facade.v1;

abstract class Furniture {
    protected String name;
    protected double price;
    protected String material;

    public Furniture(String name, double price, String material) {
        this.name = name;
        this.price = price;
        this.material = material;
    }

    public abstract void assemble();

    public void disassemble() {
        System.out.println("Disassembling the furniture");
    }

    public void polish() {
        System.out.println("Polishing the furniture");
    }

    public void paint(String color) {
        System.out.println("Painting the furniture with color: " + color);
    }

    public void clean() {
        System.out.println("Cleaning the furniture");

    }
}
