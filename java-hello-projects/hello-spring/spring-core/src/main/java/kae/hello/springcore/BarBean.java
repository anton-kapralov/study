package kae.hello.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BarBean {

  private final FooBean fooBean;

  @Autowired
  public BarBean(@Lazy FooBean fooBean) {
    this.fooBean = fooBean;
  }

}
