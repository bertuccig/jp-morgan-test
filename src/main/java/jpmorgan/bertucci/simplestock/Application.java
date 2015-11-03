package jpmorgan.bertucci.simplestock;

import jpmorgan.bertucci.simplestock.calculations.DividendCalculation;
import jpmorgan.bertucci.simplestock.calculations.PECalculation;
import jpmorgan.bertucci.simplestock.model.StockSymbol;
import jpmorgan.bertucci.simplestock.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@SpringBootApplication
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private IStockRepository repository;

    @Override
    public void run(String... args) throws Exception {

        DividendCalculation dividend = new DividendCalculation();
        PECalculation pe = new PECalculation();

        DecimalFormat df = new DecimalFormat("#,###.00");

        for(StockSymbol s : repository.getStocks().values()) {

            System.out.println(s.toString());
            BigDecimal dividendResult = dividend.Calculate(s);
            BigDecimal peResult = (dividendResult.compareTo(new BigDecimal(0)) > 0 ? pe.Calculate(s, dividendResult): new BigDecimal(0));

            System.out.println("Dividend: " + df.format(dividendResult));
            System.out.println("P/E: " + df.format(peResult));
            System.out.println("Stock Price: " + df.format(s.getStockPrice()));
        }

        System.out.println("GBCE All Share Index: " + df.format(repository.getGBCEAllShareIndex()));
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);
    }
}
