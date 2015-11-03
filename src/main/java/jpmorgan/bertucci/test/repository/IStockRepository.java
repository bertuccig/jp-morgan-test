package jpmorgan.bertucci.test.repository;

import jpmorgan.bertucci.test.model.StockSymbol;
import java.util.Map;

public interface IStockRepository {

    Map<String, StockSymbol> getStocks();
}
