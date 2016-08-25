<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/commande">
		<html>
			<head>
				<style>
					h3 {color :red}
					th {color :blue}
					.produit{text-align:center}

				</style>
			</head>
			<body>
				<table>
					<tr>
						<td>
							<h3> Commande N° </h3>
						</td>
						<td>
							:
						</td>
						<td>
							<xsl:value-of select="num" />
						</td>
					</tr>
					<tr>
						<td>
							<h3> Date </h3>
						</td>
						<td>:</td>
						<td>
							<xsl:value-of select="date" />
						</td>
					</tr>
				</table>
				<hr />
				<u>
					<h3>Produit commande</h3>
				</u>

				<table border="1" class="produit">
					<tr>
						<th>Numero</th>
						<th>Description</th>
						<th>Prix</th>
						<th>Quantite</th>
					</tr>

					<!-- <xsl:for-each select="produitEnQte"> <tr> <td ><xsl:value-of select="@num" 
						/></td> <td><xsl:value-of select="description" /></td> <td><xsl:value-of 
						select="prix" /></td> <td><xsl:value-of select="quantite" /></td> </tr> </xsl:for-each> -->
					<xsl:apply-templates select="produitEnQte" />
				</table>


			</body>
		</html>
	</xsl:template>
	<xsl:template match="produitEnQte">
		<tr>
			<td>
				<xsl:value-of select="@num" />
			</td>
			<td>
				<xsl:value-of select="description" />
			</td>
			<td>
				<xsl:value-of select="prix" />
			</td>
			<td>
				<xsl:value-of select="quantite" />
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>