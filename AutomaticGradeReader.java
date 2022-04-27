import FileReader.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class AutomaticGradeReader {
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
        System.out.println("Would You like me to read your grades [Yes/No]?");
        try {
            if (scanner.next().equals("Yes")) {
                fileReader fileReader = new fileReader();
                System.out.println("How Many Grades am i supposed to read ?");
                try {
                    int nbGrades = scanner.nextInt();
                    Double[] grades = new Double[nbGrades * 2];
                    try {
                        grades = fileReader.gradeReader(new File("E:\\ohno\\Documents\\JavaFX\\MoyenneUniv\\src\\Grades\\Grades.txt"), nbGrades);
                        System.out.println("Your grades :");
                        System.out.println(Arrays.toString(grades));
                        System.out.println("Would You like me to calculate your average on 20?[Yes/No]");
                        try{
                            if(scanner.next().equals("Yes")) {
                                double res = ManualGradeReader.calculateMoyenne(Stream.of(grades).mapToDouble(Double::doubleValue).toArray());
                                System.out.println("Your average is: [" + res + "/20]");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Erreur file not accessible");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("GoodBye ://");
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        };
        timer.schedule(timerTask,new Date(System.currentTimeMillis()+ 3 * 1000));
    }
}
