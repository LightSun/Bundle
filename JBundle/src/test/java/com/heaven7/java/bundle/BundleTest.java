package com.heaven7.java.bundle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BundleTest {

    @Test
    public void test1(){
        Bundle b = new Bundle();
        b.putByte("a", (byte)127);
        b.putShort("b", (short)32767);
        b.putInt("c", 65566);
        b.putLong("d", 65566);
        b.putBoolean("e", true);
        b.putFloat("f", 1.1111111f);
        b.putDouble("g",1.111111111111111);
        String str = "I am heaven7!";
        b.putString("h", str);
        b.putBlob("i", str.getBytes());

        assertBundleBase(b, str);
        //
        byte[] data = b.serialize();
        Bundle b2 = new Bundle();
        b2.deSerialize(data);
        assertBundleBase(b2, str);
        //
        b.putBundle("bundle", b2);
        Bundle b3 = b.getBundle(b.getItemByName("bundle"));
        assertBundleBase(b3, str);
//-----
        testLists(b2);
        // travel
        int size = b2.getItemCount();
        BundleItemDesc item = new BundleItemDesc();
        for(int i = 0 ; i < size ; i ++){
            b2.getItemDesc(i, item);
            System.out.println(item.toString());
        }
    }
    private void testLists(Bundle b2){
        //----- list byte------
        byte[] listb = {1, 2, 3};
        b2.putListByte("listb", listb);
        assertArrayEquals(listb, b2.getByteArray(b2.getItemByName("listb")));
        //----- list short ------
        short[] listsh = {1, 2, 3};
        b2.putListShort("listsh", listsh);
        assertArrayEquals(listsh, b2.getShortArray(b2.getItemByName("listsh")));
        //----- list int ------
        int[] listi = {1, 2, 3};
        b2.putListInt("listi", listi);
        assertArrayEquals(listi, b2.getIntArray(b2.getItemByName("listi")));
        //----- list long ------
        long[] listl = {1, 2, 3};
        b2.putListLong("listl", listl);
        assertArrayEquals(listl, b2.getLongArray(b2.getItemByName("listl")));
        // --- list float -----
        float[] listf = {1.22f, 2.33f, 3.44556996f};
        b2.putListFloat("listf", listf);
        assertArrayEquals(listf, b2.getFloatArray(b2.getItemByName("listf")));
        //----- list double ---
        double[] listd = {1.11111111, 2.56565656, 3.999999999999};
        b2.putListDouble("listd", listd);
        assertArrayEquals(listd, b2.getDoubleArray(b2.getItemByName("listd")));
        //----- list string -----
        String[] strs = {"a", "b", "c"};
        b2.putListString("strs", strs);
        assertArrayEquals(strs, b2.getStringArray(b2.getItemByName("strs")));

        //----- list boolean -----
        boolean[] bs = {false, true, false};
        b2.putListBoolean("bs", bs);
        assertArrayEquals(bs, b2.getBooleanArray(b2.getItemByName("bs")));
    }

    private void assertBundleBase(Bundle b, String str){
        assertEquals(b.getByte(b.getItemByName("a")), (byte)127);
        assertEquals(b.getShort(b.getItemByName("b")), (short)32767);
        assertEquals(b.getInt(b.getItemByName("c")),65566);
        assertEquals(b.getLong(b.getItemByName("d")), 65566);
        assertTrue(b.getBoolean(b.getItemByName("e")));
        assertEquals(b.getFloat(b.getItemByName("f")), 1.1111111f);
        assertEquals(b.getDouble(b.getItemByName("g")), 1.111111111111111);
        assertEquals(b.getSting(b.getItemByName("h")), str);
        assertArrayEquals(b.getBlob(b.getItemByName("i")), str.getBytes());
    }
}
