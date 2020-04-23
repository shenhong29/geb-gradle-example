import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.DriverManagerType
import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

// Location where Geb saves the screenshots and HTML dumps at the end of each test
reportsDir = 'build/test-reports'

driver = {
//  FirefoxDriverManager.instance.setup()
  FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup()
  def theDriver = new FirefoxDriver()
  theDriver.manage().window().setSize(new Dimension(1920, 1080))

  return theDriver
}

environments {

  // run with "gradlew -Dgeb.env=chrome testBrowser"
  // ChromeDriver reference: https://sites.google.com/a/chromium.org/chromedriver/
  chrome {
    // Download and configure ChromeDriver using https://github.com/bonigarcia/webdrivermanager
    ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup()

    driver = {
      def theDriver = new ChromeDriver()

      theDriver.manage().window().setSize(new Dimension(1920, 1080))

      return theDriver
    }
  }
}
