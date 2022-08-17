package com.heaven7.java.bundle;

import java.util.List;

public class Parcel{

    private long mPtr;

    static{
        NativeLoader.load(null, "jbundle");
    }
    public Parcel() {
        this.mPtr = nCreate();
    }
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
    //----------------------------------------------

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
    public void putParcel(String name, Parcel val){
        nPutBundle(mPtr, name, val.getPointer());
    }
    public void putListByte(String name, byte[] data){
        nPutBlob(mPtr, name, data);
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
        nPutBlob(mPtr, name, data);
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

    //------------------------------------------
    public byte nextByte(){
        return nNextByte(mPtr);
    }
    public short nextShort(){
        return nNextShort(mPtr);
    }
    public int nextInt(){
        return nNextInt(mPtr);
    }
    public long nextLong(){
        return nNextLong(mPtr);
    }
    public boolean nextBoolean(){
        return nNextBoolean(mPtr);
    }
    public float nextFloat(){
        return nNextFloat(mPtr);
    }
    public double nextDouble(){
        return nNextDouble(mPtr);
    }
    public String nextString(){
        return nNextString(mPtr);
    }
    public byte[] nextBlob(){
        return nNextBlob(mPtr);
    }
    public Parcel nextParcel(){
        Parcel p = new Parcel();
        nextParcel(p);
        return p;
    }
    public void nextParcel(Parcel p){
        nNextParcel(mPtr, p.getPointer());
    }
    public byte[] nextByteArray(){
        return nNextByteArray(mPtr);
    }
    public short[] nextShortArray(){
        return nNextShortArray(mPtr);
    }
    public int[] nextIntArray(){
        return nNextIntArray(mPtr);
    }
    public long[] nextLongArray(){
        return nNextLongArray(mPtr);
    }
    public boolean[] nextBooleanArray(){
        return nNextBooleanArray(mPtr);
    }
    public float[] nextFloatArray(){
        return nNextFloatArray(mPtr);
    }
    public double[] nextDoubleArray(){
        return nNextDoubleArray(mPtr);
    }
    public String[] nextStringArray(){
        return nNextStringArray(mPtr);
    }
    //------------------------------------------
    public long getDataPos(){
        return nGetDataPos(mPtr);
    }
    public void setDataPos(long pos){
        nSetDataPos(mPtr, pos);
    }
    public String nextName(){
        String str = nNextName(mPtr);
        return str.length() != 0 ? str : null;
    }
    public byte[] serialize(){
        return nSerialize(mPtr);
    }
    public void deSerialize(byte[] data){
        nDeSerialize(mPtr, data);
    }

    //-------------------------------------------------
    private static native long nCreate();
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

   // private static native void nPutByteArray(long ptr, String name, byte[] val);
    private static native void nPutShortArray(long ptr, String name, short[] val);
    private static native void nPutIntArray(long ptr, String name, int[] val);
    private static native void nPutLongArray(long ptr, String name, long[] val);
    private static native void nPutBooleanArray(long ptr, String name, boolean[] val);
    private static native void nPutFloatArray(long ptr, String name, float[] val);
    private static native void nPutDoubleArray(long ptr, String name, double[] val);
    private static native void nPutStringArray(long ptr, String name, String[] val);

    private static native byte nNextByte(long ptr);
    private static native short nNextShort(long ptr);
    private static native int nNextInt(long ptr);
    private static native long nNextLong(long ptr);
    private static native boolean nNextBoolean(long ptr);
    private static native float nNextFloat(long ptr);
    private static native double nNextDouble(long ptr);
    private static native String nNextString(long ptr);
    private static native byte[] nNextBlob(long ptr);
    private static native void nNextParcel(long ptr, long oPtr);

    private static native byte[] nNextByteArray(long ptr);
    private static native short[] nNextShortArray(long ptr);
    private static native int[] nNextIntArray(long ptr);
    private static native long[] nNextLongArray(long ptr);
    private static native boolean[] nNextBooleanArray(long ptr);
    private static native float[] nNextFloatArray(long ptr);
    private static native double[] nNextDoubleArray(long ptr);
    private static native String[] nNextStringArray(long ptr);

    private static native byte[] nSerialize(long ptr);
    private static native void nDeSerialize(long ptr, byte[] data);
    private static native String nNextName(long ptr);

    private static native long nGetDataPos(long ptr);
    private static native void nSetDataPos(long ptr, long pos);
}
