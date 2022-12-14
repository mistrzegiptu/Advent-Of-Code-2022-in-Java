import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    static List<Monkey> monkeys = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        PartOne();
        PartTwo();
    }
    public static void PartOne() throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/test11.txt")))
        {
            do
            {
                br.readLine();
                String items = br.readLine().substring(17);
                String[] itemsToList = items.split(", ");
                List<BigInteger> itemsList = new ArrayList<>();
                
                for(int i = 0; i < itemsToList.length; i++)
                {
                    itemsList.add(Long.parseLong(itemsToList[i].trim()));
                }
                String operations = br.readLine();
                String[] division = br.readLine().split(" ");
                long divisibleBy = Long.parseLong(division[division.length-1]);
                int trueMonke = br.readLine().charAt(29)-'0';
                int falseMonke = br.readLine().charAt(30)-'0';
                monkeys.add(new Monkey(itemsList, operations, divisibleBy, trueMonke, falseMonke));
            }while(br.readLine() != null);
        }
        for(int counter = 0; counter < 1000; counter++)
        {
            for (int i = 0; i < monkeys.size(); i++)
            {
                while (monkeys.get(i).startingItems.size() > 0)
                {
                    long value = monkeys.get(i).startingItems.get(0);
                    monkeys.get(i).startingItems.remove(0);
                    monkeys.get(i).inspections++;
                    value = monkeys.get(i).Operation(value);
                    //value = value / 3;
                    monkeys.get(monkeys.get(i).Test(value)).startingItems.add(value);
                }
            }
        }
        for(int i = 0; i < monkeys.size(); i++)
        {
            System.out.println(monkeys.get(i).inspections);
        }
        //monkeys.sort((Monkey monk1, Monkey monk2) -> Integer.compare(monk1.inspections, monk2.inspections));
        //System.out.println(monkeys.get(monkeys.size()-1).inspections*monkeys.get(monkeys.size()-2).inspections);
    }
    public static void PartTwo() throws IOException
    {

    }
}
class Monkey
{
    public List<BigInteger> startingItems;
    public int inspections = 0, trueIndex, falseIndex;;
    private long divisibleBy;
    String operations;

    public Monkey(List<BigInteger> startingItems, String operations, long divisibleBy, int trueIndex, int falseIndex)
    {
        this.startingItems = startingItems;
        this.operations = operations.substring(13);
        this.divisibleBy = divisibleBy;
        this.trueIndex = trueIndex;
        this.falseIndex = falseIndex;
    }
    public int Test(long n)
    {
        return n % divisibleBy == 0 ? trueIndex : falseIndex;
    }
    public long Operation(long n)
    {
        long newVal = 0;
        String[] splitted = operations.split(" ");
        switch (splitted[3].charAt(0))
        {
            case '+':
                if(splitted[4].equals("old"))
                    newVal = n + n;
                else
                    newVal = n + Long.parseLong(splitted[4]);
                break;
            case '-':
                if(splitted[4].equals("old"))
                    newVal = 0;
                else
                    newVal = n - Long.parseLong(splitted[4]);
                break;
            case '*':
                if(splitted[4].equals("old"))
                    newVal = n * n;
                else
                    newVal = n * Long.parseLong(splitted[4]);
                break;
            case '/':
                if(splitted[4].equals("old"))
                    newVal = 1;
                else
                    newVal = n / Long.parseLong(splitted[4]);
                break;
        }
        return newVal;
    }
}