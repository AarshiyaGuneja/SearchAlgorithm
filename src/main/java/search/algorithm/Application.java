package search.algorithm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args)
    {
        try {
            Setup.initialise("src/main/resources/Data/data.txt");
        } catch (Exception e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}