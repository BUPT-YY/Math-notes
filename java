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
        https://docs.oracle.com/en/java/javase/16/docs/api/index.html
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
        public static void main(String... args) { ... }

    }
    (1) [transient] [volatile]跟内存访问、线程相关, [synchronized]也是线程相关的.
    (2) [native]表明是C++等语言编写的本地的方法, 非Java的方法.

#完整的接口定义
    [public] interface InterfaceName [extends SuperInterfaceList] {
        type constantName = Value;
        returnType methodName( [paramList] );
    }

#变量及其传递
    primitive type: 其值直接存于变量中, 在“这里”
    reference type: 除占据一定的内存空间外, 它所引用的对象实体(由new创建)也要占据一定空间. 在"那里"
        MyDate m,n; m = new MyDate();
        n = m; n.addYear();
    字段变量(field)与局部变量(local variable):
        前者在类中, 后者是方法中定义的变量或方法的参变量

        从内存角度看, 
            存储位置: 字段变量为对象的一部分、存在于堆中, 局部变量是存在于栈中
            生命周期不同
            初始值: 字段变量可以自动赋初值, 局部变量则须显示赋值
        从语法角度看:
            字段变量属于类, 可以用public, private, static, final修饰
            局部变量不能够被访问控制符及static修饰
            都可以被final修饰
    变量的传递
        调用对象方法时, 要传递参数, 在传递参数时,
        Java是值传递, 即, 是将表达式的值复值给形式参数
        对于引用型变量, 传递的值是引用值, 而不是复制对象实体
            可以改变对象的属性
    变量的返回
        返回基本类型
        返回引用类型, 它就可以存取对象实体

#多态和虚方法调用
    多态(polymorphism)是指一个程序中相同的名字表示不同的含义的情况
    多态有两种情形
        编译时多态:
            重载(overload) (多个同名的不同方法): 如p.sayHello(); p.sayHello("Wang");
        运行时多态:
            覆盖(override) (子类对父类进行覆盖)
            动态绑定(dynamic binding) --- 虚方法调用(virtual method invoking)
            在调用方法时, 程序会正确地调用子类对象的方法.
    多态的特点大大提高了程序的抽象程度和简洁性.

    上溯造型(upcasting): 把派生类当所基类来处理
        Person p = new Student();
        void fun(Person p) {...} fun(new Person());
    
    虚方法调用: 可以实现运行时的多态
        子类重载了父类方法时, 运行时系统根据调用该方法的实例的类型来决定选择哪个方法调用
        所有的非static且非private且非final方法都会自动地进行动态绑定.
    
    动态类型确定: 变量 instanceof 类型(结果是boolean值)
        Object[] things = new Object[2];
        things[0] = new Integer(3);
        things[1] = new String("2.09");
        System.out.println(things[0] instanceof Integer);
        System.out.println(things[0] instanceof String);

    什么情况下不是虚方法调用
        Java中, 普通的方法是虚方法
        但static/private/final方法不是虚方法调用
        static/private/final与虚方法编译后用的指令是不同的.
            static的方法, 以声明的类型为准, 与实例类型无关
            private方法子类看不见, 也不会被虚化
            final方法子类不能覆盖, 不存在虚化的问题.

#对象的构造与初始化
    构造器(constructor)
        对象都有构造方法
        如果没有, 编译器加一个default构造方法
    抽象类(abstract):虽然不能new抽象类的对象, 但是有, 它的子类也会调它的构造方法!(日他仙人板板)
    
    调用本类或父类的构造方法
        this调用本类的其它构造方法
        super调用父类的构造方法
        this或super要放在第一条语句, 且只能够有一条

        如果没有this及super, 则编译器自动加上super(), 即调用直接父类的无参构造方法
        (因为必须令所有父类的构造方法都得到调用, 否则整个对象的构建就可能不正确)
    
    一个问题
        class A {
            A(int a) {}
        }
        class B extends A {
            B(String s) {} //不能通过编译
        }
        解决的三个方法: 
            1、在A中实现A(){}
            2、在B的构造器中加入super(3)
            3、去掉A(int a) {}, 让编译器自动加入A(){}

    创建对象时初始化
        jb = new JB() {{ len = 18; d = 5; }}
        这样可以针对没有相应构造函数, 但又要赋值
        (注意双括号)

    实例初始化(instance initializers)
        在类中直接写 { 语句... }
        实例初始化, 先于构造方法{}中的语句执行
    静态初始化(static initializers)
        static { 语句... }
        静态初始化, 在第一次使用这个类的时候要执行
        但其执行的具体时机是不确定的
            但可以肯定的是: 总是先于实例的初始化

    构造方法的执行过程
        遵照以下步骤:
            调用本类/父类的构造方法, 直至最高一层(Object)
            按照声明顺序执行字段的初始化赋值
            执行构造函数中的语句
        简单说: 先父类构造, 再本类成员构造, 最后执行构造方法中的语句.
            class Test {
                int a = 2000;       //step2
                Test() { 
                    //super();      //step1
                    this.a = 3000;  //step3
                }
            }
    一个问题: 构造方法内部调用别的方法, 如果这个方法又是虚方法, 结果如何?
        从语法上来说, 这是合法的, 但有时会造成事实上的不合理(有时step3才执行好初始化, 调用时值还没准备好).
    --->> 在构造器中, 正常人应该避免调用任何方法, 用尽可能简单的方法使对象进入就绪状态
    --->> 唯一能够安全调用的是具有final属性的方法

#对象清除与垃圾回收
    new创建对象, Java中是自动清除, 不需要使用delete

    垃圾回收(garbage collection)
        垃圾回收是由Java虚拟机的垃圾回收线程来完成的.
        为什么系统知道对象是否为垃圾:
            任何对象都有一个引用计数器, 当其值为0时, 说明该对象可以回收
        System.gc()方法
            它是System类的static方法
            它可以建议(suggest)系统进行垃圾回收
        Object的finalize()
            系统在回收时会自动调用对象的finalize()方法
            protected void finalize() throws throwable{}
        
            子类的finalize()
                可以在子类的finalize()方法释放系统资源
                一般来说, 子类的finalize()方法中应该调用父类的finalize()方法, 以保证父类的清理工作能够正常进行
        由于finalize()方法调用的时机并不确定, 所以一般不用finalize()

    try-with-resources: 关闭打开的文件、清除一些非内存资源等工作需要进行处理(JDK1.7以上)
        对于实现了java.lang.AutoCloseable的对象
        try(Scanner scanner = new Scanner(...)) {
             ...
        }
        会自动调用其close()方法, 相当于
        finally{
            Scanner.close();
        }

#内部类与匿名类
    内部类(inner class)是在其他类中的类
        class xxx {
            class yyyy{ }
        }
        编译器生成xxx$yyyy这样的class文件
        内部类不能与外部类同名

        使用: 
            在封装它的类的内部： 与普通类的使用方式相同
            在其他地方使用:
                类名前要冠以外部类的名字
                在new创建内部类时, 也要在new前面冠以变量对象
                    xxx.new yyyy( [args...]);
                
        内部类中可以直接访问外部类的字段及方法
            即使private也可以
        如果内部类有与外部类同名的字段或方法, 则可以用
            外部类名.this.字段/方法

        内部类的修饰符
            访问控制符: public, protected, 默认及private
                外部类只能够使用public修饰或者默认
                final, abstract
            static修饰符
                用static修饰内部类, 表明该内部类实际是一种外部类
                    因为它与外部类的实例无关
                    有人认为static的类是嵌套类(nested class), 不是内部类(inner class)
                static类在使用时:
                    实例化static类时, 在new前面不需要用对象实例变量
                    static类中不能访问其外部类的非static的字段及方法, 既只能够访问static成员
                    static方法中不能访问非static的域及方法, 也不能够不带前缀地new一个非static的内部类

        局部类(local class):在一个方法中也可以定义类
            同局部变量一样, 方法中的内部类
                不能够用public, private, protected, static修饰
                但可以被final或者abstract修饰
            可以访问其外部类的成员
            不能够访问该方法的局部变量, 除非是final局部变量
        
    匿名类(anonymous class)是一种特殊的内部类, 它没有类名, 在定义类的同时就生成该对象的一个实例
        "一次性使用"的类
        new Object() { ... }
        不取名字, 直接用其父类或接口的名字
            也就是说, 该类是父类的子类, 或者实现了一个接口
            编译器生成xxxx$1之类的名字
        类的定义的同时就创建实例, 即类的定义前面有一个new
            new 类名/接口名() { ... }
            不使用关键词class, 也不使用extends及implements
        在构造对象时使用父类构造方法
            不能定义构造方法, 因为它没有名字
            如果new对象时, 要带参数, 则使用父类的构造方法
        例: button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ...
            }
        });
        例: Arrays.<Book>sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.getPrice() - b2.getPrice();
            }
        });

    Lambda表达式的基本写法
        (参数) -> 结果
        例: (String s) -> s.length()
            x -> x*x
            () -> { System.out.println("Hello, world!"); }
        大体相当于其他语言的"匿名函数"/"函数指针"
        在Java中它实际上是"匿名类的一个实例"
            Runnable runnable = new Runnable() {
                public void run() { ... }
            };
            new Thread(runnable).start();

            Runnable runnable = () -> { ... };
            new Thread(runnable).start();

            new Thread(
                () -> { ... }
            ).start();

            @FunctionalInterface
            interface Fun {double fun(double x); }

            public class LambdaIntegral {
                public static void main(String... args) {
                    double d = integrate( x-> Math.sin(x), 0, Math.PI, 1e-5);
                    System.out.println(d);
                }
                static double integrate(Fun f, double a, double b, double eps) {
                    int n,k; double fa,fb,h,t1,p,s,x,t = 0;
                    fa = f.fun(a); fb = f.fun(b);
                    n = 1; h = b - a;
                    t1 = h*(fa+fb)/2.0;
                    p = Double.MAX_VALUE;
                    while(p>=eps) {
                        ...
                    }
                }
            }

            
        可以看出, Lambda表达式是接口/接口函数的简写, 
            Lambda表达式不仅仅简写了代码, 它还奖代码也当成数据来处理

新的语法
    从JDK1.5起, 增加了一些新的语法, 大部分是翻译器自动翻译的, 称为Compiler sugar

    基本类型的包装类
        它将基本类型(primitive type)包装成Object(reference type)
            如int-> Integer
        共8类: Boolean, Byte, Short, Character, Integer, Long, Float, Double
        Integer I = new Integer(10);

        Boxing & unboxing
        Integer I = 10;     //译为Integer I = Integer.valueOf(10);
        int i = I;          //译为int i = I.intValue();

        主要方便用于集合中, 如:
        Object[] array = { 1, "aaa" };
    枚举(enum)是一种特殊的class类型
        在简单的情况下, 用法与其它语言的enum相似
            enum Light { Red, Yellow, Green };
            Light light = Light.Red;
        但实际上, 它生成了 final class Light extends java.lang.Enum<Light> {
            public static final Light Red;
            public static final Light Yellow;
            public static final Light Green;
            public static Light[] values();
            public static Ligh valueOf(java.lang.String);
        }
    自定义枚举: 可以在enum定义体中, 添加字段、方法、构造方法
    enum Direction {
        EAST("东", 1), SOUTH("南", 2), WEST("西", 3), NORTH("北", 4);
        private Direction(String desc, int num) {
            this.desc = desc; this.num = num;
        }
        private String desc; private int num;
        public String getDesc() { return desc; }
        public int getNum() { return num; }
    }

    注解(annotation)
        又称为注记/标记/标注/注释(不同于comments)/元数据
        是在各种语法要素上加上附加信息, 以供编译器或其他程序使用
        所有的注解都是java.lang.annotation.Annotation的子类

        例: JDK内置的Annotation
            @Override           表示覆盖父类的方法
            @Deprecated         表示过时的方法
            @SuppressWarnings   表示让编译器不产生警告 @SuppressWarnings({"unchecked", "deprecation"})
        自定义注解
            @Target(ElementType.METHOD)         //表明可以用于方法上
            @Retention(RetentionPolicy.RUNTIME) //表明可以用反射来读取
            @Documented                         //表明它会生成到javadoc中
            public @interface DebugTime {  //使用@interface来定义一个类型, 表示它是一个注解
                boolean value() default true;
                long timeout() default 100;
                String msg();
                int[] other() default {};
            }
        注解的使用
            class MyClass {
                @DebugTime(value = true, timeout = 10, msg = "时间太长", other = {1,2,3})
                public double fib(int n) {
                    if(n==0||n==1)
                        return 1;
                    else return fib(n-1)+fib(n-2);
                }
            }
        用反射来读取注解
            method.getAnnotation(注解.class)
            method.getAnnocations()

            Class clz = new MyClass().getClass();
            Method method = clz.getMethod("fib", int.class);
            for(Method m : clz.getDeclaredMethods() ) {
                System.out.println(m);
                for(Annotation ann : m.getAnnocations() ) {
                    System.out.pritnln(ann.annotationType().getName());
                }
            }
            
            if(method.isAnnotationPresent(DebugTime.class)) {
                DebugTime debug = method.getAnnotation(DebugTime.class);
                boolean requireDebug = debug.value();
                long timeout = debug.timeout();
                if(requireDebug) {
                    Date t0 = new Date();
                    double fib = obj.fib(40);
                    Data t1 = new Date();
                    long time = t1.getTime() - t0.getTime();
                    System.out.println("time used" + time);
                    if(time > timeout) {
                        System.out.println(debug.msg() );
                    }
                }
            }
            
    没有指针的Java语言
        引用(reference)实质就是指针(pointer)
        但它是受控的、安全的, 例如
            会检查空指引
            没有指针运算 *(p+5)
            不能访问没有引用到的内存
            自动回收垃圾

        C语言指针在Java中的体现
            (1)传地址 -> 对象
                引用类型, 引用本身就相当于指针
                    可以用来修改对象的属性、调用对象的方法
                基本类型: 没有对应的
                    如 int a = 8, b = 9; swap(a,b);
                    一种变通的办法, 传出一个有两个分量x,y的对象
            (2)指针运算 -> 数组
                *(p+5) 则可以用 p[5]
            (3)函数指针 -> 接口、Lambda表达式
                例: 线程、回调函数、事件处理
            (4)指向节点的指针 -> 对象的引用
                class Node {
                    Object data;
                    Node next;
                }
            (5)使用JNI(Java Native Interface)
                它允许Java代码和其他语言写的代码进行交互

相等还是不等
    ==: 基本类型是值相等, 引用类型是引用相等
    但有具体情形具体分析:
        数值类型: 转换后比较
        浮点数, 最好不直接用==
        Double.NAN==Double.NAN结果是false
        boolean型无法与int相比较
    例:
        Integer i = new Integer(10);
        Integer j = new Integer(10);
        System.out.println(i == j); //false, 因为对象是两个

        Integer m = 10;
        Integer n = 10;
        System.out.println(m == n); //true, 因为对象有缓存

        Integer m = 200;
        Integer n = 200;
        System.out.println(p == q); //false, 因为对象是两个

    装箱对象是否相等: 注意缓存
    If the value p being boxed is true, false, a byte, or a char in
    the range \u0000 to \u007f, or an int or short number between
    -128 and 127(inclusive), then let r1 and r2 be the results of 
    any two boxing conversions of p. It is always the case that r1==r2.

    枚举对象: 内部进行了唯一实例化, 所以可以直接判断
    
    引用对象:
        是直接看两个引用是否一样
        如果要判断内容是否一样, 则要重写equals方法
        如果重写equals方法, 则最好重写hashCode()方法

    String对象
        判断相等, 一定不要用==, 要用equals
        但是字符串常量(String literal)及字符串常量会进行内部化(interned)
        相同的字符串常量是==的.
            例:
                String hello = "Hello", lo = "lo";
                System.out.println(hello == "Hello"); //true
                System.out.println(Other.hello == hello); //true

                System.out.println(hello == ("Hel" + "lo")); //true
                System.out.println(hello == ("Hel" + lo)); //false

                System.out.println(hello == new String("Hello")); //false
                System.out.println(hello == ("Hel" + lo).intern()); //true
               

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

    String类对象保存不可修改(immutable)的Unicode字符序列
        String类的下述方法能创建并返回一个新的String对象实例:
            concat(追加), replace, replaceAll, substring, toLowerCase, toUpperCase,
            trim(空格指小于等于'U+0020'的字符), toString.
        查找: endsWith, startsWith, indexOf, lastIndexOf.
        比较: equals, euqalsIgnoreCase,
        字符及长度: charAt, length
        正则表达式: matches, replaceAll, split
        JDK1.5增加了format函数 %1$,8.5f %序号$ 标识 宽度及精度 转换方式
    
        字符串常量
            除了immuatble特点外, 还要注意String常量的内部化(interned)问题
            即同样的字符串常量是合并的(是指向同一个引用的), 以保证"abc"=="abc"
                但是"abc"!=new String("abc")
        
        
    StringBuffer类: 对象保存可修改的Unicode字符序列, 线程安全
        StringBuffer(), StringBuffer(int capacity), StringBuffer(String initialString)
        实现修改操作的方法:
            append, insert, reverse, setCharAt, setLength
    StringBuilder类似, 它效率更高, 但不考虑线程安全性

    java.util.StringTokenizer:字符串的分割功能
        StringTokenizer(String str, String delim);
        public int countTokens();           //分割串的个数
        public boolean hasMoreTokens();     //是否还有分割串
        public String nextToken();          //得到下一个分割串

日期类 
             getTime()       getTime()
    Calendar ---------> Date ----------> long 

    Calendar
        得到一个实例 Calendar.getInstance() //Locale.ZH
        .get(DAY_OF_MONTH)
        .getDisplayName(DAY_OF_WEEK)
        .set    .add(HOUR, 1)   .roll(MONTH, 5)
        .setTime(data),     .getTime()
    Date
        new Date(),     new Date(System.currentTimeMillis())
        .setTime(long)  .getTime()
    SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        .format,    .parse
    
    Java8中的time api
        java.time.*
        java.time.format.*
        主要的类
            Instant时刻
            Clock时区
            Duration时间段
            常用的类LocalDateTime, LocalDate, LocalTime
                .of, .parse, .plus, .minus
            DateTimeFormatter

集合类(Collection API): 提供"集合"、"收集"的功能

    Collection接口: 有两个子接口
        List: 记录元素的保存顺序, 且允许有重复元素
        Set: 不记录元素的保存顺序, 且不允许有重复元素
    Map接口: 映射
        键-值对(key-value pair)的集合
    

    Collection接口
        add(element: object) : boolean
        remove(element: object): boolean
        size(): int
        isEmpty(): boolean
        contains(element: object): boolean
        iterator(): Iterator
    
    接口的层次:
    Iterable
        Collection
            Set
                HashSet
                TreeSet
            List
                Vector
                    Stack
                ArrayList
            Queue
                ArrayDeque
                PriorityQueue
            List, Queue
                LinkedList
    
    List接口: 线性表(Linear list)
        主要的实现类是ArrayList, LinkedList, 以及早期的Vector
        public interface List<E> extends Collection<E> {
            E get(int index);
            E set(int index, E element);
            void add(int index, E element);
            E remove(int index);
            int indexOf(Object o);
            ...
        }

    Iterator迭代器(所有的Collection都能产生)
        Iterator iterator = iterable.iterator();
        while(iterator.hasNext())
            doSomething(iterator.next());
        for(Element e: list)
            doSomething(e)
        
