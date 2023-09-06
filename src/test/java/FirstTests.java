import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTests {
    private int a;
    private int b;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        a = 20;
        b = 4;
        System.out.println("Проверим, работает ли оно?");
    }

    @AfterClass(alwaysRun = true)
    void afterClass() {
        System.out.println("Работает!!!");
        System.out.println();
    }

    @Test(priority = 1, description = "Первый тест - Сложение")
    void firstTestSum() {
        System.out.println("Посчитаем сумму чисел 20 и 4");
        int sum = a + b;
        System.out.println("Сумма чисел: " + sum);
        System.out.println();
        Assert.assertEquals(24, sum, "Что-то пошло не так! Сумма считается не верно!");

    }

    @Test(priority = 2, description = "Второй тест - Вычитание")
    void secondTestSubtract() {
        System.out.println("Посчитаем разницу чисел 20 и 4");
        int sub = a - b;
        System.out.println("Разница чисел: " + sub);
        System.out.println();
       Assert.assertEquals(16, sub, "Что-то пошло не так! Разница считается не верно!");
    }

    @Test(priority = 3, description = "Третий тест - Умножение")
    void thirdTestMultiply() {
        System.out.println("Умножим числа 20 и 4");
        int mul = a * b;
        System.out.println("Произведение чисел: " + mul);
        System.out.println();
        Assert.assertEquals(80, mul, "Что-то пошло не так! Произведение считается не верно!");
    }

    @Test(priority = 4, description = "Четвертый тест - Деление")
    void fourthTestDivision() {
        System.out.println("Разделим числа 20 и 4");
        int div = a / b;
        System.out.println("Частное от деления чисел: " + div);
        System.out.println();
        Assert.assertEquals(5, div, "Что-то пошло не так! Частное считается не верно!");
    }
}
