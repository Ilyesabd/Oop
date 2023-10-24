package Sprint1;

public class CarnivorousPlant extends Plant implements Food {
    public CarnivorousPlant(String name, double height) {
        super(name, height);
    }
    private double Liquidneeded = 0.1 + (0.2 * getHeight());

    @Override
    public double getLiquidNeeded() {
        return Liquidneeded;
    }
    private String LiquidType = "Proteindryck";

    @Override
    public String getLiquidType() {
        return LiquidType;
    }
}