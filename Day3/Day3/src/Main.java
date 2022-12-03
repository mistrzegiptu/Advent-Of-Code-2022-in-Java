import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main
{
    static int lines = 0;
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        int result = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input3.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                br.lines();
                String[] input = new String[2];
                String reapets = "";
                int middle = line.length()/2;
                input[0] = line.substring(0, middle);
                input[1] = line.substring(middle);

                for(int i = 0; i < middle; i++)
                {
                    for(int j = 0; j < middle; j++)
                    {
                        if(input[0].charAt(i) == input[1].charAt(j))
                        {
                            reapets += input[0].charAt(i);
                        }
                    }
                }

                reapets = Arrays.asList(reapets.split("")).stream().distinct().collect(Collectors.joining());

                for(int i = 0; i < reapets.length(); i++) {
                    result += GetValue(reapets.charAt(i));
                }
                lines++;
            }
        }
        System.out.println(result);
    }
    public static int GetValue(char c)
    {
        return c >= 97 ? c - 96 : c - 38;
    }
    public static void PartTwo() throws IOException {
        String[] input = new String[3];
        String reapets = "";
        int result = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input3.txt"));
        while(lines-3>=0)
        {
            reapets = "";
            for(int i = 0; i < 3; i++)
            {
                input[i] = br.readLine();
            }
            for(int i = 0; i < input[0].length(); i++)
            {
                for(int j = 0; j < input[1].length(); j++)
                {
                    for(int k = 0; k < input[2].length(); k++)
                    {
                        if (input[0].charAt(i) == input[1].charAt(j) && input[1].charAt(j) == input[2].charAt(k))
                        {
                            reapets += input[0].charAt(i);
                        }
                    }
                }
            }
            reapets = Arrays.asList(reapets.split("")).stream().distinct().collect(Collectors.joining());

            for(int i = 0; i < reapets.length(); i++) {
                result += GetValue(reapets.charAt(i));
            }
            lines -= 3;
        }
        System.out.println(result);
    }
}