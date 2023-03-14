package com.zjt.project00.service;


import org.springframework.stereotype.Service;

@Service
public class HelloService {
    class myThread extends Thread{
        private String out;
        public myThread(String output){
            this.out=output;
        }

        @Override
        public void run(){
            System.out.println("hello"+this.out);
        }
    }

    public void helloServiceThread(){
        myThread myThread1 = new myThread("1");
        myThread myThread2 = new myThread("2");
        myThread1.start();
        myThread2.start();
        while (true){

        }

    }

}
