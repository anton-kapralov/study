package kae.coding.algorithms.arrays;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/** */
public class IntRangeQueryTest {

  @Test
  public void get_returnsGlobalMin() {
    int[] nums = {4, 7, 3, 1, 5, 7};
    IntRangeQuery query = new IntRangeQuery(nums, Math::min, Integer.MAX_VALUE);

    assertThat(query.get(0, nums.length - 1)).isEqualTo(1);
  }

  @Test
  public void get_returnsLocalMin() {
    int[] nums = {0, 7, 3, 1, 5, 7};
    IntRangeQuery query = new IntRangeQuery(nums, Math::min, Integer.MAX_VALUE);

    assertThat(query.get(1, 3)).isEqualTo(1);
  }

  @Test
  public void get_returnsLocalMax() {
    int[] nums = {0, 7, 3, 1, 5, 7};
    IntRangeQuery query = new IntRangeQuery(nums, Math::max, Integer.MIN_VALUE);

    assertThat(query.get(1, 3)).isEqualTo(7);
  }

  @Test
  public void get_returnsLocalSum() {
    int[] nums = {0, 7, 3, 1, 5, 7};
    IntRangeQuery query = new IntRangeQuery(nums, Integer::sum, 0);

    assertThat(query.get(1, 3)).isEqualTo(11);
  }

  @Test
  public void update_updatesTreeForGlobalQuery() {
    int[] nums = {4, 7, 3, 1, 5, 7};
    IntRangeQuery query = new IntRangeQuery(nums, Math::min, Integer.MAX_VALUE);

    query.update(3, 8);

    assertThat(query.get(0, nums.length - 1)).isEqualTo(3);
  }

  @Test
  public void update_updatesTreeForLocalQuery() {
    int[] nums = {0, 7, 3, 1, 5, 7};
    IntRangeQuery query = new IntRangeQuery(nums, Math::min, Integer.MAX_VALUE);

    query.update(3, 8);

    assertThat(query.get(1, 3)).isEqualTo(3);
  }
}
