package junit.practice.cateogies;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestClass3 {

	@Category(MyIncludeCategory.class)
	@Test
	public void test1() {
		System.out.println("TestClass3 -> test1()");
	}

	@Test
	public void test2() {
		System.out.println("TestClass3 -> test2()");
	}

	@Category(value = { MyIncludeCategory.class, MyExcludeCategory.class })
	@Test
	public void test3() {
		System.out.println("TestClass3 -> test3()");
	}
}
