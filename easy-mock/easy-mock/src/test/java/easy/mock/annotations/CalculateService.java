package easy.mock.annotations;

public interface CalculateService {

	public <T> T add(T t1, T t2);

	public <T> T subtract(T t1, T t2);

	public <T> T multiply(T t1, T t2);

	public <T> T divide(T t1, T t2);

}
