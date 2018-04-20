package kae.study.springbootjokesapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

  private final JokeService quotesService;

  public JokesController(JokeService quotesService) {
    this.quotesService = quotesService;
  }

  @RequestMapping(path = "/")
  public String getJokes(Model model) {
    model.addAttribute("joke", quotesService.getRandomJoke());

    return "chucknorris";
  }

}
