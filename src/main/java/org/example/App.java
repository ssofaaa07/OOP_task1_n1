package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    String str = "uffheofrh fhfdk fhjd{} f";

    public App(String str) {
        this.str = str;
    }

    public int index(String path) {
        for (int i = 0; i < str.length() - path.length() + 1; i++) {
            if (str.substring(i, i + path.length()).equals(path)) {
                return i;
            }
        }
        return -1;
    }

    public String join(String s) {
        return str = str + s;
    }

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
        if (str.substring(str.length() - path.length(), str.length() - path.length() + 1).equals(path)) {
            list.add(str.substring(k, str.length() - 1));
        } else {
            list.add(str.substring(k));
        }
        return list;
    }

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
        if (str.substring(str.length() - sample.length(), str.length() - sample.length() + 1).equals(sample)) {
            sb.append(str.substring(k, str.length() - 1));
        } else {
            sb.append(str.substring(k));
        }
        newStr = sb.toString();
        return newStr;
    }

    public String format(String format) {
        return this.replace("{}", format);
    }

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
