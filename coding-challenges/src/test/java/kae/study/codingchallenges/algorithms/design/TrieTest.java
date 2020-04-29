package kae.study.codingchallenges.algorithms.design;

import static com.google.common.truth.Truth.assertThat;

import kae.study.codingchallenges.design.Trie;
import org.junit.Test;

/**
 *
 */
public class TrieTest {

  private final Trie trie = new Trie();

  @Test
  public void hasWord_returnsTrue_whenContainsWordFully() {
    trie.add("crime");

    assertThat(trie.hasWord("crime")).isTrue();
  }

  @Test
  public void hasWord_returnsFalse_whenDoesNotContainWord() {
    trie.add("crime");

    assertThat(trie.hasWord("punishment")).isFalse();
  }

  @Test
  public void hasWord_returnsFalse_whenWordIsPrefixToExisting() {
    trie.add("crimea");

    assertThat(trie.hasWord("crime")).isFalse();
  }

  @Test
  public void hasPrefix_returnsTrue_whenWordIsPrefixToExisting() {
    trie.add("crimea");

    assertThat(trie.hasPrefix("crime")).isTrue();
  }
}
