
package loadtest

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class PutMsg02 extends Simulation {

  val httpProtocol = http
    .baseUrl("http://192.168.1.3:1323")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name")
    .exec(http("request_10")
      .post("/kafka")
      .header("Content-Type", "application/json")
      .body(StringBody( """{"body":"Test massage"}""" ))
    )

  setUp(scn.inject(constantUsersPerSec(30) during(600 seconds)).protocols(httpProtocol))


}
