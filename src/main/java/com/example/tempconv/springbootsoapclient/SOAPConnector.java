package com.example.tempconv.springbootsoapclient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.tempconv.schemas.CelsiusToFahrenheit;
import com.example.tempconv.schemas.CelsiusToFahrenheitResponse;

public class SOAPConnector extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(SOAPConnector.class);

  public Object callWebService(String url, Object request){
    return getWebServiceTemplate().marshalSendAndReceive(url, request);
  }

  public CelsiusToFahrenheitResponse getFTemp(String req) {

    CelsiusToFahrenheit request = new CelsiusToFahrenheit();
    request.setCelsius(req);

    log.info("Requesting Fahrenheit for " + req);

    CelsiusToFahrenheitResponse response = (CelsiusToFahrenheitResponse) getWebServiceTemplate()
            .marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx",
                    request,
                    new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit"));

    return response;
  }
}