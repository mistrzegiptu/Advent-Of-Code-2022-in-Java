import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        List<Deque<Character>> stacks = new ArrayList<Deque<Character>>();
        boolean commands = false;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input5.txt")))
        {
            String line = br.readLine();
            if(line != null)
            {
                for(int i = 0; i < line.length(); i+=4)
                {
                    if(!Character.toString(line.charAt(i+1)).equals(" "))
                    {
                        Deque<Character> aa = new LinkedList<Character>();
                        aa.add(line.charAt(i+1));
                        stacks.add(aa);
                    }
                    else
                    {
                        stacks.add(new LinkedList<>());
                    }
                }
            }
            while ((line = br.readLine()) != null)
            {
                if(!commands)
                {
                    if (!line.startsWith(" 1   2 "))
                    {
                        for (int i = 0, index = 0; i < line.length(); i += 4, index++)
                        {
                            if(!Character.toString(line.charAt(i + 1)).equals(" "))
                            {
                                stacks.get(index).add(line.charAt(i + 1));
                            }
                        }
                    }
                    else
                    {
                        commands = true;
                        br.readLine();
                        continue;
                    }
                }
                else
                {
                    String[] command = line.split(" ");
                    int count = Integer.parseInt(command[1]);
                    int from = Integer.parseInt(command[3])-1;
                    int into = Integer.parseInt(command[5])-1;

                    for(int counter = 0; counter < count; counter++)
                    {
                        char c = stacks.get(from).poll();
                        stacks.get(into).addFirst(c);
                    }
                }
            }
        }
        for(int i = 0; i < stacks.size(); i++)
        {
            System.out.print(stacks.get(i).peek());
        }
        System.out.println();
    }
    public static void PartTwo() throws IOException
    {
        List<Deque<Character>> stacks = new ArrayList<Deque<Character>>();
        boolean commands = false;
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input5.txt")))
        {
            String line = br.readLine();
            if(line != null)
            {
                for(int i = 0; i < line.length(); i+=4)
                {
                    if(!Character.toString(line.charAt(i+1)).equals(" "))
                    {
                        Deque<Character> aa = new LinkedList<Character>();
                        aa.add(line.charAt(i+1));
                        stacks.add(aa);
                    }
                    else
                    {
                        stacks.add(new LinkedList<>());
                    }
                }
            }
            while ((line = br.readLine()) != null)
            {
                if(!commands)
                {
                    if (!line.startsWith(" 1   2 "))
                    {
                        for (int i = 0, index = 0; i < line.length(); i += 4, index++)
                        {
                            if(!Character.toString(line.charAt(i + 1)).equals(" "))
                            {
                                stacks.get(index).add(line.charAt(i + 1));
                            }
                        }
                    }
                    else
                    {
                        commands = true;
                        br.readLine();
                        continue;
                    }
                }
                else
                {
                    String[] command = line.split(" ");
                    int count = Integer.parseInt(command[1]);
                    int from = Integer.parseInt(command[3])-1;
                    int into = Integer.parseInt(command[5])-1;
                    List<Character> toMove = new ArrayList<Character>();

                    for(int counter = 0; counter < count; counter++)
                    {
                        toMove.add(stacks.get(from).poll());
                    }
                    for(int i = toMove.size()-1; i >= 0; i--)
                    {
                        stacks.get(into).addFirst(toMove.get(i));
                    }
                }
            }
        }
        for(int i = 0; i < stacks.size(); i++)
        {
            System.out.print(stacks.get(i).peek());
        }
    }
}