package jpmorgan.bertucci.test.calculations;

import jpmorgan.bertucci.test.model.StockSymbol;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Giuseppe on 03/11/2015.
 */
public class PECalculation {

    public BigDecimal Calculate(StockSymbol symbol, BigDecimal dividend) {

        BigDecimal result = symbol.getPrice().divide(dividend, 2, BigDecimal.ROUND_HALF_UP);

        return result;
    }
}
