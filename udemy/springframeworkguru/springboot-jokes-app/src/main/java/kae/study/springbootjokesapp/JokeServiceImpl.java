package kae.study.springbootjokesapp;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

  private final ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();

  @Override
  public String getRandomJoke() {
    return chuckNorrisQuotes.getRandomQuote();
  }

}
