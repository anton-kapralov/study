package kae.demo.ws.helloworld;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

  @Inject
  private HelloBean helloBean;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response sayHello() {
    return Response
        .ok()
        .entity(helloBean.sayHello())
        .build();
  }

}
