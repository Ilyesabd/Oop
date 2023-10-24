package Sprint1;

import javax.swing.*;

abstract class Plant implements Food{
    private String name;
    private double height;

    public Plant(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }


    public void calculateFood(Food f) {
        double liquidRequirement = getLiquidNeeded();
        String liquidType = f.getLiquidType();
        System.out.println("lq "+liquidType);
        String info = (getName() + " ska få " + liquidRequirement + " liter " + liquidType + " per dag.");
        JOptionPane.showMessageDialog(null, info);
    }
}

