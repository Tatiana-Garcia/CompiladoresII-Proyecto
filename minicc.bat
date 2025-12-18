@echo off

SET ANTLR_JAR="C:\Users\tatig\Documents\DocumentstoSave\Apps\antlr-4.13.2-complete.jar"
SET CLASSPATH=".\src;%ANTLR_JAR%"
javac -cp %CLASSPATH% src/*.java
IF %ERRORLEVEL% NEQ 0 (
    echo Error de compilacion. Revisa tu codigo.
    exit /b %ERRORLEVEL%
)
java -cp %CLASSPATH% Main %*