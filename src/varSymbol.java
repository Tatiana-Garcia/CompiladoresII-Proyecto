import java.util.ArrayList;
import java.util.List;

public class varSymbol extends Symbol{
    private boolean isArray;
    private int size;
    private List<Integer> arrDim = new ArrayList<>();

    public varSymbol(String name, varType type, boolean isArray, int size) {
        super(name, type);
        this.isArray = isArray;
        this.size = size;
    }

    public boolean isArray() {
        return isArray;
    }
    public void setDimentions(List<Integer> dims) {
        this.arrDim = dims;
    }
    public List<Integer> getDimentions() {
        return arrDim;
    }
}
