import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws Exception
    {
        int pairCounter = 1, result = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/test13.txt")))
        {
            String[] input = new String[2];
            do
            {
                for(int i = 0; i < 2; i++)
                {
                    input[i] = br.readLine();
                }
                if(!Compare(input))
                    result += pairCounter;
                pairCounter++;
            }
            while(br.readLine() != null);
        }
        System.out.println(result);
    }
    public static Boolean Compare(String[] input)
    {
        char[] first = input[0].replace(",", "").toCharArray();
        char[] second = input[1].replace(",", "").toCharArray();
        for(int i = 1; i < first.length; i++)
        {
            if(first[i] == '[' && second[i] == '[')
                continue;
            else if(first[i] == '[' && second[i] < 58)
            {
                if(first[i+1] < 58)
                {

                }
            }
        }
        return false;
    }
    public static void PartTwo()
    {

    }
}