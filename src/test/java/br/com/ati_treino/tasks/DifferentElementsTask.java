package br.com.ati_treino.tasks;

import br.com.ati_treino.appobjects.DifferentElementsAppObjects;
import br.com.ati_treino.frameworks.utlis.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.io.IOException;

public class DifferentElementsTask {

    private final WebDriver driver;
    private final DifferentElementsAppObjects differentElementsAppObjects;
    public WebDriverWait wait;

    public DifferentElementsTask (WebDriver driver) {
        this.driver = driver;
        differentElementsAppObjects = new DifferentElementsAppObjects(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public DifferentElementsTask textArea() {
        differentElementsAppObjects.textAreaTextField().clear();
        differentElementsAppObjects.textAreaTextField().sendKeys("É uma linguagem formal que, através de uma série de instruções, permite que um programador escreva um conjunto de ordens, ações consecutivas, dados e algoritmos para criar programas que controlam o comportamento físico e lógico de uma máquina.");
//        differentElementsAppObjects.enviarTextAreaButton().click();
        return this;
    }
    public DifferentElementsTask textBox() {
        differentElementsAppObjects.firstNameTextBoxTextField().sendKeys("Jeferson");
        differentElementsAppObjects.lastNameTextBoxTextField().sendKeys("Lopes Eugenio");
        return this;
    }
    public DifferentElementsTask radioCheckBox() {
        differentElementsAppObjects.noRadioCheckBox().click();
//        differentElementsAppObjects.otherRadioCheckBox().click();
        return this;
    }
    public DifferentElementsTask checkbox1CheckBox() {
        differentElementsAppObjects.checkbox1CheckBox().click();
        return this;
    }
    public DifferentElementsTask checkbox2CheckBox() {
        differentElementsAppObjects.checkbox2CheckBox().click();
        return this;
    }
    public DifferentElementsTask checkbox3CheckBox() {
        differentElementsAppObjects.checkbox3CheckBox().click();
        return this;
    }
    public DifferentElementsTask checkbox4CheckBox() {
        differentElementsAppObjects.checkbox4CheckBox().click();
        return this;
    }
    public DifferentElementsTask inputTypeButton() {
        differentElementsAppObjects.inputTypeButton().click();
        driver.switchTo().alert().accept();
        return this;
    }
    public DifferentElementsTask imagemExist() {
        if(differentElementsAppObjects.image().isDisplayed()){
            System.out.println("A imagem existe");
        } else {
            System.out.println("A imagem não existe");
        }
        return this;
    }
    public DifferentElementsTask dropDownSelect() throws InterruptedException {
        Set<String> abas;
        String mainWindow = driver.getWindowHandle();
        abas = driver.getWindowHandles();
//        System.out.println("string main: " + mainWindow);
//        System.out.println("abas main: " + abas.toString());

        differentElementsAppObjects.listDropDownSelect().selectByValue("fiat");
        differentElementsAppObjects.enviarDropDownButton().click();

//        String primeiraAba = driver.getWindowHandle();
        abas = driver.getWindowHandles();
//        System.out.println("string primeira aba: " + primeiraAba);
//        System.out.println("abas primeira baba: " + abas.toString());
//        System.out.println("ABA1");

        driver.switchTo().window(mainWindow);
        differentElementsAppObjects.enviarDropDownButton().click();
//        String segundaAba = driver.getWindowHandle();
        abas = driver.getWindowHandles();
//        System.out.println("string segunda aba: " + segundaAba);
//        System.out.println("abas segunda aba: " + abas.toString());
//        System.out.println("ABA2");

        driver.switchTo().window(mainWindow);
//        System.out.println("atual");
//        Thread.sleep(5000);
//        System.out.println("SetArray: " + abas.size());

//        List<String> abass = new ArrayList<>(driver.getWindowHandles());
//        System.out.println("TESTE");
//        Thread.sleep(5000);
//        driver.switchTo().window(abass.get(1));
//        Thread.sleep(5000);
//        driver.switchTo().window(abass.get(2));
//        Thread.sleep(5000);
//        driver.switchTo().window(abass.get(0));
//        Thread.sleep(5000);
//        WebDriver nomeJanela = driver.switchTo().window(abass.get(0));
//        String nome = nomeJanela.toString();
//        System.out.println("web + toSring: " + nome);
//        System.out.println("String: " + mainWindow);
//        Thread.sleep(5000);
        for(String windowHandle : abas) {
//            System.out.println(windowHandle.toString());
            if( !windowHandle.equals(mainWindow) ) {
//                System.out.println("ok");
                driver.switchTo().window(windowHandle);
//                Thread.sleep(5000);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
//        Thread.sleep(5000);
        return this;
    }
    public DifferentElementsTask webTable() {
        System.out.println("Nome: " + differentElementsAppObjects.nameJohnWebTableTextLabel().getText());
        System.out.println("Salario: " + differentElementsAppObjects.salary7000WebTableTextLabel().getText());
        return this;
    }
    public DifferentElementsTask wikipediaFrames() {
        differentElementsAppObjects.getInFrames();
        differentElementsAppObjects.searchWikipediaFramesFieldText().sendKeys("Teste");
        differentElementsAppObjects.pesquisarWikipediaFramesButton().click();
        differentElementsAppObjects.getOutFrames();
        return this;
    }
    public DifferentElementsTask datePicker() {
        differentElementsAppObjects.datePickerTextField().sendKeys("12/03/2021");
        return this;
    }
    public DifferentElementsTask autoComplete() {
        differentElementsAppObjects.emailAutoCompleteTextField().sendKeys("jeferson@hotmail.com");
        return this;
    }
    public DifferentElementsTask listBox() {
        differentElementsAppObjects.listBoxSelect().selectByValue("option2");
        return this;
    }
    public DifferentElementsTask comboBox() {
        differentElementsAppObjects.comboBoxSelect().selectByValue("java");
        return this;
    }
    public DifferentElementsTask doubleClickAndRightClick() {
        Actions act = new Actions(driver);
        act.doubleClick(differentElementsAppObjects.doubleClickButton()).perform();
        driver.switchTo().alert().accept();
//        WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
//        action.contextClick(link).perform();
//// Click on Edit link on the displayed menu options
//        WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
//        element.click();
        return this;
    }
    public DifferentElementsTask fileUpload() {
//        WebElement element = differentElementsAppObjects.escolherArquivoButton();
//        element.sendKeys("C:\\Users\\Jeferson\\Pictures\\Jeferson\\qualquer\\download.png");
        /* ou */
        differentElementsAppObjects.escolherArquivoButton().sendKeys("C:\\Users\\Jeferson\\OneDrive\\Imagens\\fotos na internet\\Wallpaper.jpg");
        return this;
    }
    public DifferentElementsTask tiposAlerts() throws InterruptedException {
        simplesAlert();
        confirmationOkAlert();
        confirmationCancelAlert();
        promptAlert();
        return this;
    }
    /* Nao funciona preender no prompt */
    private void promptAlert() throws InterruptedException {
        differentElementsAppObjects.promptAlertButton().click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("TESTE");
        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
    }

    private void confirmationCancelAlert() throws InterruptedException {
        differentElementsAppObjects.confirmationAlertButton().click();
//        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    private void confirmationOkAlert() throws InterruptedException {
        differentElementsAppObjects.confirmationAlertButton().click();
//        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    private void simplesAlert() throws InterruptedException {
        differentElementsAppObjects.simplesAlertButton().click();
//        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    public DifferentElementsTask newBrowserWindow() throws InterruptedException {
        String browserFirst = driver.getWindowHandle();
        differentElementsAppObjects.clickOpenNewBrowserWindowsButton().click();
        for(String browserSecond : driver.getWindowHandles()){
            driver.switchTo().window(browserSecond);
        }
        differentElementsAppObjects.pesquisarWikipediaTextField().sendKeys("Teste" + Keys.ENTER);
        driver.close();
        driver.switchTo().window(browserFirst);
        return this;
    }
    public DifferentElementsTask testSeleniumWaits5Seconds() {
        differentElementsAppObjects.clickMeWaitButton().click();
        wait.until(ExpectedConditions.visibilityOf(differentElementsAppObjects.welcomeToAutomationTestingInsiderTextLabel()));
//        System.out.println(differentElementsAppObjects.welcomeToAutomationTestingInsiderTextLabel().getText());
        Assert.assertEquals(differentElementsAppObjects.welcomeToAutomationTestingInsiderTextLabel().getText(),"Welcome To Automation Testing Insider");
        return this;
    }
    public DifferentElementsTask hiddenField() {
        System.out.println("Existe? " + differentElementsAppObjects.hiddenFieldTextLabel().isDisplayed());
        System.out.println(differentElementsAppObjects.hiddenFieldTextLabel().getText());
        return this;
    }
    public DifferentElementsTask sameElement() {
        differentElementsAppObjects.sameElementThirdCheckBox().click();
        return this;
    }

}
