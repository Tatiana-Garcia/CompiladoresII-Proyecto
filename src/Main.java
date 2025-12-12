import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Main {
    public static void main(String[] args) {
        try {
            String source = "docSample.mc";
            //String source = "sample.mc";
            CharStream cs = fromFileName(source);
            MiniCLexer lexer = new MiniCLexer(cs);

            lexer.removeErrorListeners();
            lexer.addErrorListener(new errorManager());

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniCParser parser = new MiniCParser(tokens);

            parser.removeErrorListeners();

            errorManager syntaxErrors = new errorManager();
            parser.addErrorListener(syntaxErrors);


            ParseTree tree = parser.program();

            if (syntaxErrors.hasErrors) {
                System.err.println("Se encontraron errores sintacticos...");
            } else {
                System.out.println("Compilacion: ✓");

                MyVisitor visitor = new MyVisitor();
                visitor.visit(tree);

                System.out.println("--- Análisis Semántico ---");
                semanticVisitor semantic = new semanticVisitor();
                semantic.visit(tree);
            }



            //System.out.println(tree.toStringTree(parser));

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}