package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ServiceClassTest {
 @Mock
 ServiceClass serviceClass;

 String expected = "Сервер доступен";
    @Test
    public void getResponse() {
        Mockito.when(serviceClass.getResponse()).thenReturn(200);

        Server server = new Server();
        String actual = server.checkServer(serviceClass.getResponse());
        assertEquals(expected, actual);
    }
}
