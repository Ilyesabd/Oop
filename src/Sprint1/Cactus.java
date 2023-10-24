package Sprint1;

public class Cactus extends Plant implements Food {
    public Cactus(String name, double height) {
        super(name, height);

    }
    private double Liquidneeded = 0.02;

    @Override
    public double getLiquidNeeded() {
        return Liquidneeded;
    }
private String LiquidType = "Mineralvatten";
    @Override
    public String getLiquidType() {
        return LiquidType;
    }
}
