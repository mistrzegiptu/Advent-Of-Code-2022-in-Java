import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException {
        int result = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input4.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] pairs = line.split(",");
                String[] first = pairs[0].split("-");
                String[] second = pairs[1].split("-");

                int firstElvX = Integer.parseInt(first[0]), firstElvY = Integer.parseInt(first[1]);
                int secondElvX = Integer.parseInt(second[0]), secondElvY = Integer.parseInt(second[1]);

                if((firstElvX <= secondElvX && firstElvY >= secondElvY) || (secondElvX <= firstElvX && secondElvY >= firstElvY))
                {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static void PartTwo() throws IOException
    {
        int result = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input4.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] pairs = line.split(",");
                String[] first = pairs[0].split("-");
                String[] second = pairs[1].split("-");

                int firstElvX = Integer.parseInt(first[0]), firstElvY = Integer.parseInt(first[1]);
                int secondElvX = Integer.parseInt(second[0]), secondElvY = Integer.parseInt(second[1]);

                if((firstElvX <= secondElvX && firstElvY >= secondElvY) || (secondElvX <= firstElvX && secondElvY >= firstElvY) || (firstElvX <= secondElvY && firstElvY >= secondElvX) || (secondElvX <= firstElvY && secondElvY >= firstElvX))
                {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}