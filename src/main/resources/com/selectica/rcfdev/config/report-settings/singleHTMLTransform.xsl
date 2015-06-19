<?xml version="1.0" encoding="ISO-8859-1" ?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:variable name="max-size" select="50"/>
<xsl:variable name="cols" select="count(ReportResults/ReportResultsParameters/ColumnHeadings/ColumnHeader)"/>
<xsl:variable name="group-totals" select="count(ReportResults/ReportResultsParameters/ColumnDetails/RowGroup/RowGroupTotal/@total) &gt; 0"/>
<xsl:variable name="num-rows" select="number(ReportResults/ReportResultsParameters/ColumnDetails/@size)"/>

	<!-- The page template -->
	<xsl:template match="ReportResults">
		<!-- Show the name, date, and report tables -->
		<div>


	<div class="HeaderAttached">
		<div class="Left"><b><xsl:apply-templates select="ReportResultsName"/></b></div>
		<div class="Left">
		<xsl:variable name="rptType"><xsl:value-of select="ReportResultsParameters/ReportType"/></xsl:variable>
		<xsl:variable name="active"><xsl:value-of select="ReportResultsName/@active"/></xsl:variable>
		<xsl:if test="$rptType = '1'">
			Rule evaluates to: 
			<xsl:if test="$num-rows &gt; 0">
				<b>True</b>
			</xsl:if>						
			<xsl:if test="$num-rows = 0">
				<b>False</b>
			</xsl:if>
			Rule is
			<xsl:if test="$active = 'true'">
				<b>Active</b>
			</xsl:if>
			<xsl:if test="$active != 'true'">
				<b>Disabled</b>
			</xsl:if>
		</xsl:if>			
		</div>
		<div class="Right"><xsl:apply-templates select="ReportResultsDate"/></div>
	</div>


		<xsl:apply-templates select="ReportResultsParameters"/>
		</div>
	</xsl:template>

	<!-- Show the report name -->
	<xsl:template match="ReportResultsName">
		<xsl:value-of select="."/>
	</xsl:template>

	<!-- Show the report date -->
	<xsl:template match="ReportResultsDate">
		<xsl:value-of select="."/>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="FilteringFields">
		&#xA0;<xsl:value-of select="@FilterType"/>&#xA0;
		<xsl:apply-templates select="FilteringField"/>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="FilteringField">
			<li>&#xA0;<xsl:value-of select="@name"/>&#xA0;<xsl:value-of select="@type"/>&#xA0;<xsl:value-of select="@value"/></li>
	</xsl:template>

	<!-- Show the ag op criteria -->
	<xsl:template match="AgOpFields">
		&#xA0;<xsl:value-of select="@FilterType"/>&#xA0;
		<xsl:apply-templates select="AgOpField"/>
	</xsl:template>

	<!-- Show the ag op criteria -->
	<xsl:template match="AgOpField">
			<li>&#xA0;<xsl:value-of select="@agOp"/>&#xA0;<xsl:value-of select="@name"/>&#xA0;<xsl:value-of select="@type"/>&#xA0;<xsl:value-of select="@value"/></li><br/>
	</xsl:template>
		
	<xsl:template match="GroupSummary">
		<xsl:variable name="incSummaryCount"><xsl:value-of select="../../ReportResultsOptions/IncSummaryCount"/></xsl:variable>		
		<tr>
			<td><xsl:value-of select="@name"/></td>
			<xsl:if test="$incSummaryCount = 'true'">
				<td><xsl:value-of select="@count"/></td>
			</xsl:if>	
			<xsl:apply-templates select="GroupValue"/>
		</tr>
	</xsl:template>
	
	<xsl:template match="GroupValue">
		<xsl:variable name="pos" select="number(@position) +1"/>
		<xsl:variable name="value" select="."/>
		<td><div>
		<xsl:attribute name="align">right</xsl:attribute>			
		<xsl:call-template name="formatTotal">
			<xsl:with-param name="pos" select="$pos"/>
			<xsl:with-param name="value" select="$value"/>
		</xsl:call-template>			
		</div></td>
	</xsl:template>
		
	<xsl:template match="ReportResultsOptions">
		<xsl:variable name="incSummaryCount"><xsl:value-of select="IncSummaryCount"/></xsl:variable>
		<xsl:variable name="incSummaryTotals"><xsl:value-of select="IncSummaryCalcs"/></xsl:variable>
		<xsl:variable name="incSummaryAvgs"><xsl:value-of select="IncSummaryAvgs"/></xsl:variable>
		<xsl:variable name="totalCount"><xsl:value-of select="../ColumnDetails/@size"/></xsl:variable>
		<xsl:if test="$incSummaryCount = 'true' or $incSummaryTotals = 'true'  or $incSummaryAvgs = 'true'">
			<div class="HeaderAttached">
				<div class="Left">Report Summary</div>
			</div>
			
			<fieldset>
			<table class="SortTable" id="StatTable" cellpadding="0" cellspacing="0">
				<thead>
				<tr class="TableHeader">
				<!-- create summary table headers -->
				<th><div>Grouped Value</div></th>
				<xsl:if test="$incSummaryCount = 'true'">
					<th><div>Count</div></th>
				</xsl:if>

				<xsl:for-each select="../ColumnHeadings/ColumnHeader">
					<xsl:if test="@reporttotal">
						<xsl:if test="$incSummaryTotals = 'true' ">
						<th align="right"><div><xsl:value-of select="."/> - Total</div></th>
						</xsl:if>
						<xsl:if test="$incSummaryAvgs = 'true' ">	
						<th align="right"><div><xsl:value-of select="."/> - Average</div></th>
						</xsl:if>
					</xsl:if>
				</xsl:for-each>					

				<xsl:apply-templates select="../ReportSummary/GroupSummary"/>
				
				<!-- create summary table detail -->
<!--				<xsl:for-each select="../ColumnDetails/RowGroup">
					<xsl:variable name="groupValue"><xsl:value-of select="@value"/></xsl:variable>
					<xsl:if test="$groupValue != ''">
						<tr>
							<td><div><xsl:value-of select="@value"/></div></td>
							<xsl:if test="$incSummaryCount = 'true'">						
								<xsl:variable name="rowsInGroup" select="count(ColumnRow)"></xsl:variable>
								<td><div><xsl:value-of select="$rowsInGroup"/></div></td>
							</xsl:if>
							<xsl:if test="$incSummaryTotals = 'true' or $incSummaryAvgs = 'true'">										
								<xsl:apply-templates select="RowGroupTotal" mode="sumTable"/>
							</xsl:if>
						</tr>
					</xsl:if>						
				</xsl:for-each>-->
				<!-- create summary table totals -->
				</tr>
				</thead>
				<tbody>
				<tr>
					<td><b>Total</b></td>
					<xsl:if test="$incSummaryCount = 'true'">					
						<td><b><xsl:value-of select="$totalCount"/></b></td>
					</xsl:if>

					<xsl:for-each select="../ColumnHeadings/ColumnHeader">
						<xsl:if test="@reporttotal != '' and $incSummaryTotals = 'true'">
							<xsl:if test="@type = 'currency'">
								<td align="right"><b><xsl:value-of select="@reporttotal"/><br/></b></td>
							</xsl:if>
							<xsl:if test="@type = 'Int'">
								<td align="right"><b><xsl:value-of select="@reporttotal"/><br/></b></td>
							</xsl:if>
							<xsl:if test="@type = 'Double'">
								<td align="right"><b><xsl:value-of select="@reporttotal"/><br/></b></td>
							</xsl:if>						
						</xsl:if>
						<xsl:if test="@reportaverage != '' and $incSummaryAvgs = 'true'">
							<xsl:if test="@type = 'currency'">
								<td align="right"><b><xsl:value-of select="@reportaverage"/><br/></b></td>
							</xsl:if>
							<xsl:if test="@type = 'Int'">
								<td align="right"><b><xsl:value-of select="@reportaverage"/><br/></b></td>
							</xsl:if>
							<xsl:if test="@type = 'Double'">
								<td align="right"><b><xsl:value-of select="@reportaverage"/><br/></b></td>
							</xsl:if>						
						</xsl:if>
					</xsl:for-each>	

				</tr>
				</tbody>
			</table>
			</fieldset>
				
		</xsl:if>

	</xsl:template>	
	
	<!-- The report tables template -->
	<xsl:template match="ReportResultsParameters">
		<xsl:variable name="incLineItemDetails"><xsl:value-of select="ReportResultsOptions/LineItemDetails"/></xsl:variable>

		<xsl:if test="count(FilteringFields/FilteringField) &gt; 0">
			<td valign="top">
				<fieldset>
				<legend>&#xA0;Filtering&#xA0;Criteria&#xA0;</legend>
					<xsl:apply-templates select="FilteringFields"/>
				</fieldset>
			</td>
		</xsl:if>
		<xsl:if test="count(AgOpFields/AgOpField) &gt; 0">
			<td valign="top">
				<fieldset>
				<legend>&#xA0;Aggregate&#xA0;Operator&#xA0;Criteria&#xA0;</legend>
					<xsl:apply-templates select="AgOpFields"/>
				</fieldset>
			</td>
		</xsl:if>		
		<xsl:if test="count(FilteringFields/FilteringField) &gt; 0 and count(ColumnHeadings/ColumnHeader/@total) &gt; 0">
			<td><img src="/pix/bump.gif" width="10" height="1"/></td>
		</xsl:if>


		<xsl:apply-templates select="ReportResultsOptions"/>
		
		<xsl:if test="$incLineItemDetails = 'true'">					
			<xsl:apply-templates select="ColumnDetails"/>
		</xsl:if>						
	</xsl:template>

	<xsl:template match="ColumnDetails">
		
			<fieldset>
				<table class="SortTable" id="StatTable" cellpadding="0" cellspacing="0">
					<xsl:apply-templates select="RowGroup"/>
				</table>
			</fieldset>
		
	</xsl:template>

	<xsl:template match="RowGroup">
		<xsl:if test="ColumnRow">
			<xsl:if test="@value">
				<tr class="TableHeader">
				<th>
				<xsl:attribute name="colspan"><xsl:value-of select="count(../../ColumnHeadings/ColumnHeader[@ignore!='true']) + 1"/></xsl:attribute>
				<div><b><xsl:value-of select="@value"/></b></div>
				</th>
				</tr>
			</xsl:if>
			<!-- Show the column headings -->
			<xsl:apply-templates select="../../ColumnHeadings">
				<xsl:with-param name="grouped" select="@value"/>
			</xsl:apply-templates>
			<xsl:apply-templates select="ColumnRow"/>
			<xsl:if test="count(RowGroupTotal/@total) &gt; 0">
				<tr>
				<td>&#xA0;</td>
				<xsl:apply-templates select="RowGroupTotal" mode="sum">
					<xsl:with-param name="display" select="'Sum:'"/>
				</xsl:apply-templates>
				</tr>
			</xsl:if>
			<xsl:if test="count(RowGroupTotal/@percentage) &gt; 0">
				<tr>
				<td>&#xA0;</td>
				<xsl:apply-templates select="RowGroupTotal" mode="percent"/>
				</tr>
			</xsl:if>
		</xsl:if>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="summaryTableHeader">
		<xsl:param name="display"/>		
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency'">
				<xsl:attribute name="align">right</xsl:attribute>
			</xsl:if>
			<xsl:if test="normalize-space(@total) = ''">&#xA0;</xsl:if>
				
			<th>Total</th>
		</xsl:if>
	</xsl:template>		
	
	<xsl:template match="RowGroupTotal" mode="sum">
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<td>
			<xsl:if test="normalize-space(@total) = '' ">&#xA0;</xsl:if>
			<xsl:if test="@total != ''">
				<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency'">
					<xsl:attribute name="align">right</xsl:attribute>
				</xsl:if>
			
				<xsl:call-template name="formatTotal">
					<xsl:with-param name="pos" select="$pos"/>
					<xsl:with-param name="value" select="@total"/>
				</xsl:call-template>
			</xsl:if>
			</td>
		</xsl:if>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="sumTable">
		<xsl:param name="display"/>
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">

				<xsl:if test="normalize-space(@total) = ''  and $display !='' ">&#xA0;</xsl:if>
				<xsl:if test="@total != ''">
					<td>
					<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency'">
						<xsl:attribute name="align">right</xsl:attribute>
					</xsl:if>
					
					<xsl:value-of select="$display"/> 
					<xsl:call-template name="formatTotal">
						<xsl:with-param name="pos" select="$pos"/>
						<xsl:with-param name="value" select="@total"/>
					</xsl:call-template>
					</td>
				</xsl:if>			
				<xsl:if test="@average != ''">			
					<td>
					<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency'">
						<xsl:attribute name="align">right</xsl:attribute>
					</xsl:if>
						
					<xsl:call-template name="formatTotal">
						<xsl:with-param name="pos" select="$pos"/>
						<xsl:with-param name="value" select="@average"/>
					</xsl:call-template>
					</td>					
					
				</xsl:if>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="formatTotal">
		<xsl:param name="pos"/>
		<xsl:param name="value"/>
		<xsl:if test="$value = ''">
			<xsl:text>&#xa0;</xsl:text>
		</xsl:if>
		<xsl:if test="$value != ''">
			<xsl:value-of select="$value"/>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="RowGroupTotal" mode="percent">
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
		<td>
			<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency'">
				<xsl:attribute name="align">right</xsl:attribute>
			</xsl:if>
			<xsl:if test="normalize-space(@percentage) = ''">&#xA0;</xsl:if>
			<xsl:if test="@percentage != ''">
				<xsl:value-of select="format-number(@percentage,'0.00')"/>% of Total
			</xsl:if>
		</td>

		</xsl:if>
	</xsl:template>

	<!-- The column headings template -->
	<xsl:template match="ColumnHeadings">
		<xsl:param name="grouped"/>
		<tr class="TableHeader">
		<th><div>
			<xsl:text>View</xsl:text>
		</div></th>
		<xsl:apply-templates select="ColumnHeader">
			<xsl:with-param name="grouped" select="$grouped"/>
		</xsl:apply-templates>
		</tr>
	</xsl:template>

	<!-- The column header template -->
	<xsl:template match="ColumnHeader">
		<xsl:param name="grouped"/>
		<xsl:variable name="col-pos" select="position()"/>
		<xsl:if test="@ignore != 'true'">
		<th><div>
 			<xsl:if test="@type = 'currency'">
 				<xsl:attribute name="align">right</xsl:attribute>
		<!-- commenting out graph link for now --> 				
		<!--	<xsl:if test="$group-totals and ../../ColumnHeadings/ColumnHeader[$col-pos]/@reporttotal and count(../../ColumnDetails/RowGroup/ColumnRow) &gt; 0 and ../../ColumnDetails/RowGroup/@value and ../../ColumnHeadings/ColumnHeader[$col-pos]/@total = 'true'">
					<a onmouseover="return !showPopup('graphPopup', event);" onmouseout="hideCurrentPopup(); return false;"><xsl:attribute name="href">JavaScript:graphLink('<xsl:value-of select="."/>');</xsl:attribute><img src="/pix/meta/graph.gif" width="16" height="15" border="0" align="absmiddle"/></a>&#xA0;
	 			</xsl:if> -->
 			</xsl:if>
			<a><xsl:attribute name="href">JavaScript:sortBy('<xsl:value-of select="@name"/>');</xsl:attribute><xsl:value-of select="."/></a>
		</div></th>
		</xsl:if>
	</xsl:template>

	<!-- The data row template -->
	<xsl:template match="ColumnRow" xmlns:encoder="xalan://java.net.URLEncoder">
		<tr>
		<!-- // START CHANGES - SUlonetskiy, 17/11/2010 - ACC: QB-18471 -->
		<!-- // DELETED -->
			<!-- <td> -->
		<!-- // ADDED -->
			<td align="center" width="1">
		<!-- // END CHANGES -->
		<a>
		<xsl:attribute name="href">JavaScript:scheduleLink('<xsl:value-of select="encoder:encode(string(ColumnDetail[$cols]))"/>');</xsl:attribute><img src="/pix/meta/view_sm.gif" width="17" height="17" border="0"/></a>
		</td>
		<xsl:apply-templates select="ColumnDetail"/>
		</tr>
	</xsl:template>

	<!-- The data cell template -->
	<xsl:template match="ColumnDetail">
		<!-- The column number of the current cell -->
		<xsl:variable name="pos" select="number(position())"/>
		<!-- The respective column's ignore flag is not true -->
		<xsl:if test="../../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
		<td>
			<xsl:if test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency'">
				<xsl:attribute name="align">right</xsl:attribute>
			</xsl:if>
			<xsl:if test="normalize-space(.) = ''">&#xA0;</xsl:if>
			<xsl:choose>
				<!-- US$ Format ($1,000,000.00) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency' and string(number(.)) != 'NaN'">
					<xsl:value-of select="format-number(.,'#,##0.00')"/>
				</xsl:when>
				<!-- Int Format (1,000) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int' and (contains(../../../../ColumnHeadings/ColumnHeader[$pos]/@name, 'rackingNum')) and string(number(.)) != 'NaN'">
					<xsl:value-of select="format-number(.,'###0')"/>
				</xsl:when>				
				<!-- Int Format (1,000) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int' and not(contains(../../../../ColumnHeadings/ColumnHeader[$pos]/@name, 'rackingNum')) and string(number(.)) != 'NaN'">
					<xsl:value-of select="format-number(.,'#,##0')"/>
				</xsl:when>				
				<!-- Percent Format (7.50%) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Percent' and string(number(.)) != 'NaN'">
					<xsl:value-of select="format-number(.,'0.00')"/><xsl:text>%</xsl:text>
				</xsl:when>
				<!-- Month Year Format (02/2003) -->
				<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'MonthYear' and string-length(normalize-space(.)) > 5">
					<xsl:value-of select="substring(.,5,2)"/>/<xsl:value-of select="substring(.,1,4)"/>
				</xsl:when>
				<!-- Truncated Format -->
				<xsl:when test="string-length(.) > $max-size">
					<xsl:value-of select="substring(.,0,$max-size)"/>
					<xsl:text> ... </xsl:text>
					<a>
					<xsl:attribute name="href">JavaScript:scheduleLink('<xsl:value-of select="../ColumnDetail[$cols]"/>');</xsl:attribute>(more)</a>
				</xsl:when>
				<!-- Text Format () -->
				<xsl:otherwise>
					<xsl:value-of select="."/>
				</xsl:otherwise>
			</xsl:choose>
		</td>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>
