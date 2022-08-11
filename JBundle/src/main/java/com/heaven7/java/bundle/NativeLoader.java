package com.heaven7.java.bundle;

import com.heaven7.java.base.util.DefaultPrinter;
import com.heaven7.java.base.util.FileUtils;
import com.heaven7.java.base.util.IOUtils;
import com.heaven7.java.base.util.TextUtils;

import java.io.*;
import java.net.URL;
import java.util.HashSet;

public final class NativeLoader {

    private static final String TAG = "NativeLoader";
    private static final String USE_LIBRARY_PATH = "USE_LIBRARY_PATH";
    private static final HashSet<String> sLoadLibs = new HashSet<>();
    private static final int MAX_PATH = 4096;

    public static boolean isLoaded(String name){
        return sLoadLibs.contains(name);
    }
    public static boolean load(String dir,String name){
        if(sLoadLibs.contains(name)){
            return true;
        }
        boolean loaded = load0(dir, name);
        if(loaded){
            sLoadLibs.add(name);
        }
        return loaded;
    }

    private static boolean load0(String dir, String name){
        if(TextUtils.isEmpty(dir)){
            return doLoad(null, name);
        }
        try{
            System.load(dir + "/" +  System.mapLibraryName(name));
            return true;
        }catch (Throwable e){
            return doLoad(new File(dir), name);
        }
    }
    private static boolean doLoad(File tempDir, String libraryName){
        final String systemLibraryName = System.mapLibraryName(libraryName);
        // load from the java.library.path
        if (System.getenv(USE_LIBRARY_PATH) != null) {
            final String javaLibraryPath = System.getProperty("java.library.path");
            try {
                warn(String.format("OVERRIDE DEFAULT: Loading %s from %s", systemLibraryName, javaLibraryPath));
                warn(String.format("LD_LIBRARY_PATH = %s", System.getenv("LD_LIBRARY_PATH")));
                System.loadLibrary(libraryName);
                return true;
            } catch (Exception|Error e) {
                warn(String.format("OVERRIDE DEFAULT: Unable to load %s from %s", systemLibraryName, javaLibraryPath));
                return false;
            }
        }

        final URL inputUrl = NativeLoader.class.getResource(systemLibraryName);
        if(inputUrl == null) {
            warn(String.format("Unable to find native library: %s" , systemLibraryName));
            return false;
        }
        InputStream in = null;
        OutputStream out = null;
        try {

            final File temp = File.createTempFile("lib" + libraryName,
                    "." + FileUtils.getFileExtension(systemLibraryName), tempDir);
            in = inputUrl.openStream();
            out = new BufferedOutputStream(new FileOutputStream(temp));
            IOUtils.copyLarge(in, out);
            out.flush();
            temp.deleteOnExit();
            if(checkPath(temp.getAbsolutePath())) {
                System.load(temp.getAbsolutePath());
                debug(String.format("Extracting %s to %s", systemLibraryName, temp.getAbsolutePath()));
                return true;
            } else{
                warn(String.format("Unable to load %s to %s", systemLibraryName, temp.getAbsolutePath()));
                return false;
            }
        } catch (Exception|Error e) {
            throw new RuntimeException(e);
        }finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }
    private static void warn(String msg){
        DefaultPrinter.getDefault().warn(TAG, "warn", msg);
    }
    private static void debug(String msg){
        DefaultPrinter.getDefault().warn(TAG, "debug", msg);
    }
    // Check library path is not too long
    private static boolean checkPath(String tempPath){
        if(tempPath.length() <= MAX_PATH){
            return true;
        }
        return false;
    }
}
