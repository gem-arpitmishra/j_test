package StepDefination;

import Objects.Locators;
import Objects.Script_PreConfig;
import com.gemini.generic.reporting.GemEcoUpload;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.ProjectConfigData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Objects.Locators.*;

public class StepDefination extends GemEcoUpload {
    public static String company = "Gemini" + Math.random();
    public static String str = "company" + Math.random();
    public static String projectNames = "SUITE_" + Math.random();
    Logger logger = LoggerFactory.getLogger(StepDefination.class);



    @Given("You are on the login screen")
    public void you_are_on_the_login_screen() {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(login_btn, "Login screen");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("Enter username as {string}")
    public void enter_username_as(String string) {
        try {
            DriverAction.typeText(Locators.user_name, string);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }


    @Then("^Enter Password as '(.*)'$")
    public void password(String pass) {
        try {
            DriverAction.typeText(Locators.password, pass);
            DriverAction.click(Locators.login_button, "Login Button");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }




    @Then("Verify the Bridge Token Button is clickable or not")
    public void verify_the_bridge_token_button_is_clickable_or_not() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge token Button");
                String s = DriverAction.getCurrentURL();
                STATUS status;
                if (s.contains("bridge-token")) {
                    status = STATUS.PASS;
                } else {
                    status = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", status);
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Bridge Token window", "Button NOt Present", STATUS.FAIL);

        }
    }

    @Then("Click on Copy Bridge Token")
    public void click_on_copy_bridge_token() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button);
        try {
            DriverAction.click(Locators.bridge_token, "Bridge token Button");
            String s = DriverAction.getCurrentURL();
            STATUS status;
            if (s.contains("bridge-token")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", status);
            boolean present;
            try {
                DriverManager.getWebDriver().findElement(Locators.copy_bridge_token);
                present = true;
            } catch (Exception e) {
                present = false;
            }
            STATUS status1;
            if (present) {

                DriverAction.click(Locators.copy_bridge_token, "Click was successful");
                DriverAction.waitSec(2);
                status1 = STATUS.PASS;
            } else {
                status1 = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", status1, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
        }
    }

    @Then("Verify the Alert when copy button is clicked")
    public void verify_the_alert_when_copy_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge token Button");
                String s = DriverAction.getCurrentURL();
                STATUS status;
                if (s.contains("bridge-token")) {
                    status = STATUS.PASS;
                } else {
                    status = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Bridge Token window", "Status", status);
                DriverAction.click(Locators.copy_bridge_token, "copy button");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
                String se = DriverAction.getElement(Locators.copy_alert).getText();
                STATUS hi;
                if (se.equals("Copied !")) {
                    hi = STATUS.PASS;
                } else {
                    hi = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Alert status", "Expected alert:Copied ", hi);

            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Status of Bridge Token button", "Not Found", STATUS.FAIL);
        }
    }

    @Then("Verify the date and time when Change Token button is clicked")
    public void verify_the_date_and_time_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button was clicked");
        try {
            DriverAction.click(Locators.bridge_token);
            DriverAction.click(Locators.change_token, "Change Token button was clicked");
            DriverAction.waitSec(1);
            GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
            String time = DriverAction.getElement(Locators.date_tab).getText();

            String timep = time.substring(11, 28);
            System.out.println("TIMEEEE:" + timep);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            LocalDateTime now = LocalDateTime.now();
            String loc = dtf.format(now);
            System.out.println("LOC:" + loc);
            System.out.println("timep: " + timep);
            STATUS status;
            if (StringUtils.contains(timep, loc)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Checking date", "Dates should match", status);

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Then("Verify the Alert when Change Token button is clicked")
    public void verify_the_alert_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button");
        try {
            DriverAction.click(Locators.bridge_token);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.change_token, "Change token button");
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

            GemTestReporter.addTestStep("Alert status", "Expected alert: Bridge Token Changed Successfully.", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }



    @Then("Verify if the Bridge token card is visible")
    public void verify_if_the_bridge_token_card_is_visible() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        try {

            String nuam = DriverAction.getElement(Locators.card_two).getText();
            STATUS status;
            if (nuam.equals("Bridge Token")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate the content of the Bridge Token card")
    public void validate_the_content_of_the_bridge_token_card() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        try {
            STATUS status;
            String nuam = DriverAction.getElement(Locators.content_card_two).getText();

            if (nuam.equals("Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Bridge Token card Content", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate if there is change token button available ,if so click it")
    public void validate_if_there_is_change_token_button_available_if_so_click_it() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge Token button");
                DriverAction.click(Locators.change_token, "Change token button");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Error", "No such element", STATUS.FAIL);
        }
    }

  }