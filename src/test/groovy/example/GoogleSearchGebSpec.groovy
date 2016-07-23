package example

import geb.spock.GebReportingSpec

class GoogleSearchGebSpec extends GebReportingSpec {
    def 'should search for Geb in Google'() {
        given:
        go "http://www.google.com"

        when:
        $("input", name: "q").value("Geb")
        $("button", name: "btnG").click()

        then:
        waitFor { $("#search").displayed }

        assert $("#search").text().contains("gebish.org")

        when:
        slowDown()

        $("h3.r").first().click()

        slowDown()

        then:
        waitFor { title == "Geb - Very Groovy Browser Automation" }
    }

    private void slowDown() {
        Thread.sleep(1000)
    }
}
