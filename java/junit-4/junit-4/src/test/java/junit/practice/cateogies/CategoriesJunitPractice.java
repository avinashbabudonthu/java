package junit.practice.cateogies;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(value = { MyIncludeCategory.class })
@ExcludeCategory(value = { MyExcludeCategory.class })
@SuiteClasses(value = { TestClass2.class, TestClass3.class })
public class CategoriesJunitPractice {

}
