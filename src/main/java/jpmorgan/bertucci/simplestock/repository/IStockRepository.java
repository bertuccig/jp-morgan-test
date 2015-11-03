package jpmorgan.bertucci.simplestock.repository;

import jpmorgan.bertucci.simplestock.model.StockSymbol;
import jpmorgan.bertucci.simplestock.model.Trade;

import java.math.BigDecimal;
import java.util.Map;

public interface IStockRepository {

    BigDecimal getGBCEAllShareIndex();

    Map<String, StockSymbol> getStocks();

    boolean recordTrade(Trade trade);
}
