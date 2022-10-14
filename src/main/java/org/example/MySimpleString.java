package org.example;

import java.util.ArrayList;
import java.util.List;

public class MySimpleString implements MyString {

    String str = "uffheofrh fhfdk fhjd{} f";

    public MySimpleString(String str) {
        this.str = str;
    }

    /**
     Метод для нахождения первого вхождение подстроки в строку.
     Если подстрока не найдена, выведет -1.

     path - искомая подстрока
     */
    public int index(String path) {
        for (int i = 0; i < str.length() - path.length() + 1; i++) {
            if (str.substring(i, i + path.length()).equals(path)) {
                return i;
            }
        }
        return -1;
    }

    /**
     Метод для соединения строки со строкой. Передаваемая строка присоединяется слева.

     s - присоединяемая строка
     */
    public String join(String s) {
        return str = str + s;
    }

    /**
     Метод для разбиения строки на строчки по разделителю.
     Сам разделитель не входит в полученный список строчек.

     path - строка, по которой происходит разбиение
     */
    public List<String> split(String path) {
        List<String> list = new ArrayList<String>();
        String newStr;
        int i = 0, k = 0;
        while (i != str.length() - path.length()) {
            if (str.substring(i,i+path.length()).equals(path)) {
                list.add(str.substring(k,i));
                k = i + path.length();
                i += path.length();
            }
            i++;
        }
        // проверка - оказался ли разделитель в конце строки
        if (str.substring(str.length() - path.length(),
                str.length() - path.length() + 1).equals(path)) {
            list.add(str.substring(k, str.length() - 1));
        } else {
            list.add(str.substring(k));
        }
        return list;
    }

    /**
     Метод для замены шаблона на замену.

     sample - шаблон
     replace - замена
     */
    public String replace(String sample, String replace) {
        int index = this.index(sample);
        String newStr;
        StringBuilder sb = new StringBuilder();
        int i = 0, k = 0;
        while (i != str.length() - sample.length()) {
            if (str.substring(i,i+sample.length()).equals(sample)) {
                sb.append(str.substring(k,i));
                sb.append(replace);
                k = i + sample.length();
                i += sample.length();
            }
            i++;
        }
        // проверка - оказался ли шаблон в конце строки
        if (str.substring(str.length() - sample.length(), str.length() - sample.length() + 1).equals(sample)) {
            sb.append(str.substring(k, str.length() - 1));
        } else {
            sb.append(str.substring(k));
        }
        newStr = sb.toString();
        return newStr;
    }

    /**
     Метод для замены {} на передаваемою строку.

     format - замена
     */
    public String format(String format) {
        return this.replace("{}", format);
    }

    /**
     Метод для сравнения двух строк.
     Если равны выведет true, а если нет - false.

     path - строка, с которой просиходит сравнение
     */
    public boolean equals(String path) {
        if (path.length() != str.length()) {
            return false;
        }
        for (int i = 0; i<str.length(); i++) {
            if (str.substring(i, i+1).toCharArray()[0] != path.substring(i, i+1).toCharArray()[0]) {
                return false;
            }
        }
        return true;
    }

}
