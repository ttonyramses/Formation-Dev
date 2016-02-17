javac  -sourcepath .\src  -d .\classes -classpath .\lib\servlet-api.jar -encoding ISO-8859-1 .\src\*.java .\src\com\eteks\test\*.java

jar  -cfM .\lib\test.jar  -C .\classes  .

javadoc  -sourcepath .\src  -d .\doc  -classpath lib\servlet-api.jar  com.eteks.outils com.eteks.test com.eteks.forum

