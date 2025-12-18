import java.util.HashMap;
import java.util.Map;

public class Scope {
    private Scope parent;
    private Map<String, Symbol> symbols = new HashMap<>();

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public Scope getParent() {
        return parent;
    }

    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    public Symbol resolve(String name) {
        Symbol s = symbols.get(name);
        if (s != null) return s;
        if (parent != null) return parent.resolve(name);
        return null;
    }

    public boolean existsInCurrentScope(String name) {
        return symbols.containsKey(name);
    }
    public java.util.Collection<Symbol> getSymbols() {
        return symbols.values();
    }
}
