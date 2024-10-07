@echo off

REM Declaration des variables
    set nom_projet=framework
    set lib=C:\Program Files\Apache Software Foundation\Tomcat 10.1\lib
    set src=C:\Users\KEVIN\Documents\GitHub\main\src
    set temp=C:\Users\KEVIN\Documents\GitHub\test\temp

    mkdir %temp%
REM compilation du code source
    for /r "%src%" %%i in (*.java) do (
        javac -cp "%lib%\*;" -sourcepath %src% -d %temp% "%%i"
    )

REM Convertir le repertoire temp en .jar
    jar -cf %nom_projet%.jar -C %temp% .

    rmdir %temp%

xcopy /y %nom_projet%.jar "C:\Users\KEVIN\OneDrive\Bureau\Etudes\S5\S6_Framework\SprintTest2"
