package dorduncuhafta.exception.global;


import dorduncuhafta.exception.UndefinedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UndefinedException.class)
    public String responseMessage(UndefinedException exception) {
        return exception.getMessage();
    }
}
