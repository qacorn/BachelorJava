package com.interview20190801;

public class IntRomanUtils {

    public String intToRoman(int num){
        String table[][] = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, {"", "M", "MM", "MMM", "", "", "", "", "", ""}};
        String roman_numeral = "";
        roman_numeral += table[3][num / 1000];
        num %= 1000;
        roman_numeral += table[2][num / 100];
        num %= 100;
        roman_numeral += table[1][num / 10];
        num %= 10;
        roman_numeral += table[0][num];
        return roman_numeral;
    }

//    public int romanToInt(String s) {
////        Map<Character, Integer> mymap = new HashMap<>();
////        mymap.put('I', 1);
////        mymap.put('V', 5);
////        mymap.put('X', 10);
////        mymap.put('L', 50);
////        mymap.put('C', 100);
////        mymap.put('D', 500);
////        mymap.put('M', 1000);
////
////
////        int result = 0, i = 0, temp;
////        for (i = 0; i < s.length() - 1; i++) {
////            temp = mymap[s[i]];
////            if (temp < mymap[s[i + 1]]) {
////                result -= temp;
////            } else {
////                result += temp;
////            }
////        }
////        result += mymap[s[i]];
////        return result;
//    }
}
