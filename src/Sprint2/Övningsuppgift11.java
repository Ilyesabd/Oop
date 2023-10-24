package Sprint2;

import java.time.LocalTime;
import java.util.Scanner;
import java.time.Duration;
import java.util.zip.ZipFile;


public class Övningsuppgift11 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hur många minuter kan bandet spela in?");
        int totalTidMinuter = scan.nextInt();
        LocalTime nuvarandeTid = LocalTime.now();
        Duration recordingTime = Duration.ofMinutes(totalTidMinuter);
        LocalTime slutTidpunkt = nuvarandeTid.plus(recordingTime);
        Duration currentRecordedTime = Duration.between(nuvarandeTid, slutTidpunkt);

        System.out.println("Inspelet påbörjades kl " + nuvarandeTid);
        System.out.println("Inspelet kommer att sluta kl " + slutTidpunkt);
        System.out.println("Hittills använd tid: " + currentRecordedTime.toMinutes() + " minuter");

        scan.close();
    }
}






