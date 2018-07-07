package com.example.tempconv.springbootsoapclient;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.tempconv.schemas.CelsiusToFahrenheit;
import com.example.tempconv.schemas.CelsiusToFahrenheitResponse;


@SpringBootApplication
public class SpringBootSoapClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootSoapClientApplication.class, args);
  }

  @Bean
  CommandLineRunner lookup(SOAPConnector soapConnector) {
    return args -> {
      String temperature_in_celcius = "36.6";
      if(args.length>0){
        temperature_in_celcius = args[0];
      }
      CelsiusToFahrenheitResponse response = soapConnector.getFTemp(temperature_in_celcius);
      System.err.println(response.getCelsiusToFahrenheitResult());
    };
  }
}