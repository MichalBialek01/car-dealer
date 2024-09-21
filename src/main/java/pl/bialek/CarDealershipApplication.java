package pl.bialek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealershipApplication {
    public static void main(String[] args) {
        try{
            SpringApplication.run(CarDealershipApplication.class, args);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}