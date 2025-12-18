.data
newline: .asciiz "\n"
str_1: .asciiz "\nsuma: "
str_0: .asciiz "suma: "
.align 2
.text
.globl main
# begin_func main
# main:
main:
  subu $sp, $sp, 8
  sw $fp, 0($sp)
  sw $ra, 4($sp)
  move $fp, $sp
  subu $sp, $sp, 200
# a = 5
  li $t0, 5
  sw $t0, -12($fp)
# b = 10
  li $t0, 10
  sw $t0, -16($fp)
# t0 = 5 < 10
  li $t1, 5
  li $t2, 10
  slt $t0, $t1, $t2
  sw $t0, -20($fp)
# ifFalse t0 goto L0
  lw $t0, -20($fp)
  beqz $t0, L0
# t1 = a + b
  lw $t1, -12($fp)
  lw $t2, -16($fp)
  add $t0, $t1, $t2
  sw $t0, -24($fp)
# suma = t1
  lw $t0, -24($fp)
  sw $t0, -28($fp)
# goto L1
  j L1
# L0:
L0:
# t2 = a - b
  lw $t1, -12($fp)
  lw $t2, -16($fp)
  sub $t0, $t1, $t2
  sw $t0, -32($fp)
# suma = t2
  lw $t0, -32($fp)
  sw $t0, -28($fp)
# L1:
L1:
# param "suma: "
# t3 = call print_str, 1
  subu $sp, $sp, 16
  la $t0, str_0
  move $a0, $t0
  jal print_str
  addiu $sp, $sp, 16
  sw $v0, -36($fp)
# param suma
# t4 = call print_int, 1
  subu $sp, $sp, 16
  lw $t0, -28($fp)
  move $a0, $t0
  jal print_int
  addiu $sp, $sp, 16
  sw $v0, -40($fp)
# L2:
L2:
# t5 = suma > 0
  lw $t1, -28($fp)
  li $t2, 0
  sgt $t0, $t1, $t2
  sw $t0, -44($fp)
# ifFalse t5 goto L3
  lw $t0, -44($fp)
  beqz $t0, L3
# t6 = suma - 1
  lw $t1, -28($fp)
  li $t2, 1
  sub $t0, $t1, $t2
  sw $t0, -48($fp)
# suma = t6
  lw $t0, -48($fp)
  sw $t0, -28($fp)
# goto L2
  j L2
# L3:
L3:
# param "\nsuma: "
# t7 = call print_str, 1
  subu $sp, $sp, 16
  la $t0, str_1
  move $a0, $t0
  jal print_str
  addiu $sp, $sp, 16
  sw $v0, -52($fp)
# param suma
# t8 = call print_int, 1
  subu $sp, $sp, 16
  lw $t0, -28($fp)
  move $a0, $t0
  jal print_int
  addiu $sp, $sp, 16
  sw $v0, -56($fp)
# return suma
  lw $v0, -28($fp)
  move $sp, $fp
  lw $ra, 4($fp)
  lw $fp, 0($fp)
  addiu $sp, $sp, 8
  jr $ra
# return
  move $sp, $fp
  lw $ra, 4($fp)
  lw $fp, 0($fp)
  addiu $sp, $sp, 8
  jr $ra
# end_func main
print_int:
  li $v0, 1
  syscall
  jr $ra
print_bool:
  li $v0, 1
  syscall
  jr $ra
print_str:
  li $v0, 4
  syscall
  jr $ra
print_char:
  li $v0, 11
  syscall
  jr $ra
println:
  la $a0, newline
  li $v0, 4
  syscall
  jr $ra
read_int:
  li $v0, 5
  syscall
  jr $ra
read_char:
  li $v0, 12
  syscall
  jr $ra
_exit:
  li $v0, 10
  syscall
