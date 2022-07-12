package easy.mock.hello.world;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test1 {

	private static Portfolio portfolio;
	private static StockService stockService;

	@BeforeClass
	public static void setup() {
		portfolio = new Portfolio();
		stockService = EasyMock.createMock(StockService.class);
		portfolio.setStockService(stockService);
	}

	@AfterClass
	public static void teardown() {
		portfolio = null;
		stockService = null;
	}

	@Test
	public void getMarketValue() {

		List<Stock> stocks = new ArrayList<>();

		Stock stock = new Stock();
		stock.setQuantity(1);
		stock.setName("stock1");
		stock.setStockId("1");

		Stock stock2 = new Stock();
		stock2.setName("stock2");
		stock2.setQuantity(2);
		stock2.setStockId("2");

		stocks.add(stock);
		stocks.add(stock2);

		portfolio.setStocks(stocks);

		EasyMock.expect(stockService.getPrice(stock)).andReturn(12D);
		EasyMock.expect(stockService.getPrice(stock2)).andReturn(12D);

		//activate the mock
		EasyMock.replay(stockService);

		double stockValue = portfolio.getMarketValue();
		System.out.println(stockValue);
	}
}