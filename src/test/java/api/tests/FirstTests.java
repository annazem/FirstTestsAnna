package api.tests;

import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTests {
    private int a;
    private int b;

    @AfterMethod(alwaysRun = true)
    void afterMethod(){
        System.out.println();
    }

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        a = 20;
        b = 4;
        Allure.step("text");
        System.out.println("Проверим, работает ли оно?");
        System.out.println();
    }

    @AfterClass(alwaysRun = true)
    void afterClass() {
        System.out.println("Работает!!!");
    }

    @Test(priority = 1, description = "Первый тест - Сложение")
    void firstTestSum() {
        System.out.println("Посчитаем сумму чисел 20 и 4");
        int sum = a + b;
        System.out.println("Сумма чисел: " + sum);
        Assert.assertEquals(24, sum, "Что-то пошло не так! Сумма считается не верно!");

    }

    @Test(priority = 2, description = "Второй тест - Вычитание")
    void secondTestSubtract() {
        System.out.println("Посчитаем разницу чисел 20 и 4");
        int sub = a - b;
        System.out.println("Разница чисел: " + sub);
       Assert.assertEquals(16, sub, "Что-то пошло не так! Разница считается не верно!");
    }

    @Test(priority = 3, description = "Третий тест - Умножение")
    void thirdTestMultiply() {
        System.out.println("Умножим числа 20 и 4");
        int mul = a * b;
        System.out.println("Произведение чисел: " + mul);
        Assert.assertEquals(80, mul, "Что-то пошло не так! Произведение считается не верно!");
    }

    @Test(priority = 4, description = "Четвертый тест - Деление")
    void fourthTestDivision() {
        System.out.println("Разделим числа 20 и 4");
        int div = a / b;
        System.out.println("Частное от деления чисел: " + div);
        Assert.assertEquals(5, div, "Что-то пошло не так! Частное считается не верно!");
    }
}
