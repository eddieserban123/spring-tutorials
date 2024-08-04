package com.example.session.service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Backoff;

@Service
public class MyService {
    @Retryable(
            value = {RuntimeException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000, multiplier = 1.5)
    )
    public void callRemoteService() {
        System.out.println("Calling remote service...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (true) {
            throw new RuntimeException("Remote service not available");
        }
    }

    @Recover
    public void recover(RuntimeException e) {
        System.out.println("Retries exhausted. Handling failure...");
    }

}
