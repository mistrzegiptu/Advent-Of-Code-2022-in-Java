import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.math.BigInteger;

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
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/mistr/Desktop/AdventOfCode2022/Advent-Of-Code-2022-in-Java/Inputs/input11.txt")))
        {
            do
            {
                br.readLine();
                String items = br.readLine().substring(17);
                String[] itemsToList = items.split(", ");
                List<BigInteger> itemsList = new ArrayList<>();

                for(int i = 0; i < itemsToList.length; i++)
                {
                    itemsList.add(new BigInteger(itemsToList[i].trim()));
                }
                String operations = br.readLine();
                String[] division = br.readLine().split(" ");
                BigInteger divisibleBy = new BigInteger(division[division.length-1]);
                int trueMonke = br.readLine().charAt(29)-'0';
                int falseMonke = br.readLine().charAt(30)-'0';
                monkeys.add(new Monkey(itemsList, operations, divisibleBy, trueMonke, falseMonke));
            }while(br.readLine() != null);
        }
        BigInteger prod = new BigInteger("1");
        for(int i = 0; i < monkeys.size(); i++)
        {
            prod = prod.multiply(monkeys.get(i).divisibleBy);
        }
        for(int counter = 0; counter < 10000; counter++)
        {
            for (int i = 0; i < monkeys.size(); i++)
            {
                while (monkeys.get(i).startingItems.size() > 0)
                {
                    BigInteger value = monkeys.get(i).startingItems.get(0);
                    monkeys.get(i).startingItems.remove(0);
                    monkeys.get(i).inspections++;
                    value = monkeys.get(i).Operation(value);

                    //Uncomment for part two:
                    value = value.mod(prod);

                    //Uncomment for part one:
                    //value = value.divide(new BigInteger("3"));
                    monkeys.get(monkeys.get(i).Test(value)).startingItems.add(value);
                }
            }
        }
        for(int i = 0; i < monkeys.size(); i++)
        {
            System.out.println(monkeys.get(i).inspections);
        }
        monkeys.sort((Monkey monk1, Monkey monk2) -> Integer.compare(monk1.inspections, monk2.inspections));
        System.out.println((long)monkeys.get(monkeys.size()-1).inspections*(long)monkeys.get(monkeys.size()-2).inspections);
    }
}
class Monkey
{
    public List<BigInteger> startingItems;
    public int inspections = 0, trueIndex, falseIndex;;
    public BigInteger divisibleBy;
    private BigInteger modulo = new BigInteger("0");
    private char operator;
    String operations;

    public Monkey(List<BigInteger> startingItems, String operations, BigInteger divisibleBy, int trueIndex, int falseIndex)
    {
        this.startingItems = startingItems;
        this.operations = operations.substring(13);
        this.divisibleBy = divisibleBy;
        this.trueIndex = trueIndex;
        this.falseIndex = falseIndex;
        operator = operations.split(" ")[3].charAt(0);
    }
    public int Test(BigInteger n)
    {
        return n.mod(divisibleBy).equals(modulo) ? trueIndex : falseIndex;
    }
    public BigInteger Operation(BigInteger n)
    {
        BigInteger newVal = null;
        String[] splitted = operations.split(" ");
        switch (splitted[3].charAt(0))
        {
            case '+':
                if(splitted[4].equals("old"))
                    newVal = n.add(n);
                else
                    newVal = n.add(new BigInteger(splitted[4]));
                break;
            case '-':
                if(splitted[4].equals("old"))
                    newVal = new BigInteger("0");
                else
                    newVal = n.subtract(new BigInteger(splitted[4]));
                break;
            case '*':
                if(splitted[4].equals("old"))
                    newVal = n.multiply(n);
                else
                    newVal = n.multiply(new BigInteger(splitted[4]));
                break;
            case '/':
                if(splitted[4].equals("old"))
                    newVal = new BigInteger("1");
                else
                    newVal = n.divide(new BigInteger(splitted[4]));
                break;
        }
        return newVal;
    }
}