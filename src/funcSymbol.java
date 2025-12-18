import java.util.ArrayList;
import java.util.List;

public class funcSymbol extends Symbol{

    private List<varType> paramsType = new ArrayList<>();
    private int stackSize = 0;

    public funcSymbol(String name, varType returnType) {
        super(name, returnType);
    }

    public void addParam(varType param) {
        paramsType.add(param);
    }

    public List<varType> getParams() {
        return paramsType;
    }

    public void setStackSize(int s) {
        this.stackSize = s;
    }
    public int getStackSize() {
        return stackSize;
    }

}
