import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) throws IOException {
        int numberofRandom = 500000;

        String fileName = "D:\\Documents\\GDrive\\ISEL\\Algoritmos e Estruturas de Dados\\Serie1.2\\";
        fileName += numberofRandom + "Records.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));



        int numberRange = 1000000;
        Random rand = new Random();
        for(int i = 0; i< numberofRandom; ++i) {

            writer.write("updateSet " + rand.nextInt(numberRange) + "\n");

        }
        writer.close();
        System.out.println("file done") ;
    }
}
