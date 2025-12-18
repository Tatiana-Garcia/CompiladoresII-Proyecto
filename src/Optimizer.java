import java.util.*;

public class Optimizer {
    private List<Quadruple> code;

    public Optimizer(List<Quadruple> code) {
        this.code = new ArrayList<>(code);
    }

    public List<Quadruple> optimize() {
        boolean changed = true;
        while (changed) {
            changed = false;
            if (constantFolding()) changed = true;
            if (copyPropagation()) changed = true;
        }
        return code;
    }

    private boolean constantFolding() {
        boolean changed = false;
        for (int i = 0; i < code.size(); i++) {
            Quadruple q = code.get(i);

            if (isArithmetic(q.op)) {
                if (isNumber(q.arg1) && isNumber(q.arg2)) {
                    int v1 = Integer.parseInt(q.arg1);
                    int v2 = Integer.parseInt(q.arg2);
                    int res = 0;

                    switch (q.op) {
                        case ADD: res = v1 + v2; break;
                        case SUB: res = v1 - v2; break;
                        case MULT: res = v1 * v2; break;
                        case DIV: if(v2!=0) res = v1 / v2; break;
                        case MOD: if(v2!=0) res = v1 % v2; break;
                    }

                    q.op = TACOp.ASSIGN;
                    q.arg1 = String.valueOf(res);
                    q.arg2 = null;

                    changed = true;
                }
            }
        }
        return changed;
    }

    private boolean copyPropagation() {
        boolean changed = false;
        Map<String, String> replacements = new HashMap<>();

        for (Quadruple q : code) {
            if (q.op != TACOp.ADDR) {
                if (q.arg1 != null && replacements.containsKey(q.arg1)) {
                    q.arg1 = replacements.get(q.arg1);
                    changed = true;
                }
            }
            if (q.arg2 != null && replacements.containsKey(q.arg2)) {
                q.arg2 = replacements.get(q.arg2);
                changed = true;
            }
            if (q.op == TACOp.ASSIGN) {
                replacements.put(q.result, q.arg1);
            }
            else if (q.result != null) {
                replacements.remove(q.result);
            }

            if (q.op == TACOp.LABEL || q.op == TACOp.GOTO ||
                    q.op == TACOp.IF_TRUE || q.op == TACOp.IF_FALSE ||
                    q.op == TACOp.CALL || q.op == TACOp.FUNC_BEGIN) {
                replacements.clear();
            }
        }
        return changed;
    }

    private boolean isNumber(String s) {
        return s != null && s.matches("-?\\d+");
    }

    private boolean isArithmetic(TACOp op) {
        return op == TACOp.ADD || op == TACOp.SUB ||
                op == TACOp.MULT || op == TACOp.DIV || op == TACOp.MOD;
    }
}