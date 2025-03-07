package com.itheima;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Constants;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

@Slf4j
public class practice3 {

    public static void main(String[] args) {

        Thread t1 = new Thread("t1"){

            public void run() {
                log.debug(Thread.currentThread().getName());
            }
        };

        t1.start();

        log.debug("do other things ...");
    }
}
