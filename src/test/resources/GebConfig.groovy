import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver

// Location where Geb saves the screenshots and HTML dumps at the end of each test
reportsDir = 'build/test-reports'

driver = {
  def theDriver = new FirefoxDriver()
  theDriver.manage().window().setSize(new Dimension(1366, 768))

  return theDriver
}
