package general.hw_22.facade.v1;

class FurnitureFactory {
    public Furniture createChair(String material) {
        return new Chair(material);
    }

    public Furniture createTable(String material) {
        return new Table(material);
    }

    public Furniture createSofa(String material) {
        return new Sofa(material);
    }
}
