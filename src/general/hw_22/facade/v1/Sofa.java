package general.hw_22.facade.v1;

class Sofa extends Furniture {
    public Sofa(String material) {
        super("Sofa", 500.0, material);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a sofa");
    }
}
