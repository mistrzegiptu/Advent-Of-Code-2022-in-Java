import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        int result = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input10.txt")))
        {
            String line;
            int x = 1, counter = 0;
            while((line = br.readLine()) != null)
            {
                if(line.equals("noop"))
                {
                    counter++;
                    if(counter==20||counter==60||counter==100||counter==140||counter==180||counter==220)
                    {
                        result += counter*x;
                    }
                }
                else if(line.startsWith("addx"))
                {
                    int value = Integer.parseInt(line.split(" ")[1]);
                    for(int i = 0; i < 2; i++)
                    {
                        counter++;
                        if(counter==20||counter==60||counter==100||counter==140||counter==180||counter==220)
                        {
                            result += counter*x;
                        }
                        if(i==1)
                        {
                            x += value;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static void PartTwo() throws IOException
    {
        int result = 0, x = 1;
        String[] output = new String[6];
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input10.txt")))
        {
            int i = 0;
            String line = "", input;
            for(int counter = 0; counter < 260;)
            {
                input = br.readLine();
                if(input == null)
                {
                    output[i] = line;
                    break;
                }
                if(input.equals("noop"))
                {
                    counter++;
                    if(counter%40==1 && counter != 1)
                    {
                        output[i] = line;
                        line = "";
                        i++;
                    }
                    if(x%40==counter%40||(x+1)%40==counter%40||(x+2)%40==counter%40)
                    {
                        line += "#";
                    }
                    else
                    {
                        line += ".";
                    }
                }
                else if(input.startsWith("addx"))
                {
                    for(int j = 0; j < 2; j++)
                    {
                        counter++;
                        if(counter%40==1 && counter != 1)
                        {
                            output[i] = line;
                            line = "";
                            i++;
                        }
                        if(x%40==counter%40||(x+1)%40==counter%40||(x+2)%40==counter%40)
                        {
                            line += "#";
                        }
                        else
                        {
                            line += ".";
                        }
                        if(j==1)
                        {
                            x += Integer.parseInt(input.split(" ")[1]);
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 6; i++)
        {
            System.out.println(output[i]);
        }
    }
}