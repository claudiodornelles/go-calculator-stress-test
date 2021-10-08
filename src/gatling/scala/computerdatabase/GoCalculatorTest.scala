package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class GoCalculatorTest extends Simulation {

  val numberOfUsers: Integer = Integer.getInteger("users", 1)

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost:8090")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn: ScenarioBuilder = scenario("Test calculator endpoints")
    .pause(7)
    .exec(http("Divide")
      .get("/calc/div/10/7"))
    .pause(2)
    .exec(http("Multiply")
      .get("/calc/mul/10/7"))
    .pause(3)
    .exec(http("Sum")
      .get("/calc/sum/10/7"))
    .pause(2)
    .exec(http("Subtract")
      .get("/calc/sub/10/7"))
    .pause(670.milliseconds)
    .exec(http("Power")
      .get("/calc/pow/10/3"))
    .exec(http("History")
      .get("/calc/history"))

  setUp(scn.inject(atOnceUsers(numberOfUsers)).protocols(httpProtocol))
}
