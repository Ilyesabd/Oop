package Sprint1;
import javax.swing.*;


public class Useroptioncalculatefood {
    public class PP {

        public static void performPlantAction(String choiceStr) {
            if (choiceStr != null) {
                try {
                    int choice = Integer.parseInt(choiceStr);

                    if (choice >= 1 && choice <= 4) {
                        switch (choice) {
                            case 1:
                                // Skapar en instans av Cactus och anropar calculateFood-metoden.
                                Cactus igge = new Cactus("Igge", 0.2);
                                igge.calculateFood(igge);
                                break;
                            case 2:
                                PalmTrees laura = new PalmTrees("Laura", 5);
                                laura.calculateFood(laura);
                                break;
                            case 3:
                                PalmTrees olof = new PalmTrees("Olof", 1);
                                olof.calculateFood(olof);
                                break;
                            case 4:
                                CarnivorousPlant meatloaf = new CarnivorousPlant("Meatloaf", 0.7);
                                meatloaf.calculateFood(meatloaf);
                                break;
                        }
                    } else {
                        // Om användaren anger ett ogiltigt nummer.
                        JOptionPane.showMessageDialog(null, "Ogiltigt val. Ange ett nummer mellan 1 och 4.", "Felaktigt val", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    // Om användaren inte angav ett nummer.
                    JOptionPane.showMessageDialog(null, "Felaktig inmatning. Ange ett nummer mellan 1 och 4.", "Felaktig inmatning", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
