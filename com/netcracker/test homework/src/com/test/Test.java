package com.test;

public class Test {
    public Test(){
        //1
        /*Someble o1 = new Some();
        System.out.println(o1 instanceof Object);*/

        //2
        /*TestClass2 testClass2 = new TestClass2();*/

        //3
        /*int[ ] a[ ] = new int [5][4] ;
        int a1[ ][ ] = new int [5][4] ;
        int a2[ ][ ] = new int [][4] ; //illegal.
        int[ ] a3[ ] = new int[4][ ] ;
        int[ ][ ] a4 = new int[5][4];*/

        //4
        /*TestClass4 testClass4 = new TestClass4();*/

        //5
        /*TestClass5 testClass5 = new TestClass5(); //will fail.*/

        //9
        /*TestClass9 testClass9 = new TestClass9();*/

        //11
        /*A a = new A();
        B b = new B();
        //a = (B)(I)b;
        //b = (B)(I) a; //exception.
        //a = (I) b; //exception.
        //I i = (C) a; //exception.*/

        //12
        /*int[] values = { 10, 20, 30 };
        for(int k: values){}
        for( ;; ){}*/

        //13
        /*TestClass13 testClass13 = new TestClass13();*/

        //16
        /*TestClass16 testClass16 = new TestClass16();*/

        //18
        /*int a = 1;
        int[] ia = new int[10];
        int b = ia[a];
        int c = b + a;
        System.out.println(b = c);*/

        //19
        /*char c = 320;
        float f = 320;
        double d = 320;
        //byte b = 320; //illegal.*/

        //20
        /*InitClass20 initClass20 = new InitClass20();*/

        //21
        /*byte m = 127;
        switch( m ){
            case 32 : System.out.println("32"); break;
            case 64 : System.out.println("64"); break;
            case 128 : System.out.println("128"); break;
        }*/

        //23
        /*TestClass23 testClass23 = new TestClass23();*/

        //24
        /*TestClass24 testClass24 = new TestClass24();*/

        //25
        /*boolean b1 = false;
        boolean b2 = false;
        if (b2 = b1 == false){
            System.out.println("true");
        }
        else{System.out.println("false");
        }*/

        //28
        /*//enum Season { SUMMER, WINTER, SPRING, FALL }
        Season s = Season.SPRING;
        switch(s){
            case SUMMER : System.out.println("SUMMER");
            case default : System.out.println("SEASON");
            case WINTER : System.out.println("WINTER");
        }*/

        //34
        /*Test t1, t2, t3, t4;
        t1 = t2 = new Test();
        t3 = new Test();*/

        //36
        /*TestClass36 testClass36 = new TestClass36();*/

        //41
        /*TestClass41 testClass41 = new TestClass41();*/

        //42
        /*Outer42 outer42 = new Outer42();
        Outer42.print();*/

        //43
        /*AccessTest43 accessTest43 = new AccessTest43();*/

        //46
        /*TestClass46 testClass46 = new TestClass46();*/

        //48
        /*if (false) ;
        else ;*/
    }
}

//1---------------------------------------------------------------------------------------------------------------------
/*class Some implements Someble { }
interface Someble { }*/
//2---------------------------------------------------------------------------------------------------------------------
/*class ABCD{
    int x = 10;
    static int y = 20;
}
class MNOP extends ABCD{
    int x = 30;
    static int y = 40;
}
class TestClass2 {
    public TestClass2() {
        System.out.println(new MNOP().x+", "+new MNOP().y);
    }
}*/
//4---------------------------------------------------------------------------------------------------------------------
/*class TestClass4{
    public TestClass4(){
        int i;
        int j;
        for (i = 0, j = 0 ; j < 1 ; ++j , i++){
            System.out.println( i + " " + j );
        }
        System.out.println( i + " " + j );
    }
}*/
//5---------------------------------------------------------------------------------------------------------------------
/*class TestClass5{
    public TestClass5(){
        transformNumber(7);
    }

    public int transformNumber(int n){
        int radix = 2;
        int output = 0;

        output += radix*n;
        radix = output/radix;

        if(output<14){
            return output;
        }
        else{
            output = output*radix/2;
            return output;
        }
      else {
            return output/2;
        }
    }
}*/
//9---------------------------------------------------------------------------------------------------------------------
/*class TestClass9{
    public TestClass9(){
        A a = new A();
        B b = new B();

        System.out.println(a instanceof T1);//true
        System.out.println(a instanceof T2);//true
        System.out.println(b instanceof T2);//true
        System.out.println(b instanceof T2);//true
        System.out.println(b instanceof A);//true
    }
}
class A implements T1, T2{}
class B extends A implements T1{}
interface T1 { }
interface T2 { }*/
//11--------------------------------------------------------------------------------------------------------------------
/*interface I{ }
class A implements I{ }
class B extends A { }
class C extends B{ }*/
//13--------------------------------------------------------------------------------------------------------------------
/*class TestClass13{
    static int a;
    int b;
    public TestClass13(){
        int c;
        c = a;
        a++;
        b += c;
    }
}*/
//16--------------------------------------------------------------------------------------------------------------------
/*
abstract class A extends B {}
class B {}
class TestClass16 {
    public TestClass16() {
        A a;
    }
}*/
//20--------------------------------------------------------------------------------------------------------------------
/*class InitClass20{
    private static int loop = 15 ;
    static final int INTERVAL = 10 ;
    boolean flag ;
//line 1
    static {System.out.println("Static"); }
    static { loop = 1; }
    static { loop += INTERVAL; }
    //static { INTERVAL = 10; } //error.
    { flag = true; loop = 0; }
}*/
//23--------------------------------------------------------------------------------------------------------------------
/*class TestClass23{
    public static int switchTest(int k){
        int j = 1;
        switch(k){
            case 1: j++;
            case 2: j++;
            case 3: j++;
            case 4: j++;
            case 5: j++;
            default : j++;
        }
        return j + k;
    }
    public TestClass23(){
        System.out.println( switchTest(4) );
    }
}*/
//24--------------------------------------------------------------------------------------------------------------------
/*class TestClass24{
    public TestClass24(){

        Object obj1 = new Object();
        Object obj2 = obj1;

        if( obj1.equals(obj2) ) System.out.println("true");
        else System.out.println("false");
    }
}*/
//27--------------------------------------------------------------------------------------------------------------------
/*class TestClass27 {
    public static final void m1() {

    }
}
class TestClass27Sub extends TestClass27 {
    @Override
    public static void m1() {

    }
}*/
//30--------------------------------------------------------------------------------------------------------------------
/*
interface A {}
interface B {}
interface C extends A,B {}*/
//31--------------------------------------------------------------------------------------------------------------------
/*class Test31{
    int i1;
    static int i2;

    public void method1(){
        int i;
        // ... insert statements here
        i = this.i1;
        i = this.i2;
        this = new Test31( );
        this.i = 4;
        this.i1 = i2;

    }
}*/
//32--------------------------------------------------------------------------------------------------------------------
/*interface I1 { }
interface I2 { }
class C1 implements I1 { }
class C2 implements I2 { }
class C3 extends C1 implements I2 { }
class C4 extends C3 implements I1, I2 { }
class TestClass32 {
    public TestClass32() {
        C1 o1 = new C1();
        C2 o2 = new C2();
        C3 o3 = new C3();

        //o3 = o1;
        //o3 = o2;
        I1 i1 = o3; I2 i2 = (I2) i1;
        I1 b = o3;
    }
}*/
//33--------------------------------------------------------------------------------------------------------------------
/*class TestClass33 {
    TestClass33(TestClass33 t){}
}*/
//
//36--------------------------------------------------------------------------------------------------------------------
/*class TestClass36{
    public TestClass36(){
        B b = new C();
        A a = b;

        if (a instanceof A) System.out.println("A");
        if (a instanceof B) System.out.println("B");
        if (a instanceof C) System.out.println("C");
        if (a instanceof D) System.out.println("D");
    }
}
class A { }
class B extends A { }
class C extends B { }
class D extends C { }*/
//37--------------------------------------------------------------------------------------------------------------------
/*class A{ }
class B extends A{ }
class C extends B{ }
class X{
    B getB(){ return new B(); }
}
class Y extends X{
// method declaration here
//public C getB(){ return new B(); }
//protected B getB(){ return new C(); }
//C getB(){ return new C(); }
//A getB(){ return new A(); }
}*/
//38--------------------------------------------------------------------------------------------------------------------
/*public class TestClass38 {
    public TestClass38() {
        someMethod();
    }
    static void someMethod(Object parameter) {
        System.out.println("Value is "+parameter);
    }
}*/
//40--------------------------------------------------------------------------------------------------------------------
/*interface I1{
    void setValue(String s);
    String getValue();
}
class A extends I1{
    String s;
    void setValue(String val) { s = val; }
    String getValue() { return s; }
}
interface I2 extends I1{
    void analyse();
}
abstract class B implements I1{
    int getValue(int i) { return 0; }
}
interface I3 implements I1{
    void perform_work();
}*/
//41--------------------------------------------------------------------------------------------------------------------
/*class Outer41 {
    class Inner {
        public void print() {
            System.out.println("Inner: print");
        }
    }
}
class TestClass41 {
    public TestClass41() {
        Outer41.Inner inner = new Outer41().new Inner();
        inner.print();
    }
}*/
//42--------------------------------------------------------------------------------------------------------------------
/*class Outer42 {
    private int mem = 10;
    class Inner {
        private int imem = new Outer42().mem; // ACCESS1
    }
    public static void print() {
        System.out.println(new Outer42().new Inner().imem); // ACCESS2
    }
}*/
//43--------------------------------------------------------------------------------------------------------------------
/*class AccessTest43{
    String a = "x";
    static char b = 'x';
    String c = "x";

    class Inner{
        String a = "y";
        String get(){
            String c = "temp";
            // Line 1
            //c = ""+AccessTest43.b;
            //c = AccessTest43.this.a;
            c = ""+b;

            return c;
        }
    };

    AccessTest43() {
        System.out.println( new Inner().get() );
    }
}*/
//44--------------------------------------------------------------------------------------------------------------------
/*class MyString extends String{
    MyString(){ super(); }
}*/
//45--------------------------------------------------------------------------------------------------------------------
/*class TestClass45 {
    public static void main(String[] args){
        int k = 2;
        while(--k){
            System.out.println(k);
        }
    }
}*/
//46--------------------------------------------------------------------------------------------------------------------
/*class A{
    public void m1() {
        System.out.println("A");
    }
}
class B extends A{
    public void m1() {
        System.out.println("B");
    }
}
class C extends B{
    public void m1(){
        ((A)this).m1();
    }
}
class TestClass46 {
    public  TestClass46() {
        C c = new C();
        c.m1();
    }
}*/
