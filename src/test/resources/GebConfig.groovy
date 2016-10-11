import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

// Location where Geb saves the screenshots and HTML dumps at the end of each test
reportsDir = 'build/test-reports'

driver = {
  def theDriver = new FirefoxDriver()
  theDriver.manage().window().setSize(new Dimension(1366, 768))

  return theDriver
}

environments {

  // run with "gradlew -Dgeb.env=chrome testBrowser"
  // ChromeDriver reference: https://sites.google.com/a/chromium.org/chromedriver/
  chrome {
    // Download and configure ChromeDriver using https://github.com/bonigarcia/webdrivermanager
    ChromeDriverManager.getInstance().setup()

    driver = {
      def theDriver = new ChromeDriver()

      theDriver.manage().window().setSize(new Dimension(1366, 768))

      return theDriver
    }
  }
}
