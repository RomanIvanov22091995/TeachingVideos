import java.util.HashMap;
import java.util.Map;

public class Converter{
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
        Map<String, Integer> map = new HashMap<>() {{
            put ("O",0); put ( "I",1); put ( "II",2); put ( "III",3); put ( "IV",4); put ( "V",5); put ( "VI",6); put ( "VII",7); put ( "VIII",8); put ( "IX",9); put ( "X",10);
            put ( "XI",11); put ( "XII",12); put ( "XIII",13); put ( "XIV",14); put ( "XV",15); put ( "XVI",16); put ( "XVII",17); put ( "XVIII",18); put ( "XIX",19); put ( "XX",20);
            put ("XXI",21); put ( "XXII",22); put ( "XXIII",23); put ( "XXIV",24); put ( "XXV",25); put ( "XXVI",26); put ( "XXVII",27); put ( "XXVIII",28); put ( "XXIX",29); put ( "XXX",30);
            put ( "XXXI",31); put ( "XXXII",32); put ( "XXXIII",33); put ( "XXXIV",34); put ( "XXXV",35); put ( "XXXVI",36); put ( "XXXVII",37); put ( "XXXVIII",38); put ( "XXXIX",39); put ( "XL",40);
            put ("XLI",41); put ( "XLII",42); put ( "XLIII",43); put ( "XLIV",44); put ( "XLV",45); put ( "XLVI",46); put ( "XLVII",47); put ( "XLVIII",48); put ( "XLIX",49); put ( "L",50);
            put ( "LI",51); put ( "LII",52); put ( "LIII",53); put ( "LIV",54); put ( "LV",55); put ( "LVI",56); put ( "LVII",57); put ( "LVIII",58); put ( "LIX",59); put ( "LX",60);
            put ("LXI",61); put ( "LXII",62); put ( "LXIII",63); put ( "LXIV",64); put ( "LXV",65); put ( "LXVI",66); put ( "LXVII",67); put ( "LXVIII",68); put ( "LXIX",69); put ( "LXX",70);
            put ("LXXI",71); put ( "LXXII",72); put ( "LXXIII",73); put ( "LXXIV",74); put ( "LXXV",75); put ( "LXXVI",76); put ( "LXXVII",77); put ( "LXXVIII",78); put ( "LXXIX",79); put ( "LXXX",80);
            put ("LXXXI",81); put ( "LXXXII",82); put ( "LXXXIII",83); put ( "LXXXIV",84); put ( "LXXXV",85); put ( "LXXXVI",86); put ( "LXXXVII",87); put ( "LXXXVIII",88); put ( "LXXXIX",89); put ( "XC",90);
            put ("XCI",91); put ( "XCII",92); put ( "XCIII",93); put ( "XCIV",94); put ( "XCV",95); put ( "XCVI",96); put ( "XCVII",97); put ( "XCVIII",98); put ( "XCIX",99); put ( "C",100);

        }};

        if(s1.equals(null)||s2.equals(null))
            throw new NullPointerException("Value is can't to be null");


        for (var entry : map.entrySet()) {
            if(s1.equals(entry.getKey()))
                s1 = String.valueOf(entry.getValue());
        }
        for (var entry1 : map.entrySet()) {
            if (s2.equals(entry1.getKey()))
                s2 = String.valueOf(entry1.getValue());
        }

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
        for (var entry : map.entrySet()) {
            if(result==entry.getValue())
                newResult = entry.getKey();
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

