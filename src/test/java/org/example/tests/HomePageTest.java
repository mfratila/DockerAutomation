package org.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.*;


public class HomePageTest extends BaseTest {

    final static String homePageUrl = "http://mywebapp:8080/";

    public HomePageTest() throws MalformedURLException {

    }

    @Test
    public void whenNavigatingToHomepage_theCorrectTitleAppears() {
        getDriver().get(homePageUrl);

        String homepageTitle = getDriver().getTitle();

        assertThat(homepageTitle).as("Page title is not correct")
                .isEqualTo("Homepage");

    }

    @Test
    public void whenNavigatingToHomepage_theCorrectH1Appears() {
        getDriver().get(homePageUrl);

        String homepageTitle = getDriver().findElement(By.id("pageTitle")).getText();

        assertThat(homepageTitle).as("H1 is not correct")
                .isEqualTo("Welcome to My Web Application");

    }

    @Test
    public void whenNavigatingToHomepage_theCorrectParagraphAppears() {
        getDriver().get(homePageUrl);

        String homepageTitle = getDriver().findElement(By.id("mainParagraph")).getText();

        assertThat(homepageTitle).as("Paragraph is not correct")
                .isEqualTo("This is a sample homepage.");

    }

}
