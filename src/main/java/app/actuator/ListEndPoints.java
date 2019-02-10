package app.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="helloEndpoint")
@Component
public class ListEndPoints {
    @ReadOperation
    public String mypoint(){
        return "Hello" ;
    }
}