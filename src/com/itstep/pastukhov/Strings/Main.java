package com.itstep.pastukhov.Strings;

import java.text.DecimalFormat;

/**
 * Created by lotrik on 08.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        task1_ReplaceChar();
        task2_NumberInAlphabet();
        task3_ReplaceRaToRo();
        task4_ReplaceSubstring();
        task5_InsertSubstring();
        task6_InsertWord();
        task7_DeletingSymbols();
        task8_DeletingWordsConsonant();
    }

    /* Заменяем каждый 3-й символ в слове знаком - */
    public static void task1_ReplaceChar (){
        String ourString = "Each Java source file contains a single public class or interface";
        String[] splitString = ourString.split(" ");
        StringBuilder sb;
        String ourNewString = "";

        for (int i = 0; i < splitString.length; i++){
            if (splitString[i].length() >= 3) {
                sb = new StringBuilder(splitString[i]);
                sb.setCharAt(2, '-');
                ourNewString += sb.toString().concat(" ");
            }
        }

        System.out.println("Task 1");
        System.out.println(ourNewString);
        System.out.println();
    }

    public static void task2_NumberInAlphabet (){
        int num;
        String ourString = "В русском тексте каждую букву заменить ее порядковым номером в алфавите";
        char ch[] = new char[ourString.length()];
        ourString.getChars(0, ourString.length(), ch, 0);
        String ourStringFinal = new String();
        String numberChar = "";
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        for (int i = 0; i < ourString.length(); i++) {
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
        System.out.println();
    }

    public static void task3_ReplaceRaToRo () {
        String ourString = "Mira Miro Miri Miru Miry Mire Mir Ra";
        StringBuilder sb = new StringBuilder(ourString);

        System.out.println("Task 3");
        System.out.println(sb.toString().toLowerCase().replaceAll("ra", "ro"));
        System.out.println();
    }

    /* Заменяем в тексте слова длинной 5 символов на подстроку*/
    public static void task4_ReplaceSubstring () {
        String ourString = "В тексте слова заданной длины заменить указанной подстрокой, длина которой может не " +
                            "совпадать с длиной слова";
        String[] splitString = ourString.split(" ");
        String ourFinalString = new String();

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() == 5) {
                splitString[i] = ourString.substring(30,43);
                ourFinalString += splitString[i].concat(" ");
            } else {
                ourFinalString += splitString[i].concat(" ");
            }
        }

        System.out.println("Task 4");
        System.out.println(ourFinalString);
        System.out.println();
    }

    /* После 10-го символа в тексте вставляем подстроку*/
    public static void task5_InsertSubstring () {
        String ourString = "В тексте после k-го символа вставить заданную подстроку.";
        StringBuilder sb = new StringBuilder(ourString);

        sb.insert(10, ourString.substring(20, 30));

        System.out.println("Task 5");
        System.out.println(sb);
        System.out.println();
    }

    /* Вставляем после каждого слова заканчивающегося подстрокой "ой" слово "*****" */
    public static void task6_InsertWord () {
        String ourString = "После каждого слова текста, заканчивающегося заданной подстрокой вставить указанное слово";
        String[] splitString = ourString.split(" ");
        String ourFinalString = new String();

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].endsWith("ой")) {
                ourFinalString += splitString[i].concat(" ***** ");
            } else {
                ourFinalString += splitString[i].concat(" ");
            }
        }

        System.out.println("Task 6");
        System.out.println(ourFinalString);
        System.out.println();
    }

    public static void task7_DeletingSymbols () {
        String ourString = "Из небольшого текста удалить все символы, кроме пробелов, неявляющиеся буквами. "
                            + "Между последовательностями подряд идущих букв оставить хотя бы один пробел.";
        char ch[] = new char[ourString.length()];
        String ourFinalString = new String();

        ourString.getChars(0, ourString.length(), ch, 0);
        for (int i = 0; i < ch.length; i++) {
            if ((Character.isAlphabetic(ch[i])) || (Character.isSpaceChar(ch[i]))) {
                ourFinalString += ch[i];
            }
        }

        System.out.println("Task 7");
        System.out.println(ourFinalString);
        System.out.println();
    }

    /* Удаляем слова длинной 5 символов и начинающиеся на согласную букву*/
    public static void task8_DeletingWordsConsonant () {
        char consonant[] = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц',
                            'ч', 'ш', 'щ'};
        String ourString = "Из текста удалить все слова заданной длины, начинающиеся на согласную аукву";
        String[] splitString = ourString.split(" ");
        String ourFinalString = new String();


        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() != 5) {
                ourFinalString += splitString[i].concat(" ");
                continue;
            } else {
                for (int j = 0; j < consonant.length; j++) {
                    if (splitString[i].toLowerCase().startsWith(String.valueOf(consonant[j]))) {
                        break;
                    } if (j == consonant.length-1) {
                        ourFinalString += splitString[i].concat(" ");
                    }
                }
            }
        }

        System.out.println("Task 8");
        System.out.println(ourFinalString);
        System.out.println();
    }
}
