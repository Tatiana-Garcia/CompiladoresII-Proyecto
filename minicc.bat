@echo off

SET ANTLR_JAR="C:\Users\tatig\Documents\DocumentstoSave\Apps\antlr-4.13.2-complete.jar"
SET CLASSPATH=".\src;%ANTLR_JAR%"
java -cp %CLASSPATH% Main %*