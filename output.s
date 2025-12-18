.data
newline: .asciiz "\n"
str_2: .asciiz "Error: Fallo en logica booleana"
str_3: .asciiz "Factorial de 5 (120): "
str_0: .asciiz "Esperado 50: "
str_1: .asciiz "Correcto: c es mayor a 40 y a es 10"
.align 2
res: .word 0
.text
.globl main
_print_int:
  li $v0, 1
  syscall
  jr $ra
_print_str:
  li $v0, 4
  syscall
  jr $ra
_println:
  la $a0, newline
  li $v0, 4
  syscall
  jr $ra
_exit:
  li $v0, 10
  syscall
# begin_func main
# main:
main:
  subu $sp, $sp, 8
  sw $fp, 0($sp)
  sw $ra, 4($sp)
  move $fp, $sp
  subu $sp, $sp, 200
# a = 10
  li $t0, 10
  sw $t0, -12($fp)
# b = 20
  li $t0, 20
  sw $t0, -16($fp)
# t0 = 40
  li $t0, 40
  sw $t0, -20($fp)
# t1 = 50
  li $t0, 50
  sw $t0, -24($fp)
# c = 50
  li $t0, 50
  sw $t0, -28($fp)
# param "Esperado 50: "
  la $t0, str_0
  move $a0, $t0
  sw $t0, 0($sp)
  addiu $sp, $sp, -4
# t2 = call print_str, 1
  addiu $sp, $sp, 4
  lw $a0, 0($sp)
  jal _print_str
# param c
  lw $t0, -28($fp)
  move $a0, $t0
  sw $t0, 0($sp)
  addiu $sp, $sp, -4
# t3 = call print_int, 1
  addiu $sp, $sp, 4
  lw $a0, 0($sp)
  jal _print_int
# t4 = call println, 0
  jal _println
# t5 = c > 40
  lw $t1, -28($fp)
  li $t2, 40
  sgt $t0, $t1, $t2
  sw $t0, -32($fp)
# t6 = a == 10
  lw $t1, -12($fp)
  li $t2, 10
  seq $t0, $t1, $t2
  sw $t0, -36($fp)
# AND t5, t6, t7
  lw $t1, -32($fp)
  lw $t2, -36($fp)
  and $t0, $t1, $t2
  sw $t0, -40($fp)
# ifFalse t7 goto L0
  lw $t0, -40($fp)
  beqz $t0, L0
# param "Correcto: c es mayor a 40 y a es 10"
  la $t0, str_1
  move $a0, $t0
  sw $t0, 0($sp)
  addiu $sp, $sp, -4
# t8 = call print_str, 1
  addiu $sp, $sp, 4
  lw $a0, 0($sp)
  jal _print_str
# goto L1
  j L1
# L0:
L0:
# param "Error: Fallo en logica booleana"
  la $t0, str_2
  move $a0, $t0
  sw $t0, 0($sp)
  addiu $sp, $sp, -4
# t9 = call print_str, 1
  addiu $sp, $sp, 4
  lw $a0, 0($sp)
  jal _print_str
# L1:
L1:
# t10 = call println, 0
  jal _println
# f = 5
  li $t0, 5
  sw $t0, -44($fp)
# fact = 1
  li $t0, 1
  sw $t0, -48($fp)
# L2:
L2:
# t11 = f > 0
  lw $t1, -44($fp)
  li $t2, 0
  sgt $t0, $t1, $t2
  sw $t0, -52($fp)
# ifFalse t11 goto L3
  lw $t0, -52($fp)
  beqz $t0, L3
# t12 = fact * f
  lw $t1, -48($fp)
  lw $t2, -44($fp)
  mul $t0, $t1, $t2
  sw $t0, -56($fp)
# fact = t12
  lw $t0, -56($fp)
  sw $t0, -48($fp)
# t13 = f - 1
  lw $t1, -44($fp)
  li $t2, 1
  sub $t0, $t1, $t2
  sw $t0, -60($fp)
# f = t13
  lw $t0, -60($fp)
  sw $t0, -44($fp)
# goto L2
  j L2
# L3:
L3:
# param "Factorial de 5 (120): "
  la $t0, str_3
  move $a0, $t0
  sw $t0, 0($sp)
  addiu $sp, $sp, -4
# t14 = call print_str, 1
  addiu $sp, $sp, 4
  lw $a0, 0($sp)
  jal _print_str
# param fact
  lw $t0, -48($fp)
  move $a0, $t0
  sw $t0, 0($sp)
  addiu $sp, $sp, -4
# t15 = call print_int, 1
  addiu $sp, $sp, 4
  lw $a0, 0($sp)
  jal _print_int
# t16 = call println, 0
  jal _println
# return
  move $sp, $fp
  lw $ra, 4($fp)
  lw $fp, 0($fp)
  addiu $sp, $sp, 8
  jr $ra
# end_func main
