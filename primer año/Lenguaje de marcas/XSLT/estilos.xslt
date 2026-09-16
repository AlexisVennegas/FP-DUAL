<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h1>Mis ciclos</h1>
    <ul>
        <xsl:for-each select="ies/ciclos/ciclo">
            <li>    
            <xsl:value-of select="nombre"/>
                <ul>
                    <li>
                        <xsl:value-of select="@id"/>
                    </li>
                </ul>
            </li>
        </xsl:for-each>
    </ul>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>