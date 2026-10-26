
package com.automationExercise.test.practice.elements;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Practice_ItextContext {

    @Test
    public void addition(ITestContext context) {

        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;

        context.setAttribute("num1", num1);
        context.setAttribute("num2", num2);
        context.setAttribute("sum", sum);

        System.out.println("=========Addition =============");

        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);
        System.out.println("Sum = " + sum);

        System.out.println();
        System.out.println();

    }

    @Test(dependsOnMethods = "addition")
    public void multiplication(ITestContext context) {

        int num1 = (int) context.getAttribute("num1");
        int num2 = (int) context.getAttribute("num2");

        int result = num1 * num2;


        System.out.println("=========Multiple =============");

        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);
        System.out.println("Multiplication = " + result);
    }
}
