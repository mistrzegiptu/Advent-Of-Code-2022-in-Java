import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/test7.txt")))
        {
            Node head = new Node(new ArrayList<>(), 0, "/");
            Node actualNode = head;
            br.readLine();
            br.readLine();
            String line;
            while((line = br.readLine()) != null)
            {
                String[] input = line.split(" ");
                if(input[0].equals("$"))
                {
                    if(input[1].equals("cd"))
                    {
                        actualNode = actualNode.dirs.stream().filter(x -> x.name.equals(input[2])).findAny().orElse(actualNode);
                    }
                }
                else if(input[0].equals("dir"))
                {
                    actualNode.dirs.add(new Node(new ArrayList<>(), 0, input[1]));
                }
                else
                {
                    head.size += Integer.parseInt(input[0]);
                    actualNode.size += Integer.parseInt(input[0]);
                }
            }
        }
    }
    public static void PartTwo()
    {

    }
}
class Node
{
    List<Node> dirs = new ArrayList<>();
    String name;
    public int size;

    public Node(List<Node> dirs, int size, String name)
    {
        this.dirs = dirs;
        this.name = name;
        this.size = size;
    }
}