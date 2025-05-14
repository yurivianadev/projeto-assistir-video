@echo off
cls
echo Compilando o projeto...

:: Remove pasta bin se existir
rmdir /s /q bin
mkdir bin

:: Cria um arquivo com todos os .java encontrados
del sources.txt >nul 2>nul
(for /R src %%f in (*.java) do @echo %%f) > sources.txt

:: Compila todos os arquivos listados em sources.txt
javac -cp "lib\mysql-connector-j-9.2.0.jar" -d bin @sources.txt

if errorlevel 1 (
    echo Erro na compilacao. Verifique o codigo-fonte.
    pause
    exit /b
)

echo Compilacao concluida com sucesso!
echo.
echo Executando App...

java -cp "bin;lib\mysql-connector-j-9.2.0.jar" br.com.yuri.projeto.app.AppInteracao

echo.
pause
