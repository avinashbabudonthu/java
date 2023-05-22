package junit.practice.model;

public class Model1 {

	public String method1() {
		return "Hello World";
	}

	public String exceptionMethod(boolean flag) throws Exception {
		if (flag) {
			throw new RuntimeException("Model1 -> exceptionMethod(" + flag + ")");
		} else {
			return "No Exception";
		}
	}

	public void timeOutMethod() {
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
