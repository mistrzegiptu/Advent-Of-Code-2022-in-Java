import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    static String[] input = new String[5];
    //static String[] input = new String[41];
    static Map<Point, List<Point>> graph = new HashMap<>();
    static List<Point> proceded = new ArrayList<>();
    static int finalResult = 0;
    static int result = 0, graphSize;
    static int xHead = 0, yHead = 0;
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/test12.txt")))
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
                    if(j<input[0].length()-1 && (input[i].charAt(j+1)==input[i].charAt(j)+1 || (input[i].charAt(j+1)<=input[i].charAt(j) && input[i].charAt(j+1) != 'S') || (input[i].charAt(j) == 'z' && input[i].charAt(j+1) == 'E')))
                        neighbours.add(new Point(i, j+1));
                    if(i<input.length-1 && (input[i+1].charAt(j)==input[i].charAt(j)+1 || (input[i+1].charAt(j)<=input[i].charAt(j) && input[i+1].charAt(j) != 'S') || (input[i].charAt(j) == 'z' && input[i+1].charAt(j) == 'E')))
                        neighbours.add(new Point(i+1, j));
                    if(j>0 && (input[i].charAt(j-1)==input[i].charAt(j)+1 || (input[i].charAt(j-1)<=input[i].charAt(j) && input[i].charAt(j-1) != 'S') || (input[i].charAt(j) == 'z' && input[i].charAt(j-1) == 'E')))
                        neighbours.add(new Point(i, j-1));
                    if(i>0 && (input[i-1].charAt(j)==input[i].charAt(j)+1 || (input[i-1].charAt(j)<=input[i].charAt(j) && input[i-1].charAt(j) != 'S')|| (input[i].charAt(j) == 'z' && input[i-1].charAt(j) == 'E')))
                        neighbours.add(new Point(i-1, j));
                    graph.put(new Point(i,j), neighbours);
                }
            }
        }
        //DFS(new Point(xHead,yHead));
        //System.out.println(finalResult);
        System.out.println(BFS());
    }
    public static int BFS()
    {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(xHead, yHead));


        while(!queue.isEmpty())
        {
            Point point = queue.poll();
            for(Point p: graph.get(point))
            {
                if(!proceded.contains(p))
                {
                    if (input[p.x].charAt(p.y) == 'E')
                        return result;
                    else
                    {
                        proceded.add(p);
                        queue.add(p);
                    }
                }
            }
            result++;
        }
        return result;
    }
    /*public static void DFS(Point point)
    {
        result++;
        proceded.add(point);
        for(Point p: graph.get(point))
        {
            if(!proceded.contains(p))
            {
                if (input[p.x].charAt(p.y) == 'E')
                    finalResult = result;
                else
                {
                    DFS(p);
                }
            }
        }
        //System.out.println(result);
        result--;
    }*/
    public static void PartTwo()
    {

    }
}