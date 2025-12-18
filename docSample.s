.data
newline: .asciiz "\n"
str_0: .asciiz "a["
str_1: .asciiz "] = "
str_2: .asciiz "Gracias por usar Mini-C!\n"
.align 2
a: .space 200
m: .space 200
.text
.globl main
# begin_func fill
# fill:
fill:
  subu $sp, $sp, 8
  sw $fp, 0($sp)
  sw $ra, 4($sp)
  move $fp, $sp
  subu $sp, $sp, 200
# ARG_STORE 0, , x
  sw $a0, -12($fp)
# ARG_STORE 1, , y
  sw $a1, -16($fp)
# cont = 1
  li $t0, 1
  sw $t0, -20($fp)
# i = x
  lw $t0, -12($fp)
  sw $t0, -24($fp)
# L0:
L0:
# t0 = i >= 1
  lw $t1, -24($fp)
  li $t2, 1
  sge $t0, $t1, $t2
  sw $t0, -28($fp)
# ifFalse t0 goto L2
  lw $t0, -28($fp)
  beqz $t0, L2
# j = y
  lw $t0, -16($fp)
  sw $t0, -32($fp)
# L3:
L3:
# t1 = j >= 1
  lw $t1, -32($fp)
  li $t2, 1
  sge $t0, $t1, $t2
  sw $t0, -36($fp)
# ifFalse t1 goto L5
  lw $t0, -36($fp)
  beqz $t0, L5
# t2 = x - y
  lw $t1, -12($fp)
  lw $t2, -16($fp)
  sub $t0, $t1, $t2
  sw $t0, -40($fp)
# t3 = cont + t2
  lw $t1, -20($fp)
  lw $t2, -40($fp)
  add $t0, $t1, $t2
  sw $t0, -44($fp)
# t4 = t3 + 5
  lw $t1, -44($fp)
  li $t2, 5
  add $t0, $t1, $t2
  sw $t0, -48($fp)
# t5 = t4 % 15
  lw $t1, -48($fp)
  li $t2, 15
  div $t1, $t2
  mfhi $t0
  sw $t0, -52($fp)
# t6 = i * 5
  lw $t1, -24($fp)
  li $t2, 5
  mul $t0, $t1, $t2
  sw $t0, -56($fp)
# t7 = t6 + j
  lw $t1, -56($fp)
  lw $t2, -32($fp)
  add $t0, $t1, $t2
  sw $t0, -60($fp)
# t8 = t7 * 4
  lw $t1, -60($fp)
  li $t2, 4
  mul $t0, $t1, $t2
  sw $t0, -64($fp)
# m[t8] = t5
  lw $t0, -52($fp)
  la $t1, m
  lw $t2, -64($fp)
  addu $t1, $t1, $t2
  sw $t0, 0($t1)
# t9 = cont + 1
  lw $t1, -20($fp)
  li $t2, 1
  add $t0, $t1, $t2
  sw $t0, -68($fp)
# cont = t9
  lw $t0, -68($fp)
  sw $t0, -20($fp)
# L4:
L4:
# t10 = j - 1
  lw $t1, -32($fp)
  li $t2, 1
  sub $t0, $t1, $t2
  sw $t0, -72($fp)
# j = t10
  lw $t0, -72($fp)
  sw $t0, -32($fp)
# goto L3
  j L3
# L5:
L5:
# L1:
L1:
# t11 = i - 1
  lw $t1, -24($fp)
  li $t2, 1
  sub $t0, $t1, $t2
  sw $t0, -76($fp)
# i = t11
  lw $t0, -76($fp)
  sw $t0, -24($fp)
# goto L0
  j L0
# L2:
L2:
# return
  move $sp, $fp
  lw $ra, 4($fp)
  lw $fp, 0($fp)
  addiu $sp, $sp, 8
  jr $ra
# end_func fill
# begin_func main
# main:
main:
  subu $sp, $sp, 8
  sw $fp, 0($sp)
  sw $ra, 4($sp)
  move $fp, $sp
  subu $sp, $sp, 200
# x = 10
  li $t0, 10
  sw $t0, -12($fp)
# y = 5
  li $t0, 5
  sw $t0, -16($fp)
# cont = 1
  li $t0, 1
  sw $t0, -20($fp)
# length = 50
  li $t0, 50
  sw $t0, -24($fp)
# param 10
# param 5
# t12 = call fill, 2
  subu $sp, $sp, 16
  li $t0, 10
  move $a0, $t0
  li $t0, 5
  move $a1, $t0
  jal fill
  addiu $sp, $sp, 16
  sw $v0, -28($fp)
# cont = 1
  li $t0, 1
  sw $t0, -20($fp)
# i = 1
  li $t0, 1
  sw $t0, -32($fp)
# L6:
L6:
# t13 = i <= x
  lw $t1, -32($fp)
  lw $t2, -12($fp)
  sle $t0, $t1, $t2
  sw $t0, -36($fp)
# ifFalse t13 goto L8
  lw $t0, -36($fp)
  beqz $t0, L8
# j = 1
  li $t0, 1
  sw $t0, -40($fp)
# L9:
L9:
# t14 = j <= y
  lw $t1, -40($fp)
  lw $t2, -16($fp)
  sle $t0, $t1, $t2
  sw $t0, -44($fp)
# ifFalse t14 goto L11
  lw $t0, -44($fp)
  beqz $t0, L11
# t15 = i * 5
  lw $t1, -32($fp)
  li $t2, 5
  mul $t0, $t1, $t2
  sw $t0, -48($fp)
# t16 = t15 + j
  lw $t1, -48($fp)
  lw $t2, -40($fp)
  add $t0, $t1, $t2
  sw $t0, -52($fp)
# t17 = t16 * 4
  lw $t1, -52($fp)
  li $t2, 4
  mul $t0, $t1, $t2
  sw $t0, -56($fp)
# t18 = m[t17]
  la $t1, m
  lw $t2, -56($fp)
  addu $t1, $t1, $t2
  lw $t0, 0($t1)
  sw $t0, -60($fp)
# t19 = cont * 4
  lw $t1, -20($fp)
  li $t2, 4
  mul $t0, $t1, $t2
  sw $t0, -64($fp)
# a[t19] = t18
  lw $t0, -60($fp)
  la $t1, a
  lw $t2, -64($fp)
  addu $t1, $t1, $t2
  sw $t0, 0($t1)
# t20 = cont + 1
  lw $t1, -20($fp)
  li $t2, 1
  add $t0, $t1, $t2
  sw $t0, -68($fp)
# cont = t20
  lw $t0, -68($fp)
  sw $t0, -20($fp)
# L10:
L10:
# t21 = j + 1
  lw $t1, -40($fp)
  li $t2, 1
  add $t0, $t1, $t2
  sw $t0, -72($fp)
# j = t21
  lw $t0, -72($fp)
  sw $t0, -40($fp)
# goto L9
  j L9
# L11:
L11:
# L7:
L7:
# t22 = i + 1
  lw $t1, -32($fp)
  li $t2, 1
  add $t0, $t1, $t2
  sw $t0, -76($fp)
# i = t22
  lw $t0, -76($fp)
  sw $t0, -32($fp)
# goto L6
  j L6
# L8:
L8:
# cont = 1
  li $t0, 1
  sw $t0, -20($fp)
# L12:
L12:
# t23 = length + 1
  lw $t1, -24($fp)
  li $t2, 1
  add $t0, $t1, $t2
  sw $t0, -80($fp)
# t24 = cont != t23
  lw $t1, -20($fp)
  lw $t2, -80($fp)
  sne $t0, $t1, $t2
  sw $t0, -84($fp)
# ifFalse t24 goto L13
  lw $t0, -84($fp)
  beqz $t0, L13
# param "a["
# t25 = call print_str, 1
  subu $sp, $sp, 16
  la $t0, str_0
  move $a0, $t0
  jal print_str
  addiu $sp, $sp, 16
  sw $v0, -88($fp)
# param cont
# t26 = call print_int, 1
  subu $sp, $sp, 16
  lw $t0, -20($fp)
  move $a0, $t0
  jal print_int
  addiu $sp, $sp, 16
  sw $v0, -92($fp)
# param "] = "
# t27 = call print_str, 1
  subu $sp, $sp, 16
  la $t0, str_1
  move $a0, $t0
  jal print_str
  addiu $sp, $sp, 16
  sw $v0, -96($fp)
# t28 = cont * 4
  lw $t1, -20($fp)
  li $t2, 4
  mul $t0, $t1, $t2
  sw $t0, -100($fp)
# t29 = a[t28]
  la $t1, a
  lw $t2, -100($fp)
  addu $t1, $t1, $t2
  lw $t0, 0($t1)
  sw $t0, -104($fp)
# param t29
# t30 = call print_int, 1
  subu $sp, $sp, 16
  lw $t0, -104($fp)
  move $a0, $t0
  jal print_int
  addiu $sp, $sp, 16
  sw $v0, -108($fp)
# t31 = call println, 0
  subu $sp, $sp, 16
  jal println
  addiu $sp, $sp, 16
  sw $v0, -112($fp)
# t32 = cont + 1
  lw $t1, -20($fp)
  li $t2, 1
  add $t0, $t1, $t2
  sw $t0, -116($fp)
# cont = t32
  lw $t0, -116($fp)
  sw $t0, -20($fp)
# goto L12
  j L12
# L13:
L13:
# param "Gracias por usar Mini-C!\n"
# t33 = call print_str, 1
  subu $sp, $sp, 16
  la $t0, str_2
  move $a0, $t0
  jal print_str
  addiu $sp, $sp, 16
  sw $v0, -120($fp)
# return 0
  li $v0, 0
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
