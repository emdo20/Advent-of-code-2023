import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 
{
    public static void main(String[] args)
    {
        String filepath = "input.txt";
        final int possibleRed = 12;
        final int possibleGreen = 13;
        final int possibleBlue = 14;
        int sum = 0;

        try (FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) 
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) 
            {
                boolean gamePossible = true;
                String[] game = line.split(":");
                String modifiedLine = line.replace(game[0] + ": ", "");

                String[] cubes = modifiedLine.split("\\, |\\; ");

                for (String color : cubes)
                {
                    String checkRed = "red";
                    int indexRed = color.indexOf(checkRed);
                    boolean containsRed = indexRed != -1;
                    
                    String checkGreen = "green";
                    int indexGreen = color.indexOf(checkGreen);
                    boolean containsGreen = indexGreen != -1;

                    String checkBlue = "blue";
                    int indexBlue = color.indexOf(checkBlue);
                    boolean containsBlue = indexBlue != -1;

                    String[] quantity = color.split(" ");
                    int number = Integer.parseInt(quantity[0]);

                    if (containsRed)
                    {
                        if (number > possibleRed)
                        {
                            gamePossible = false;
                        }
                    }
                    else if (containsGreen) 
                    {
                        if (number > possibleGreen)
                        {
                            gamePossible = false;
                        }
                    }
                    else if (containsBlue)
                    {
                        if (number > possibleBlue)
                        {
                            gamePossible = false;
                        }
                    }
                }

                if (gamePossible)
                {
                    System.out.println(game[0] + " is possible.");

                    String[] gameNumber = line.split(" ");
                    String modifiedGameNumber = gameNumber[1].replace(":", "");
                    int number = Integer.parseInt(modifiedGameNumber);

                    sum += number;
                }
                else
                {
                    System.out.println(game[0] + " is not possible.");
                }                
            }
            System.out.println(sum);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}