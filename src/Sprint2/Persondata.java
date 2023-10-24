package Sprint2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Persondata {

    public static void main(String[] args) {
        boolean kundHittad = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Sprint2/Gymmets data.txt"))) {
            String line;
            String personnummer = "";
            String namn = "";
            String betalningsDatumStr = "";
            boolean readingName = false;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ange personnummer eller namn: ");
            String input = scanner.nextLine().trim();

            while ((line = reader.readLine()) != null) {
                if (!readingName) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        personnummer = parts[0].trim();
                        namn = parts[1].trim();
                        readingName = true;
                    }
                } else {
                    readingName = false;
                    betalningsDatumStr = line.trim();
                    LocalDate betalningsDatum = LocalDate.parse(betalningsDatumStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate idag = LocalDate.now();

                    if (personnummer.equals(input) || namn.equals(input)) {
                        System.out.println("Kund hittad:");
                        System.out.println("Personnummer: " + personnummer);
                        System.out.println("Namn: " + namn);
                        if (idag.minusYears(1).isBefore(betalningsDatum)) {
                            System.out.println(namn + " är en betalande kund.");
                            kundHittad = true;

                            try (BufferedWriter trainingWriter = new BufferedWriter(new FileWriter("PersonligTraning.txt", true))) {
                                LocalDate träningsDatum = LocalDate.now();
                                trainingWriter.write(personnummer + "," + namn + "," + träningsDatum.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                                trainingWriter.newLine();
                                System.out.println("Träningsinformation sparad.");
                            } catch (IOException e) {
                                System.err.println("Det uppstod ett fel vid skrivning av personlig träningsinformation: " + e.getMessage());
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println(namn + " är en före detta kund.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Det uppstod ett fel vid läsning av filen: " + e.getMessage());
            e.printStackTrace();
        }

        if (!kundHittad) {
            System.out.println("Personen är obehörig.");
        }
    }
}
