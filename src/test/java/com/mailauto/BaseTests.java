package com.mailauto;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class BaseTests {

    protected void assertContainsString(String actual, String expected) {
        assertTrue(actual.contains(expected));
    }
}