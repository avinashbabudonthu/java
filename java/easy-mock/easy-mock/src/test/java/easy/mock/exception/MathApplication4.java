package easy.mock.exception;

public class MathApplication4 {

	private CalculateService4 calculateService4;

	public void setCalculateService4(CalculateService4 calculateService4) {
		this.calculateService4 = calculateService4;
	}

	public <T> T add(T t1, T t2) {
		return calculateService4.add(t1, t2);
	}

	public <T> T subtract(T t1, T t2) {
		return calculateService4.subtract(t1, t2);
	}
}
