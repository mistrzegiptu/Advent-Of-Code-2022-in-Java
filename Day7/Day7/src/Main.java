import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    static List<Node> nodes = new ArrayList<>();
    static int partOneResult = 0;

    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        Node head = new Node(new ArrayList<>(), null, 0, "/");
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input7.txt")))
        {
            int result = 0;

            Node actualNode = head;
            nodes.add(head);

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
                        if (input[2].equals(".."))
                        {
                            actualNode = actualNode.previous;
                        }
                        else
                        {
                            actualNode = actualNode.dirs.stream()
                                    .filter(x -> x.name.equals(input[2]))
                                    .findAny()
                                    .orElse(actualNode);
                            nodes.add(actualNode);
                        }
                    }
                }
                else if(input[0].equals("dir"))
                {
                    actualNode.dirs.add(new Node(new ArrayList<>(), actualNode, 0, input[1]));
                }
                else
                {
                    if(actualNode != head)
                    {
                        Node node = actualNode.previous;

                        while (node.previous != null)
                        {
                            node.size += Integer.parseInt(input[0]);
                            node = node.previous;
                        }
                        head.size += Integer.parseInt(input[0]);
                    }
                    actualNode.size += Integer.parseInt(input[0]);
                }
            }
        }
        DfsTree(head);
        System.out.println(partOneResult);
    }
    public static void DfsTree(Node n)
    {
        for(Node node: n.dirs)
        {
            if(node.size<100000)
            {
                partOneResult += node.size;
            }
            DfsTree(node);
        }
    }
    public static void PartTwo()
    {
        Collections.sort(nodes, (a, b) -> a.size < b.size ? -1 : a.size == b.size ? 0 : 1);
        int space = 30000000 - (70000000 - nodes.get(nodes.size()-1).size);

        for(int i = 0; i < nodes.size(); i++)
        {
            if(nodes.get(i).size>=space)
            {
                System.out.println(nodes.get(i).size);
                return;
            }
        }
    }
}
class Node
{
    List<Node> dirs = new ArrayList<>();
    Node previous;
    String name;
    public int size;

    public Node(List<Node> dirs, Node previous, int size, String name)
    {
        this.dirs = dirs;
        this.previous = previous;
        this.name = name;
        this.size = size;
    }
}