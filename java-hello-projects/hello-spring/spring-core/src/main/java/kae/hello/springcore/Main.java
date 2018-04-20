package kae.hello.springcore;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    Client client = (Client) ctx.getBean("client");
    System.out.println(client.getFullName());
    final App app = ctx.getBean(App.class);
    final Event event = ctx.getBean(Event.class);
    event.setMessage("Some event for user {1}");

    app.logEvent(EventType.ERROR, event);
    app.logEvent(null, event);

    final HelloAnnotationBasedBean helloAnnotationBasedBean = (HelloAnnotationBasedBean) ctx.getBean("hello-world");
    helloAnnotationBasedBean.sayIt();

    ctx.close();

    final FooBean fooBean = ctx.getBean(FooBean.class);
    final BarBean barBean = ctx.getBean(BarBean.class);
  }

}
