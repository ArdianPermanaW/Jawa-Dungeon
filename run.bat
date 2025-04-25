@echo off
echo Deleting old .class files...
del /s *.class

echo.
echo Compiling all Java files recursively...
for /R %%f in (*.java) do javac "%%f"

if %errorlevel% neq 0 (
    echo ❌ Compile error!
    pause
    exit /b
)

echo.
echo Running Game...
java Game

echo.
pause
