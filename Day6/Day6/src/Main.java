import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        String input = Files.readString(Path.of("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input6.txt"));
        int result = 0;

        List<Character> chars = new ArrayList<Character>();
        chars.add(input.charAt(0));
        chars.add(input.charAt(1));
        chars.add(input.charAt(2));
        chars.add(input.charAt(3));
        if(IsUnrepeatable(chars)) {
            System.out.println(3);
            return;
        }
        for(int i = 4; i < input.length(); i++)
        {
            chars.remove(0);
            chars.add(input.charAt(i));
            if(IsUnrepeatable(chars))
            {
                result = i+1;
                break;
            }
        }
        System.out.println(result);
    }
    public static boolean IsUnrepeatable(List<Character> x)
    {
        for(int i = 0; i < x.size(); i++)
        {
            for(int j = i+1; j < x.size(); j++)
            {
                if(x.get(i)==x.get(j))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void PartTwo() throws IOException {
        String input = Files.readString(Path.of("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input6.txt"));
        int result = 0;

        List<Character> chars = new ArrayList<Character>();
        for(int i = 0; i < 14; i++)
        {
            chars.add(input.charAt(i));
        }
        if(IsUnrepeatable(chars)) {
            System.out.println(14);
            return;
        }
        for(int i = 4; i < input.length(); i++)
        {
            chars.remove(0);
            chars.add(input.charAt(i));
            if(IsUnrepeatable(chars))
            {
                result = i+1;
                break;
            }
        }
        System.out.println(result);
    }
}