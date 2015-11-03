package jpmorgan.bertucci.test.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Giuseppe on 03/11/2015.
 */
public class StockSymbol {

    protected String name;
    protected StockType type;
    protected BigDecimal lastDividend;
    protected BigDecimal fixedDividend;
    protected BigDecimal parValue;

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public StockType getType() {
        return type;
    }
    public void setType(StockType type) {
        this.type = type;
    }

    public BigDecimal getLastDividend() {
        return lastDividend;
    }
    public void setLastDividend(BigDecimal lastDividend) {
        this.lastDividend = lastDividend;
    }

    public BigDecimal getFixedDividend() {
        return fixedDividend;
    }
    public void setFixedDividend(BigDecimal fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public BigDecimal getParValue() {
        return parValue;
    }
    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("#,###.00");
        return String.format("%s %s %s %s %s",
                this.getName(), this.getType(),
                df.format(this.getLastDividend()),
                (this.getFixedDividend() != null ? df.format(this.getFixedDividend()) : "-"),
                df.format(this.getParValue()));
    }
}
