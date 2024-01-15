import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        boolean repeat = false;
        String rec;
        ArrayList <String>recs = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTextData.txt");

        do {
            ID = SafeInputs.getNonZeroLenString(in, "enter your ID");
            firstName = SafeInputs.getNonZeroLenString(in, "enter your first name");
            lastName = SafeInputs.getNonZeroLenString(in, "enter your last name");
            title = SafeInputs.getNonZeroLenString(in, "enter your title");
            YOB = SafeInputs.getRangedInt(in, "enter your year of birth", 1, 2021);
            rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB + ".";

            recs.add(rec);

            repeat = SafeInputs.getYNConfirm("are you done?");

        }
        while (!repeat);

        System.out.println(recs);

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String r : recs)
            {
                writer.write(r, 0, r.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
