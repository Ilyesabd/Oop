package Sprint1;

import javax.swing.*;

public class Planthotel {
    public static void main(String[] args) {

        String choiceStr = JOptionPane.showInputDialog(null, "Vilken planta vill du ge näring?\n" +
                "1 Cactus Igge\n" + "2 Palmtree Laura\n" + "3 Palmtree Olof\n" + "4 Meatloaf");
        Useroptioncalculatefood.PP.performPlantAction(choiceStr);
    }
}
