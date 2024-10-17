@echo off
set CLASSPATH=%~dp0.idea\libraries\sqlite-jdbc-3.46.1.2.jar;.
cd /d "%~dp0src"
javac -cp %CLASSPATH% *.java
java -cp %CLASSPATH%;. Main
cd /d "%~dp0"
pause