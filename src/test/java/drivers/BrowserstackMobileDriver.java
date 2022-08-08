package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

	Credentials config = ConfigFactory.create(Credentials.class);

	@Override
	public WebDriver createDriver(Capabilities capabilities) {
		MutableCapabilities mutableCapabilities = new MutableCapabilities();
		mutableCapabilities.merge(capabilities);
		mutableCapabilities.setCapability("browserstack.user", config.getLogin());
		mutableCapabilities.setCapability("browserstack.key", config.getPassword());
		mutableCapabilities.setCapability("app", config.getAppUrl());
		mutableCapabilities.setCapability("device", "Google Pixel 3");
		mutableCapabilities.setCapability("os_version", "9.0");
		mutableCapabilities.setCapability("project", "First Java Project");
		mutableCapabilities.setCapability("build", "browserstack-build-1");
		mutableCapabilities.setCapability("name", "first_test");
		return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
	}

	public URL getBrowserstackUrl() {
		try {
			return new URL(config.getRemoteHost());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
