package com.example.advanced.trace.threadlocal;

import com.example.advanced.trace.threadlocal.code.FieldService;
import com.example.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");

        Runnable userA = () -> {
            service.logic("userA");
        };
        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        //sleep(2000); //동시성 발생 X
        sleep(100); // 발생
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
