package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockedTest {
    @Mock
    ArrayList list;

    @Mock
    List<String> friendsList;


    @Test
    public void checkList() {
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        Mockito.verify(list, Mockito.times(3)).add(Mockito.any());
    }
}
