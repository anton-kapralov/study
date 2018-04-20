package kae.demo.ws.helloworld;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("helloBean")
public class HelloBean {

  public String sayHello() {
    return "Hello World!";
  }

}
