import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        int max = 0, current = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input1.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    if(current > max)
                    {
                        max = current;
                    }
                    current = 0;
                }
                else
                {
                    current += Integer.parseInt(line);
                }
            }
        }
        System.out.println(max);
    }
    public static void PartTwo() throws IOException {
        int current = 0;
        int[] top = new int[3];
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input1.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                if(line.isEmpty())
                {
                    if(top[0]<current)
                    {
                        if(top[1]<current)
                        {
                            if(top[2]<current)
                            {
                                top[0] = top[1];
                                top[1] = top[2];
                                top[2] = current;
                            }
                            else
                            {
                                top[0] = top[1];
                                top[1] = current;
                            }
                        }
                        else
                        {
                            top[0] = current;
                        }
                    }
                    current = 0;
                }
                else
                {
                    current += Integer.parseInt(line);
                }
            }
            if(top[0]<current)
            {
                if(top[1]<current)
                {
                    if(top[2]<current)
                    {
                        top[0] = top[1];
                        top[1] = top[2];
                        top[2] = current;
                    }
                    else
                    {
                        top[0] = top[1];
                        top[1] = current;
                    }
                }
                else
                {
                    top[0] = current;
                }
            }
        }
        System.out.println(IntStream.of(top).sum());
        //System.out.println(top[0]+top[1]+top[2]);
    }
}