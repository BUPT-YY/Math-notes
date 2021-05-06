#0.1 Java的发展历程
    #Internet发展中的两次飞跃
        www
        Java
    #Java的出现
        1990年SUN “Green”--开发家用电器软件
        1994年Oak语言
        1995年Java语言
            SUN公布第一版编译器JDK1.0
            Sun: Stanford University Network
#Java之父 James Gosling
#Java官方网站 java.sun.com

#Java三大平台
    Java SE(Standard Edition) 标准版
    Java EE(Enterprise Edition)企业版
    Java ME(Micro Edition)微型版
#Java的开发工具包 Java Development Kit

#Java的发展历程

     初创    Java2   改进     稳定    语法增加    广泛    改进    前进大步
    JDK1.0  JDK1.2  JDK1.3  JDK1.4  JDK1.5   JDK1.6  JDK1.7  JDK1.8
     1995    1998    2000    2002    2004     2006    2010    2014
    #2010年, Oracle并购Sun

#Java主要改进
    JDK1.4: assert、logging、Java2D、NIO、正则表达式
    Java5:  范型、增强的foreach、自动装箱拆箱、枚举、可变长参数、静态引入、注记、printf、StringBuilder
    Java6:  Compiler API(动态编译)、脚本语言支持、WebService支持
    Java7:  常量等的写法、带资源的try、重抛异常
    https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html
    https://www.oracle.com/java/technologies/javase/16u-relnotes.html

#Java的推动力: JCP & JSR
    Java Community Process: https://jcp.org
    Java Specification Requests
    例: JSR335 Lambda Expressions for Java8
#API文档 http://docs.oracle.com/javase/8/docs/api/index.html

#Java的语言特点
    面向对象(OOP)
    平台无关性
    安全稳定
    支持多线程
    网络化
    数据库操作

    #丰富的类库: 语言包(package)、实用程序包、I/O包、网络包、图形用户界面包、...

#与C++的区别
    无直接指针操作
    自动内存管理
    数据类型长度固定
    不用头文件
    不包含struct和union
    不支持宏
    不用多重继承        --> 改成interface
    无类外全局变量       -> 类内static 
    无GOTO

#Java运行机制
    Java虚拟机(Java Virtual Machine)
    代码安全性检测(Code Security)
    垃圾收集机制(Garbage collection)

#Java的编译和运行
                javac                java
    Source.java -----> Source.class -----> JVM for Dos/Winx/Unix/Other Platform
       源程序          字节码(bytecode)
                          平台无关

#Java虚拟机(Java Virtual Machine)
    在一台计算机上由软/硬件模拟的计算机
    JVM读取并处理编译过的字节码class文件
    JVM规范定义了: 指令集、寄存器集、类文件结构、堆栈、垃圾收集堆、内存区域

#Java运行环境(JRE: Java Runtime Environment)
    JRE = JVM + API(Lib)
    JRE运行程序时的三项主要功能:
        加载代码: 由class loader完成;
        检验代码: 由bytecode verifier完成;
        执行代码: 由runtime interpreter完成.
    -> 跨平台、安全性.

#Java自动垃圾回收技术
    Garbage collectoin
    在C/C++等语言中, 由程序员负责回收无用内存

    Java中:
        系统级线程跟踪存储空间的分配情况
        在JVM的空闲时, 检查并释放那些可释放的存储器空间
        程序员也无法精确控制和干预该回收过程

#JDK提供的工具
    编译器              javac
    执行器              java
    文档生成器           javadoc
    打包器              jar
    调试器              jdb
    查看类信息、反汇编    javap
    运行图形界面程序      javaw

#path、classpath
javac -cp , javac -d (指定根目录)

jar cvfm A.jar MANIFEST.mf A.class
    MANIFEST:清单文件, cvfm=create+verbose(显示详情)+f(指定文件名)+m(清单文件)
java -jar A.jar
javadoc -d 目录名 xxxx.java
/**
@author
@version
@see --->    对类、属性、方法的说明 参考转向,也就是相关主题
@param
@return
@exception
*/
javap 类名          查看类信息
javap -c 类名       反汇编


#面向对象程序设计
    对象(object) 是 类(class)的实例
    类是对象的抽象

    类  变量: 字段 field
        函数: 方法 method

    三大特征: 
        封装： 模块化、信息隐蔽
        继承(inheritance):父子类间共享数据的方法， 更好地进行抽象与分类、提高代码的重用率、提高可维护性
        多态(polymorphism)：不同的对象调同一个方法可产生不同的效果， 实现细节由接收对象自行决定


#1 Java程序的类型
    Application、Applet

    结构和运行环境不同.
    Application是独立的程序、由执行器(调用虚拟机)来运行
    Applet是嵌在HTML网页中的非独立的程序
            由专门的appletViewer来运行
            由Web浏览器（调Java虚拟机）来运行
    
    public class HelloWorldApp {
        public static void main(String args[]) {
            System.out.println("Hello, world!");
        }
    }

    //HelloWorldApplet.java
    import java.awt.*;
    import java.applet.*;
    import java.swing.*;
    public class HellpWorldApp extends JApplet {
        public void paint(Graphics g) {
            g.drawString("Hello, world!", 20, 20);
        }
    }

    //HelloWorldApplet.html
    <HTML>
    <HEAD><TITLE> An Applet </TITLE> </HEAD>
    <BODY><applet code="HelloWorldApplet.class"
        width=200 height=40 background=white>
    </applet></BODY>
    </HTML>

#Java工具包JDK
    /bin      存放工具文件
    /jre      存放与java运行环境相关的文件
    /demo     存放一些示例文件
    /include  存放与C相关的头文件
    /lib      存放程序库
    /db       数据库相关


#2. 基本的输入输出
    //使用Scanner类
    import java.util.Scanner
    class ScannerTest {
        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            double b = scanner.nextDouble();
            String c = scanner.next();          //下一个单词
            System.out.printf("%d, %f, %s\n", a, b, c);
        }
    }

    //使用in和out
    class Test {
        public static void main(String args[]) {
            char c = ' ';
            try {
                c = (char) System.in.read();
            } catch(IOException e) {}
            System.out.println("" + c);
        }
    }

    //使用BufferedReader
    class BufferedReaderTest {
        public static void main(String args[]) {
            try {
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
                );
                s = in.readLine();
            } catch(IOException e) { }
            int n = Integer.parseInt(s);
            //double a = Double.parseDouble(s);
            System.out.println(n);
        }
    }


#3. 数据类型、变量、常量

数据类型决定数据的存储&运算方式
Java中的数据类型分为两大类
    #primitive types(基本数据类型)
        数值型
            整数类型: byte(1), short(2), int(4), long(8字节)
            浮点型: float(4), double(8)
        字符型: char(2字节,Unicode编码)
        布尔型: boolean(1字节)
    #reference types(引用类型)
        类(class)
        接口(interface)
        数组
primitive types存储在栈, 在“这里”
reference types存储在堆, 在“那里”: 引用类似指针, 在栈

boolean只有true和false, 不可以用0、非0替代
char c1 = '\u0061'; //十六进制编码
char c2 = '\123';   //八进制编码, 1-3位
\n 换行(new line),
\\, \', \"", \r回车， \f走纸换页, \t横向跳格, \b退格

整型: 十进制 12， -314, 0
     八进制 012 (以0开头)
     十六进制 0x12 (以0X/0x开头)
     二进制 0b00010010 (以0b/0B开头)
整型默认int, 常量后加'L'表long型
Remark: Java中没有无符号数, 用long处理C/C++中的uint


浮点型:默认double, 
 3.14， 2.5e2, 123_456.789_012 (千分位分割符用下划线)
 float f = 3.14f;

标识符(Identifier): 变量、常量、方法、对象、类的名字
    (1) 由字母、数字、下划线、$组合而成.
    (2) 不能用数字开头
    (3) 大小写敏感


运算符与表达式
    算术运算符: +,-,*,/,%,++,--
    关系运算符: >,<,>=,<=,==,!=
    逻辑运算符: !,&,|,^, &&(短路与), ||(短路或)
    位运算符:  &,|,^,~,>>,<<,>>>(高位补0)
    赋值运算符: =, (扩展)+=，-=，*=，/=，%=，&=，|=，^=,<<=,>>=,>>>=
    字符串连接运算符: +

    移位运算符: 
        <<低位补0， >>高位补符号位
        >>>高位补0
        (1) 低于int型先整形提升再移位
        (2) int型a>>b， b先对32取模
        (3) long型a>>b, b先对62取模
    String s = Integer.toBinaryString(n);


    赋值运算符:
        (1)当'='两侧的数据类型不一致时, 适用默认类型转换或强制类型转换(casting)原则
            long l = 100;
            int i = (int)l;
        (2) 整型常量可直接赋给byte、short、char, 无需转换
            byte b = 12; //合法
            byte c = 4096; //非法(超出其表示范围)
    
表达式: 符合一定语法规则的运算符和操作数的序列
    优先级相同的按照约定的结合方向, 适当使用括号
    Separator   . () {} ; ,
    Associative  Operators
      R to L     ++,--,~,| (data type)
      L to R     *,/，%
      L to R     +，-，.
      L to R     <<，>>,>>> 
      L to R     <,>,<=,>=,instance of
      L to R     ==,!= 
      L to R     &
      L to R     ^
      L to R     |
      L to R     &&
      L to R     ||
      R to L     ?=
      R to L     =,*=,/=,%=,+=,-=,<<=,>>=,>>>=,&=,^=,|=
    从高到低: 单目, 算术， 逻辑， 赋值

    当有不同种类的混合运算时:
        int->long->float->double
        所有的byte、short、char先转换为int
    无表达式语句、逗号运算符
    x+y; //不合法

流程控制语句: 顺序、分支、循环
    分支:
        int year = 2003;
        if( (year%4==0) && (year%100!=0) || (year%400==0) ) {
            System.out.println("A leap year");
        } else {
            System.out.println("Not a leap year");
        }
        char grade = 'C';
        switch(grade) {
            case 'A': ...; break;
            case 'B': ...; break;
            case 'C': ...; break;
            case 'D': ...; break;
            default: ;
        }
    循化:
        初始化部分   init statement
        循环条件部分 test expression
        循环体部分   body statement
        迭代部分     alter statement
        结束后处理

        for(int i = 0; i < 100 ; ++i) {
            //body statement
        }
        while(test expression) {
            //body statement
        }
        do {

        } while(test expression);

    break 标号;         //在循环前面表明是哪重循环
    continue 标号；     //不加标号只跳出一重
    label1: {
    label2:     {
    label3:         {
                        break label2;
            }        
        }
    }


#数组
    int[] a,b,c;    //a,b,c都是数组
    int a[], b, c;  //只有a是数组
    
    a.length 指明它的长度

    int[] a = new int[10];
    int[] B = new int[] { 3, 9, 8, }; //最后可以多加个逗号
    //每个元素隐式初始化
        数值初始化为0
        引用初始化为null
    
    //Enhanced for
    for(int b: B) { //只读型
        System.out.println(b);
    }

    System.arraycopy(source, 0, dest, 0, source.length);

#二维数组: 数组的数组
    int[][] a = { {1,2},{3,4,0,9},{5,6,7} };
    int[][] t = new int[3][];
    //不一定是矩形!
    t[0] = new int[2];
    t[1] = new int[10];
    t[2] = new int[4];
    
    声明时和初始化时应从高维到低维的顺序进行
    //非法: int t1[][] = new int[][4];


#类、字段、方法
    class Person {
        String name;
        int age;
        void sayHello() { System.out.println("Hello!, My name is " + name); }

        Person(int a) { age = a; }

        //Constructor
        Person(String n, int a) {
            this(a);    //调用另一构造器, 必须放在第一句
            name = n; 
        }


    }


    方法的重载(overload): 
        (1)多个方法有相同的名字, 编译时能识别出来
        (2)签名(signature)/参数个数/参数类型不同
        (3)通过方法重载可实现多态(polymorphism)

#继承(inheritance/派生):一个子类只能有一个父类
    Student is a Person.

    class SubClass extends SuperClass {
        
    }
    //无extends子句时默认为java.lang.Object的子类

    //方法的Override(覆盖/重写)
    @Override
    void sayHello() {}

    super的使用: 指明父类的域/方法 
    a = this.age;
    b = super.age;

    子类
    Student(String name, int age, String school) {
        super(name, age);   //调父类的构造器
        this.school = school;
    }
    void sayHello() {
        super.sayHello();   //继承父类的同时使用父类的方法
        ...
    }

        子类对象可以视为父类的对象, 
            例: Student对象也一个是Person
        父类对象可以强制类型转换(casting)为子类对象.


#包(package)
    java.lang, java.io, java.net, java.util, java.swing,

    解决名字空间、名字冲突
    一个包中的各个类, 默认下可互相访问.

    Remark: 一个子类 和它的父类可以在不同的包中.

#修饰符(modifiers)
    access modifiers(访问修饰符号)
        public, private, protected
    其它修饰符
        abstract等
    
                同类   同包   不同包中的子类  不同包中的非子类
    private     Yes  
    default     Yes   Yes
    protected   Yes   Yes      Yes
    public      Yes   Yes      Yes            Yes


    static    静态的、非实例的、类的     可修饰内部类   可修饰成员
    final     最终的、不可改变的         可修饰类      可修饰成员、局部变量
    abstract  抽象的、不可实例化的       可修饰类      可修饰成员

    static字段
        最本质的特点是: 它们是类的字段, 不属于任何一个实例对象
        它不保存在某个对象实例的内存区间中, 而是保存在类的内存区域的公共存储单元.
        类变量可以通过类名直接访问, 也可以通过实例对象来访问, 两种方法的结果是相同的.
        例: System类的in和out就属于类的域, 直接用类名来访问, 即System.in和System.out

        例: class A {
            static long N;
            int age;
            String name;
        };
        在一定意义上, 可以用来表示全局变量

    static方法
        static方法又称为类方法; 不用static修饰的方法, 则称为实例方法.
        类方法的本质是: 它属于整个类, 而不是属于某个实例的

        声明一个方法为static有以下几重含义.
            (1) static方法属于整个类, 它在内存中的代码段将随着类的定义而进行分配和装载, 不被任何一个对象专有.
            (2) static方法不能操纵、处理属于某个对象的成员变量, 而只能处理本类的static域或调用static方法.
            (3) static方法不能访问实例变量, 不能使用this或super.
            (4) 调用这个方法时, 可以直接用类名调用, 也可以用某一个具体对象的名字调用
        例: Math.random(), Integer.parseInt()
    
    import static java.lang.System.*;
    out.println(); //表示System.out.println();


    final类
        如果一个类是final类, 说明这个类不能被继承, 即不可能有子类.
    final方法
        final修饰符所修饰的方法, 是不能被子类所覆盖的方法.
    final字段、final局部变量
        只读量, 能且只能被赋值一次, 值一旦给定, 就不能更改.
    
    static final字段: 可以表示常量
        例: Integer.MAX_VALUE和Math.PI 
    赋值:
        static final域: 若不给定初始值, 则按默认进行初始化(数值为0, boolean为false, 引用为null)
        final字段(无static): 必须且只能赋值一次
            在定义变量时赋初值/在每一个构造器中赋值.
        final局部变量: 必须且只能赋值一次
            它的值可能不是常量, 但它的取值在变量存在期间不会改变.
    
    abstract类(抽象类): 不能被实例化

    abstract方法(抽象方法): 只需声明, 不需实现. 目的是为所有子类定义一个统一的接口.
        格式: abstract returnType method([paramlist]);

        抽象类可包含抽象方法, 也可以不包含. 但一个类包含了abstract方法, 这个类就必须声明为abstract类
        abstract方法必须在子类中被实现, 否则子类仍然是abstract的.
    
#接口(interface): 某种特征的约定
    定义接口 interface： 所有方法都自动是public abstract
    实现接口 implements: 可实现多继承, 与类的继承关系无关
    例: Flyable f = new Bird();

    作用: 
        (1) 通过接口可以实现不相关类的相同行为, 而不需要考虑这些类之间的层次关系, 从而在一定意义上实现了多重继承.
        (2) 通过接口可以指明多个类需要实现的方法.
        (3) 通过接口可以了解对象的交互界面, 而不需要了解对象所对应的类.
    例: interface Collection {          //接口声明
        void add(Object obj);
        void delete(Object obj);        //接口体
        Object find(Object obj);
        int size();
    }

    一般以able或ible结尾, 表明接口能完成一定的行为.
    [public] interface interfaceName [extends listOfSuperInterface] {
        ...
    }
    (1) 其中public指明任意类均可以使用这个接口, 而缺省情况下, 只有与该接口定义在同一个包中的类才可以访问这个接口
    (2) extends子句后是父接口列表, 与类继承的extends子句基本相同, 
        不同的是一个接口可以有多个父接口, 用逗号隔开, 而一个类只能有一个父类.
        子接口继承父接口中所有的常量和方法.
    (3) 如果在子接口中定义了和父接口同名的常量或相同的方法, 则父接口中的常量被隐藏, 方法被重载.

    实现接口:
    例: class FIFOQueue implements Collection {
        public void add(Object obj) { ... }
        ...
    }
    在类中实现接口所定义的方法时, 方法必须与接口中所定义的完全一致.

    #接口类型
        接口可以作为一种引用类型来使用, 任何实现该接口的类的实例都可以存储在该接口类型的变量中, 
        通过这些变量可以访问类所实现的接口中的方法. Java运行时系统动态地确定该使用哪个类中的方法.

        把接口作为一种数据类型可以不需要了解对象所对应的具体的类.
        例: Collection c = new FIFOQueue();
            c.add(obj);
    #接口中的常量: 自动具有public static final的属性
        type NAME = value;

    #枚举: 从Java 1.5起可用
        例: enum Light { Red, Yellow, Green };

            Light light = Light.Red;
            if(light==Light.Red) { ... }
    
    #Java8以上, 接口成员还可以是:
        static方法 
        具有具体实现的方法(default方法)
            default方法的好处是提供了一个默认实现, 子类在implements可不用再重新写了.
    

#完整的类定义
    [public] [abstract|final] class className [extends ...] [implements ...] {
        [public|protected|private] [static] [final] [transient] [volatile] type variableName;

        [public|protected|private] [static] [final|abstract] [native] [synchronized] 
        returnType methodName( [paramlist] ) [throws ...] {
            ... //statements
        }

        //构造器
        className( [paramList] ) {}
        //finalize() 
        protected void finalize() throws throwable { ... }
        //main()
        public static void main(String[] args) { ... }

    }
    (1) [transient] [volatile]跟内存访问、线程相关, [synchronized]也是线程相关的.
    (2) [native]表明是C++等语言编写的本地的方法, 非Java的方法.

#完整的接口定义
    [public] interface InterfaceName [extends SuperInterfaceList] {
        type constantName = Value;
        returnType methodName( [paramList] );
    }



Week7. 工具类及常用算法

#Java基础类库
    java.lang Java语言的核心类库, Java是自动导入Java.lang.*的
    java.util 实用工具
    java.io   标准输入/输出类库
    java.awt java.swing 图形用户界面(GUI)的类库
    java.net  网络功能的类库
    java.sql  数据库访问的类库

    http://docs.oracle.com/javase/8/docs/index.html
    JDK源码: JDK目录下的src.zip

Object类: 所有类的直接或间接父类, 让所有的类有了一致性

    (1) equals()和 ==: ==是引用是否相等, equals是内容(含义)相等
        Integer one = new Integer(1);
        Integer anotherOne = new Integer(1);
        if(one==anotherOne) ... //false
        if(one.equals(anotherOne)) ... //true

        如果覆盖equals方法, 一般也要覆盖hashCode()方法

    (2) getClass(): 它返回一个对象在运行时所对应的类的表示
        getClass()是final方法, 它不能被重载

        void printClassName(Object obj) {
            System.out.println(obj.getClass().getName());
        }

        Object createNewInstanceOf(Object obj) {
            return obj.getClass.newInstance();
        }
    (3) toString(): 返回对象的字符串表示
        通过重载toString()方法, 可以适当地显示对象的信息以进行调试.
    (4) finalize(): 用于在垃圾收集前清除对象

    (5) notify()、notifyAll()、wait(): Object的其他方法

基本数据类型的wrapper(包装类): 为与面向对象的环境一致而提供
    Character, Byte, Short, Integer, Long, Float, Double, Boolean
    (1) 提供了一些常数
        例: Integer.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY
    (2) 提供了valueOf(String), toString()
        用于从字符串转换或转换成字符串
    (3) 通过xxxValue()方法可以得到所包装的值
        例子: Integer对象的intvalue()方法 
    (4) 对象所包装的值是不可改变的(immutable)
        要改变对象中的值只有重新生成新的对象
    (5) toString(), equals()等方法进行了覆盖
    出以上特点外, 还提供了一些实用的方法以便操作
        例: Double.parseDouble()， max, min方法等.
包装(boxing)与拆包(unboxing)
    Integer I = 5; //等价于 Integer.valueOf(5);
    int i = I;     //等价于 i = I.intValue();

Math类: 完成一些常用的数学运算
    public final static double E; //2.71828182845904
    public final static double PI;//3.14159265358979
    public static double abs(double a);//绝对值
    public static double exp(double a);//参数次幂
    public static double floor(double a); //不大于参数的最大整数
    public static double IEEEremainder(double f1, double f2);//求余
    public static double log(double a); //自然对数
    public static double max(double a, double b); //最大值
    public static double min(float a, float b); //最小值
    public static double pow(double a, double b);//乘方
    public static double random(); //产生[0,1)上的伪随机数
    public static double rint(double a); //四舍五入
    public static double sqrt(double a); //平方根
    public static double sin(double a); //正弦
    public static double cos(double b); //余弦
    public static double tan(double b); //正切
    public static double asin(double b); //反正弦
    public static double acos(double b); //反余弦
    public static double atan(double b); //反正切

System类
    在Java中, 系统属性可以通过环境变量来获得
    System.getProperty(String name)方法获得特定的系统属性值
    System.getProperties() 方法获得一个Properties类的对象, 其中包含了所有可用的系统属性信息

    java -Dvar=value MyProg :使用-D选项添加新的系统属性

    
字符串
    String类
        创建之后不会再做修改和变动, 即immutable
    StringBuffer、StringBuilder类
        创建之后允许再做更改和变化
        其中StringBuilder类是JDK1.5增加的, 它是非线程安全的
    在循环中使用String的+=可能会带来效率问题
