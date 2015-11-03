package jpmorgan.bertucci.test.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;

/**
 * Created by Giuseppe on 03/11/2015.
 */
public class Trade {

    private String symbol;
    private Timestamp time;
    private Integer quantity;
    private TradeOperation operation;
    protected BigDecimal price;

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TradeOperation getOperation() {
        return operation;
    }

    public void setOperation(TradeOperation operation) {
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
