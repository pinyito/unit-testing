package com.eriaothienopinyi;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in Calculator Class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void declareCalculatorVariable(){
        System.out.println("Some logic here! Performed before test starts");
    }

    @BeforeEach
    void createCalculatorInstance(){
        System.out.println("Before each test method is executed...");
        calculator = new Calculator();
    }

    @DisplayName("Test 4/2=2")
    @Test
    void integerDivisionTest() {

        assertEquals(2, calculator.integerDivision(4, 2), "4/2 did not yield 2!");
    }

    @DisplayName("Test 4-2=2")
    @Test
    void integerSubtractionTest(){
        assertEquals(2, calculator.integerSubtraction(4, 2), () -> "4-2 does not yield 2!");
    }

    //Naming Tests:: test<system under test>_<condition or state change>_expected result>
    //@Disabled("TO DO: Still figuring out the cause of failure.")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(){
        //Arrange
        int dividend = 4;
        int divisor = 0;

        //Act && Assert
        assertThrows(ArithmeticException.class, () -> {
            // Act
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an exception");
    }

    // test method structure
    /*
     *  Arrange OR Given
     *
     *  Act OR When
     *
     *  Assert OR Then
     */
}