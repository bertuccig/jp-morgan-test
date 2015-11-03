package jpmorgan.bertucci.test.repository;

import jpmorgan.bertucci.test.model.StockSymbol;
import jpmorgan.bertucci.test.model.StockType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StockRepository implements IStockRepository {

    private static  Map<String, StockSymbol> symbols;
    static {
        Map<String, StockSymbol> aMap = new HashMap<String, StockSymbol>();
        aMap.put("TEA", new StockSymbol() { { name = "TEA"; type = StockType.Common; lastDividend = new BigDecimal(0); fixedDividend = null; parValue =  new BigDecimal(100); } });
        aMap.put("POP", new StockSymbol() { { name = "POP"; type = StockType.Common; lastDividend = new BigDecimal(8); fixedDividend = null; parValue =  new BigDecimal(100); } });
        aMap.put("ALE", new StockSymbol() { { name = "ALE"; type = StockType.Common; lastDividend = new BigDecimal(23); fixedDividend = null; parValue =  new BigDecimal(60); } });
        aMap.put("GIN", new StockSymbol() { { name = "GIN"; type = StockType.Preferred; lastDividend = new BigDecimal(8); fixedDividend = new BigDecimal(2); parValue =  new BigDecimal(100); } });
        aMap.put("JOE", new StockSymbol() { { name = "JOE"; type = StockType.Common; lastDividend = new BigDecimal(13); fixedDividend = null; parValue =  new BigDecimal(250); } });

        symbols = Collections.unmodifiableMap(aMap);
    }

    @Override
    public Map<String, StockSymbol> getStocks() {
        return symbols;
    }
}
