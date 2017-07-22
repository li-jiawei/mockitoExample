package example1; /**
 * Created by Jiawei on 7/21/17.
 */

import example1.Portfolio;
import example1.Stock;
import example1.StockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioTest {

    @InjectMocks
    Portfolio portfolio;
    @Mock
    StockService stockService;

    @Before
    public void setUp(){
        //Create a portfolio object which is to be tested
//        portfolio = new Portfolio();

        //Create the mock object of stock service
//        stockService = mock(StockService.class);

        //set the stockService to the portfolio
//        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketValue(){

        //Creates a list of stocks to be added to the portfolio
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google", 10);
        Stock microsoftStock = new Stock("2","Microsoft",100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        //add stocks to the portfolio
        portfolio.setStocks(stocks);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        assertEquals(marketValue, 100500.0, 10e-4);
    }
}