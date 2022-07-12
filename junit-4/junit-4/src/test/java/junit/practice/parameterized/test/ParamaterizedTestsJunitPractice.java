package junit.practice.parameterized.test;

import java.util.ArrayList;
import java.util.List;

import junit.practice.model.Model2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParamaterizedTestsJunitPractice {

	private static Model2 model2 = new Model2();
	private int input1;
	private int input2;
	private int expected;

	@Parameters
	public static List<Object[]> data() {
		List<Object[]> dataList = new ArrayList<>();
		dataList.add(new Object[] { 1, 2, 3 });
		dataList.add(new Object[] { 2, 3, 5 });
		dataList.add(new Object[] { 3, 4, 7 });
		dataList.add(new Object[] { 5, 6, 11 });
		dataList.add(new Object[] { 7, 8, 15 });

		return dataList;
	}

	public ParamaterizedTestsJunitPractice(int input1, int input2, int expected) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = expected;
	}

	@Test
	public void sum() {
		int actual = model2.sum(input1, input2);

		Assert.assertEquals(expected, actual);
	}
}
