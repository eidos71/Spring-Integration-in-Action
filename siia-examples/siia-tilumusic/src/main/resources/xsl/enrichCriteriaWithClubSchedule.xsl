<!-- * Copyright 2012 the original author or authors. * * Licensed under 
	the Apache License, Version 2.0 (the "License"); * you may not use this file 
	except in compliance with the License. * You may obtain a copy of the License 
	at * * http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by 
	applicable law or agreed to in writing, software * distributed under the 
	License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS 
	OF ANY KIND, either express or implied. * See the License for the specific 
	language governing permissions and * limitations under the License. -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/clubCalendar">
	<root xmlns:cs="http://www.example.org/siia/club-schedule">
			<xsl:for-each select="list-djstream/node()">
			<cs:clubCalendar>
				<cs:calendarStream>
					<djStream>
						<xsl:copy-of select="@djEventNumber"></xsl:copy-of>
					</djStream>	
					<date>
						<xsl:copy-of select="/clubCalendar/startingCalendarSchedule/node()" />
					</date>
					<streamURL>
						<xsl:copy-of select="@streamUrl"></xsl:copy-of>
					</streamURL>
				</cs:calendarStream>
				<cs:faceBookCalendar>
					<djStream>
						<xsl:copy-of select="@djEventNumber"></xsl:copy-of>
					</djStream>
					<date>
						<xsl:copy-of select="/clubCalendar/startingCalendarSchedule/node()" />
					</date>
					<streamURL>
						<xsl:copy-of select="@facebookpost"></xsl:copy-of>
					</streamURL>
				</cs:faceBookCalendar>
				<cs:TwitterCalendar>
					<djStream>
						<xsl:copy-of select="@djEventNumber"></xsl:copy-of>
					</djStream>
					<date>
						<xsl:copy-of select="/clubCalendar/startingCalendarSchedule/node()" />
					</date>
					<streamURL>
						<xsl:copy-of select="@twitterAccount"></xsl:copy-of>
					</streamURL>
				</cs:TwitterCalendar>

			</cs:clubCalendar>
			</xsl:for-each>
		</root>
	</xsl:template>
</xsl:stylesheet>
