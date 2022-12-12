import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    record coords(int x, int y){}
    static List<coords> moves = new ArrayList<>();
    static List<Point> knots = new ArrayList<>();
    static int xHead = 0, yHead = 0, xTail = 0, yTail = 0;

    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input9.txt")))
        {
            moves.add(new coords(0,0));
            String line;
            while((line = br.readLine()) != null)
            {
                char dir = line.split(" ")[0].charAt(0);
                int moveCount = Integer.parseInt(line.split(" ")[1]);

                if(dir=='R')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        yHead++;
                        MoveTail();
                    }
                }
                else if(dir=='L')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        yHead--;
                        MoveTail();
                    }
                }
                else if(dir=='U')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        xHead--;
                        MoveTail();
                    }
                }
                else if(dir=='D')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        xHead++;
                        MoveTail();
                    }
                }
            }
        }
        System.out.println(moves.size());
        moves.clear();
    }
    public static void MoveTail()
    {
        int deltaX = xHead - xTail, deltaY = yHead - yTail;
        if(!(Math.abs(deltaX) <= 1 && Math.abs(deltaY) <= 1))
        {
            xTail += SignOf(deltaX);
            yTail += SignOf(deltaY);
        }
        if(!moves.contains(new coords(xTail, yTail)))
        {
            moves.add(new coords(xTail, yTail));
        }
    }
    public static int SignOf(int n)
    {
        return n == 0 ? 0 : n > 0 ? 1 : -1;
    }
    public static void PartTwo() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input9.txt")))
        {
            moves.add(new coords(0,0));
            for(int i = 0; i < 10; i++)
                knots.add(new Point(0,0));
            String line;
            while((line = br.readLine()) != null)
            {
                char dir = line.split(" ")[0].charAt(0);
                int moveCount = Integer.parseInt(line.split(" ")[1]);

                if(dir=='R')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        knots.get(0).y += 1;
                        for(int j = 1; j < 10; j++)
                        {
                            MoveBody(knots.get(j-1), j);
                        }
                    }
                }
                else if(dir=='L')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        knots.get(0).y -= 1;
                        for (int j = 1; j < 10; j++)
                        {
                            MoveBody(knots.get(j - 1), j);
                        }
                    }
                }
                else if(dir=='U')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        knots.get(0).x -= 1;
                        for(int j = 1; j < 10; j++)
                        {
                            MoveBody(knots.get(j-1), j);
                        }
                    }
                }
                else if(dir=='D')
                {
                    for(int i = 0; i < moveCount; i++)
                    {
                        knots.get(0).x += 1;
                        for(int j = 1; j < 10; j++)
                        {
                            MoveBody(knots.get(j-1), j);
                        }
                    }
                }
            }
        }
        System.out.println(moves.size());
    }
    public static void MoveBody(Point h, int index)
    {
        Point t = knots.get(index);
        int deltaX = h.x - t.x, deltaY = h.y - t.y;
        if(!(Math.abs(deltaX) <= 1 && Math.abs(deltaY) <= 1))
        {
            knots.get(index).x += SignOf(deltaX);
            knots.get(index).y += SignOf(deltaY);
        }
        if(!moves.contains(new coords(knots.get(9).x, knots.get(9).y)))
        {
            moves.add(new coords(knots.get(9).x, knots.get(9).y));
        }
    }
}