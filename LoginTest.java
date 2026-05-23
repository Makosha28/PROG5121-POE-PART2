
package com.mycompany.quickchat;

import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mamphekgonthabiseng
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Scanner keyboard = null;
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.loginUser(keyboard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
