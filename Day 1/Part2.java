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
            int index = 0;
            while ((line = bufferedReader.readLine()) != null)
            {
                index++;

                // Define an array of specific words and numbers
                String[] targetWords = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

                String firstDigit = null;
                String lastDigit = null;
                int firstNumber = -1;
                int lastNumber = -1;

                // Iterate through the string
                for (int i = 0; i < line.length(); i++) 
                {
                    // Check if any of the words start at the current position in the string
                    for (String word : targetWords) 
                    {
                        if (line.startsWith(word, i)) 
                        {
                            if (firstDigit == null)
                            {
                                firstDigit = word;
                                // Move the index to the end of the matched word
                                //i += word.length() - 1;
                                break;
                            }
                            lastDigit = word;
                            // Move the index to the end of the matched word
                            //i += word.length() - 1;
                            break;
                        }
                    }
                }

                if (firstDigit != null)
                {
                    firstNumber = convertStringToNumber(firstDigit);
                }
                if (lastDigit != null)
                {
                    lastNumber = convertStringToNumber(lastDigit);
                }

                int number = 0;

                if (firstNumber != -1 && lastNumber != -1)
                {
                    number = Integer.parseInt(Integer.toString(firstNumber) + Integer.toString(lastNumber));
                }
                else if (firstNumber == -1)
                {
                    number = lastNumber;
                }
                else
                {
                    number = firstNumber;
                }

                sum += number;
                System.out.println(index + ". " + number + "\tCurrent sum: " + sum + "\t" + line);
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        System.out.println(sum);
    }

    private static int convertStringToNumber(String word) 
    {
        switch (word.toLowerCase()) 
        {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            
            default:
                return -1; // Indicates an invalid word for a number
        }
    }
}
