javac  -sourcepath ./src  -d ./web/WEB-INF/classes -classpath ./lib/servlet-api.jar -encoding ISO-8859-1 ./src/com/eteks/test/ServletBienvenue.java
 
jar -cfM ./bin/test.war  -C ./web .
