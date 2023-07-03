import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Asset {

    public static String txtToString() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);
        StringBuilder movielist = new StringBuilder();

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            movielist.append(line).append("\n");
        }
        scan.close();
        return movielist.toString();
    }

    public static String randomLineFromString(String list) {
        String [] lines = list.split("\n");
        Random rand = new Random();
        int randomIndex = rand.nextInt(lines.length);
        return lines[randomIndex].toLowerCase().replaceAll(" ","");
    }

    public static String stringToBlanks(String text) {
        return text.replaceAll(".","_");
    }

    public static String guessBlanks(String text, char[] input) {
        char[] array = text.toCharArray();
        for(int i = 0; i < array.length; i++){
            boolean found = false;
            for (int j = 0; j < input.length; j++) {
                if (array[i] == input[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                array[i] = '_';
            }
        }
        return new String(array);
    }

    public static char[] usedLettersArray(char[] oldArray, char input) {
        char[] newArray = new char[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[newArray.length - 1] = input;
        return newArray;
    }

}
