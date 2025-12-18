import org.antlr.v4.runtime.tree.ParseTree;
import java.util.HashMap;
import java.util.Map;

public class symbolTable {
    private Scope rootScope;
    private Scope currentScope;
    private Map<ParseTree, Scope> listScope = new HashMap<>();

    public symbolTable() {
        rootScope = new Scope(null);
        currentScope = rootScope;
    }
    public void enterScope(ParseTree ctx) {
        Scope newScope = new Scope(currentScope);
        currentScope = newScope;
        if (ctx != null) listScope.put(ctx, newScope);
    }

    public void exitScope() {
        if (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        } else {
            System.err.println("Error: Intentando cerrar el Scope global.");
        }
    }

    public void insert(Symbol symbol) {
        if (currentScope.existsInCurrentScope(symbol.getName())) {
            throw new RuntimeException("Error semantico: Variable '" + symbol.getName() + "' ya declarada en este Scope.");
        }
        currentScope.define(symbol);
    }

    public Symbol lookup(String name) {
        return currentScope.resolve(name);
    }

    public void pushScope(ParseTree ctx) {
        if (listScope.containsKey(ctx)) {
            currentScope = listScope.get(ctx);
        } else {
            enterScope(ctx);
        }
    }
    public boolean isGlobalScope() {
        return currentScope.getParent() == null;
    }
    public Scope getGlobalScope() {
        return rootScope;
    }
}
