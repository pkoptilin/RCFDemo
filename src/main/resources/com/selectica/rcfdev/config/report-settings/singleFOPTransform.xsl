<?xml version="1.0" encoding="ISO-8859-1"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:output method="xml" indent="no" encoding="UTF-8"/>

<!-- Determine the total width -->
<xsl:variable name="total-width">
	<xsl:call-template name="sum-of-widths">
		<xsl:with-param name="columns" select="ReportResults/ReportResultsParameters/ColumnHeadings/ColumnHeader[@ignore != 'true']"/>
	</xsl:call-template>
</xsl:variable>
<!-- Determine the font size -->
<xsl:variable name="calculated-font-size" select="round(12 - ($total-width * .025))"/>
<xsl:variable name="font-size">
	<xsl:choose>
		<xsl:when test="$calculated-font-size > 3">
			<xsl:value-of select="$calculated-font-size"/>
		</xsl:when>
		<xsl:otherwise>3</xsl:otherwise>
	</xsl:choose>
</xsl:variable>

<!-- Set the filePath param; needed for rollback to xalan 1.2 -->
<xsl:param name="filePath" select="'default value'"/> 
<xsl:param name="headerPath" select="'default value'"/> 

	<!-- The page template -->
	<xsl:template match="ReportResults">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="smreport" 
						page-height="8.5in" 
						page-width="11in" 
						margin-top="0.5in" 
						margin-bottom="0.5in" 
						margin-left="0.5in" 
						margin-right="0.5in">
					<fo:region-body margin-top="1.05in" margin-bottom="1.0in"/>
					<fo:region-before extent="1.05in"/>
					<fo:region-after extent="0.5in"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-name="smreport" master-reference="smreport" white-space-collapse="false">
				<fo:static-content flow-name="xsl-region-before">
					<xsl:if test="$headerPath">
						<fo:block><fo:external-graphic src="url('{$headerPath}')" content-width="720px" content-height="52px"/></fo:block>
					</xsl:if>
					<fo:table>
						<fo:table-column column-width="5in" padding-left="2pt" padding-right="2pt"/>
						<fo:table-column column-width="5in" padding-left="2pt" padding-right="2pt"/>
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<xsl:apply-templates select="ReportResultsName"/>
								</fo:table-cell>
								<fo:table-cell>
									<xsl:apply-templates select="ReportResultsDate"/>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
				</fo:static-content>
				<fo:static-content flow-name="xsl-region-after">
					<fo:block text-align="end" font-style="italic"><xsl:attribute name="font-size"><xsl:value-of select="$font-size"/>pt</xsl:attribute><xsl:value-of select="ReportStaticText/PageText/@value"/> <fo:page-number/> <xsl:value-of select="ReportStaticText/PageOfText/@value"/> <fo:page-number-citation ref-id="endofdoc"/></fo:block>
				</fo:static-content> 
				<fo:flow flow-name="xsl-region-body" text-align="start" font-family="arialuni"><xsl:attribute name="font-size"><xsl:value-of select="$font-size"/>pt</xsl:attribute>
					<!-- Show the report table -->
					<xsl:apply-templates select="ReportResultsParameters"/>
					<fo:block id="endofdoc"></fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>  
	</xsl:template>

	<!-- Calculate the sum of column widths -->
	<xsl:template name="sum-of-widths">
		<xsl:param name="columns"/>
		<xsl:choose>
			<xsl:when test="$columns">
				<xsl:variable name="first">
					<xsl:call-template name="get-width">
						<xsl:with-param name="column" select="$columns[1]"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:variable name="rest">
					<xsl:call-template name="sum-of-widths">
						<xsl:with-param name="columns" select="$columns[position()!=1]"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:value-of select="$first + $rest"/>
			</xsl:when>
			<xsl:otherwise>0</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- Look up widths for various columns -->
	<xsl:template name="get-width">
		<xsl:param name="column"/>
		<xsl:choose>
			<xsl:when test="$column = 'Lessor'">28</xsl:when>
			<xsl:when test="$column = 'Schedule #'">16</xsl:when>
			<xsl:when test="$column = 'Schedule ID'">25</xsl:when>
			<xsl:when test="$column = 'Master Lease #'">16</xsl:when>
			<xsl:when test="$column = 'Asset Type'">24</xsl:when>
			<xsl:when test="$column = 'Dept. Code'">12</xsl:when>
			<xsl:when test="$column = 'Location'">16</xsl:when>
			<xsl:when test="$column = 'Start Date'">10</xsl:when>
			<xsl:when test="$column = 'End Date'">10</xsl:when>
			<xsl:when test="$column = 'Term'">6</xsl:when>
			<xsl:when test="$column = 'OEC'">20</xsl:when>
			<xsl:when test="$column = 'Payment'">20</xsl:when>
			<xsl:when test="$column = 'Schedule Comments'">32</xsl:when>
			<xsl:when test="$column = 'Option Type'">16</xsl:when>
			<xsl:when test="$column = 'Exercise Date'">10</xsl:when>
			<xsl:when test="$column = 'Notification Date'">10</xsl:when>
			<xsl:when test="$column = 'Reminder Comments'">32</xsl:when>
			<xsl:when test="$column = 'Delivery Cost'">28</xsl:when>
			<xsl:when test="$column = 'Equip. Cost Subtotal'">50</xsl:when>
			<xsl:when test="$column = 'Equip. Quantity'">12</xsl:when>
			<xsl:when test="$column = 'Equip. Description'">60</xsl:when>
			<xsl:when test="$column = 'Equip. Cost'">20</xsl:when>
			<xsl:when test="$column = 'Equip. Dept. Code'">16</xsl:when>
			<xsl:when test="$column = 'Equip. City'">16</xsl:when>
			<xsl:when test="$column = 'Equip. State'">6</xsl:when>
			<xsl:when test="$column = 'Equip. County'">16</xsl:when>
			<xsl:when test="$column = 'Reference #'">16</xsl:when>
			<xsl:when test="$column = 'Serial #'">16</xsl:when>
			<xsl:when test="$column = 'Invoice #'">16</xsl:when>
			<xsl:when test="$column = 'Equip. Comments'">32</xsl:when>
			<xsl:when test="$column = 'Reminder Recipient(s)'">32</xsl:when>
			<xsl:when test="$column = 'Project Name'">24</xsl:when>
			<xsl:otherwise>16</xsl:otherwise>
		</xsl:choose>		
	</xsl:template>

	<!-- Show the report name -->
	<xsl:template match="ReportResultsName">
		<fo:block text-align="start" font-style="italic" color="#003366"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 4"/>pt</xsl:attribute>
			<xsl:value-of select="."/>
		</fo:block>
	</xsl:template>

	<!-- Show the report date -->
	<xsl:template match="ReportResultsDate">
		<fo:block text-align="end" font-style="italic" color="#003366"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 4"/>pt</xsl:attribute>
			<xsl:text></xsl:text>
			<xsl:value-of select="."/>
		</fo:block>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="FilteringFields">
		<fo:block text-align="start"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute><xsl:value-of select="@FilterType"/>&#xA0;</fo:block>
		<xsl:apply-templates/>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="FilteringField">
		<xsl:if test="@name != ''">
			<fo:block text-align="start"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute>- <xsl:value-of select="@name"/>&#xA0;<xsl:value-of select="@type"/>&#xA0;<xsl:value-of select="@value"/></fo:block>
		</xsl:if>		
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="AgOpFields">
		<fo:block text-align="start"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute><xsl:value-of select="@FilterType"/>&#xA0;</fo:block>
		<xsl:apply-templates/>
	</xsl:template>

	<!-- Show the report criteria -->
	<xsl:template match="AgOpField">
		<xsl:if test="@value != ''">
			<fo:block text-align="start"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute>- <xsl:value-of select="@agOp"/>&#xA0;<xsl:value-of select="@name"/>&#xA0;<xsl:value-of select="@type"/>&#xA0;<xsl:value-of select="@value"/></fo:block>
		</xsl:if>		
	</xsl:template>






	<xsl:template match="ReportResultsOptions">
		<xsl:variable name="incSummaryCount"><xsl:value-of select="IncSummaryCount"/></xsl:variable>
		<xsl:variable name="incSummaryTotals"><xsl:value-of select="IncSummaryCalcs"/></xsl:variable>
		<xsl:variable name="incSummaryAvgs"><xsl:value-of select="IncSummaryAvgs"/></xsl:variable>		
		<xsl:variable name="totalCount"><xsl:value-of select="../ColumnDetails/@size"/></xsl:variable>
		<xsl:if test="$incSummaryCount = 'true' or $incSummaryTotals = 'true' or $incSummaryAvgs = 'true'">
			<fo:table>
			<!-- make sure you allocate enough fo:table-columns or FOP gives weird array out of bounds errors-->	
			<fo:table-column column-width="2in"/>
			<fo:table-column column-width="1in"/>

			<xsl:for-each select="../ColumnHeadings/ColumnHeader">
				<xsl:if test="@reporttotal">
					<xsl:if test="$incSummaryTotals = 'true'">									
						<fo:table-column column-width="2in"/>
					</xsl:if>
					<xsl:if test="$incSummaryAvgs = 'true'">									
						<fo:table-column column-width="2in"/>
					</xsl:if>
				</xsl:if>
			</xsl:for-each>					

			
			<fo:table-body>
				
				<fo:table-row>
					<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold"><xsl:value-of select="../../ReportStaticText/ReportSummaryText/@value"/></fo:block></fo:table-cell>
                    <xsl:for-each select="../ColumnHeadings/ColumnHeader">
                        <xsl:if test="@reporttotal">
                            <xsl:if test="$incSummaryTotals = 'true' ">
                                <fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block></fo:block></fo:table-cell>
                            </xsl:if>
                            <xsl:if test="$incSummaryAvgs = 'true' ">
                                <fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block></fo:block></fo:table-cell>
                            </xsl:if>
                        </xsl:if>
                    </xsl:for-each>
				</fo:table-row>
			<!-- create summary table headers -->			
				<fo:table-row>
					<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold"><xsl:value-of select="../../ReportStaticText/GroupedValueText/@value"/></fo:block></fo:table-cell>
				<xsl:if test="$incSummaryCount = 'true'">
					<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold">Count</fo:block></fo:table-cell>
				</xsl:if>

				<xsl:for-each select="../ColumnHeadings/ColumnHeader">
					<xsl:if test="@reporttotal">
						<xsl:if test="$incSummaryTotals = 'true' ">
							<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold"><xsl:value-of select="."/> - Total<xsl:value-of select="../../ReportStaticText/TotalText/@value"/></fo:block></fo:table-cell>
						</xsl:if>	
						<xsl:if test="$incSummaryAvgs = 'true' ">
							<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold"><xsl:value-of select="."/> - Average<xsl:value-of select="../../ReportStaticText/AverageText/@value"/></fo:block></fo:table-cell>								
						</xsl:if>	
					</xsl:if>
				</xsl:for-each>					

				</fo:table-row>
					
				<!-- create summary table detail -->
				<xsl:for-each select="../ReportSummary/GroupSummary">
					<xsl:variable name="pos1" select="number(position())"/>				
					<xsl:variable name="groupName"><xsl:value-of select="@name"/></xsl:variable>
					<xsl:if test="$groupName != ''">
					<fo:table-row>
						<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block><xsl:value-of select="@name"/></fo:block></fo:table-cell>
						<xsl:if test="$incSummaryCount = 'true'">						
							<xsl:variable name="rowsInGroup"><xsl:value-of select="@count"/></xsl:variable>
							<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block><xsl:value-of select="$rowsInGroup"/></fo:block></fo:table-cell>
						</xsl:if>
				<xsl:for-each select="GroupValue">
					<xsl:variable name="pos2" select="number(position())"/>				
						<xsl:if test="$incSummaryTotals = 'true' or $incSummaryAvgs = 'true'">				
							<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block><xsl:value-of select="."/></fo:block></fo:table-cell>
						</xsl:if>
				</xsl:for-each>
					</fo:table-row>
					</xsl:if>	
				</xsl:for-each>


				<!-- create summary table totals -->
				<fo:table-row>
					<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold">Total</fo:block></fo:table-cell>
					<xsl:if test="$incSummaryCount = 'true'">					
						<fo:table-cell padding-left="2pt" padding-right="2pt"><fo:block  font-weight="bold"><xsl:value-of select="$totalCount"/></fo:block></fo:table-cell>
					</xsl:if>

					<xsl:for-each select="../ColumnHeadings/ColumnHeader">
						<xsl:if test="@reporttotal and $incSummaryTotals = 'true'">
							<xsl:if test="@type = 'currency'">
								<fo:table-cell><fo:block  font-weight="bold"><xsl:value-of select="@reporttotal"/></fo:block></fo:table-cell>
							</xsl:if>
							<xsl:if test="@type = 'Int'">
								<fo:table-cell><fo:block  font-weight="bold"><xsl:value-of select="@reporttotal"/></fo:block></fo:table-cell>
							</xsl:if>
							<xsl:if test="@type = 'Double'">
								<fo:table-cell><fo:block  font-weight="bold"><xsl:value-of select="@reporttotal"/></fo:block></fo:table-cell>
							</xsl:if>	
						</xsl:if>
						<xsl:if test="@reporttotal and $incSummaryAvgs = 'true'">
							<xsl:if test="@type = 'currency'">
								<fo:table-cell><fo:block  font-weight="bold"><xsl:value-of select="@reportaverage"/></fo:block></fo:table-cell>
							</xsl:if>
							<xsl:if test="@type = 'Int'">
								<fo:table-cell><fo:block  font-weight="bold"><xsl:value-of select="@reportaverage"/></fo:block></fo:table-cell>
							</xsl:if>
							<xsl:if test="@type = 'Double'">
								<fo:table-cell><fo:block  font-weight="bold"><xsl:value-of select="@reportaverage"/></fo:block></fo:table-cell>
							</xsl:if>	
						</xsl:if>								
					</xsl:for-each>	

				</fo:table-row>	
				</fo:table-body>
			</fo:table>					
		</xsl:if>
	</xsl:template>	

	<!-- The report tables template -->
	<xsl:template match="ReportResultsParameters">
		<xsl:variable name="has-filter" select="count(FilteringFields/FilteringField[@name != '']) &gt; 0"/>
		<xsl:variable name="has-agOp" select="count(AgOpFields/AgOpField[@name != '']) &gt; 0"/>		
		<xsl:variable name="has-totals" select="count(ColumnHeadings/ColumnHeader/@reporttotal) &gt; 0"/>
		<xsl:variable name="incLineItemDetails"><xsl:value-of select="ReportResultsOptions/LineItemDetails"/></xsl:variable>
		<xsl:if test="$has-filter or $has-totals">
			<fo:table>
				<xsl:choose>
					<xsl:when test="$has-filter and $has-totals">
						<fo:table-column column-width="4.5in"/>
						<fo:table-column column-width="1in"/>
						<!--<fo:table-column column-width="4.5in"/>-->
					</xsl:when>
					<xsl:otherwise>
						<fo:table-column column-width="10in"/>
					</xsl:otherwise>
				</xsl:choose>
				<fo:table-body>
					<fo:table-row>
						<xsl:if test="$has-filter">
							<fo:table-cell padding-left="2pt" padding-right="2pt">
								<fo:block text-align="start" font-weight="bold"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute><xsl:value-of select="../ReportStaticText/FilterText/@value"/></fo:block>
								<xsl:apply-templates select="FilteringFields"/>
							</fo:table-cell>
						</xsl:if>
						<xsl:if test="$has-filter and $has-totals">
							<fo:table-cell/>
						</xsl:if>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</xsl:if>
		
		<xsl:if test="$has-agOp">
				<fo:table>
					<fo:table-column column-width="10in"/>
					<fo:table-body>
						<fo:table-row>
							<xsl:if test="$has-agOp">
								<fo:table-cell padding-left="2pt" padding-right="2pt">
									<fo:block text-align="start" font-weight="bold"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute><xsl:value-of select="../ReportStaticText/AggregateOpText/@value"/></fo:block>
									<xsl:apply-templates select="AgOpFields"/>
								</fo:table-cell>
							</xsl:if>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
		</xsl:if>
		
		<xsl:apply-templates select="ReportResultsOptions"/>
		
		<fo:block>&#xA0;</fo:block>
		<fo:block>&#xA0;</fo:block>
		<xsl:if test="$incLineItemDetails = 'true' and ColumnDetails/@size &gt; 0">
			<xsl:apply-templates select="ColumnDetails"/>
		</xsl:if>
	</xsl:template>

	<xsl:template match="ColumnDetails">
		<xsl:apply-templates select="RowGroup"/>
	</xsl:template>


	<xsl:template match="RowGroup">
		<xsl:if test="@value">
			<fo:block text-align="start" color="#009900"><xsl:attribute name="font-size"><xsl:value-of select="$font-size + 2"/>pt</xsl:attribute><xsl:value-of select="@value"/></fo:block>
		</xsl:if>
		<fo:table>
			<!-- Get & set the column widths -->
			<xsl:for-each select="../../ColumnHeadings/ColumnHeader">
				<!-- Don't check hidden columns -->
				<xsl:if test="@ignore != 'true'">
					<xsl:variable name="width">
						<!-- Get the width -->
						<xsl:call-template name="get-width">
							<xsl:with-param name="column" select="."/>
						</xsl:call-template>
					</xsl:variable>
					<!-- Set the width -->
					<fo:table-column><xsl:attribute name="column-width"><xsl:value-of select="($width div $total-width) * 10"/>in</xsl:attribute></fo:table-column>
				</xsl:if>
			</xsl:for-each>
			
			<!-- Show the column headings -->
			<xsl:apply-templates select="../../ColumnHeadings"/>
			
			<fo:table-body>
				<xsl:apply-templates select="ColumnRow"/>

				<xsl:if test="count(RowGroupTotal/@total) &gt; 0">
					<fo:table-row>
						<xsl:apply-templates select="RowGroupTotal" mode="sum">
							<xsl:with-param name="display" select="'Sum:'"/>
						</xsl:apply-templates>
					</fo:table-row>
				</xsl:if>
				<xsl:if test="count(RowGroupTotal/@percentage) &gt; 0">
					<fo:table-row>
						<xsl:apply-templates select="RowGroupTotal" mode="percent"/>
					</fo:table-row>
				</xsl:if>
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="summaryTableHeader">
		<xsl:param name="display"/>		
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<xsl:if test="normalize-space(@total) = ''">&#xA0;</xsl:if>
			
			<fo:table-column>Total</fo:table-column>
		</xsl:if>
	</xsl:template>	
	
	<xsl:template match="RowGroupTotal" mode="sum">
		<xsl:param name="display"/>
		<!-- The sum (formatted) -->
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<fo:table-cell padding-left="2pt" padding-right="2pt">
				<xsl:if test="@total">
					<fo:block text-align="end">
						<xsl:value-of select="$display"/> 
						<xsl:call-template name="formatTotal">
							<xsl:with-param name="pos" select="$pos"/>
							<xsl:with-param name="value" select="@total"/>
						</xsl:call-template>
					</fo:block>
				</xsl:if>
			</fo:table-cell>
		</xsl:if>
	</xsl:template>

	<xsl:template match="RowGroupTotal" mode="sumTable">
		<xsl:variable name="pos" select="number(position())"/>
		<xsl:if test="../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			
			<xsl:if test="normalize-space(@total) = '' ">&#xA0;</xsl:if>
			<xsl:if test="@total != ''">
				<fo:table-cell padding-left="2pt" padding-right="2pt">
				<fo:block>
					<xsl:call-template name="formatTotal">
						<xsl:with-param name="pos" select="$pos"/>
						<xsl:with-param name="value" select="@total"/>						
					</xsl:call-template>
				</fo:block>
				</fo:table-cell>
			</xsl:if>
			<xsl:if test="@average != ''">
				<fo:table-cell padding-left="2pt" padding-right="2pt">
					<fo:block>
						<xsl:call-template name="formatTotal">
							<xsl:with-param name="pos" select="$pos"/>
							<xsl:with-param name="value" select="@average"/>							
						</xsl:call-template>
					</fo:block>
				</fo:table-cell>
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
			<fo:table-cell padding-left="2pt" padding-right="2pt">
				<xsl:if test="@percentage">
					<fo:block text-align="end">
						<xsl:value-of select="format-number(@percentage div 100,'#0.0%')"/> of Total
					</fo:block>
				</xsl:if>
			</fo:table-cell>
		</xsl:if>
	</xsl:template>

	<!-- The column headings template -->
	<xsl:template match="ColumnHeadings">
		<fo:table-header>
			<fo:table-row>
				<xsl:apply-templates select="ColumnHeader"/>
			</fo:table-row>
		</fo:table-header>
	</xsl:template>

	<!-- The column header template -->
	<xsl:template match="ColumnHeader">
		<xsl:if test="@ignore != 'true'">
			<fo:table-cell padding-left="2pt" padding-right="2pt">
				<fo:block font-weight="bold">
					<xsl:if test="@type = 'currency' or @type = 'Int'">
						<xsl:attribute name="text-align">end</xsl:attribute>
					</xsl:if>
					<xsl:value-of select="."/>
				</fo:block>
			</fo:table-cell>
		</xsl:if>
	</xsl:template>

	<!-- The data row template -->
	<xsl:template match="ColumnRow">
		<fo:table-row>
			<xsl:apply-templates select="ColumnDetail"/>
		</fo:table-row>
	</xsl:template>

	<!-- The data cell template -->
	<xsl:template match="ColumnDetail">
		<!-- The column number of the current cell -->
		<xsl:variable name="pos" select="number(position())"/>
		<!-- The respective column's ignore flag is not true -->
		<xsl:if test="../../../../ColumnHeadings/ColumnHeader[$pos]/@ignore != 'true'">
			<fo:table-cell padding-left="2pt" padding-right="2pt">
				<fo:block>
					<xsl:if test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency' or ../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int'">
						<xsl:attribute name="text-align">end</xsl:attribute>
					</xsl:if>
					<xsl:choose>
						<!-- US$ Format ($1,000,000) -->
						<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'currency' and string(number(.)) != 'NaN'">
							<xsl:value-of select="."/>
						</xsl:when>
						<!-- Int Format (1,000) -->
						<xsl:when test="../../../../ColumnHeadings/ColumnHeader[$pos]/@type = 'Int' and contains(../../../../ColumnHeadings/ColumnHeader[$pos]/@name, 'rackingNum') and string(number(.)) != 'NaN'">
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
						<!-- Text Format () -->
						<xsl:otherwise>
							<xsl:value-of select="."/>
						</xsl:otherwise>
					</xsl:choose>
				</fo:block>
			</fo:table-cell>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>