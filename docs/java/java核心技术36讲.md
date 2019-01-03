# 极客时间学习笔记
<!-- GFM-TOC -->
* [一、谈谈你对Java平台的理解](#一谈谈你对Java平台的理解)
* [二、Exception和Error区别](#二Exception和Error区别)
* [三、final、finally、finalize区别](#final、finally、finalize区别)
* [谈谈Spring Bean的生命周期和作用域](#谈谈Spring Bean的生命周期和作用域)
极客时间版权所有: https://time.geekbang.org/column/article/8799


<!-- GFM-TOC -->
# 一、谈谈你对Java平台的理解
 Java 本身是一种面向对象的语言，最显著的特性有两个方面，一是所谓的“书写一次，到处运行”能够非常容易地获得跨平台能力；我们开发的 Java 的源代码，首先通过 Javac 编译为字节码（bytecode），然后，在运行时，通过 Java 虚拟机（JVM）内嵌的解释器将字节码转换成为最终的机器码。  
 我们通常把 Java 分为编译期和运行时。  
 编译期，Javac 的编译，编译 Java 源码生成“.class”文件里面实际是字节码，而不是可以直接执行的机器码。Java 通过字节码和 Java 虚拟机（JVM）这种跨平台的抽象，屏蔽了操作系统和硬件的细节，这也是实现“一次编译，到处执行”的基础。  
 在运行时，JVM 会通过类加载器（Class-Loader）加载字节码，解释或者编译执行。  
 Java 虚拟机启动时，可以指定不同的参数对运行模式进行选择比如，指定“-Xint”，就是告诉 JVM 只进行解释执行不对代码进行编译。  
 Java的跨平台特性与Java虚拟机的存在密不可分，可在不同的环境中运行比如说Windows平台和Linux平台都有相应的JDK，安装好JDK后也就有了Java语言的运行环境。程序从源代码到运行的三个阶段：编码——编译——运行——调试。Java在编译阶段则体现了跨平台的特点。编译过程大概是这样的：首先是将Java源代码转化成.CLASS文件字节码，这是第一次编译。.class文件就是可以到处运行的文件。然后Java字节码会被转化为目标机器代码，这是是由JVM来执行的，即Java的第二次编译。“到处运行”的关键和前提就是JVM。因为在第二次编译中JVM起着关键作用。在可以运行Java虚拟机的地方都内含着一个JVM操作系统。从而使JAVA提供了各种不同平台上的虚拟机制，因此实现了“到处运行”的效果。需要强调的一点是，java并不是编译机制，而是解释机制。Java字节码的设计充分考虑了JIT这一即时编译方式，可以将字节码直接转化成高性能的本地机器码，这同样是虚拟机的一个构成部分。

                                                            
  # 二、Exception和Error区别
  Exception和Error都是继承了Throwable类，在Java中只有Throwable 类型的实例才可以被抛出（throw）或者捕获（catch）它是异常处理机制的基本组成类型。  
  Exception 是程序正常运行中，可以预料的意外情况，可能并且应该被捕获，进行相应处理。  
  Error 是指在正常情况下，不大可能出现的情况，绝大部分的Error都会导致程序（比如 JVM 自身）处于非正常的、不可恢复状态。
                                                        
# 三、final、finally、finalize区别
  
 final 可以用来修饰类、方法、变量，分别有不同的意义，final 修饰的 class 代表不可以继承扩展，final 的变量是不可以修改的，而 final 的方法也是不可以重写的（override）。  
 finally 则是 Java 保证重点代码一定要被执行的的一种机制。我们可以使用 try-finally 或者 try-catch-finally 来进行类似关闭 JDBC连接、保证 unlock 锁等动作。  
 finalize 是基础类 java.lang.Object 的一个方法，它的设计目的是保证对象在被垃圾收集前完成特定资源的回收。finalize 机制现在已经不推荐使用。  
                                  
                                   
  # 。。。省略
   
# 谈谈Spring Bean的生命周期和作用域
 在Spring中，那些组成应用程序的主体及由Spring IoC容器所管理的对象，被称之为bean。简单地讲，bean就是由IoC容器初始化、装配及管理的对象。  
 1.  Spring Bean 生命周期比较复杂，可以分为创建和销毁两个过程。  
 首先，创建 Bean 会经过一系列的步骤，主要包括：
 - 实例化Bean对象。 
 - 设置Bean属性。
 - 如果我们通过各种 Aware 接口声明了依赖关系，则会注入 Bean 对容器基础设施层面的依赖。具体包括 BeanNameAware、BeanFactoryAware 和 ApplicationContextAware，分别会注入 Bean ID、Bean Factory 或者 ApplicationConText。
 - 调用 BeanPostProcessor 的前置初始化方法postProcessBeforeInitialization。
 - 如果实现了 InitializingBean 接口，则会调用afterPropertiesSet 方法。
 - 调用 Bean 自身定义的 init 方法。
 - 调用 BeanPostProcessor 的后置初始化方法postProcessAfterInitialization。
 - 创建过程完毕。
 第二，Spring Bean 的销毁过程会依次调用DisposableBean 的 destroy 方法和Bean 自身定制的 destroy 方法。
 
 2. Spring Bean有五个作用域，其中最基础的有下面两种...
   - Singleton，这是 Spring 的默认作用域，也就是为每个 IOC 容器创建唯一的一个 Bean 实例。
   - Prototype，针对每个 getBean 请求，容器都会单独创建一个 Bean 实例。  
   如果是 Web 容器，则支持另外三种作用域：
   - Request，为每个 HTTP 请求创建单独的 Bean实例。  
   - Session，很显然 Bean 实例的作用域是 Session 范围。
   - GlobalSession，用于 Portlet 容器，因为每个 Portlet 有单独的 Session，GlobalSession 提供一个全局性的HTTP Session。
                                                                           
 3. Spring 的基础机制  
  - 控制反转（Inversion of Control）或者也叫依赖注入（Dependency Injection）广泛应用于 Spring 框架之中，可以有效地改善了模块之间的紧耦合问题。 从 Bean 创建过程可以看到，它的依赖关系都是由容器负责注入，具体实现方式包括带参数的构造函数、setter 方法或者AutoWired方式实现。
  - AOP，我们已经在前面接触过这种切面编程机制，Spring 框架中的事务、安全、日志等功能都依赖于 AOP...通过 AOP 等机制，我们可以把横跨多个不同模块的代码抽离出来，让模块本身变得更加内聚，进而业务开发者可以更加专注于业务逻辑本身。
                                                                                                        
 # Java 应用开发中的注入攻击
   1. 最常见的 SQL 注入攻击
   假设应用逻辑是，后端程序利用界面输入动态生成类似下面的SQL，然后让 JDBC 执行。
   Select * from use_info where username = “input_usr_name” and password = “input_pwd”  
   但是，如果我输入的 input_pwd 是类似下面的文本，“ or “”=”  
   Select * from use_info where username = “input_usr_name” and password = “” or “” = “” ；
   那么，拼接出的 SQL 字符串就变成了下面的条件，OR 的存在导致输入什么名字都是复合条件的。
   2. 操作系统命令注入，Java 语言提供了类似 Runtime.exec(…) 的的 API，可以用来执行特定命令，假设我们构建了一个应用，以输入文本作为参数执行下面的命令：ls –la input_file_name。但是如果用户输入是 “input_file_name;rm –rf /*”，就有可能有问题。
   3. XML 注入攻击。
# 集合框架
## Vector、ArrayList、LinkedList 区别
Vector 是 Java 早期提供的线程安全的动态数组，Vector 内部是使用对象数组来保存数据，可以根据需要自动的增加容量，当数组已满时，会创建新的数组，并拷贝原有数组数据。  
ArrayList 是应用更加广泛的动态数组实现，它本身不是线程安全的，所以性能要好很多。与 Vector 近似，ArrayList 也是可以根据需要调整容量，不过两者的调整逻辑有所区别，Vector 在扩容时会提高 1 倍，而 ArrayList 则是增加 50%。  
LinkedList 顾名思义是 Java 提供的双向链表，所以它不需要像上面两种那样调整容量，它也不是线程安全的。
## set
TreeSet 支持自然顺序访问，但是添加、删除、包含等操作要相对低效（log(n) 时间）。  
HashSet 则是利用哈希算法，理想情况下，如果哈希散列正常，可以提供常数时间的添加、删除、包含等操作，但是它不保证有序。
LinkedHashSet，内部构建了一个记录插入顺序的双向链表，因此提供了按照插入顺序遍历的能力，与此同时，也保证了常数时间的添加、删除、包含等操作，这些操作性能略低于 HashSet，因为需要维护链表的开销。
## Hashtable、HashMap、TreeMap
Hashtable 是早期 Java 类库提供的一个哈希表实现，本身是同步的，不支持 null 键和值。由于同步导致的性能开销，所以已经很少被推荐使用。  
HashMap 不是同步的，支持 null 键和值等。通常情况下，HashMap 进行 put 或者 get 操作。  
TreeMap 则是基于红黑树的一种提供顺序访问的 Map。  
这个可以去看一些博客。

# synchronized和ReentrantLock区别
 synchronized是Java内建的同步机制，叫（内锁）Intrinsic Locking它提供了互斥的语义和可见性，当一个线程已经获取当前锁时，其他试图获取的线程只能等待或者阻塞在那里。  
 ReentrantLock，通常翻译为再入锁，再入锁通过代码直接调用 lock() 方法获取，代码书写也更加灵活。与此同时，ReentrantLock提供了很多实用的方法，能够实现很多 synchronized无法做到的细节控制，比如可以控制fairness，也就是公平性，或者利用定义条件等。但是，编码中也需要注意，必须要明确调用 unlock()方法释放，不然就会一直持有该锁。  
 
 理解什么是线程安全。 synchronized、ReentrantLock 等机制的基本使用与案例。掌握 synchronized、ReentrantLock底层实现。理解锁膨胀、降级；理解偏斜锁、自旋锁、轻量级锁、重量级锁等概...掌握并发包中 java.util.concurrent.lock 各种不同实现和案例分析。  
 
 1. 线程安全是一个多线程环境下正确性的概念，也就是保证多线程环境下共享的、可修改的状态的正确性，这里的状态反映在程序中其实可以看作是数据。  
    - 保证线程安全的两个办法：封装：通过封装，我们可以将对象内部状态隐藏、保护起来；不可变：
    - 线程安全需要保证几个基本特性： 原子性，简单说就是相关操作不会中途被其他线程干扰，一般通过同步机制实现。可见性，是一个线程修改了某个共享变量，其状态能够立即被其他线程知晓，通常被解释为将线程本地状态反映到主内存上，volatile 就是负责保证可见性的。有序性，是保证线程内串行语义，避免指令重排等。
 2.ReentrantLock，它是表示当一个线程试图获取一个它已经获取的锁时，这个获取动作就自动成功，这是对锁获取粒度的一个概念也就是锁的持有是以线程为单位而不是基于调用次数。Java 锁实现强调再入性是为了和 pthread 的行为进行区分。再入锁可以设置公平性（fairness）我们可在创建再入锁时选择是否是公平的。
 ````$xslt
ReentrantLock fairLock = new ReentrantLock(true);
````
 这里所谓的公平性是指在竞争场景中，当公平性为真时会倾向于将锁赋予等待时间最久的线程。公平性是减少线程“饥饿”（个别线程长期等待锁，但始终无法获取）情况发生的一个办法。  
 如果使用 synchronized，我们根本无法进行公平性的选择，其永远是不公平的，这也是主流操作系统线程调度的选择。若要保证公平性则会引入额外开销，自然会导致一定的吞吐量下降。所以，我建议只有当你的程序确实有公平性需要的时候，才有必要指定公平锁。
 - ReentrantLock 相比 synchronized，因为可以像普通对象一样使用，所以可以利用其提供的各种便利方法，进行精细的同步操作，如：带超时的获取锁尝试。可以判断是否有线程，或者某个特定线程，在排队等待获取锁。可以响应中断请求。  
 条件变量（java.util.concurrent.Condition）如果说 ReentrantLock 是synchronized 的替代选择，Condition 则是将 wait、notify、notifyAll 等操作转化为相应的对象，将复杂而晦涩的同步操作转变为直观可控的对象行为。条件变量最为典型的应用场景就是标准类库中的ArrayBlockingQueue 等。
  ````$xslt
  //首先，通过再入锁获取条件变量：
/** Condition for waiting takes */
private final Condition notEmpty;

/** Condition for waiting puts */
private final Condition notFull;
 
public ArrayBlockingQueue(int capacity, boolean fair) {
	if (capacity <= 0)
    	throw new IllegalArgumentException();
	this.items = new Object[capacity];
	lock = new ReentrantLock(fair);
	notEmpty = lock.newCondition();
	notFull =  lock.newCondition();
}
//两个条件变量是从同一再入锁创建出来，然后使用在特定操作中
public E take() throws InterruptedException {
	final ReentrantLock lock = this.lock;
	lock.lockInterruptibly();
	try {
    	while (count == 0)
        	notEmpty.await();
    	return dequeue();
	} finally {
    	lock.unlock();
	}
}

````                                                                                                                                                                      
3. synchronized 代码块是由一对儿monitorenter/monitorexit 指令实现的Monitor 对象是同步的基本实现单元。JVM提供了三种不同的 Monitor 实现，也就是常说的三种不同的锁：偏斜锁（Biased Lockin）、轻量级锁和重量级锁，大大改进了其性能。  

所谓锁的升级、降级，就是 JVM 优化 synchronized 运行的机制，当 JVM 检测到不同的竞争状况时，会自动切换到适合的锁实现，这种切换就是锁的升级、降级。  
当没有竞争出现时，默认会使用偏斜锁。JVM 会利用 CAS 操作（compare and swap）在对象头上的 Mark Word 部分设置线程 ID以表示这个对象偏向于当前线程，大部分对象生命周期中最多会被一个线程锁定，使用偏斜锁可以降低无竞争开销。  
如果有另外的线程试图锁定某个已经被偏斜过的对象，JVM 就需要撤销（revoke）偏斜锁，并切换到轻量级锁实现。轻量级锁依赖 CAS 操作Mark Word 来试图获取锁，如果重试成功，就使用普通的轻量级锁；否则，进一步升级为重量级锁。当 JVM 进入安全点（SafePoint）的时候，会检查是否有闲置的 Monitor，然后试图进行降级。
                                                                                                                                                   
                                                                                                                                    
# 一个线程两次调用 start() 方法会出现
   
Java 的线程是不允许启动两次的，第二次调用必然会抛出IllegalThreadStateException，
- 线程状态：
     <div align="center"> <img src="../pic/thread.png " width=""/> </div><br>  
                             
-  守护线程（Daemon Thread）有的时候应用中需要一个长期驻留的服务程序，但是不希望其影响应用退出，就可以将其设置为守护线程，如果 JVM 发现只有守护线程存在时，将结束进程。注意，必须在线程启动之前设置。
 ````$xslt
Thread daemonThread = new Thread();
daemonThread.setDaemon(true);
daemonThread.start();
````
 - ThreadLocal，这是 Java 提供的一种保存线程私有信息的机制，因为其在整个线程生命周期内有效，所以可以方便地在一个线程关联的不同业务模块之间传递信息，比如事务 ID、Cookie 等上下文相关信息。ThreadLocalMap！这就是很多 OOM 的来源，
                                                                                                            

                            
                                                                                   