package pages

import geb.Page

class GoogleHomePage extends Page {

    static url = "http://www.google.com"

    static content = {
        searchInputField { $("input", name: "q") }
        searchButton{ $("input", name: "btnK") }
    }

    void searchFor(String searchContent) {
        waitFor { searchInputField.displayed }
        searchInputField.value(searchContent)
        searchButton.lastElement().click()
    }

    String getSearchResults() {
        waitFor { $("#search").displayed }
        return $("#search").text()
    }

    void goToSearchResultItem(String expectedItem) {
        $("h3", text: expectedItem).click()
    }

    void waitForSearchLandingPageTitle(String expectedTitle) {
        waitFor { title == expectedTitle }
    }
}
