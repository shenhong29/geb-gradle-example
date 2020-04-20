package specs

import geb.spock.GebReportingSpec
import org.junit.Rule
import org.junit.rules.TestName
import pages.GoogleHomePage

class GoogleSearchGebSpec extends GebReportingSpec {

    @Rule
    public TestName testName = new TestName();

    def 'should search for Geb in Google'() {
        given:
//        go "http://www.google.com"
        GoogleHomePage googleHomePage = to(GoogleHomePage)

        slowDownForPresentation()

        when:
        googleHomePage.searchFor("Geb browser testing")

        then:
        def results = googleHomePage.getSearchResults();
        assert results.contains("gebish.org")

        when:

        googleHomePage.goToSearchResultItem("Geb - Very Groovy Browser Automation")
        slowDownForPresentation()

        then:
        googleHomePage.waitForSearchLandingPageTitle("Geb - Very Groovy Browser Automation")

    }

    private void slowDownForPresentation(long time = 2000) {
        if (System.getProperty('slow')) {
            Thread.sleep(time)
        }
    }
}
