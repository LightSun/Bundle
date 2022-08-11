package com.heaven7.java.bundle;

public class BundleItem {

    private long mPtr;
    private boolean mNeedDestroy = true;

    static{
        NativeLoader.load(null, "jbundle");
    }
    public BundleItem() {
        this.mPtr = nCreate();
    }
    public BundleItem(long ptr) {
        this.mPtr = ptr;
        this.mNeedDestroy = false;
    }
    public long getPointer(){
        return mPtr;
    }
    @Override
    protected void finalize() throws Throwable {
        if(mNeedDestroy && mPtr != 0){
            nDestroy(mPtr);
            mPtr = 0;
        }
        super.finalize();
    }
    private static native long nCreate();
    private static native void nDestroy(long ptr);
}
