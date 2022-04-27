package FileReader;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class fileReader {
    //public double[] grades;

    public Double[] gradeReader(File file, int nbGrades) throws FileNotFoundException {
        Scanner scanner = new Scanner(file).useDelimiter("/|;");
        Double[] note = new Double[nbGrades*2];
        for (int i = 0 ; i < note.length ; i++) {
            note[i] = scanner.nextDouble();
        }
        return note;
    }

    public static void main(String[] args) throws FileNotFoundException {


    }
}
