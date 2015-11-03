package jpmorgan.bertucci.test;

import org.springframework.stereotype.Repository;

@Repository
public class StockRepository implements IStockRepository {


    @Override
    public String getQuote() {
        return "yep";
    }
}
