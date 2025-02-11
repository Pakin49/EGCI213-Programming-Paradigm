
public class midterm {

}

class InvalidNumberException extends RuntimeException
{
    public InvalidNumberException(String message) {
        super("InvalidNumberException: For input string: \""+ message+"\"");
    }
}
