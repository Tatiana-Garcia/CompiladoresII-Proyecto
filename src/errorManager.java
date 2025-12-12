import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class errorManager extends BaseErrorListener {
    public boolean hasErrors = false;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        hasErrors = true;


        System.err.printf("Error sintactico en linea %d:%d - %s%n", line, charPositionInLine, msg);

    }
}
