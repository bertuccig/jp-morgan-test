package jpmorgan.bertucci.simplestock.repository;

import jpmorgan.bertucci.simplestock.model.StockSymbol;
import jpmorgan.bertucci.simplestock.model.StockType;
import jpmorgan.bertucci.simplestock.model.Trade;
import jpmorgan.bertucci.simplestock.model.TradeOperation;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StockRepository implements IStockRepository {

    private static  Map<String, StockSymbol> symbols;
    static {
        Map<String, StockSymbol> aMap = new HashMap<String, StockSymbol>();
        aMap.put("TEA", new StockSymbol() { { name = "TEA"; type = StockType.Common; lastDividend = new BigDecimal(0); fixedDividend = null; parValue =  new BigDecimal(100); price =  new BigDecimal(11.1); } });
        aMap.put("POP", new StockSymbol() { { name = "POP"; type = StockType.Common; lastDividend = new BigDecimal(8); fixedDividend = null; parValue =  new BigDecimal(100); price =  new BigDecimal(17.47); } });
        aMap.put("ALE", new StockSymbol() { { name = "ALE"; type = StockType.Common; lastDividend = new BigDecimal(23); fixedDividend = null; parValue =  new BigDecimal(60); price =  new BigDecimal(21.32); } });
        aMap.put("GIN", new StockSymbol() { { name = "GIN"; type = StockType.Preferred; lastDividend = new BigDecimal(8); fixedDividend = new BigDecimal(2); parValue =  new BigDecimal(100); price =  new BigDecimal(17.45); } });
        aMap.put("JOE", new StockSymbol() { { name = "JOE"; type = StockType.Common; lastDividend = new BigDecimal(13); fixedDividend = null; parValue =  new BigDecimal(250); price =  new BigDecimal(9.1); } });

        symbols = Collections.unmodifiableMap(aMap);
    }

    public StockRepository() {

        // initialise with fake trades
        for(StockSymbol s : symbols.values()) {

            for(int i = 1; i < 20; i++) {
                Trade t = new Trade();
                t.setSymbol(s.getName());
                t.setOperation(TradeOperation.Buy);
                t.setPrice(s.getParValue().multiply(new BigDecimal(i * 0.15)));
                t.setQuantity(i);

                recordTrade(t);
            }
        }
    }

    @Override
    public  boolean recordTrade(Trade trade) {

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        trade.setTime(new java.sql.Timestamp(now.getTime()));

        symbols.get(trade.getSymbol()).getTrades().add(trade);

        return true;
    }

    @Override
    public BigDecimal getGBCEAllShareIndex() {

        BigDecimal index = new BigDecimal(0);
        BigDecimal totalTradesTransactions = new BigDecimal(0);
        BigDecimal totalTradesQuantities = new BigDecimal(0);

        for(StockSymbol s : symbols.values()) {

            for(Trade t : s.getTrades()) {

                // check if is included in 15 min
                // in a real world app this check is not necessary and the repository should return the
                // values in the expected range
                if(true) {
                    BigDecimal TradeTransaction = t.getPrice().multiply(new BigDecimal(t.getQuantity()));

                    totalTradesTransactions = totalTradesTransactions.add(TradeTransaction);
                    totalTradesQuantities = totalTradesQuantities.add(new BigDecimal(t.getQuantity()));
                }
            }
        }

        index = totalTradesTransactions.divide(totalTradesQuantities, 2, BigDecimal.ROUND_HALF_UP);
        return index;
    }

    @Override
    public Map<String, StockSymbol> getStocks() {
        return symbols;
    }
}
