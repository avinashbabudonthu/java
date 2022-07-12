package junit.practice.cateogies;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(MyIncludeCategory.class)
public class TestClass2 {

    @Test
    public void test1() {
	System.out.println("TestClass2 -> test1()");
    }

    @Test
    public void test2() {
	System.out.println("TestClass2 -> test2()");
    }
}
