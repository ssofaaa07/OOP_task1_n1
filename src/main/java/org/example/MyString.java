package org.example;

import java.util.List;

public interface MyString {

    public int index(String path);

    public String join(String str);

    public List<String> split(String path);

    public String replace(String sample, String replace);

    public String format(String format);

    public boolean equals(String str);

}
