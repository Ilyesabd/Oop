package Sprint2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gym {
    private static final String DATA_FILE = "src/Sprint2/Gymmets data.txt";
    private static final String TRAINING_FILE = "PersonligTraning.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ange personnummer eller namn: ");
            String input = scanner.nextLine().trim();
            boolean kundHittad = false;

            String line;
            String personnummer = "";
            String namn = "";
            LocalDate betalningsDatum = null;

            while ((line = reader.readLine()) != null) {
                if (personnummer.isEmpty()) {
                    personnummer = line;
                } else if (namn.isEmpty()) {
                    namn = line;
                } else if (betalningsDatum == null) {
                    try {
                        betalningsDatum = LocalDate.parse(line, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (Exception e) {
                        // Felaktigt formaterat datum
                    }
                }

                if (!personnummer.isEmpty() && !namn.isEmpty() && betalningsDatum != null) {
                    if (personnummer.equals(input) || namn.equals(input)) {
                        System.out.println("Kund hittad:");
                        System.out.println("Personnummer: " + personnummer);
                        System.out.println("Namn: " + namn);

                        LocalDate idag = LocalDate.now();

                        if (idag.minusYears(1).isBefore(betalningsDatum)) {
                            System.out.println(namn + " är en betalande kund.");
                            kundHittad = true;
                            saveTrainingData(personnummer, namn);
                        }
                    }

                    personnummer = "";
                    namn = "";
                    betalningsDatum = null;
                }
            }

            if (!kundHittad) {
                System.out.println("Personen är obehörig.");
            }
        } catch (IOException e) {
            System.out.println("Det uppstod ett fel vid läsning av filen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void saveTrainingData(String personnummer, String namn) {
        try (BufferedWriter trainingWriter = new BufferedWriter(new FileWriter(TRAINING_FILE, true))) {
            LocalDate träningsDatum = LocalDate.now();
            trainingWriter.write(personnummer + "," + namn + "," + träningsDatum.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            trainingWriter.newLine();
            System.out.println("Träningsinformation sparad.");
        } catch (IOException e) {
            System.err.println("Det uppstod ett fel vid skrivning av personlig träningsinformation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
