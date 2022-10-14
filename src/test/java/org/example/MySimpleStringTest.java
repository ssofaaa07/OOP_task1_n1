package org.example;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class MySimpleStringTest extends TestCase {
    public void testIndex() {
        MySimpleString str = new MySimpleString("s;nvc s;pifuvni splejn");
        Assert.assertEquals(8, str.index("pif"));
        Assert.assertEquals(-1, str.index("q")); // отсутствие подстроки

    }

    public void testJoin() {
        MySimpleString str1 = new MySimpleString("s;nvc s;pifuvni");
        Assert.assertEquals("s;nvc s;pifuvni s;nvc", str1.join(" s;nvc"));
    }

    public void testSplit() {
        MySimpleString str = new MySimpleString(" s;nvc s;nifuvni splejn ");
        List<String> list1 = new ArrayList<String>();
        list1.add("");
        list1.add("s;nvc");
        list1.add("s;nifuvni");
        list1.add("splejn");
        Assert.assertEquals(list1, str.split(" ")); // пробелы в начале и конце
        List<String> list2 = new ArrayList<String>();
        list2.add(" s");
        list2.add("vc s");
        list2.add("ifuvni splejn ");
        Assert.assertEquals(list2, str.split(";n")); // строка
        List<String> list3 = new ArrayList<String>();
        list3.add(" s;nvc s;nifuvni splejn ");
        Assert.assertEquals(list3, str.split("qwe")); // отсутствие разделителя

    }

    public void testReplace() {
        MySimpleString str = new MySimpleString("ns;nvc s;nifuvni splejn");
        Assert.assertEquals("ns;nvc s;1uvni splejn", str.replace("nif", "1"));
        Assert.assertEquals("ns nvc s nifuvni splejn", str.replace(";", " "));
        Assert.assertEquals("s;vc s;ifuvi splej", str.replace("n", ""));
        Assert.assertEquals("ns;nvc s;nifuvni splejn", str.replace("poi", "1")); // отсутствие шаблона

    }

    public void testFormat() {
        MySimpleString str = new MySimpleString("ns;nvc s;nifu{}vni splejn");
        Assert.assertEquals("ns;nvc s;nifu123vni splejn", str.format("123"));
        MySimpleString str1 = new MySimpleString("ns;nvc s;nifuvni splejn");
        Assert.assertEquals("ns;nvc s;nifuvni splejn", str1.format("123")); // отсутствие {}
    }

    public void testEquals() {
        MySimpleString str = new MySimpleString("ns;nvc");
        Assert.assertTrue(str.equals("ns;nvc"));
        Assert.assertFalse(str.equals("ns;nv"));
    }

}
