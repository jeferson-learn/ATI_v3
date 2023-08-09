package br.com.ati_treino.frameworks.utlis;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriver driver;

    public Wait(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitVisibilityElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Alert waitElementAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement waitLoadElement(WebElement element) {
        try {
            return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return element;
        }
    }
}
