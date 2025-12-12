public class symbolTable {
    private Scope currentScope;

    public symbolTable() {
        currentScope = new Scope(null);
    }

    public void enterScope() {
        currentScope = new Scope(currentScope);
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
}
