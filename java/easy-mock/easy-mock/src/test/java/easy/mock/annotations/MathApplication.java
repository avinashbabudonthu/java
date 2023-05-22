package easy.mock.annotations;

public class MathApplication {

	private CalculateService calculateService;

	public void setCalculateService(CalculateService calculateService) {
		this.calculateService = calculateService;
	}

	public <T> T add(T t1, T t2) {
		return calculateService.add(t1, t2);
	}

	public <T> T subtract(T t1, T t2) {
		return calculateService.subtract(t1, t2);
	}

	public <T> T multiply(T t1, T t2) {
		return calculateService.multiply(t1, t2);
		//		return t1;
	}

	public <T> T multiply2(T t1, T t2) {
		calculateService.multiply(t1, t2);
		return calculateService.multiply(t1, t2);
	}

	public <T> T multiply3(T t1, T t2) {
		calculateService.multiply(t1, t2);
		calculateService.multiply(t1, t2);
		return calculateService.multiply(t1, t2);
	}

	public <T> T divide(T t1, T t2) {
		return calculateService.divide(t1, t2);
	}
}
