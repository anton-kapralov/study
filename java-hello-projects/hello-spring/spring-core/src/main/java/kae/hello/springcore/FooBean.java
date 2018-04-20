package kae.hello.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooBean {

  private final BarBean barBean;

  @Autowired
  public FooBean(BarBean barBean) {
    this.barBean = barBean;
  }
}
