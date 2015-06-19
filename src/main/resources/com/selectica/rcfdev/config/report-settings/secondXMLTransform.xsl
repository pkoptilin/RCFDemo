<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

	<xsl:variable name="primary-sorting-number" select="ReportResults/ReportResultsParameters/MetaInfo/PrimarySortingColumn"/>

	<!-- The page template -->
	<xsl:template match="ReportResults">
		<!-- Show the name, date, and report tables -->
		<ReportResults>
			<xsl:apply-templates/>
		</ReportResults>
	</xsl:template>

	<!-- Show the report name -->
	<xsl:template match="ReportResultsName">
		<ReportResultsName>
			<xsl:value-of select="."/>
		</ReportResultsName>
	</xsl:template>

	<!-- Show the report date -->
	<xsl:template match="ReportResultsDate">
		<ReportResultsDate>
			<xsl:value-of select="."/>
		</ReportResultsDate>
	</xsl:template>


	<!-- Show the report criteria -->
	<xsl:template match="FilteringFields">
		<FilterType><xsl:value-of select="@FilterType"/></FilterType>	
		<xsl:apply-templates/>
	</xsl:template>


	<!-- Show the report criteria -->
	<xsl:template match="FilteringField">
		<xsl:if test="@name != ''">
			<FilterCriteria>
				<xsl:value-of select="@name"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="@type"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="@value"/>
			</FilterCriteria>
		</xsl:if>
	</xsl:template>

	<!-- Show the aggregate funtions criteria -->
	<xsl:template match="AgOpFields">
		<AgOpFilterType><xsl:value-of select="@FilterType"/></AgOpFilterType>	
		<xsl:apply-templates/>
	</xsl:template>
	
	<!-- Show the ag op criteria -->
	<xsl:template match="AgOpField">
		<xsl:if test="@value != ''">
			<AgOpFilterCriteria>
				<xsl:value-of select="@agOp"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="@name"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="@type"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="@value"/>
			</AgOpFilterCriteria>
		</xsl:if>		
	</xsl:template>

	<!-- The report tables template -->
	<xsl:template match="ReportResultsParameters">
		<xsl:variable name="incLineItemDetails"><xsl:value-of select="ReportResultsOptions/LineItemDetails"/></xsl:variable>
		<xsl:if test="count(FilteringFields/FilteringField[@name != '']) &gt; 0">
			<xsl:apply-templates select="FilteringFields"/>
		</xsl:if>
		<xsl:if test="count(AgOpFields/AgOpField[@name != '']) &gt; 0">
			<xsl:apply-templates select="AgOpFields"/>
		</xsl:if>
		<xsl:if test="count(ColumnHeadings/ColumnHeader/@reporttotal) &gt; 0">
			<xsl:for-each select="ColumnHeadings/ColumnHeader">
				<xsl:if test="@reporttotal">
					<ReportTotal>
					<xsl:if test="@type = 'USD'">
						<xsl:value-of select="."/>: <xsl:value-of select="@reporttotal"/>
					</xsl:if>
					<xsl:if test="@type = 'currency'">
						<xsl:value-of select="."/>: <xsl:value-of select="@reporttotal"/>
					</xsl:if>
					<xsl:if test="@type = 'Int'">
						<xsl:value-of select="."/>: <xsl:value-of select="@reporttotal"/>
					</xsl:if>
					<xsl:if test="@type = 'Double'">
						<xsl:value-of select="."/>: <xsl:value-of select="@reporttotal"/>
					</xsl:if>					
					</ReportTotal>
				</xsl:if>
			</xsl:for-each>
		</xsl:if>
		<xsl:apply-templates select="ReportResultsOptions"/>
		<xsl:if test="$incLineItemDetails = 'true'">
			<ReportResultsParameters>
				<xsl:apply-templates select="ColumnHeadings"/>
				<xsl:apply-templates select="ColumnDetails"/>
			</ReportResultsParameters>
		</xsl:if>			
	</xsl:template>

	<xsl:template match="ReportResultsOptions">
		<xsl:variable name="incSummaryCount"><xsl:value-of select="IncSummaryCount"/></xsl:variable>
		<xsl:variable name="incSummaryTotals"><xsl:value-of select="IncSummaryCalcs"/></xsl:variable>
		<xsl:variable name="incSummaryAvgs"><xsl:value-of select="IncSummaryAvgs"/></xsl:variable>
		<xsl:variable name="totalCount"><xsl:value-of select="../ColumnDetails/@size"/></xsl:variable>
		<xsl:if test="$incSummaryCount = 'true' or $incSummaryTotals = 'true'  or $incSummaryAvgs = 'true'">
			
			<ReportSummary>
				<!-- create summary table headers -->
				<!-- nothing to do in xml case, headers are wrapped around data	-->	

				<!-- create summary table detail -->


				<xsl:for-each select="../ReportSummary/GroupSummary">
					<GroupName>
					<xsl:variable name="pos1" select="number(position())"/>
					<xsl:variable name="groupName"><xsl:value-of select="@name"/></xsl:variable>
					<xsl:if test="$groupName != ''">
					
						<xsl:value-of select="@name"/>
						<xsl:if test="$incSummaryCount = 'true'">						
							<xsl:variable name="rowsInGroup"><xsl:value-of select="@count"/></xsl:variable>
							<xsl:value-of select="$rowsInGroup"/>
						</xsl:if>
				<xsl:for-each select="GroupValue">
					<xsl:variable name="pos2" select="number(position())"/>				
						<xsl:if test="$incSummaryTotals = 'true' or $incSummaryAvgs = 'true'">				
							<GroupValue><xsl:value-of select="."/></GroupValue>
						</xsl:if>
				</xsl:for-each>				
			
					</xsl:if>	
				</GroupName>	
				</xsl:for-each>
				<!-- create summary table totals -->
				<SummaryTotals>
					<xsl:if test="$incSummaryCount = 'true'">					
						<SummaryCount><xsl:value-of select="$totalCount"/></SummaryCount>
					</xsl:if>
					
					<!--<xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute>-->

					<xsl:for-each select="../ColumnHeadings/ColumnHeader">
						<xsl:variable name="colName" select="."/>
						<xsl:if test="@reporttotal != '' and $incSummaryTotals = 'true'">
							<xsl:if test="@type = 'currency'">
								<SummaryTotal><xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute><xsl:value-of select="@reporttotal"/></SummaryTotal>
							</xsl:if>
							<xsl:if test="@type = 'Int'">
								<SummaryTotal><xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute><xsl:value-of select="@reporttotal"/></SummaryTotal>
							</xsl:if>
							<xsl:if test="@type = 'Double'">
								<SummaryTotal><xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute><xsl:value-of select="@reporttotal"/></SummaryTotal>
							</xsl:if>						
						</xsl:if>
						<xsl:if test="@reportaverage != '' and $incSummaryAvgs = 'true'">
							<xsl:if test="@type = 'currency'">
								<SummaryAverage><xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute><xsl:value-of select="@reportaverage"/></SummaryAverage>
							</xsl:if>
							<xsl:if test="@type = 'Int'">
								<SummaryAverage><xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute><xsl:value-of select="@reportaverage"/></SummaryAverage>
							</xsl:if>
							<xsl:if test="@type = 'Double'">
								<SummaryAverage><xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute><xsl:value-of select="@reportaverage"/></SummaryAverage>
							</xsl:if>						
						</xsl:if>
					</xsl:for-each>
				</SummaryTotals>					
			</ReportSummary>					
		</xsl:if>
		
	</xsl:template>	
	
	
	<xsl:template match="ColumnHeadings">
		<ColumnHeadings>
			<xsl:apply-templates select="ColumnHeader"/>
		</ColumnHeadings>
	</xsl:template>

	<xsl:template match="ColumnHeader">
		<xsl:if test="@ignore != 'true'">
			<ColumnHeader>
				<xsl:attribute name="type"><xsl:value-of select="@type"/></xsl:attribute>
				<xsl:value-of select="."/>
			</ColumnHeader>
		</xsl:if>
	</xsl:template>

	<xsl:template match="ColumnDetails">
		<xsl:apply-templates select="RowGroup"/>
	</xsl:template>

	<!-- Loop through the groups -->
	<xsl:template match="RowGroup">
		<ResultGroup>
		<xsl:attribute name="name"><xsl:value-of select="@value"/></xsl:attribute>
		<xsl:apply-templates select="ColumnRow"/>
		<xsl:if test="count(RowGroupTotal/@total) &gt; 0">
			<SummaryRow>
				<xsl:apply-templates select="RowGroupTotal" mode="sum"/>
			</SummaryRow>
		</xsl:if>
		<xsl:if test="count(RowGroupTotal/@percentage) &gt; 0">
			<SummaryRow>
				<xsl:apply-templates select="RowGroupTotal" mode="percent"/>
			</SummaryRow>
		</xsl:if>
		</ResultGroup>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="sum">
		<!-- The sum (formatted) -->
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<ColumnDetail><xsl:if test="@total">
				Sum:<xsl:choose>
					<!-- US$ Format ($1,000,000) -->
					<xsl:when test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency' and string(number(@total)) != 'NaN'">
						<xsl:value-of select="@total"/>
					</xsl:when>
					<!-- Int Format (1,000) -->
					<xsl:when test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int' and string(number(@total)) != 'NaN'">
						<xsl:value-of select="@total"/>
					</xsl:when>					
					<!-- Text Format () -->
					<xsl:otherwise>
						<xsl:value-of select="@total"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:if>
			</ColumnDetail>
		</xsl:if>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="sumTable">
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:variable name="colName" select="../../../ColumnHeadings/ColumnHeader[$pos]"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			
			<!--<xsl:if test="normalize-space(@total) = '' ">&#xA0;</xsl:if>-->
			<xsl:if test="@total != ''">
				<GroupValue>
					<xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute>
					<xsl:attribute name="type"><xsl:value-of select="'total'"/></xsl:attribute>										
					<xsl:call-template name="formatTotal">
						<xsl:with-param name="pos" select="$pos"/>
						<xsl:with-param name="value" select="@total"/>
					</xsl:call-template>
				</GroupValue>
			</xsl:if>			
			<xsl:if test="@average != ''">			
				<GroupValue>
					<xsl:attribute name="colName"><xsl:value-of select="$colName"/></xsl:attribute>
					<xsl:attribute name="type"><xsl:value-of select="'average'"/></xsl:attribute>					
					<xsl:call-template name="formatTotal">
						<xsl:with-param name="pos" select="$pos"/>
						<xsl:with-param name="value" select="@average"/>
					</xsl:call-template>
				</GroupValue>			
				
			</xsl:if>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="RowGroupTotal" mode="percent">
		<!-- The sum percentages (formatted) -->
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<ColumnDetail>
			<xsl:if test="@percentage">
				<xsl:value-of select="format-number(@percentage div 100,'0.00%')"/> of Total
			</xsl:if>
			</ColumnDetail>
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
	
	<!-- The data row template -->
	<xsl:template match="ColumnRow">
		<ColumnRow>
		<xsl:apply-templates select="ColumnDetail"/>
		</ColumnRow>
	</xsl:template>

	<!-- The summary row template -->
	<xsl:template match="SummaryRow">
		<SummaryRow>
		<xsl:apply-templates select="ColumnDetail"/>
		</SummaryRow>
	</xsl:template>

	<!-- The data cell template -->
	<xsl:template match="ColumnDetail">
		<!-- The column number of the current cell -->
		<xsl:variable name="pos" select="number(position())"/>
		<!-- The respective column's ignore flag is not true -->
		<xsl:if test="../../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<ColumnDetail>
				<xsl:choose>
					<!-- US$ Format ($1,000,000) -->
					<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency' and string(number(.)) != 'NaN'">
						<xsl:value-of select="."/>
					</xsl:when>
					<!-- Int Format (1,000) -->
					<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int' and string(number(.)) != 'NaN'">
						<xsl:value-of select="."/>
					</xsl:when>				
					<!-- Percent Format (7.50%) -->
					<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Percent' and string(number(.)) != 'NaN'">
						<xsl:value-of select="format-number(.,'0.00')"/><xsl:text>%</xsl:text>
					</xsl:when>
					<!-- Integer Format (1,000) -->
					<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int' and string(number(.)) != 'NaN'">
						<xsl:value-of select="format-number(.,'#,##0')"/>
					</xsl:when>
					<!-- Double Format (1,000.00) -->
					<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Double' and string(number(.)) != 'NaN'">
						<xsl:value-of select="."/>
					</xsl:when>					
					<!-- Text Format () -->
					<xsl:otherwise>
						<xsl:value-of select="."/>
					</xsl:otherwise>
				</xsl:choose>
			</ColumnDetail>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>
