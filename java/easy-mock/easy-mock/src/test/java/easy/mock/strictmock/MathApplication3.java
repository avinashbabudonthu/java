package easy.mock.strictmock;

public class MathApplication3 {

	private CalculateService3 calculateService3;

	public void setCalculateService3(CalculateService3 calculateService3) {
		this.calculateService3 = calculateService3;
	}

	public <T> T add(T t1, T t2) {
		return calculateService3.add(t1, t2);
	}

	public <T> T subtract(T t1, T t2) {
		return calculateService3.subtract(t1, t2);
	}
}
