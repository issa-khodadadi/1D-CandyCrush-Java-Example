import java.util.Date;
import java.util.Scanner;

/**
 * Created on ۰۶/۱۰/۲۰۲۱ 12:27:30,
 */
public class CandyCrush {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please enter your candies:");
            System.out.println(
                    doCandyCrushOneD(
                            scanner.nextLine())
            );
            //System.out.println(process(input));
        }
    }
    
    static String doCandyCrushOneD(String input) {
        Map<Character, String> candyItems = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (i != 0) {
                if (candyItems.get(currentChar) == null) {
                    candyItems = new HashMap<>();
                    candyItems.put(currentChar, String.valueOf(currentChar));
                } else {
                    if (candyItems.get(currentChar).length() >= 2) {
                        if (i == input.length() - 1 || currentChar != input.charAt(i + 1)) {
                            input = input.replaceFirst (
                                    candyItems.get(
                                            currentChar) + currentChar, "");
                            return doCandyCrushOneD(input);
                        } else {
                            candyItems.put(currentChar,
                                    candyItems.get(currentChar) + currentChar);
                        }
                    } else {
                        candyItems.put(currentChar,
                                candyItems.get(currentChar) + currentChar);
                    }
                }
            } else {
                candyItems.put(currentChar, String.valueOf(currentChar));
            }
        }
        return input;
    }

    public static String process(String candyBoard) {
        StringBuilder myBoard = new StringBuilder(candyBoard);
        boolean isCrushed = false;
        StringBuilder newBoard = new StringBuilder();

        if (myBoard.length() >= 3) {
            for (int i = 0; i < myBoard.length(); i++) {
                for (int j = i + 1; j < myBoard.length(); j++) {
                    if (myBoard.charAt(i) == myBoard.charAt(j)) {
                        for (int k = j + 1; k < myBoard.length(); k++) {
                            if (myBoard.charAt(j) == myBoard.charAt(k)) {
                                newBoard = myBoard.deleteCharAt(k);
                                isCrushed = true;
                                if (newBoard.length() <= j + 1) {
                                    newBoard.deleteCharAt(j);
                                    newBoard.deleteCharAt(i);

                                    return newBoard.toString();
                                } else {
                                    k--;
                                }

                            } else {
                                if (isCrushed) {
                                    newBoard.deleteCharAt(j);
                                    newBoard.deleteCharAt(i);
                                    isCrushed = false;

                                    i = 0;
                                    j = 0;
                                } else {
                                    i = k;
                                    j = k;
                                }
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return newBoard.toString();
    }
}

