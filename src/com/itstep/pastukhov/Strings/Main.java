package com.itstep.pastukhov.Strings;

import java.text.DecimalFormat;

/**
 * Created by lotrik on 08.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        task1_ReplaceChar();
        task2_NumberInAlphabet();
    }

    public static void task1_ReplaceChar (){
        String ourString = "Each Java source file contains a single public class or interface";
        String[] splitString = ourString.split(" ");
        StringBuilder sb;
        String ourNewString = "";
        for (int i=0;i<splitString.length;i++){
            if (splitString[i].length() >= 3) {
                sb = new StringBuilder(splitString[i]);
                sb.setCharAt(2, '-');
                ourNewString += sb.toString().concat(" ");
            }
        }
        System.out.println("Task 1");
        System.out.println(ourNewString);
    }

    public static void task2_NumberInAlphabet (){
        String ourString = "В русском тексте каждую букву заменить ее порядковым номером в алфавите";
        char ch[] = new char[ourString.length()];
        ourString.getChars(0,ourString.length(),ch,0);
        String ourStringFinal = new String();
        String numberChar = "";
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        int num;
        for (int i=0;i<ourString.length();i++) {
            if (Character.isAlphabetic(ch[i])) {
                ourStringFinal += ch[i];
                ourStringFinal += "  ";
                if (Character.isUpperCase(ch[i])) {
                    ch[i] = Character.toLowerCase(ch[i]);
                    num = alphabet.indexOf(ch[i]);
                    numberChar += (new DecimalFormat("00").format(num + 1));
                    numberChar += " ";
                    ch[i] = Character.toUpperCase(ch[i]);
                } else {
                    num = alphabet.indexOf(ch[i]);
                    numberChar += (new DecimalFormat("00").format(num + 1));
                    numberChar += " ";
                }
            }

        }
        System.out.println("Task 2");
        System.out.println(ourStringFinal);
        System.out.println(numberChar);
    }
}