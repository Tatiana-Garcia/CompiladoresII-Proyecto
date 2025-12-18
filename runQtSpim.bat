@echo off
SET QTSPIM_PATH=C:\Program Files (x86)\QtSpim\QtSpim.exe

if "%~1"=="" (
    echo Uso: runQtSpim.bat ^<archivo.s^>
    exit /b 1
)

echo Ejecutando %1 en QtSpim...
call "%QTSPIM_PATH%" "%~1"
