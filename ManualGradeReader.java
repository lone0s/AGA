import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManualGradeReader {

    public static double getSur20(double note, double notemax) {
        return ((note*20) / notemax);
    }

    public static double getMoyenne(double[] grades) {
        int cpt = 0;
        double sum = 0;
        for (double grade : grades
             ) {
            sum += grade;
            cpt++;
        }
        return (sum/cpt);
    }

    public static double calculateMoyenne(double[] grades) {
        int cpt = 0;
        int cptarray = 0;
        double[] notes20 = new double[grades.length/2];
        while (cpt != grades.length) {
            double localNote = grades[cpt];
            cpt += 1;
            double localCoef = grades[cpt];
            cpt += 1;
            notes20[cptarray] = getSur20(localNote,localCoef);
            cptarray += 1;
        }
        System.out.println((grades.length)/2);
        return getMoyenne(notes20);
    }

    public static void main(String[] args) {
        boolean isFinished = false;
        System.out.println("---------------------------------------------------------------------");
        System.out.println("___  ___                                          _                \n" +
                "|  \\/  |                                         | |               \n" +
                "| .  . |  ___   _   _   ___  _ __   _ __    __ _ | |_   ___   _ __ \n" +
                "| |\\/| | / _ \\ | | | | / _ \\| '_ \\ | '_ \\  / _` || __| / _ \\ | '__|\n" +
                "| |  | || (_) || |_| ||  __/| | | || | | || (_| || |_ | (_) || |   \n" +
                "\\_|  |_/ \\___/  \\__, | \\___||_| |_||_| |_| \\__,_| \\__| \\___/ |_|   \n" +
                "                 __/ |                                             \n" +
                "                |___/                                              ");

        System.out.println("---------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nThis app is pretty simple\nJust enter your grades and we'll deal with them\nType start to begin\n\n");
        while (!scanner.next().equals("start")) {
            System.out.println("Please type <start>");
        }
        ArrayList<Double> grades = new ArrayList<Double>();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\n\nImagine you've had a 15/25 grade, first enter the 15 and after that the 25\n\n");
        System.out.println("---------------------------------------------------------------------");
        while (!isFinished) {
            System.out.println("\n\n\nFirst the left part of your grade: ");
            try {
                grades.add(scanner.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("Please enter your grade and nothing else");
            }
            System.out.println("\nNow the right part of your grade: ");
            try {
                grades.add(scanner.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("Please enter your grade and nothing else");
            }
            System.out.println("Alright, if you wanna stop type exit, otherwise, you'll be prompted all over again");
            if (scanner.next().equals("exit")) {
                isFinished = true;
            }
        }
        double[] arr = grades.stream().mapToDouble(Double::doubleValue).toArray();
        System.out.println("Wanna see your average?[Y/n]");
        try {
            if (scanner.next().equals("Y")) {
                System.out.println("MOYENNE : [" + calculateMoyenne(arr) + ']');
                //System.out.println(Arrays.toString(arr));
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Jsp");
        }
    }

}
