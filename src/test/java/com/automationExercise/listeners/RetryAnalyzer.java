package com.automationExercise.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    private static final int MAX_RETRY_COUNT = 1;

    private static final ThreadLocal<Boolean> FINAL_FAILURE =
            ThreadLocal.withInitial(() -> false);

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            FINAL_FAILURE.set(false);

            return true;
        }

        FINAL_FAILURE.set(true);

        return false;
    }

    public static boolean isFinalFailure() {
        return FINAL_FAILURE.get();
    }

    public static void clearFinalFailure() {
        FINAL_FAILURE.remove();
    }
}