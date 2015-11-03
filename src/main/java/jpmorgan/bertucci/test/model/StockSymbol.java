package jpmorgan.bertucci.test.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giuseppe on 03/11/2015.
 */
public class StockSymbol {

    protected String name;
    protected StockType type;
    protected BigDecimal lastDividend;
    protected BigDecimal fixedDividend;
    protected BigDecimal parValue;
    protected BigDecimal price;
    private List<Trade> trades = new ArrayList<Trade>();

    public BigDecimal getStockPrice() {

        // this code could be moved to StockRepository to keep the business logic out of the pocos/model
        // it is a "style" choice more than a best practice (imho)

        BigDecimal totalQuantity = new BigDecimal(0);
        BigDecimal totalTradeTransaction = new BigDecimal(0);

        for(Trade t : trades) {

            BigDecimal tradeTransaction = new BigDecimal(0);

            totalQuantity = totalQuantity.add(new BigDecimal(t.getQuantity()));
            tradeTransaction = t.getPrice().multiply(new BigDecimal(t.getQuantity()));
            totalTradeTransaction = totalTradeTransaction.add(tradeTransaction);
        }

        return totalTradeTransaction.divide(totalQuantity, 2, BigDecimal.ROUND_HALF_UP);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public StockType getType() { return type; }
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

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("#,###.00");
        return String.format("%s %s %s %s %s %s",
                this.getName(), this.getType(),
                df.format(this.getLastDividend()),
                (this.getFixedDividend() != null ? df.format(this.getFixedDividend()) : "-"),
                df.format(this.getParValue()),
                df.format(this.getPrice()));
    }

    public List<Trade> getTrades() {
        return trades;
    }
    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
