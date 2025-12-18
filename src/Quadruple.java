public class Quadruple {
    TACOp op;
    String arg1;
    String arg2;
    String result;

    public Quadruple(TACOp op, String arg1, String arg2, String result) {
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }

    public TACOp getOp() {
        return op;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public String getresult() {
        return result;
    }

    public void setOp(TACOp op) {
        this.op = op;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public void setresult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        String a1 = (arg1 == null) ? "" : arg1;
        String a2 = (arg2 == null) ? "" : arg2;
        String r = (result == null) ? "" : result;
        switch (op) {
            case ADD: case SUB: case MULT: case DIV: case MOD:
                case LT: case GT: case LTE: case GTE: case EQ: case NEQ:
                return String.format("\t%s = %s %s %s", r, a1, getOpSym(), a2);
            case ASSIGN:
                return String.format("\t%s = %s", r, a1);
            case LABEL:
                return r + ":";
            case GOTO:
                return String.format("\tgoto %s", r);
            case IF_FALSE:
                return String.format("\tifFalse %s goto %s", a1, r);
            case PARAM:
                return String.format("\tparam %s", a1);
            case CALL:
                return String.format("\t%s = call %s, %s", r, a1, a2);
            case RETURN:
                return String.format("\treturn %s", a1);
            case ARR_LOAD:
                return String.format("\t%s = %s[%s]", r, a1, a2); // t1 = arr[i]
            case ARR_STORE:
                return String.format("\t%s[%s] = %s", r, a2, a1); // arr[i] = val
            case PTR_LOAD:
                return String.format("\t%s = *%s", r, a1);
            case PTR_STORE:
                return String.format("\t*%s = %s", r, a1);
            case ADDR:
                return String.format("\t%s = &%s", r, a1);
            case FUNC_BEGIN:
                return "\nbegin_func " + r;
            case FUNC_END:
                return "end_func " + r;
            case UMINUS: case NOT:
                return String.format("\t%s = %s%s", r, op,a1);
            default:
                return String.format("\t%s %s, %s, %s", op, a1, a2, r);

        }

    }
    private String getOpSym() {
        switch(op) {
            case ADD: return "+"; case SUB: return "-"; case MULT: return "*";
            case DIV: return "/"; case MOD: return "%";
            case LT: return "<"; case GT: return ">";
            case LTE: return "<="; case GTE: return ">=";
            case EQ: return "=="; case NEQ: return "!=";
            default: return "?";
        }
    }

}