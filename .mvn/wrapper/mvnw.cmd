@echo off
setlocal
set MVNW_REPOURL=https://repo.maven.apache.org/maven2
set WRAPPER_DIR=%~dp0.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar

if not exist "%WRAPPER_JAR%" (
  echo Downloading Maven Wrapper jar...
  if not exist "%WRAPPER_DIR%" mkdir "%WRAPPER_DIR%"
  powershell -NoProfile -ExecutionPolicy Bypass -Command ^
    "Invoke-WebRequest -Uri '%MVNW_REPOURL%/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar' -OutFile '%WRAPPER_JAR%'"
)

java -jar "%WRAPPER_JAR%" %*
endlocal