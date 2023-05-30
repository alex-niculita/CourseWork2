package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AmountOutOfSizeException extends RuntimeException{
    public AmountOutOfSizeException() {
    }

    public AmountOutOfSizeException(String message) {
        super(message);
    }

    public AmountOutOfSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountOutOfSizeException(Throwable cause) {
        super(cause);
    }

    public AmountOutOfSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
