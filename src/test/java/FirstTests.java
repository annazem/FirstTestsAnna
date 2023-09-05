import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTests {
    private int a;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        System.out.println("Проверим, работает ли оно?");
    }

    @AfterClass(alwaysRun = true)
    void afterClass() {
        System.out.println("Работает!!!");
    }

    @Test(description = "Первый тест")
    void firstTest() {

        System.out.println("Пароль от квартиры, где деньги лежат...");
        System.out.println("Не скажу конечно)");

    }

    @Test(description = "Второй тест")
    void secondTest() {
        System.out.println("Посчитаем сумму чисел - 1234 и 4321");
        int a = 1234;
        int b = 4321;
        int sum = a + b;
        System.out.println("Сумма чисел:" + sum);
       Assert.assertEquals(5555, sum, "Что-то пошло не так! Сумма считается не верно!");
    }
}
