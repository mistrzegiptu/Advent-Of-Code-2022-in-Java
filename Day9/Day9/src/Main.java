import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    static char[][] input = new char[10][10];
    static record Point(int x, int y){};
    static List<Point> moves = new ArrayList<>();
    static int size = 6;
    static int xHead = size-1, yHead = 0, xTail = size-1, yTail = 0;

    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/test9.txt")))
        {
            String line;
            Boolean firstMove = true;
            while((line = br.readLine()) != null)
            {
                char dir = line.split(" ")[0].charAt(0);
                int moveCount = Integer.parseInt(line.split(" ")[1]);

                if(dir=='R')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        yHead++;
                        if(firstMove)
                        {
                            firstMove = false;
                            continue;
                        }
                        MoveTail();
                    }
                }
                else if(dir=='L')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        yHead--;
                        if(firstMove)
                        {
                            firstMove = false;
                            continue;
                        }
                        MoveTail();
                    }
                }
                else if(dir=='U')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        xHead--;
                        if(firstMove)
                        {
                            firstMove = false;
                            continue;
                        }
                        MoveTail();
                    }
                }
                else if(dir=='D')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        xHead++;
                        if(firstMove)
                        {
                            firstMove = false;
                            continue;
                        }
                        MoveTail();
                    }
                }
            }
        }
        System.out.println(moves.size());
    }
    public static void MoveTail()
    {
        if(xHead == xTail)
        {
            if(yHead>yTail)
            {
                yTail++;
            }
            else if(yHead<yTail)
            {
                yTail--;
            }
        }
        else if(yHead == yTail)
        {
            if(xHead>xTail)
            {
                xHead++;
            }
            else if(xHead<xTail)
            {
                xHead--;
            }
        }
        else
        {
            if(Math.abs(xHead-xTail)>1||Math.abs(yHead-yTail)>1)
            {
                if (xHead > xTail)
                {
                    if (yHead > yTail)
                    {
                        xTail++;
                        yTail++;
                    }
                    else
                    {
                        xTail++;
                        yTail--;
                    }
                }
                else if (xHead < xTail)
                {
                    if (yHead > yTail)
                    {
                        xTail--;
                        yTail++;
                    } else
                    {
                        xTail--;
                        yTail--;
                    }
                }
            }
        }
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(i==xTail&&j==yTail)
                    System.out.print("T");
                else if(i==xHead&&j==yHead)
                    System.out.print("H");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        if(!moves.contains(new Point(xTail, yTail)))
        {
            moves.add(new Point(xTail, yTail));
        }
    }
    public static void PartTwo()
    {

    }
}