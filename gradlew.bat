@echo off
set DIR=%~dp0
if "%DIR:~-1%"=="\" set DIR=%DIR:~0,-1%
set CLASSPATH=%DIR%\gradle\wrapper\gradle-wrapper.jar
if not exist "%CLASSPATH%" (
    echo Gradle wrapper JAR not found. Please generate the wrapper first using the GitHub Action bootstrap workflow.
    exit /b 1
)
java %JAVA_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
