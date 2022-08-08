package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {

	@Test
	void searchBrowserStackTest() {
		step("Search article about \"BrowserStack\"", () -> {
			$(AppiumBy.accessibilityId("Search Wikipedia")).click();
			$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
					.sendKeys("BrowserStack");
		});
		step("Verify content is found", () ->
				$$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
						.shouldHave(sizeGreaterThan(0)));
	}

	@Test
	void findSamsungInResults() {
		step("Search first article about \"BrowserStack\"", () -> {
			$(AppiumBy.accessibilityId("Search Wikipedia")).click();
			$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
					.sendKeys("Samsung");
		});
		step("Verify article is found", () ->
				$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description"))
						.shouldHave(text("South Korean multinational conglomerate")));
	}
}
