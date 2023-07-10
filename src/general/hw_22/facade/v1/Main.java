package general.hw_22.facade.v1;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory = new FurnitureFactory();

        Furniture chair = factory.createChair("Wood");
        chair.assemble();

        Furniture table = factory.createTable("Glass");
        table.assemble();

        Furniture sofa = factory.createSofa("Leather");
        sofa.assemble();

        Furniture tableTwo = factory.createTable("Wood");
        tableTwo.assemble();

        Furniture sofaTwo = factory.createSofa("Fabric");
        sofaTwo.assemble();

        Furniture chairTwo = factory.createChair("Iron");
        chairTwo.assemble();
    }
}
