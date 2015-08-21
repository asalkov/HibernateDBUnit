package com.ansa;

import com.ansa.hierarchy.*;

import java.util.Calendar;


public class MainClass {



    public static void main(String[] args) throws InterruptedException {

        BookService bookService = new BookService();

        Book major = bookService.findBook(1L);
        System.out.println("Getting book from major thread:" + major.getBookName());


        Thread th = new Thread(new TestThread());
        th.start();
        th.join();

        major.setBookName("test major" + Calendar.getInstance().getTime().getTime());
        bookService.save(major);
        System.out.println("Book is updated in major thread:"+major.getBookName());


    }

    static class TestThread implements Runnable {

        public void run() {
            BookService bookService = new BookService();
            Book secondary = bookService.findBook(1L);
            System.out.println("Getting book from major thread:"+ secondary.getBookName());
            secondary.setBookName("test secondary" + Calendar.getInstance().getTime().getTime());
            bookService.save(secondary);
            System.out.println("Book is updated in secondary:" + secondary.getBookName());



        }
    }
}
