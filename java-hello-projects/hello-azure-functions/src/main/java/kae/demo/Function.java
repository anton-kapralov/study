package kae.demo;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Map;
import java.util.Optional;

import static java.lang.Integer.parseInt;

/** Azure Functions with HTTP Trigger. */
public class Function {
  /**
   * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl"
   * command in bash: 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java&code={your function
   * key} 2. curl "{your host}/api/HttpTrigger-Java?name=HTTP%20Query&code={your function key}"
   * Function Key is not needed when running locally, it is used to invoke function deployed to
   * Azure. More details: https://aka.ms/functions_authorization_keys
   */
  @FunctionName("HttpTrigger-Java")
  public HttpResponseMessage run(
      @HttpTrigger(
              name = "req",
              methods = {HttpMethod.GET, HttpMethod.POST},
              authLevel = AuthorizationLevel.FUNCTION)
          HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {
    context.getLogger().info("Java HTTP trigger processed a request.");

    // Parse query parameter
    String query = request.getQueryParameters().get("name");
    String name = request.getBody().orElse(query);

    if (name == null) {
      return request
          .createResponseBuilder(HttpStatus.BAD_REQUEST)
          .body("Please pass a name on the query string or in the request body")
          .build();
    } else {
      return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name).build();
    }
  }

  @FunctionName("add")
  public HttpResponseMessage add(
      @HttpTrigger(
              name = "req",
              methods = {HttpMethod.GET, HttpMethod.POST},
              authLevel = AuthorizationLevel.FUNCTION)
          HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {
    Map<String, String> queryParameters = request.getQueryParameters();

    int a;
    int b;
    try {
      a = getParameterIntValue(queryParameters, "a");
      b = getParameterIntValue(queryParameters, "b");
    } catch (IllegalArgumentException e) {
      return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body(e.getMessage()).build();
    }

    int result = a + b;

    return request.createResponseBuilder(HttpStatus.OK).body(result).build();
  }

  private int getParameterIntValue(Map<String, String> queryParameters, String parameterName) {
    String parameterValue = queryParameters.get(parameterName);
    if (parameterValue == null || parameterValue.isEmpty()) {
      throw new IllegalArgumentException(
          String.format("The parameter '%s' is required.", parameterName));
    }
    try {
      return parseInt(parameterValue);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          String.format(
              "The value of the parameter '%s' is not a valid integer value: %s.",
              parameterName, parameterValue));
    }
  }
}
