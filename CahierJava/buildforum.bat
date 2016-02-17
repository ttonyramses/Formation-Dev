REM Compilation des fichiers necessaires au serveur 
javac  -sourcepath .\src  -d .\forum\WEB-INF\classes -encoding ISO-8859-1 .\src\com\eteks\forum\UtilisateurForum.java .\src\com\eteks\forum\EnsembleMessagesForum.java .\src\com\eteks\outils\MotDePasse.java .\src\com\eteks\outils\OutilsChaine.java

REM Compilation des fichiers necessaires a l'applet de chat
javac  -sourcepath .\src  -d .\forum\classes -encoding ISO-8859-1 .\src\com\eteks\forum\AppletChatLive.java

REM Creation de l'application Web
jar -cfM .\bin\forum.war  -C .\forum .
