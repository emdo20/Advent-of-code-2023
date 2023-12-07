import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 
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
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(line);
                String firstDigit = null;
                String lastDigit = null;
                String number = "";

                while (matcher.find()) 
                {
                    if (firstDigit == null) 
                    {
                        firstDigit = matcher.group();
                    }
                    lastDigit = matcher.group();
                }

                if (firstDigit != null)
                {
                    number += firstDigit;
                }
                if (lastDigit != null)
                {
                    number += lastDigit;
                }

                sum += Integer.parseInt(number);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}
