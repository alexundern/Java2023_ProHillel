package general.hw_22.facade.v1;

class Chair extends Furniture {
    public Chair(String material) {
        super("Chair", 100.0, material);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a chair");
    }
}
