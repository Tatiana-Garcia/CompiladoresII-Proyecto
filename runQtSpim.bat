@echo off
SET QTSPIM_PATH="C:\Users\tatig\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\QtSpim\QtSpim.exe"

if "%~1"=="" (
    echo Uso: run_mips.bat <archivo.s>
    exit /b
)

echo Ejecutando %1 en QtSPIM...

REM Opción A: Abrir GUI cargando el archivo
%QTSPIM_PATH% "%1"
