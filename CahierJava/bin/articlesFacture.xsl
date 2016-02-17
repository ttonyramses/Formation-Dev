<?xml version="1.0" encoding="UTF-8"?>
<!-- Fichier articlesFacture.xsl -->
<xsl:stylesheet version="1.0"
       xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h1>Articles :</h1>
        <xsl:for-each select="//article">
          <p><xsl:value-of select="@description"/></p>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
