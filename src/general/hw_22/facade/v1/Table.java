package general.hw_22.facade.v1;

class Table extends Furniture {
    public Table(String material) {
        super("Table", 200.0, material);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a table");
    }
}
