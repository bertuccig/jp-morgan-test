package jpmorgan.bertucci.simplestock.calculations;

import jpmorgan.bertucci.simplestock.model.StockSymbol;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Giuseppe on 03/11/2015.
 */
public class DividendCalculation {

    public BigDecimal Calculate(StockSymbol symbol) {

        BigDecimal result = null;

        switch(symbol.getType()) {

            case Common:
                result = symbol.getLastDividend().divide(symbol.getPrice(), 2, RoundingMode.HALF_UP);
                break;

            case Preferred:

                BigDecimal tmp = symbol.getFixedDividend().multiply(symbol.getParValue());
                result = tmp.divide(symbol.getPrice(), 2, RoundingMode.HALF_UP);
                break;
        }

        return result;
    }
}
