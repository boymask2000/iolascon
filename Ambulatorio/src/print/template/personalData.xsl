<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:template match="personalData">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4"
					page-height="29.7cm" page-width="21cm" margin-top="2cm"
					margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="20pt">
						Personal Data
					</fo:block>
					<fo:block font-size="10pt">
						<fo:table table-layout="fixed" width="100%"
							border-collapse="separate">
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="5cm" />
							<fo:table-body>
								<xsl:apply-templates select="paziente" />
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="paziente">
		<fo:table-row>

			<fo:table-cell>
				<fo:block>
					First Name:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="name" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					Second Name:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="surname" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>
		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					familial degree:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="familial_degree" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					consanguinity:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="consanguinity" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					withdrawal:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="withdrawal" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					acceptance:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="acceptance" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					codeEthnicity:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="codeEthnicity" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					gender:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="gender" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					dob:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="dob" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					place of residence:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="place_of_residence" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					reference_doctor:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="reference_doctor" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					initial_clinical:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="initial_clinical" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>


		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					age_at_diagnosis:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="age_at_diagnosis" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>
		
		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					onset_symptoms:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="onset_symptoms" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>
		
		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					age_onset_symptoms:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="age_onset_symptoms" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

	</xsl:template>
</xsl:stylesheet>