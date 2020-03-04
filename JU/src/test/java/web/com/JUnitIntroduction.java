package web.com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitIntroduction {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Executed before class...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Executed after class...");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Executed before...");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Executed after...");
    }

    @Test
    public void test1() {
        System.out.println("Executed Test1...");
    }

    @Test
    public void test2() {
        System.out.println("Executed Test2...");
    }

}
