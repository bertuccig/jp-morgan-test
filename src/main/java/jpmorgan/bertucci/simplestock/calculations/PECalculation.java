package jpmorgan.bertucci.simplestock.calculations;

import jpmorgan.bertucci.simplestock.model.StockSymbol;

import java.math.BigDecimal;

/**
 * Created by Giuseppe on 03/11/2015.
 */
public class PECalculation {

    public BigDecimal Calculate(StockSymbol symbol, BigDecimal dividend) {

        BigDecimal result = symbol.getPrice().divide(dividend, 2, BigDecimal.ROUND_HALF_UP);

        return result;
    }
}
