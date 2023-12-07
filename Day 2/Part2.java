import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 
{
    public static void main(String[] args)
    {
        String filepath = "input.txt";
        int sum = 0;

        try (FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) 
            {
                int leastRed = 0;
                int leastGreen = 0;
                int leastBlue = 0;

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
                        if (number > leastRed)
                        {
                            leastRed = number;
                        }
                    }
                    else if (containsGreen) 
                    {
                        if (number > leastGreen)
                        {
                            leastGreen = number;
                        }
                    }
                    else if (containsBlue)
                    {
                        if (number > leastBlue)
                        {
                            leastBlue = number;
                        }
                    }
                }

                int power = leastRed * leastGreen * leastBlue;
                sum += power;
            }
            System.out.println(sum);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
