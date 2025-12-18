import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Debe usar: java Main <input.mc> [-o output.s] [-S] [-O] [--dump-ir]");
            return;
        }

        String inputFile = null;
        String outputFile = "output.s";
        boolean optimize = false;
        boolean dumpIR = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                if (i + 1 < args.length) outputFile = args[i + 1];
                i++;
            } else if (args[i].equals("-O")) {
                optimize = true;
            } else if (args[i].equals("--dump-ir")) {
                dumpIR = true;
            } else if (!args[i].startsWith("-")) {
                inputFile = args[i];
            }
        }

        if (inputFile == null) {
            System.err.println("Error: No se especificó archivo de entrada.");
            return;
        }

        try {
            //String source = "testingFile.mc";
            //String source = "docSample.mc";
            //String source = "sample.mc";
            CharStream cs = fromFileName(inputFile);

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
                return;
            }
            System.out.println("Compilacion: ✓");

            //MyVisitor visitor = new MyVisitor();
            //visitor.visit(tree);

            System.out.println("--- Analisis Semantico ---");
            semanticVisitor semantic = new semanticVisitor();
            semantic.visit(tree);

            IR irGen = new IR();
            irGen.setSymbolTable(semantic.getSymbolTable());
            irGen.visit(tree);

            List<Quadruple> code = irGen.code;

            if (dumpIR) {
                System.out.println("--- Codigo Intermedio ---");
                for (Quadruple q : code) {
                    System.out.println(q);
                }
            }
            // Optimizacion
            if (optimize) {
                Optimizer optimizer = new Optimizer(code);
                code = optimizer.optimize();
                if (dumpIR) {
                    System.out.println("--- IR Optimizado ---");
                    for (Quadruple q : code) System.out.println(q);
                }

            }

            if (!code.isEmpty()) {
                System.out.println("\nGenerando codigo en MIPS ...");

                mipsAssembler assembler = new mipsAssembler(code, semantic.getSymbolTable());

                assembler.generate(outputFile);
            }


        } catch(IOException e) {
            System.err.println("No se pudo leer el archivo '" + inputFile + "'");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}