set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_102
set WSDL_URL=http://192.168.102.91:8081/serviceTva?wsdl
cd /d "%~dp0"
"%JAVA_HOME%/bin/wsimport" -d ../src/main/java -keep %WSDL_URL%
pause