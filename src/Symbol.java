
public abstract class Symbol {
    protected String name;
    protected varType type;

    public Symbol(String name, varType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public varType getType() { return type; }
}





