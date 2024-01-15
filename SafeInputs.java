import java.util.Scanner;

public class SafeInputs {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner pipe, String prompt){
        int retInt = 0;
        String empty;
        int tf = 0;
        do{
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNextInt()){
                retInt = pipe.nextInt();
                pipe.nextLine();
                tf = 1;
            }else{
                empty=pipe.nextLine();
                System.out.print(empty+" is not valid");
            }
        }while(tf==0);

        return retInt;
    }
    public static double getDouble(Scanner pipe, String prompt){
        double retDouble = 0;
        String empty;
        int tf = 0;
        do{
            System.out.print("\n" +prompt + ": ");
            if(pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                tf = 1;
            }else{
                empty=pipe.nextLine();
                System.out.print(empty+" is not valid");
            }
        }while(tf==0);

        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int retRangedInt = 0;
        String empty;
        int tf = 0;
        do{
            System.out.print("\n" +prompt);
            if(pipe.hasNextInt()){
                retRangedInt = pipe.nextInt();
                pipe.nextLine();
                if (retRangedInt >= low && retRangedInt <= high){
                    tf = 1;
                }else{
                    System.out.print(retRangedInt+" is not valid within the range");
                }
            }else{
                empty=pipe.nextLine();
                System.out.print(empty+" is not valid");
            }
        }while(tf==0);

        return retRangedInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double retRangedDouble = 0;
        String empty;
        int tf = 0;
        do{
            System.out.print("\n" +prompt);
            if(pipe.hasNextDouble()){
                retRangedDouble = pipe.nextDouble();
                pipe.nextLine();
                if (retRangedDouble >= low && retRangedDouble <= high){
                    tf = 1;
                }else{
                    System.out.print(retRangedDouble+" is not valid within the range");
                }
            }else{
                empty=pipe.nextLine();
                System.out.print(empty+" is not valid");
            }
        }while(tf==0);

        return retRangedDouble;
    }
    public static String getYNConfirm(Scanner pipe, String prompt) {

        String response;
        boolean invalid;
        String trash;
        do {
            System.out.println(prompt + " :");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                invalid = false;
            } else if (response.equalsIgnoreCase("N")) {
                invalid = false;
            } else {
                invalid = true;
            }
        } while (invalid);
        return response;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String Line = "";
        String retPattern = "";
        int tf = 0;
        String empty;
        do{
            System.out.print("\n" +prompt + ": ");
            Line = pipe.nextLine();
            if(Line.matches(regEx)){
                retPattern = Line;
                tf = 1;
            }else{
                empty=Line;
                System.out.print(empty+" is not valid");
            }
        }while(tf==0);

        return retPattern;
    }
    public static void prettyHeader(String msg) {
        int rows = 60;
        int sides = 0;
        sides = (54 - msg.length()) / 2;

        for (int i = 1; i <= rows; ++i) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i <= 3; ++i) {
            System.out.print("*");
        }
        for (int i = 1; i <= sides; ++i) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 1; i <= sides; ++i) {
            System.out.print(" ");
        }
        for (int i = 1; i <= 3; ++i) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i <= rows; ++i) {
            System.out.print("*");
        }
    }
}
