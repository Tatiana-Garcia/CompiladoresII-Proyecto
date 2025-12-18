import java.util.ArrayList;
import java.util.List;

public class varSymbol extends Symbol{
    private boolean isArray;
    private int size; // bytes
    private int offset; // Stack pos
    private boolean isGlobal; // True = .data, False = stack ($fp)
    private List<Integer> arrDim = new ArrayList<>();

    public varSymbol(String name, varType type, boolean isArray, int size, int offset, boolean isGlobal) {
        super(name, type);
        this.isArray = isArray;
        this.size = size;
        this.offset = offset;
        this.isGlobal = isGlobal;
    }

    public boolean isArray() { return isArray; }

    public void setDimentions(List<Integer> dims) { this.arrDim = dims; }

    public List<Integer> getDimentions() { return arrDim; }
    public int getOffset() { return offset; }
    public boolean isGlobal() { return isGlobal; }
    public int getSize() { return size; }
}
