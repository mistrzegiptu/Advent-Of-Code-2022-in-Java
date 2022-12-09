import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    static int[][] input;
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        String line;
        int count = 0, result = 0;
        Boolean inputCreated = false;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input8.txt")))
        {
            while((line = br.readLine()) != null)
            {
                String[] splitted = line.split("");
                if(!inputCreated)
                {
                    input = new int[line.length()][line.length()];
                    inputCreated = true;
                }
                for(int i = 0; i < line.length(); i++)
                {
                    input[count][i] = Integer.parseInt(splitted[i]);
                }
                ++count;
            }
        }
        for(int i = 1; i < input.length-1; i++)
        {
            for(int j = 1; j < input[0].length-1; j++)
            {
                result += SidesCount(i,j) ? 1 : 0;
            }
        }
        result += 4*input.length - 4;
        System.out.println(result);
    }
    public static Boolean SidesCount(int x, int y)
    {
        Boolean isVisible = true;

        for(int i = 0; i < y; i++)             //  ------>
        {
            if(input[x][y] <= input[x][i])
            {
                isVisible = false;
                break;
            }
        }
        if(isVisible)
            return true;
        isVisible = true;
        for(int i = input.length-1; i > y; i--)    //  <------
        {
            if(input[x][y] <= input[x][i])
            {
                isVisible = false;
                break;
            }
        }
        if(isVisible)                       //  |
            return true;                    //  |
        isVisible = true;                   //  |
                                            //  |
        for(int i = 0; i < x; i++)          //  |
        {                                   //  |
            if(input[x][y] <= input[i][y])  //  V
            {
                isVisible = false;
                break;
            }
        }
        if(isVisible)                                   //  ^
            return true;                                //  |
        isVisible = true;                               //  |
                                                        //  |
        for(int i = input.length-1; i > x; i--)         //  |
        {                                               //  |
            if(input[x][y] <= input[i][y])              //  |
            {
                isVisible = false;
                break;
            }
        }
        if(isVisible)
            return true;
        return false;
    }
    public static void PartTwo()
    {
        int scenicScore = 0, result = 0;

        for(int i = 1; i < input.length-1; i++)
        {
            for(int j = 1; j < input[0].length-1; j++)
            {
                result = CalculateScenicScore(i, j);
                if(result > scenicScore)
                    scenicScore = result;
            }
        }
        System.out.println(scenicScore);
    }
    public static int CalculateScenicScore(int x, int y)
    {
        int result = 1, treeCount = 0, i;

        // TO RIGHT
        i = y+1;
        while(i < input.length && input[x][y] > input[x][i])
        {
            treeCount++;
            i++;
        }

        if(i < input.length)
            treeCount++;
        if(treeCount>0)
            result *= treeCount;
        treeCount = 0;

        // TO LEFT
        i = y-1;
        while(i >= 0 && input[x][y] > input[x][i])
        {
            treeCount++;
            i--;
        }

        if(i > 0)
            treeCount++;
        if(treeCount>0)
            result *= treeCount;
        treeCount = 0;

        // TO BOTTOM
        i = x+1;
        while(i < input.length && input[x][y] > input[i][y])
        {
            treeCount++;
            i++;
        }

        if(i < input.length)
            treeCount++;
        if(treeCount>0)
            result *= treeCount;
        treeCount = 0;

        // TO TOP
        i = x-1;
        while(i >= 0 && input[x][y] > input[i][y])
        {
            treeCount++;
            i--;
        }

        if(i > 0)
            treeCount++;
        if(treeCount>0)
            result *= treeCount;
        treeCount = 0;

        return result != 1 ? result : 0;
    }
}