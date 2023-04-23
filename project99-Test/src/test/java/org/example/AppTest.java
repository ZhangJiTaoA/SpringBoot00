package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */

    public class MyThread extends Thread {
        String out;

        public MyThread(String output) {
            this.out = output;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("output" + this.out);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class MyThread2 implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("output");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class MyThread3 implements Callable<String> {

        public String call() throws Exception {
            return "hello zjt";
        }
    }

    // 测试多线程
    public void testApp() throws ExecutionException, InterruptedException {
        Thread myThread1 = new Thread(new MyThread2());
        MyThread myThread2 = new MyThread("2");
        Thread myThread3 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("output_Runable");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        FutureTask<String> stringFutureTask = new FutureTask<String>(new MyThread3());
        Thread thread4 = new Thread(stringFutureTask);

        myThread1.start();
        myThread2.start();
        myThread3.start();
        thread4.start();
        String s = stringFutureTask.get();
        System.out.println(s);
        System.out.println("ddd");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("rrr");
            }
        });


        try {
            sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public class Student {
        private String age;
        private String name;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // 测试反射
    public void test00() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> studengClass = Student.class;
        Method setName = studengClass.getMethod("setName", String.class);
        Student stu = new Student();
        setName.invoke(stu,"zjt");
        System.out.println(stu.getName());

    }


    public interface A {
        public void eat();

        public void drink();
    }

    public class B implements A {

        public void eat() {
            System.out.println("eat wkkkkkkkk!");
        }

        public void drink() {
            System.out.println("drink wkkkkkkk!");
        }
    }

    public class ProxyB implements A {
        public A a;

        public ProxyB() {
            this.a = new B();
        }

        public void eat() {
            System.out.println("eat zzzzzz");
            this.a.eat();
            System.out.println("eat ttttttt");
        }

        public void drink() {

        }
    }

    public class MyProxy implements InvocationHandler {
        private Object target;

        public MyProxy(Object obj) {
            this.target = obj;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("bbbbbbbb");
            method.invoke(target, args);

            System.out.println("aaaaaaaa");
            return null;
        }
    }


    // 测试代理
    public void test01() {
        A a = new B();
        A proxyB = new ProxyB();
        a.eat();
        proxyB.eat();
        MyProxy myProxy = new MyProxy(a);
        A b = (A) Proxy.newProxyInstance(a.getClass().getClassLoader(), a.getClass().getInterfaces(), myProxy);
        b.drink();

    }

    public class ZjtList<E extends Integer>{
        public void add(E e){
            System.out.println(e);
        }
    }

    // 测试泛型
    public void test02(){
        ZjtList zjtList = new ZjtList();
        zjtList.add(22);
        Set<Integer> mySet=new HashSet<Integer>();
        mySet.add(1);
        mySet.add(2);
        Iterator<Integer> iter = mySet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(1%4);
        System.out.println(1&3);
    }
}



















