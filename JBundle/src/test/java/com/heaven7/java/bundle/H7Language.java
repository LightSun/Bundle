package com.heaven7.java.bundle;

import java.util.List;

public class H7Language {
    public static final int TYPE_i8   = 1;
    public static final int TYPE_ui8  = 2;
    public static final int TYPE_i16  = 3;
    public static final int TYPE_ui16 = 4;
    public static final int TYPE_i32  = 5;
    public static final int TYPE_ui32 = 6;
    public static final int TYPE_i64  = 7;
    public static final int TYPE_ui64 = 8;
    public static final int TYPE_string = 9;
    public static final int TYPE_bool = 10;

    public static class Package{
        String name;
        List<H7File> files;
    }
    public static class H7File{
        String pkgName;
        List<String> imports;
        List<String> staticImports;
        List<ClassDef> defines;
        List<MethodDef> methods;
        List<Expression> expres;
    }
    public static class Def{

    }
    public static class ClassDef extends Def{
        String name;
        List<FieldMember> fields;
        List<MethodMember> methods;
    }
    public static class MethodDef extends Def{
        String name;
        List<Integer> paramTypes;
        Integer returnType;
    }
    public static class FieldDef extends Def{
        String name;
        byte type;
        int flags;
    }
    public static class FieldMember{
        String name;
        byte type;
        int flags; //final , static
        Bundle annotation;
    }
    public static class MethodMember{
        String name;
        List<Integer> paramTypes;
        Integer returnType;
        Bundle annotation;
    }
    public static class Expression{

    }
    //= , ?: , 一元操作, arr[i] = xx, call, while, for, switch, if-else
}
