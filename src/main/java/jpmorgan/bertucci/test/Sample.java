package jpmorgan.bertucci.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Sample implements CommandLineRunner {

    @Autowired
    private IStockRepository repository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(repository.getQuote());
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Sample.class, args);
    }
}
