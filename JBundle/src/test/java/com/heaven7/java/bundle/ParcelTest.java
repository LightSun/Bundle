package com.heaven7.java.bundle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelTest {

    @Test
    public void test1(){
        Parcel b = new Parcel();

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
        Parcel b2 = new Parcel();
        b2.deSerialize(data);
        assertBundleBase(b2, str);
        //
        //long dataPos = b.getDataPos();
        b.putParcel("bundle", b2);
        assertEquals(b.nextName(), "bundle");
        Parcel b3 = b.nextParcel();
        assertBundleBase(b3, str);
        //
        testLists(b2);
    }

    private void testLists(Parcel b2){
        //----- list byte------
        byte[] listb = {1, 2, 3};
        b2.putListByte("listb", listb);
        assertEquals(b2.nextName(), "listb");
        assertArrayEquals(listb, b2.nextByteArray());
        //----- list short ------
        short[] listsh = {1, 2, 3};
        b2.putListShort("listsh", listsh);
        assertEquals(b2.nextName(), "listsh");
        assertArrayEquals(listsh, b2.nextShortArray());
        //----- list int ------
        int[] listi = {1, 2, 3};
        b2.putListInt("listi", listi);
        assertEquals(b2.nextName(), "listi");
        assertArrayEquals(listi, b2.nextIntArray());
        //----- list long ------
        long[] listl = {1, 2, 3};
        b2.putListLong("listl", listl);
        assertEquals(b2.nextName(), "listl");
        assertArrayEquals(listl, b2.nextLongArray());
        // --- list float -----
        float[] listf = {1.22f, 2.33f, 3.44556996f};
        b2.putListFloat("listf", listf);
        assertEquals(b2.nextName(), "listf");
        assertArrayEquals(listf, b2.nextFloatArray());
        //----- list double ---
        double[] listd = {1.11111111, 2.56565656, 3.999999999999};
        b2.putListDouble("listd", listd);
        assertEquals(b2.nextName(), "listd");
        assertArrayEquals(listd, b2.nextDoubleArray());
        //----- list string -----
        String[] strs = {"a", "b", "c"};
        b2.putListString("strs", strs);
        assertEquals(b2.nextName(), "strs");
        assertArrayEquals(strs, b2.nextStringArray());

        //----- list boolean -----
        boolean[] bs = {false, true, false};
        b2.putListBoolean("bs", bs);
        assertEquals(b2.nextName(), "bs");
        assertArrayEquals(bs, b2.nextBooleanArray());
    }

    private void assertBundleBase(Parcel b, String str){
        assertEquals(b.nextName(), "a");
        assertEquals(b.nextByte(), (byte)127);
        assertEquals(b.nextName(), "b");
        assertEquals(b.nextShort(), (short)32767);
        assertEquals(b.nextName(), "c");
        assertEquals(b.nextInt(),65566);
        assertEquals(b.nextName(), "d");
        assertEquals(b.nextLong(), 65566);
        assertEquals(b.nextName(), "e");
        assertTrue(b.nextBoolean());
        assertEquals(b.nextName(), "f");
        assertEquals(b.nextFloat(), 1.1111111f);
        assertEquals(b.nextName(), "g");
        assertEquals(b.nextDouble(), 1.111111111111111);
        assertEquals(b.nextName(), "h");
        assertEquals(b.nextString(), str);
        assertEquals(b.nextName(), "i");
        assertArrayEquals(b.nextBlob(), str.getBytes());
    }
}
