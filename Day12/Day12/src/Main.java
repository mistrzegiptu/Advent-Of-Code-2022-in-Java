import java.awt.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    //static String[] input = new String[5];
    static String[] input = new String[41];
    static Map<Point, List<Point>> graph = new HashMap<>();
    static List<Point> proceded = new ArrayList<>();
    static int finalResult = Integer.MAX_VALUE;
    static int result = 0, graphSize;
    static int xHead = 20, yHead = 0;
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input12.txt")))
        {
            String line;
            int i = 0;
            while((line = br.readLine()) != null)
            {
                input[i] = line;
                i++;
            }
        }
        List<Point> head = new ArrayList<>();
        head.add(new Point(xHead, yHead+1));
        head.add(new Point(xHead+1,yHead));
        if(xHead>0)
            head.add(new Point(xHead-1, yHead));
        if(yHead>0)
            head.add(new Point(xHead, yHead-1));
        graph.put(new Point(xHead, yHead), head);
        graphSize = input[0].length() * input.length;
        for(int i = 0; i < input.length; i++)
        {
           for(int j = 0; j < input[0].length(); j++)
            {
                if(!graph.containsKey(new Point(i, j)))
                {
                    List<Point> neighbours = new ArrayList<>();
                    if(j<input[0].length()-1 && (input[i].charAt(j+1)==input[i].charAt(j)+1 || (input[i].charAt(j+1)<=input[i].charAt(j) && input[i].charAt(j+1) != 'S' && input[i].charAt(j+1) != 'E') || (input[i].charAt(j) == 'z' && input[i].charAt(j+1) == 'E')))
                        neighbours.add(new Point(i, j+1));
                    if(i<input.length-1 && (input[i+1].charAt(j)==input[i].charAt(j)+1 || (input[i+1].charAt(j)<=input[i].charAt(j) && input[i+1].charAt(j) != 'S' && input[i+1].charAt(j) != 'E') || (input[i].charAt(j) == 'z' && input[i+1].charAt(j) == 'E')))
                        neighbours.add(new Point(i+1, j));
                    if(j>0 && (input[i].charAt(j-1)==input[i].charAt(j)+1 || (input[i].charAt(j-1)<=input[i].charAt(j) && input[i].charAt(j-1) != 'S' && input[i].charAt(j-1) != 'E') || (input[i].charAt(j) == 'z' && input[i].charAt(j-1) == 'E')))
                        neighbours.add(new Point(i, j-1));
                    if(i>0 && (input[i-1].charAt(j)==input[i].charAt(j)+1 || (input[i-1].charAt(j)<=input[i].charAt(j) && input[i-1].charAt(j) != 'S' && input[i-1].charAt(j) != 'E')|| (input[i].charAt(j) == 'z' && input[i-1].charAt(j) == 'E')))
                        neighbours.add(new Point(i-1, j));
                    graph.put(new Point(i,j), neighbours);
                }
            }
        }
        System.out.println(BFS(new Point(xHead, yHead)));
        proceded.clear();
    }
    public static int BFS(Point paramPoint)
    {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(paramPoint);
        Map<Point, Integer> values = new HashMap<>();
        values.put(paramPoint, 0);

        while(!queue.isEmpty())
        {
            Point point = queue.poll();
            for(Point p: graph.get(point))
            {
                if(!values.containsKey(p))
                {
                    values.put(p, values.get(point)+1);
                }
                else
                {
                    if(values.get(p)>values.get(point)+1)
                    {
                        values.replace(p, values.get(point)+1);
                    }
                }
                if(!proceded.contains(p))
                {
                    if (input[p.x].charAt(p.y) == 'E')
                        return values.get(p);
                    else
                    {
                        proceded.add(p);
                        queue.add(p);
                    }
                }
            }
            result++;
        }
        return Integer.MAX_VALUE;
    }
    public static void PartTwo()
    {
        //List<Point> points = new ArrayList<>();
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < input.length; i++)
        {
            for(int j = 0; j < input[0].length(); j++)
            {
                if(input[i].charAt(j) == 'a')
                {
                    int current = BFS(new Point(i, j));
                    if(current<result)
                        result = current;
                    proceded.clear();
                }
            }
        }
        System.out.println(result);
    }
}