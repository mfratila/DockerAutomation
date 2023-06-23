package org.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.*;

public class AboutPageTest extends BaseTest {

    final static String aboutPageUrl = "http://mywebapp:8080/about-us";


    public AboutPageTest() throws MalformedURLException {

    }

    @Test
    public void whenNavigatingToAboutUs_theCorrectTitleAppears() {
        getDriver().get(aboutPageUrl);

        String homepageTitle = getDriver().getTitle();

        assertThat(homepageTitle).as("Page title is not correct")
                .isEqualTo("About Us");

    }

    @Test
    public void whenNavigatingToAboutUs_theCorrectH1Appears() {
        getDriver().get(aboutPageUrl);

        String homepageTitle = getDriver().findElement(By.id("pageTitle")).getText();

        assertThat(homepageTitle).as("H1 is not correct")
                .isEqualTo("Welcome to My About Us Page");

    }

    @Test
    public void whenNavigatingToAboutUs_theCorrectParagraphAppears() {
        getDriver().get(aboutPageUrl);

        String homepageTitle = getDriver().findElement(By.id("mainParagraph")).getText();

        assertThat(homepageTitle).as("Paragraph is not correct")
                .isEqualTo("This is a sample about us page.");

    }
}
