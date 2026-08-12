package redis.clients.jedis.timeseries;

import static org.hamcrest.MatcherAssert.assertThat;
import static redis.clients.jedis.timeseries.TimeSeriesProtocol.TimeSeriesKeyword.DUPLICATE_POLICY;
import static redis.clients.jedis.util.CommandArgumentsMatchers.hasArgumentCount;
import static redis.clients.jedis.util.CommandArgumentsMatchers.hasArguments;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.CommandArguments;
import redis.clients.jedis.timeseries.TimeSeriesProtocol.TimeSeriesCommand;

public class TSAddParamsTest {

  @Test
  public void duplicatePolicyIsEmittedOnce() {
    CommandArguments args = new CommandArguments(TimeSeriesCommand.ADD);
    TSAddParams.addParams().duplicatePolicy(DuplicatePolicy.LAST).addParams(args);

    assertThat(args, hasArguments(TimeSeriesCommand.ADD, DUPLICATE_POLICY, DuplicatePolicy.LAST));
    assertThat(args, hasArgumentCount(3));
  }
}
