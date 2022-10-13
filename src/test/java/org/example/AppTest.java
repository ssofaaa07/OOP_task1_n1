package org.example;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public void testIndex() {
        App str = new App("s;nvc s;pifuvni splejn");
        Assert.assertEquals(8, str.index("pif"));
    }

    public void testJoin() {
        App str1 = new App("s;nvc s;pifuvni");
        Assert.assertEquals("s;nvc s;pifuvni s;nvc", str1.join(" s;nvc"));
    }

    public void testSplit() {
        App str = new App(" s;nvc s;nifuvni splejn ");
        List<String> list1 = new ArrayList<String>();
        list1.add("");
        list1.add("s;nvc");
        list1.add("s;nifuvni");
        list1.add("splejn");
        Assert.assertEquals(list1, str.split(" "));
        List<String> list2 = new ArrayList<String>();
        list2.add(" s");
        list2.add("vc s");
        list2.add("ifuvni splejn ");
        Assert.assertEquals(list2, str.split(";n"));
    }

    public void testReplace() {
        App str = new App("ns;nvc s;nifuvni splejn");
        Assert.assertEquals("ns;nvc s;1uvni splejn", str.replace("nif", "1"));
        Assert.assertEquals("ns nvc s nifuvni splejn", str.replace(";", " "));
        Assert.assertEquals("s;vc s;ifuvi splej", str.replace("n", ""));
    }

    public void testFormat() {
        App str = new App("ns;nvc s;nifu{}vni splejn");
        Assert.assertEquals("ns;nvc s;nifu123vni splejn", str.format("123"));
    }

    public void testEquals() {
        App str = new App("ns;nvc");
        Assert.assertTrue(str.equals("ns;nvc"));
        Assert.assertFalse(str.equals("ns;nv"));
    }

}
