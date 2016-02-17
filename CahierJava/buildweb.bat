javac  -sourcepath .\src  -d .\web\WEB-INF\classes -classpath -encoding ISO-8859-1 .\lib\servlet-api.jar .\src\com\eteks\test\ServletBienvenue.java

jar -cfM .\bin\test.war  -C .\web .
