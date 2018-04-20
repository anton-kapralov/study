package kae.demo.jws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 */
@WebService
public class HelloWebService {
  @WebMethod
  public String sayHello() {
    return "Hello! What can I do for you sir?";
  }
}
