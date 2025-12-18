import java.io.PrintWriter;
import java.util.*;

public class mipsAssembler {
    private List<Quadruple> irCode;
    private symbolTable symbolTable;
    private PrintWriter out;
    private Set<String> globalNames = new HashSet<>();
    private int paramCount = 0;

    private Map<String, Integer> currentStackMap;
    private int currentStackOffset;

    private Map<String, String> stringTable = new HashMap<>();
    private int stringCount = 0;

    public mipsAssembler(List<Quadruple> irCode, symbolTable st) {
        this.irCode = irCode;
        this.symbolTable = st;
    }

    public void generate(String filename) {
        try {
            scanStrings();
            out = new PrintWriter(filename);
            generateDataSection();
            generateTextSection();
            out.close();
            System.out.println("Archivo MIPS generado: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void scanStrings() {
        for (Quadruple q : irCode) {
            checkString(q.arg1);
            checkString(q.arg2);
            checkString(q.result);
        }
    }

    private void checkString(String s) {
        if (s != null && s.startsWith("\"") && s.endsWith("\"")) {
            if (!stringTable.containsKey(s)) {
                stringTable.put(s, "str_" + stringCount++);
            }
        }
    }

    private void generateDataSection() {
        out.println(".data");
        out.println("newline: .asciiz \"\\n\"");

        for (Map.Entry<String, String> entry : stringTable.entrySet()) {
            out.println(entry.getValue() + ": .asciiz " + entry.getKey());
        }
        out.println(".align 2");

        for (Symbol sym : symbolTable.getGlobalScope().getSymbols()) {

            if (sym instanceof varSymbol) {
                varSymbol v = (varSymbol) sym;

                out.print(v.getName() + ": ");


                globalNames.add(v.getName());

                if (v.isArray()) {
                    out.println(".space " + v.getSize());
                } else {
                    out.println(".word 0");
                }
            }
        }
    }

    private void generateTextSection() {
        out.println(".text");
        out.println(".globl main");

        generateRuntime();

        for (Quadruple q : irCode) {
            out.println("# " + q.toString().replace("\n", "").trim());
            translate(q);
        }
    }

    private void translate(Quadruple q) {
        switch (q.op) {
            case FUNC_BEGIN:
            case FUNC_END:
                break;
            case LABEL:
                out.println(q.result + ":");
                if (!q.result.startsWith("L")) {
                    resetStackFrame();
                    generatePrologue();

                    if (q.result.equals("fill")) {
                        int offX = getStackOffset("x");
                        int offY = getStackOffset("y");
                        out.println("  sw $a0, " + offX + "($fp)");
                        out.println("  sw $a1, " + offY + "($fp)");
                    }
                }
                break;
            case ASSIGN:
                load("$t0", q.arg1);
                store("$t0", q.result);
                break;
            case ADD:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  add $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case SUB:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  sub $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case MULT:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  mul $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case DIV:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  div $t1, $t2");
                out.println("  mflo $t0");
                store("$t0", q.result);
                break;
            case MOD:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  div $t1, $t2");
                out.println("  mfhi $t0");
                store("$t0", q.result);
                break;
            case GOTO:
                out.println("  j " + q.result);
                break;
            case IF_FALSE:
                load("$t0", q.arg1);
                out.println("  beqz $t0, " + q.result);
                break;
            case IF_TRUE:
                load("$t0", q.arg1);
                out.println("  bnez $t0, " + q.result);
                break;
            case LT:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  slt $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case GT:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  sgt $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case LTE:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  sle $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case GTE:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  sge $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case EQ:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  seq $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case NEQ:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  sne $t0, $t1, $t2");
                store("$t0", q.result);
                break;

            case AND:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  and $t0, $t1, $t2");
                store("$t0", q.result);
                break;
            case OR:
                load("$t1", q.arg1);
                load("$t2", q.arg2);
                out.println("  or $t0, $t1, $t2");
                store("$t0", q.result);
                break;

            case PARAM:
                load("$t0", q.arg1);
                if (paramCount == 0) out.println("  move $a0, $t0");
                else if (paramCount == 1) out.println("  move $a1, $t0");
                else if (paramCount == 2) out.println("  move $a2, $t0");
                else if (paramCount == 3) out.println("  move $a3, $t0");

                out.println("  sw $t0, 0($sp)");
                out.println("  addiu $sp, $sp, -4");
                paramCount++;
                break;

            case CALL:
                String func = q.arg1;
                if (func.equals("print_int")) {
                    out.println("  addiu $sp, $sp, 4");
                    out.println("  lw $a0, 0($sp)");
                    out.println("  jal _print_int");
                } else if (func.equals("print_str")) {
                    out.println("  addiu $sp, $sp, 4");
                    out.println("  lw $a0, 0($sp)");
                    out.println("  jal _print_str");
                } else if (func.equals("println")) {
                    out.println("  jal _println");
                } else {
                    out.println("  jal " + func);
                    int numParams = Integer.parseInt(q.arg2);
                    if (numParams > 0) {
                        out.println("  addiu $sp, $sp, " + (numParams * 4));
                    }
                    if (q.result != null) store("$v0", q.result);
                }
                paramCount = 0;
                break;

            case RETURN:
                if (q.arg1 != null) load("$v0", q.arg1);
                out.println("  move $sp, $fp");
                out.println("  lw $ra, 4($fp)");
                out.println("  lw $fp, 0($fp)");
                out.println("  addiu $sp, $sp, 8");
                out.println("  jr $ra");
                break;

            case PTR_STORE:
                load("$t0", q.arg1);
                load("$t1", q.arg2);
                out.println("  sw $t0, 0($t1)");
                break;

            case ARR_STORE:
                load("$t0", q.arg1);
                if (globalNames.contains(q.result)) {
                    out.println("  la $t1, " + q.result);
                } else {
                    int off = getStackOffset(q.result);
                    out.println("  addiu $t1, $fp, " + off);
                }
                load("$t2", q.arg2);
                out.println("  addu $t1, $t1, $t2");
                out.println("  sw $t0, 0($t1)");
                break;

            case ARR_LOAD:
                if (globalNames.contains(q.arg1)) {
                    out.println("  la $t1, " + q.arg1);
                } else {
                    int off = getStackOffset(q.arg1);
                    out.println("  addiu $t1, $fp, " + off);
                }
                load("$t2", q.arg2);
                out.println("  addu $t1, $t1, $t2");
                out.println("  lw $t0, 0($t1)");
                store("$t0", q.result);
                break;
        }
    }

    private void load(String reg, String variable) {
        if (variable == null) return;
        if (variable.matches("-?\\d+")) {
            out.println("  li " + reg + ", " + variable);
            return;
        }
        if (variable.startsWith("\"")) {
            String label = stringTable.get(variable);
            out.println("  la " + reg + ", " + label);
            return;
        }
        if (globalNames.contains(variable)) {
            out.println("  lw " + reg + ", " + variable);
        } else {
            int offset = getStackOffset(variable);
            out.println("  lw " + reg + ", " + offset + "($fp)");
        }
    }

    private void store(String reg, String variable) {
        if (variable == null) return;
        if (globalNames.contains(variable)) {
            out.println("  sw " + reg + ", " + variable);
        } else {
            int offset = getStackOffset(variable);
            out.println("  sw " + reg + ", " + offset + "($fp)");
        }
    }

    private int getStackOffset(String var) {
        if (!currentStackMap.containsKey(var)) {
            currentStackOffset -= 4;
            currentStackMap.put(var, currentStackOffset);
        }
        return currentStackMap.get(var);
    }

    private void resetStackFrame() {
        currentStackMap = new HashMap<>();
        currentStackOffset = -8;
    }

    private void generatePrologue() {
        out.println("  subu $sp, $sp, 8");
        out.println("  sw $fp, 0($sp)");
        out.println("  sw $ra, 4($sp)");
        out.println("  move $fp, $sp");
        out.println("  subu $sp, $sp, 200");
    }

    private void generateRuntime() {
        out.println("_print_int:");
        out.println("  li $v0, 1");
        out.println("  syscall");
        out.println("  jr $ra");

        out.println("_print_str:");
        out.println("  li $v0, 4");
        out.println("  syscall");
        out.println("  jr $ra");

        out.println("_println:");
        out.println("  la $a0, newline");
        out.println("  li $v0, 4");
        out.println("  syscall");
        out.println("  jr $ra");

        out.println("_exit:");
        out.println("  li $v0, 10");
        out.println("  syscall");
    }
}