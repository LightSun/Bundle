package com.heaven7.java.bundle;

import java.util.List;

public class Bundle {

    private long mPtr;

    static{
        NativeLoader.load(null, "jbundle");
    }

    Bundle(int initItemCount, int initDataSize){
        mPtr = nCreate(initItemCount, initDataSize);
    }
    Bundle(){
        this(0, 0);
    }

    public void putByte(String name, byte val){
        nPutByte(mPtr, name, val);
    }
    public void putShort(String name, short val){
        nPutShort(mPtr, name, val);
    }
    public void putInt(String name, int val){
        nPutInt(mPtr, name, val);
    }
    public void putLong(String name, long val){
        nPutLong(mPtr, name, val);
    }
    public void putBoolean(String name, boolean val){
        nPutBoolean(mPtr, name, val);
    }
    public void putFloat(String name, float val){
        nPutFloat(mPtr, name, val);
    }
    public void putDouble(String name, double val){
        nPutDouble(mPtr, name, val);
    }
    public void putString(String name, String val){
        nPutString(mPtr, name, val);
    }
    public void putBlob(String name, byte[] val){
        nPutBlob(mPtr, name, val);
    }
    public void putBundle(String name, Bundle val){
        nPutBundle(mPtr, name, val.getPointer());
    }
    public void putListByte(String name, byte[] data){
        nPutByteArray(mPtr, name, data);
    }
    public void putListByte(String name, List<Byte> list){
        putListByte(name, list, (byte)0);
    }
    public void putListByte(String name, List<Byte> list, byte defVal){
        byte[] data = new byte[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Byte val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutByteArray(mPtr, name, data);
    }
    public void putListShort(String name, short[] data){
        nPutShortArray(mPtr, name, data);
    }
    public void putListShort(String name, List<Short> list){
        putListShort(name, list, (short)0);
    }
    public void putListShort(String name, List<Short> list, short defVal){
        short[] data = new short[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Short val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutShortArray(mPtr, name, data);
    }
    public void putListInt(String name, int[] data){
        nPutIntArray(mPtr, name, data);
    }
    public void putListInt(String name, List<Integer> list){
        putListInt(name, list, 0);
    }
    public void putListInt(String name, List<Integer> list, int defVal){
        int[] data = new int[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Integer val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutIntArray(mPtr, name, data);
    }
    public void putListLong(String name, long[] data){
        nPutLongArray(mPtr, name, data);
    }
    public void putListLong(String name, List<Long> list){
        putListLong(name, list, 0L);
    }
    public void putListLong(String name, List<Long> list, long defVal){
        long[] data = new long[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Long val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutLongArray(mPtr, name, data);
    }
    public void putListBoolean(String name, boolean[] data){
        nPutBooleanArray(mPtr, name, data);
    }
    public void putListBoolean(String name, List<Boolean> list){
        putListBoolean(name, list, false);
    }
    public void putListBoolean(String name, List<Boolean> list,boolean defVal){
        boolean[] data = new boolean[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Boolean val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutBooleanArray(mPtr, name, data);
    }
    public void putListFloat(String name, float[] data){
        nPutFloatArray(mPtr, name, data);
    }
    public void putListFloat(String name, List<Float> list){
        putListFloat(name, list, 0f);
    }
    public void putListFloat(String name, List<Float> list, float defVal){
        float[] data = new float[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Float val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutFloatArray(mPtr, name, data);
    }
    public void putListDouble(String name, double[] data){
        nPutDoubleArray(mPtr, name, data);
    }
    public void putListDouble(String name, List<Double> list){
        putListDouble(name, list, 0);
    }
    public void putListDouble(String name, List<Double> list, double defVal){
        double[] data = new double[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            Double val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutDoubleArray(mPtr, name, data);
    }
    public void putListString(String name, String[] data){
        nPutStringArray(mPtr, name, data);
    }
    public void putListString(String name, List<String> list){
        putListString(name, list, "");
    }
    public void putListString(String name, List<String> list, String defVal){
        String[] data = new String[list.size()];
        for(int i = 0 ; i < data.length ; i ++){
            String val = list.get(i);
            data[i] = val != null ? val : defVal;
        }
        nPutStringArray(mPtr, name, data);
    }
    //--------------------------------------
    public byte getByte(BundleItem item){
        return nGetByte(mPtr, item.getPointer());
    }
    public short getShort(BundleItem item){
        return nGetShort(mPtr, item.getPointer());
    }
    public int getInt(BundleItem item){
        return nGetInt(mPtr, item.getPointer());
    }
    public long getLong(BundleItem item){
        return nGetLong(mPtr, item.getPointer());
    }
    public boolean getBoolean(BundleItem item){
        return nGetBoolean(mPtr, item.getPointer());
    }
    public float getFloat(BundleItem item){
        return nGetFloat(mPtr, item.getPointer());
    }
    public double getDouble(BundleItem item){
        return nGetDouble(mPtr, item.getPointer());
    }
    public String getSting(BundleItem item){
        return nGetString(mPtr, item.getPointer());
    }
    public byte[] getBlob(BundleItem item){
        return nGetBlob(mPtr, item.getPointer());
    }
    public Bundle getBundle(BundleItem item){
         Bundle b = new Bundle();
         nGetBundle(mPtr, item.getPointer(), b.getPointer());
         return b;
    }
    public void getBundle(BundleItem item, Bundle b){
        nGetBundle(mPtr, item.getPointer(), b.getPointer());
    }
    public byte[] getByteArray(BundleItem item){
        return nGetByteArray(mPtr, item.getPointer());
    }
    public short[] getShortArray(BundleItem item){
        return nGetShortArray(mPtr, item.getPointer());
    }
    public int[] getIntArray(BundleItem item){
        return nGetIntArray(mPtr, item.getPointer());
    }
    public long[] getLongArray(BundleItem item){
        return nGetLongArray(mPtr, item.getPointer());
    }
    public boolean[] getBooleanArray(BundleItem item){
        return nGetBooleanArray(mPtr, item.getPointer());
    }
    public float[] getFloatArray(BundleItem item){
        return nGetFloatArray(mPtr, item.getPointer());
    }
    public double[] getDoubleArray(BundleItem item){
        return nGetDoubleArray(mPtr, item.getPointer());
    }
    public String[] getStringArray(BundleItem item){
        return nGetStringArray(mPtr, item.getPointer());
    }
    //--------------------------
    public int getItemCount(){
        return nGetItemCount(mPtr);
    }
    public void getItemAt(int index, BundleItem item){
        nGetItem(mPtr, index, item.getPointer());
    }
    public BundleItem getItemAt(int index){
        BundleItem item = new BundleItem();
        getItemAt(index, item);
        return item;
    }
    public void getItemByName(String name, BundleItem item){
        nGetItemByName(mPtr, name, item.getPointer());
    }
    public BundleItem getItemByName(String name){
        BundleItem item = new BundleItem();
        nGetItemByName(mPtr, name, item.getPointer());
        return item;
    }
    public void getItemDesc(int index, BundleItemDesc desc){
        nGetItemDesc(mPtr, index, desc.getPointer());
    }
    public BundleItemDesc getItemDesc(int index){
        BundleItemDesc desc = new BundleItemDesc();
        getItemDesc(index, desc);
        return desc;
    }
    public void getItemDesc(String name, BundleItemDesc desc){
        nGetItemDesc2(mPtr, name, desc.getPointer());
    }
    public BundleItemDesc getItemDesc(String name){
        BundleItemDesc desc = new BundleItemDesc();
        getItemDesc(name, desc);
        return desc;
    }
    public boolean hasName(String name){
        return nHasName(mPtr, name);
    }
    public byte[] serialize(){
        return nSerialize(mPtr);
    }
    public void deSerialize(byte[] data){
        nDeSerialize(mPtr, data);
    }
    //-----------------------------------------
    public final long getPointer() {
        return mPtr;
    }
    @Override
    protected void finalize() throws Throwable {
        if(mPtr != 0){
            nDestroy(mPtr);
            mPtr = 0;
        }
        super.finalize();
    }

    private static native long nCreate(int initItemCount, int initDataSize);
    private static native void nDestroy(long ptr);
    private static native void nPutByte(long ptr, String name, byte val);
    private static native void nPutShort(long ptr, String name, short val);
    private static native void nPutInt(long ptr, String name, int val);
    private static native void nPutLong(long ptr, String name, long val);
    private static native void nPutBoolean(long ptr, String name, boolean val);
    private static native void nPutFloat(long ptr, String name, float val);
    private static native void nPutDouble(long ptr, String name, double val);
    private static native void nPutString(long ptr, String name, String val);
    private static native void nPutBundle(long ptr, String name, long oPtr);
    private static native void nPutBlob(long ptr, String name, byte[] val);

    private static native void nPutByteArray(long ptr, String name, byte[] val);
    private static native void nPutShortArray(long ptr, String name, short[] val);
    private static native void nPutIntArray(long ptr, String name, int[] val);
    private static native void nPutLongArray(long ptr, String name, long[] val);
    private static native void nPutBooleanArray(long ptr, String name, boolean[] val);
    private static native void nPutFloatArray(long ptr, String name, float[] val);
    private static native void nPutDoubleArray(long ptr, String name, double[] val);
    private static native void nPutStringArray(long ptr, String name, String[] val);

    private static native int nGetItemCount(long ptr);
    private static native void nGetItem(long ptr, int index, long itemPtr);
    private static native byte nGetByte(long ptr, long itemPtr);
    private static native short nGetShort(long ptr, long itemPtr);
    private static native int nGetInt(long ptr, long itemPtr);
    private static native long nGetLong(long ptr, long itemPtr);
    private static native boolean nGetBoolean(long ptr, long itemPtr);
    private static native float nGetFloat(long ptr, long itemPtr);
    private static native double nGetDouble(long ptr, long itemPtr);
    private static native String nGetString(long ptr, long itemPtr);
    private static native byte[] nGetBlob(long ptr, long itemPtr);
    private static native void nGetBundle(long ptr, long itemPtr, long outPtr);

    private static native byte[] nGetByteArray(long ptr, long itemPtr);
    private static native short[] nGetShortArray(long ptr, long itemPtr);
    private static native int[] nGetIntArray(long ptr, long itemPtr);
    private static native long[] nGetLongArray(long ptr, long itemPtr);
    private static native boolean[] nGetBooleanArray(long ptr, long itemPtr);
    private static native float[] nGetFloatArray(long ptr, long itemPtr);
    private static native double[] nGetDoubleArray(long ptr, long itemPtr);
    private static native String[] nGetStringArray(long ptr, long itemPtr);

    private static native void nGetItemByName(long ptr,String name, long itemPtr);
    private static native byte[] nSerialize(long ptr);
    private static native void nDeSerialize(long ptr, byte[] data);

    private static native void nGetItemDesc(long ptr, int index, long descPtr);
    private static native void nGetItemDesc2(long ptr, String name, long descPtr);
    private static native boolean nHasName(long ptr, String name);
}
