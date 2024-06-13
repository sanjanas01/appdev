package com.example.vit;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator calc;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calc=new Calculator();
    }

    public void testAdd()
    {
        int exp=90;
        int actual= calc.add(40,50);
        assertEquals(exp,actual);
    }

    public void testMult()
    {
        int exp=10;
        int act= calc.mult(5,2);
        assertEquals(exp,act);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSub()
    {
        int e=9;
        int a=calc.sub(100,91);
        assertEquals(e,a);
    }
}