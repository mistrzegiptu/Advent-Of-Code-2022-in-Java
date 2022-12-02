import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException {
        int score = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input2.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] splittedInput = line.split(" ");
                if(splittedInput[0].equals("A"))
                {
                    if(splittedInput[1].equals("X"))
                    {
                        score += 4;
                    }
                    else if (splittedInput[1].equals("Y"))
                    {
                        score += 8;
                    }
                    else if (splittedInput[1].equals("Z"))
                    {
                        score += 3;
                    }
                } 
                else if (splittedInput[0].equals("B"))
                {
                    if(splittedInput[1].equals("X"))
                    {
                        score += 1;
                    }
                    else if (splittedInput[1].equals("Y"))
                    {
                        score += 5;
                    }
                    else if (splittedInput[1].equals("Z"))
                    {
                        score += 9;
                    }
                }
                else if (splittedInput[0].equals("C"))
                {
                    if(splittedInput[1].equals("X"))
                    {
                        score += 7;
                    }
                    else if (splittedInput[1].equals("Y"))
                    {
                        score += 2;
                    }
                    else if (splittedInput[1].equals("Z"))
                    {
                        score += 6;
                    }
                }
            }
        }
        System.out.println(score);
    }
    public static void PartTwo() throws IOException
    {
        int score = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input2.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] splittedInput = line.split(" ");
                if(splittedInput[0].equals("A"))
                {
                    if(splittedInput[1].equals("X"))
                    {
                        score += 3;
                    }
                    else if (splittedInput[1].equals("Y"))
                    {
                        score += 4;
                    }
                    else if (splittedInput[1].equals("Z"))
                    {
                        score += 8;
                    }
                }
                else if (splittedInput[0].equals("B"))
                {
                    if(splittedInput[1].equals("X"))
                    {
                        score += 1;
                    }
                    else if (splittedInput[1].equals("Y"))
                    {
                        score += 5;
                    }
                    else if (splittedInput[1].equals("Z"))
                    {
                        score += 9;
                    }
                }
                else if (splittedInput[0].equals("C"))
                {
                    if(splittedInput[1].equals("X"))
                    {
                        score += 2;
                    }
                    else if (splittedInput[1].equals("Y"))
                    {
                        score += 6;
                    }
                    else if (splittedInput[1].equals("Z"))
                    {
                        score += 7;
                    }
                }
            }
        }
        System.out.println(score);
    }
}