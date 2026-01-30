package main.java.com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppTest {

    @Mock
    private Calculator calc;
    
    @Mock
    private UserService service;

    @Test
    void testExecute() throws Exception {
        when(calc.calculate(10, 5, "add")).thenReturn(15);
        
        App.execute(calc, service);
        
        verify(calc).calculate(10, 5, "add");
        verify(service).findUser("admin");
        verify(service).deleteUser("admin");
    }
}
