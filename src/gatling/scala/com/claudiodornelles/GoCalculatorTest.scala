package com.claudiodornelles

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class GoCalculatorTest extends Simulation {

  var numberOfUsers = 1
  var repeatCount = 10
  var execution = 0

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost:8090")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn: ScenarioBuilder = scenario("Test calculator endpoints")
    .exec(http("Divide")
      .get("/calc/div/10/7"))
    .pause(500.milliseconds)
    .exec(http("Multiply")
      .get("/calc/mul/10/7"))
    .pause(500.milliseconds)
    .exec(http("Sum")
      .get("/calc/sum/10/7"))
    .pause(500.milliseconds)
    .exec(http("Subtract")
      .get("/calc/sub/10/7"))
    .pause(500.milliseconds)
    .exec(http("History")
      .get("/calc/history"))

  for( execution <- 1 to repeatCount){
    setUp(scn.inject(atOnceUsers(math.pow(numberOfUsers, execution).toInt)).protocols(httpProtocol))
  }

}
