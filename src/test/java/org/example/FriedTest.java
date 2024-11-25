package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FriedTest {

    @Mock
    List<String> friendListStub;

    @Test
    public void getListSize() {
        Fried fried = new Fried(friendListStub);
        Mockito.when(friendListStub.size()).thenReturn(100);
        System.out.println(
                fried.getListSize()
        );
    }
}