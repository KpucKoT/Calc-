import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {

        System.out.println("Input: ");

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(calculator(input));
    }
    public static String calculator(String input) throws Exception {

        String[] nums = input.split(" ");
        boolean isRoman;
        int a;
        int b;
        String c;
        String res;

        if (nums.length != 3) throw new Exception ("Incorrect input");

        c = nums[1];
        c = Oper(input);
        if (c == null) throw new Exception ("Incorrect input");

        if (Roman.isRoman(nums[0]) && Roman.isRoman(nums[2])) {
            a = Roman.convertArab(nums[0]);
            b = Roman.convertArab(nums[2]);
            isRoman = true;
        } else if (!Roman.isRoman(nums[0]) && !Roman.isRoman(nums[2])){
            a = Integer.parseInt(nums[0]);
            b = Integer.parseInt(nums[2]);
            isRoman = false;
        } else throw new Exception ("Incorrect Input");

            if (a > 10 || a <= 0 || b > 10 || b <= 0) throw new Exception("Incorrect input");


            int arab = calc(a, b, c);

            if (isRoman) {
                if (arab <= 0) throw new Exception ("Incorrect Result");
                res = Roman.convertRom(arab);
            } else {
                res = String.valueOf(arab);
            }

            return res;
    }

class Roman {
    static String[] romanNums = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String rom) {
        for (String romanNum : romanNums) {
            if (rom.equals(romanNum)) {
                return true;
            }
        }
        return false;
    }


    public static int convertArab(String roman) {
        for (int i = 0; i < romanNums.length; i++) {
            if(roman.equals(romanNums[i]))
                return i;
        }
        return -1;
    }

    public static String convertRom(int arab) {
        return romanNums[arab];
    }
}
    private static int calc(int a, int b, String c) {
        if (c.equals("+"))
            return a + b;
        else if (c.equals("-"))
            return a - b;
        else if (c.equals("/"))
            return a / b;
        else return a * b;
    }
    static String Oper(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;


    }
    }


























































