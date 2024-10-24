package com.eriaothienopinyi.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplTest {
    @Test
    void findTheGreatestFromAllDataTest(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllData_Mockito(){
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test // Mocks make it easier and simpler to mock data as compared to Stubs
    void findTheGreatestFromAllData_MockitoOneValue(){
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
}
