import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Main {
    public static void main(String[] args) {
        try {
            String source = "test.txt";
            CharStream cs = fromFileName(source);
            MiniCLexer Lexer = new MiniCLexer(cs);
            CommonTokenStream token = new CommonTokenStream(Lexer);
            MiniCParser parser = new MiniCParser(token);
            ParseTree tree = parser.program();

            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);

            System.out.println(tree.toStringTree(parser));

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}