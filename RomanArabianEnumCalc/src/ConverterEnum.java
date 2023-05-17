import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConverterEnum {
    public static int computeArab(String s1, String s2, String operator) throws Exception {
        int result = 0;

        result = switch (operator) {
            case "+" -> Integer.parseInt(s1) + Integer.parseInt(s2);
            case "-" -> Integer.parseInt(s1) - Integer.parseInt(s2);
            case "/" -> Integer.parseInt(s1) / Integer.parseInt(s2);
            case "*" -> Integer.parseInt(s1) * Integer.parseInt(s2);
            default -> throw new Exception("Invalid operator");
        };
        return result;
    }

    public static String computeRoman(String s1, String s2, String operator) throws Exception {
        int result = 0;


        if(s1.equals(null)||s2.equals(null))
            throw new NullPointerException("Value is can't to be null");

        for (RomanNumbers rn : RomanNumbers.values()) {
            if(s1.equals(rn.name()))
                s1= String.valueOf(rn.getValue());
        }

        for (RomanNumbers rn1 : RomanNumbers.values()) {
            if(s2.equals(rn1.name()))
                s2= String.valueOf(rn1.getValue());
        }

        // multiplicate int values
        result = switch (operator) {
            case "+" -> Integer.parseInt(s1) + Integer.parseInt(s2);
            case "-" -> Integer.parseInt(s1) - Integer.parseInt(s2);
            case "/" -> Integer.parseInt(s1) / Integer.parseInt(s2);
            case "*" -> Integer.parseInt(s1) * Integer.parseInt(s2);
            default -> throw new Exception("Invalid operator");
        };

        if(result<0){
            throw new Exception();
        }

        String newResult = null;
        for (RomanNumbers rn3 : RomanNumbers.values()) {
            if(result==rn3.getValue())
                newResult = rn3.name();
        }
        return newResult;
    }
    public static void checkValid(String s1, String s2, String operator) throws Exception {
        if (isRoman(s1) && isArabic(s2))
            throw new Exception("Invalid type of values");
        else if (isRoman(s2) && isArabic(s1))
            throw new Exception("Invalid type of values");
        if (!operator.matches("[-+/*]"))
            throw new Exception("Invalid operator type ");
    }

    public static boolean isRoman(String s) {
        if (s.matches("[IVXLC]*"))
            return true;
        return false;
    }

    public static boolean isArabic(String s) {
        if (s.matches("[0-9]*"))
            return true;
        return false;
    }

}

enum RomanNumbers {
    O(0), I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
    XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20),
    XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26), XXVII(27), XXVIII(28), XXIX(29), XXX(30),
    XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
    XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45), XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
    LI(51), LII(52), LIII(53), LIV(54), LV(55), LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
    LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65), LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
    LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75), LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
    LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85), LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
    XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95), XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100);

    private int value;
    RomanNumbers(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

}
