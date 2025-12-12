import java.util.ArrayList;
import java.util.List;

public class funcSymbol extends Symbol{

    private List<varType> paramsType = new ArrayList<>();

    public funcSymbol(String name, varType returnType) {
        super(name, returnType);
    }

    public void addParam(varType param) {
        paramsType.add(param);
    }

    public List<varType> getParams() {
        return paramsType;
    }

}
