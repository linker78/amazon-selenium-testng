package com.amazon.automation.utils;

import org.openqa.selenium.By;

public class Locators {
    public static final By SEARCH_BOX = By.id("twotabsearchtextbox");
    public static final By SEARCH_BUTTON = By.id("nav-search-submit-button");
    public static final By RESULTS_TEXT = By.cssSelector("span.a-color-state.a-text-bold");
    public static final By FIRST_PRODUCT = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result'] h2 a");
    public static final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");
    public static final By CART_CONFIRMATION = By.cssSelector("h1.a-size-medium.a-text-bold");
    public static final By EMAIL_FIELD = By.id("ap_email_login");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By PASSWORD_FIELD = By.id("ap_password");
    public static final By SIGNIN_BUTTON = By.id("signInSubmit");
    // Wishlist locators
    public static final By ADD_TO_WISHLIST_BUTTON = By.id("add-to-wishlist-button-submit");
    public static final By VIEW_WISHLIST_LINK = By.xpath("//a[contains(@href, '/hz/wishlist/')]");
    public static final By WISHLIST_ITEM = By.cssSelector(".g-item-sortable");
    public static final By DELETE_WISHLIST_ITEM_BUTTON = By.name("submit.deleteItem");
    // Account & Lists locators
    public static final By ACCOUNT_LISTS_DROPDOWN = By.xpath("//button[@aria-label='Expand Account and Lists']");
    public static final By SIGNIN_DROPDOWN_BUTTON = By.cssSelector("#nav-flyout-ya-signin .nav-action-signin-button");
    public static final By EMAIL_FIELD_LOGIN = By.id("ap_email_login");
    public static final By NOT_NOW_LINK = By.xpath("//a[contains(text(),'Not now')]");
    // Add more shared locators as needed
    public static By brandFilterCheckbox(String brand) {
        return By.xpath("//ul[contains(@id, 'filter')]//a[contains(@aria-label,'" + brand + "')]//input");
    }
    public static final By FILTER_SIDEBAR = By.id("brandsRefinements");
    public static final By LOADING_SPINNER = By.cssSelector("div.s-main-slot .s-loading-spinner");
    public static final By PRODUCT_TITLE_SPANS = By.cssSelector("div.s-main-slot h2 a span");
}
