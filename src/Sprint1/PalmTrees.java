package Sprint1;

public class PalmTrees extends Plant implements Food {
    public PalmTrees (String name, double height) {
        super(name, height);
    }
private double Liquidneeded = 0.5 * getHeight();
    @Override
    public double getLiquidNeeded() {
        return Liquidneeded;
    }
    private String LiquidType = "Kranvatten";

    @Override
    public String getLiquidType() {
        return LiquidType;
    }
}

