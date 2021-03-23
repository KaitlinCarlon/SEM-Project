package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    DataConnect testConnect = new DataConnect();

    @Test
    void TestCountryPopulationOrder()
    {
    Req1 testOrder = new Req1(testConnect);
    testOrder.countryReport(1);
    }

    @Test
    void TestCityPopulationOrder()
    {
        Req7 testOrder = new Req7(testConnect);
        testOrder.cityReport(1);
    }

}
