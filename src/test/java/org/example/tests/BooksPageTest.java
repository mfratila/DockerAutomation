package org.example.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class BooksPageTest extends BaseTest {

    final static String booksPageUrl = "http://mywebapp:8080/books";

    public BooksPageTest() throws MalformedURLException {

    }

    @Test
    public void whenNavigatingToBooksPage_theCorrectTitleAppears() {

        getPage(booksPageUrl);

        String homepageTitle = getDriver().getTitle();

        assertThat(homepageTitle).as("Page title is not correct")
                .isEqualTo("Books");

    }

    @Test
    public void whenNavigatingToBooksPage_andAddingNewBook_bookIsPresentOnPage() {

        String bookName = "The Hobbit";

        getPage(booksPageUrl);

        WebElement addForm = getElementById("addForm").findElement(By.tagName("input"));
        WebElement addButton = getElementById("addForm").findElement(By.id("addButton"));

        addForm.sendKeys("LOTR - The Two Towers");
       addButton.click();

        By bookLocator = By.xpath("//ul[@id='booksList']/li[text()='" + bookName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookLocator));

        assertThat(getDriver().findElement(bookLocator)).isNotNull();
        assertThat(getDriver().findElement(bookLocator).getText())
                .as("Book name mismatch")
                .isEqualTo(bookName);
    }

    @Test
    public void whenNavigatingToBooksPage_andSearchingForBook_bookIsPresentOnPage() {

        List<String> bookNames = Arrays.asList("The Great Gatsby", "To Kill a Mockingbird", "Pride and Prejudice");

        getPage(booksPageUrl);


        for (String bookName : bookNames) {
            addBook(bookName);
        }

        for (String bookName : bookNames) {
            searchBook(bookName);
            // Assert that the book name is present in the search results
            By searchResultsLocator = By.xpath("//ul[@id='booksList']/li[text()='" + bookName + "']");
            assertThat(getDriver().findElement(searchResultsLocator)).isNotNull();
            assertThat(getDriver().findElement(searchResultsLocator).getText())
                    .as("Book name mismatch")
                    .isEqualTo(bookName);
        }

    }

    private void addBook(String bookName) {

        WebElement addForm = getElementById("addForm").findElement(By.tagName("input"));
        WebElement addButton = getElementById("addForm").findElement(By.id("addButton"));

        addForm.sendKeys(bookName);
        addButton.click();

        By bookLocator = By.xpath("//ul[@id='booksList']/li[text()='" + bookName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookLocator));

        addForm = getElementById("addForm").findElement(By.tagName("input"));
        addButton = getElementById("addForm").findElement(By.id("addButton"));
    }

    private void searchBook(String bookName) {

        WebElement searchForm = getElementById("searchForm").findElement(By.tagName("input"));
        WebElement searchButton = getElementById("searchForm").findElement(By.id("searchButton"));

        searchForm.clear();
        searchForm.sendKeys(bookName);

        searchButton.click();

        searchForm = getElementById("searchForm").findElement(By.tagName("input"));
        searchButton = getElementById("searchForm").findElement(By.id("searchButton"));
    }
}


