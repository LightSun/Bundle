package com.heaven7.java.bundle;

public class BundleItemDesc {

    public static final int TYPE_BYTE = 1;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_INT = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_BOOLEAN = 7;
    public static final int TYPE_STRING = 8;
    public static final int TYPE_BLOB = 9;

    public static final int TYPE_LIST_BYTE = TYPE_BYTE * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_SHORT = TYPE_SHORT * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_INT = TYPE_INT * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_LONG = TYPE_LONG * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_FLOAT = TYPE_FLOAT * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_DOUBLE = TYPE_DOUBLE * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_BOOLEAN = TYPE_BOOLEAN * 10 + TYPE_BLOB;
    public static final int TYPE_LIST_STRING = TYPE_STRING * 10 + TYPE_BLOB;
    public static final int TYPE_BUNDLE = TYPE_BLOB * 10 + TYPE_BLOB;

    private long mPtr;

    static{
        NativeLoader.load(null, "jbundle");
    }
    public BundleItemDesc() {
        this.mPtr = nCreate();
    }
    public long getPointer(){
        return mPtr;
    }
    public BundleItem getItem(){
         return new BundleItem(nGetItemPointer(mPtr));
    }
    public String getName(){
        return nGetName(mPtr);
    }
    public int getType(){
        return nGetType(mPtr);
    }
    public int getSize(){
        return nGetSize(mPtr);
    }
    public int getIndex(){
        return nGetIndex(mPtr);
    }
    public static String typeStr(int type){
        switch(type){
            case TYPE_BYTE: return "byte";
            case TYPE_SHORT: return "short";
            case TYPE_INT: return "int";
            case TYPE_LONG: return "long";
            case TYPE_FLOAT: return "float";
            case TYPE_DOUBLE: return "double";
            case TYPE_BOOLEAN: return "boolean";
            case TYPE_STRING: return "string";
            case TYPE_BLOB: return "blob";

            case TYPE_LIST_BYTE: return "byte-array";
            case TYPE_LIST_SHORT: return "short-array";
            case TYPE_LIST_INT: return "int-array";
            case TYPE_LIST_LONG: return "long-array";
            case TYPE_LIST_FLOAT: return "float-array";
            case TYPE_LIST_DOUBLE: return "double-array";
            case TYPE_LIST_BOOLEAN: return "boolean-array";
            case TYPE_LIST_STRING: return "string-array";
            case TYPE_BUNDLE: return "bundle";
        }
        return "unknown_" + type;
    }
    @Override
    protected void finalize() throws Throwable {
        if(mPtr != 0){
            nDestroy(mPtr);
            mPtr = 0;
        }
        super.finalize();
    }

    @Override
    public String toString() {
        return "BundleItemDesc{" +
                "name = " + getName() +
                ", type = " + typeStr(getType()) +
                ", size = " + getSize() +
                ", index = " + getIndex() +
                '}';
    }

    private static native long nCreate();
    private static native void nDestroy(long ptr);
    private static native long nGetItemPointer(long ptr);

    private static native String nGetName(long ptr);
    private static native int nGetSize(long ptr);
    private static native int nGetType(long ptr);
    private static native int nGetIndex(long ptr);
}
