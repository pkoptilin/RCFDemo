<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:output method="text" encoding="UTF-8"/>
<xsl:strip-space elements="*"/>

<xsl:variable name="cols" select="count(ReportResults/ReportResultsParameters/ColumnHeadings/ColumnHeader) - 1"/>

	<!-- The page template -->
	<xsl:template match="ReportResults">
		<xsl:apply-templates select="ReportResultsName"/>
		<xsl:text>,,</xsl:text>
		<xsl:apply-templates select="ReportResultsDate"/>
		<xsl:text>&#10;&#10;</xsl:text>
		<xsl:apply-templates select="ReportResultsParameters"/>
	</xsl:template>

	<!-- Show the report name -->
	<xsl:template match="ReportResultsName">
		<xsl:value-of select="translate(.,',','')"/>
	</xsl:template>

	<!-- Show the report date -->
	<xsl:template match="ReportResultsDate">
		<xsl:text></xsl:text>
		<xsl:value-of select="translate(.,',','')"/>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="FilteringFields">
		<xsl:text>,,</xsl:text>	
		<xsl:value-of select="@FilterType"/>
		<xsl:text>&#10;</xsl:text>		
		<xsl:apply-templates/>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="FilteringField">
		<xsl:if test="@name != ''">
			<xsl:text>,,</xsl:text>
			<xsl:value-of select="@name"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="@type"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>		
	</xsl:template>

	<!-- Show the ag op criteria -->
	<xsl:template match="AgOpFields">
		<xsl:text>,,</xsl:text>	
		<xsl:value-of select="@FilterType"/>
		<xsl:text>&#10;</xsl:text>		
		<xsl:apply-templates/>
	</xsl:template>

	<!-- Show the ag op criteria -->
	<xsl:template match="AgOpField">
		<xsl:if test="@value != ''">
			<xsl:text>,,</xsl:text>
			<xsl:value-of select="@agOp"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="@name"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="@type"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>		
	</xsl:template>
	
	<xsl:template match="ReportResultsOptions">
		<xsl:variable name="incSummaryCount"><xsl:value-of select="IncSummaryCount"/></xsl:variable>
		<xsl:variable name="incSummaryTotals"><xsl:value-of select="IncSummaryCalcs"/></xsl:variable>
		<xsl:variable name="incSummaryAvgs"><xsl:value-of select="IncSummaryAvgs"/></xsl:variable>		
		<xsl:variable name="totalCount"><xsl:value-of select="../ColumnDetails/@size"/></xsl:variable>
		<xsl:if test="$incSummaryCount = 'true' or $incSummaryTotals = 'true'  or $incSummaryAvgs = 'true'">
			<xsl:text>Report Summary&#10;</xsl:text>
			<!-- create summary table headers -->
			<xsl:text>Grouped Value,</xsl:text>
			<xsl:if test="$incSummaryCount = 'true'">
				<xsl:text>Count,</xsl:text>
			</xsl:if>

			<xsl:for-each select="../ColumnHeadings/ColumnHeader">
				<xsl:if test="@reporttotal">
					<xsl:if test="$incSummaryTotals = 'true' ">
						<xsl:value-of select="."/><xsl:text> (total),</xsl:text>
					</xsl:if>
					<xsl:if test="$incSummaryAvgs = 'true' ">	
						<xsl:value-of select="."/><xsl:text> (average),</xsl:text>
					</xsl:if>						
				</xsl:if>
			</xsl:for-each>					

			<xsl:text>&#10;</xsl:text>
			<!-- create summary table detail -->
			<xsl:for-each select="../ReportSummary/GroupSummary">
				<xsl:variable name="pos1" select="number(position())"/>
				<xsl:variable name="groupName"><xsl:value-of select="@name"/></xsl:variable>
				<xsl:if test="$groupName != ''">				
					<xsl:value-of select="@name"/><xsl:text>,</xsl:text>
					<xsl:if test="$incSummaryCount = 'true'">						
						<xsl:variable name="rowsInGroup"><xsl:value-of select="@count"/></xsl:variable>
						<xsl:value-of select="$rowsInGroup"/><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:for-each select="GroupValue">
						<xsl:variable name="pos2" select="number(position())"/>				
							<xsl:if test="$incSummaryTotals = 'true' or $incSummaryAvgs = 'true'">				
								<xsl:text>"</xsl:text><xsl:value-of select="."/><xsl:text>"</xsl:text><xsl:text>,</xsl:text>
							</xsl:if>
					</xsl:for-each>					
					<xsl:text>&#10;</xsl:text>
				</xsl:if>	
			</xsl:for-each>
			<!-- create summary table totals -->
			<xsl:text>Total,</xsl:text>
			<xsl:if test="$incSummaryCount = 'true'">					
				<xsl:value-of select="$totalCount"/><xsl:text>,</xsl:text>
			</xsl:if>

			<xsl:for-each select="../ColumnHeadings/ColumnHeader">
				<xsl:if test="@reporttotal != '' and $incSummaryTotals = 'true'">
					<xsl:if test="@type = 'USD'">
						<xsl:text>"</xsl:text><xsl:value-of select="@reporttotal"/><xsl:text>"</xsl:text><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:if test="@type = 'currency'">
						<xsl:text>"</xsl:text><xsl:value-of select="@reporttotal"/><xsl:text>"</xsl:text><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:if test="@type = 'Int'">
						<xsl:value-of select="@reporttotal"/><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:if test="@type = 'Double'">
						<xsl:value-of select="@reporttotal"/><xsl:text>,</xsl:text>
					</xsl:if>						
				</xsl:if>
				<xsl:if test="@reportaverage != '' and $incSummaryAvgs = 'true'">
					<xsl:if test="@type = 'USD'">
						<xsl:text>"</xsl:text><xsl:value-of select="@reportaverage"/><xsl:text>"</xsl:text><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:if test="@type = 'currency'">
						<xsl:text>"</xsl:text><xsl:value-of select="@reportaverage"/><xsl:text>"</xsl:text><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:if test="@type = 'Int'">
						<xsl:value-of select="@reportaverage"/><xsl:text>,</xsl:text>
					</xsl:if>
					<xsl:if test="@type = 'Double'">
						<xsl:value-of select="@reportaverage"/><xsl:text>,</xsl:text>
					</xsl:if>						
				</xsl:if>				
			</xsl:for-each>	

			<xsl:text>&#10;</xsl:text>
		
		</xsl:if>
		
	</xsl:template>
	
	<!-- The report tables template -->
	<xsl:template match="ReportResultsParameters">
		<xsl:variable name="incLineItemDetails"><xsl:value-of select="ReportResultsOptions/LineItemDetails"/></xsl:variable>
		<xsl:if test="count(FilteringFields/FilteringField[@name != '']) &gt; 0">
			<xsl:text>Filtering Criteria</xsl:text>
			<xsl:apply-templates select="FilteringFields"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test="count(AgOpFields/AgOpField[@name != '']) &gt; 0">
			<xsl:text>Aggregate Operator Criteria</xsl:text>
			<xsl:apply-templates select="AgOpFields"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>		
		<xsl:apply-templates select="ReportResultsOptions"/>
		<xsl:if test="$incLineItemDetails = 'true'">
			<xsl:apply-templates select="ColumnDetails"/>
		</xsl:if>
	</xsl:template>

	<xsl:template match="ColumnDetails">
		<xsl:apply-templates select="RowGroup"/>
	</xsl:template>

	<xsl:template match="RowGroup">
		<xsl:if test="@value">
			<xsl:text>&#10;</xsl:text><xsl:value-of select="@value"/><xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:text>,</xsl:text>
		<!-- Show the column headings -->
		<xsl:apply-templates select="../../ColumnHeadings"/><xsl:text>&#10;</xsl:text>
		<xsl:apply-templates select="ColumnRow"/>
		<xsl:if test="count(RowGroupTotal/@total) &gt; 0">
			<xsl:apply-templates select="RowGroupTotal" mode="sum">
				<xsl:with-param name="display" select="'Sum:,'"/>
			</xsl:apply-templates>
		</xsl:if>
		<xsl:if test="count(RowGroupTotal/@percentage) &gt; 0">
			<xsl:text>&#10;Percent of Total,</xsl:text>
			<xsl:apply-templates select="RowGroupTotal" mode="percent"/>
		</xsl:if>
		<xsl:text>&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="sum">
		<xsl:param name="display"/>
		<!-- The sum (formatted) -->
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<xsl:if test="@total">
				<xsl:value-of select="$display"/> 
				<xsl:call-template name="formatTotal">
					<xsl:with-param name="pos" select="$pos"/>
					<xsl:with-param name="value" select="@total"/>
				</xsl:call-template>
			</xsl:if>
			<xsl:text>,</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="sumTable">
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			
			<xsl:if test="normalize-space(@total) = '' ">&#xA0;</xsl:if>
			<xsl:if test="@total != ''">
				<xsl:call-template name="formatTotal">
					<xsl:with-param name="pos" select="$pos"/>
					<xsl:with-param name="value" select="@total"/>						
				</xsl:call-template>
				<xsl:text>,</xsl:text>
			</xsl:if>
			<xsl:if test="@average != ''">
				<xsl:call-template name="formatTotal">
					<xsl:with-param name="pos" select="$pos"/>
					<xsl:with-param name="value" select="@average"/>					
				</xsl:call-template>
				<xsl:text>,</xsl:text>
			</xsl:if>			
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="formatTotal">
		<xsl:param name="pos"/>
		<xsl:param name="value"/>		
		<xsl:if test="$value = ''">
			<xsl:value-of select="$value"/>
		</xsl:if>
		<xsl:if test="$value != ''">
			<xsl:value-of select="$value"/>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="RowGroupTotal" mode="percent">
		<!-- The sum percentages (formatted) -->
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<xsl:if test="@percentage">
				<xsl:value-of select="format-number(@percentage div 100,'0.00%')"/>
			</xsl:if>
			<xsl:text>,</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="summaryTableHeader">
		<xsl:param name="display"/>		
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<xsl:if test="normalize-space(@total) = ''">&#xA0;</xsl:if>
			<xsl:text>Total</xsl:text>
		</xsl:if>
	</xsl:template>	
	
	<!-- The column headings template -->
	<xsl:template match="ColumnHeadings">
		<xsl:apply-templates select="ColumnHeader"/>
	</xsl:template>

	<!-- The column header template -->
	<xsl:template match="ColumnHeader">
		<xsl:if test="@ignore != 'true'">
			<xsl:value-of select="translate(.,',','')"/><xsl:if test="position()!=last()">,</xsl:if>
		</xsl:if>
	</xsl:template>

	<!-- The data row template -->
	<xsl:template match="ColumnRow">
		<xsl:text>,</xsl:text><xsl:apply-templates select="ColumnDetail"/><xsl:text>&#10;</xsl:text>
	</xsl:template>

	<!-- The data cell template -->
	<xsl:template match="ColumnDetail">
		<!-- The column number of the current cell -->
		<xsl:variable name="pos" select="number(position())"/>
		<!-- The respective column's ignore flag is not true -->
		<xsl:if test="../../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<xsl:choose>
				<!-- US$ Format ($1,000,000) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'USD' and string(number(.)) != 'NaN'">
					<xsl:text>"</xsl:text><xsl:value-of select="."/><xsl:text>"</xsl:text>
				</xsl:when>
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency' and string(number(.)) != 'NaN'">
					<xsl:text>"</xsl:text><xsl:value-of select="."/><xsl:text>"</xsl:text>
				</xsl:when>
				<!-- Percent Format (7.50%) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Percent' and string(number(.)) != 'NaN'">
					<xsl:value-of select="format-number(.,'0.00')"/><xsl:text>%</xsl:text>
				</xsl:when>
				<!-- Text Format () -->
				<xsl:otherwise>
					<xsl:variable name="noReturns" select="translate(.,'&#xA;&#xD;','')"/>
					<xsl:choose>
						<xsl:when test="contains($noReturns,'&quot;')">
							<xsl:text>"</xsl:text>
							<xsl:call-template name="EscapeQuotes">
								<xsl:with-param name="string" select="$noReturns" />
							</xsl:call-template>
							<xsl:text>"</xsl:text>
						</xsl:when>
						<xsl:when test="contains($noReturns,',')">
							<xsl:text>"</xsl:text><xsl:value-of select="$noReturns"/><xsl:text>"</xsl:text>
						</xsl:when>	
						<xsl:otherwise>
							<xsl:value-of select="$noReturns"/>
						</xsl:otherwise>
					</xsl:choose>						
				</xsl:otherwise>
			</xsl:choose>
			<xsl:if test="position()!=last()">,</xsl:if>
		</xsl:if>
	</xsl:template>

	<xsl:template name="EscapeQuotes">
		<xsl:param name="string" />
		<xsl:choose>
			<xsl:when test="contains($string,'&quot;')">
				<xsl:value-of select="substring-before($string, '&quot;')" />
				<xsl:text>""</xsl:text>
				<xsl:call-template name="EscapeQuotes">
					<xsl:with-param name="string" select="substring-after($string, '&quot;')" />
      			</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$string" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

</xsl:stylesheet>
