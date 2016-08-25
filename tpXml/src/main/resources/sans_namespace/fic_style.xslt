<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:template match="/pays">
<html>
<body>
<h3>....<xsl:value-of select="@nom" /> ...</h3>
<xsl:apply-templates select="region" />
</body>
</html>
</xsl:template>
<xsl:template match="region">
<h5> <font color='blue'><xsl:value-of select="@nom" /> </font> </h5>
<table border='1'> ...
<xsl:for-each select="departement">
<tr>
<td> <xsl:value-of select="@num" /></td>
...
</tr>
</xsl:for-each>
</table>
</xsl:template>
</xsl:stylesheet>