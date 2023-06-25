package org.example.tests;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.*;


public class HomePageTest extends BaseTest {

    final static String homePageUrl = "http://mywebapp:8080/";

    public HomePageTest() throws MalformedURLException {

    }

    @Test
    public void whenNavigatingToHomepage_theCorrectTitleAppears() {

        getPage(homePageUrl);

        String homepageTitle = getDriver().getTitle();

        assertThat(homepageTitle).as("Page title is not correct")
                .isEqualTo("Homepage");

    }

    @Test
    public void whenNavigatingToHomepage_theCorrectH1Appears() {

        getPage(homePageUrl);

        String homepageTitle = getElementById("pageTitle").getText();

        assertThat(homepageTitle).as("H1 is not correct")
                .isEqualTo("Welcome to My Web Application");

    }

    @Test
    public void whenNavigatingToHomepage_theCorrectParagraphAppears() {

        getPage(homePageUrl);

        String homepageTitle = getElementById("mainParagraph").getText();

        assertThat(homepageTitle).as("Paragraph is not correct")
                .isEqualTo("This is a sample homepage.");

    }

}
