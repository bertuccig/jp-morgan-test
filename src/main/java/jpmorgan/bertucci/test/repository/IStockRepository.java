package jpmorgan.bertucci.test.repository;

import jpmorgan.bertucci.test.model.StockSymbol;
import jpmorgan.bertucci.test.model.Trade;

import java.math.BigDecimal;
import java.util.Map;

public interface IStockRepository {

    BigDecimal getGBCEAllShareIndex();

    Map<String, StockSymbol> getStocks();

    boolean recordTrade(Trade trade);
}
