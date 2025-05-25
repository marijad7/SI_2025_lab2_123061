import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        // Тест случај 1: Валиден предмет со попуст
        List<Item> items1 = new ArrayList<>();
        Item item1 = new Item("Item1", 5, 400, 0.1);
        item1.setBarcode("123456");
        items1.add(item1);
        String cardNumber1 = "1234567890123456";
        double result1 = SILab2.checkCart(items1, cardNumber1);
        assertEquals(1800.0, result1, 0.001);

        // Тест случај 2: Валиден предмет без попуст
        List<Item> items2 = new ArrayList<>();
        Item item2 = new Item("Item2", 3, 200, 0);
        item2.setBarcode("654321");
        items2.add(item2);
        String cardNumber2 = "1234567890123456";
        double result2 = SILab2.checkCart(items2, cardNumber2);
        assertEquals(600.0, result2, 0.001);
    }

    @Test
    public void testMultipleCondition() {
        // Тест случај 1: Сите услови се false
        List<Item> items1 = new ArrayList<>();
        Item item1 = new Item("Item1", 5, 200, 0);
        item1.setBarcode("123456");
        items1.add(item1);
        String cardNumber1 = "1234567890123456";
        double result1 = SILab2.checkCart(items1, cardNumber1);
        assertEquals(1000.0, result1, 0.001);

        // Тест случај 2: Првиот услов е true (цена > 300)
        List<Item> items2 = new ArrayList<>();
        Item item2 = new Item("Item2", 5, 400, 0);
        item2.setBarcode("654321");
        items2.add(item2);
        String cardNumber2 = "1234567890123456";
        double result2 = SILab2.checkCart(items2, cardNumber2);
        assertEquals(1970.0, result2, 0.001);

        // Тест случај 3: Вториот услов е true (попуст > 0)
        List<Item> items3 = new ArrayList<>();
        Item item3 = new Item("Item3", 5, 200, 0.1);
        item3.setBarcode("789012");
        items3.add(item3);
        String cardNumber3 = "1234567890123456";
        double result3 = SILab2.checkCart(items3, cardNumber3);
        assertEquals(870.0, result3, 0.001);

        // Тест случај 4: Третиот услов е true (количина > 10)
        List<Item> items4 = new ArrayList<>();
        Item item4 = new Item("Item4", 15, 200, 0);
        item4.setBarcode("345678");
        items4.add(item4);
        String cardNumber4 = "1234567890123456";
        double result4 = SILab2.checkCart(items4, cardNumber4);
        assertEquals(2970.0, result4, 0.001);
    }
} 