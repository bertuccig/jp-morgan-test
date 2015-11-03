package jpmorgan.bertucci.test;

import jpmorgan.bertucci.test.model.StockSymbol;
import jpmorgan.bertucci.test.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private IStockRepository repository;

    @Override
    public void run(String... args) throws Exception {

        for(StockSymbol s : repository.getStocks().values()) {


            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);
    }
}
