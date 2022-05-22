lab5:
	javac lab5.java

test1:
	java lab5 lab4_fib20.asm lab5.script 2 > prediction
	diff -w -B prediction lab5_ghr2.output
	rm prediction

test2:
	java lab5 lab4_fib20.asm lab5.script 4 > prediction
	diff -w -B prediction lab5_ghr4.output
	rm prediction

test3:
	java lab5 lab4_fib20.asm lab5.script 8 > prediction
	diff -w -B prediction lab5_ghr8.output
	rm prediction

delClass: 
	rm *.class

dlab5:
	rm *.class
	javac lab5.java

turnin:
	handin jseng 315_lab5_1 Makefile
	handin jseng 315_lab5_1 *.java