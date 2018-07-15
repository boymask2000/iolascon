<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:template match="schedaPaziente">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4"
					page-height="29.7cm" page-width="21cm" margin-top="2cm"
					margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
				<fo:simple-page-master
					master-name="simpleA4Landscape" reference-orientation="90"
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
							<fo:table-column column-width="5cm" />
							
							<fo:table-body>
								<xsl:apply-templates select="paziente" />
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="20pt">
						Surgical Intervention
					</fo:block>
					<fo:block font-size="10pt">
						<fo:table table-layout="fixed" width="100%"
							border-collapse="separate">
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="4cm" />
							<fo:table-column column-width="5cm" />
							<fo:table-body>
								<xsl:apply-templates select="surgical" />
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>

			</fo:page-sequence>
			<fo:page-sequence
				master-reference="simpleA4Landscape">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="20pt">
						Hematologic Data
					</fo:block>
					<fo:block font-size="10pt">
						<fo:table table-layout="fixed" width="100%"
							border-collapse="separate">
							<fo:table-column column-width="3cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-header text-align="center"
								background-color="silver">
								<fo:table-row>
									<fo:table-cell padding="1mm" border-width="1mm"
										border-style="solid">
										<fo:block>Date</fo:block>
									</fo:table-cell>
									<fo:table-cell padding="1mm" border-width="1mm"
										border-style="solid">
										<fo:block>rcb</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-header>
							<fo:table-body>
								<xsl:apply-templates select="hematologic" />
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>

			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="hematologic">
		<fo:table-row>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="date" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="rcb" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="hb" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="ht" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="mcv" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="mchc" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="rdw" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="retics" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="wbc" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="plt" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="pdw" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="hba2" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="hbf" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="trasf_need" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="trasf_dep" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="n_life_trasf" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="g6pd_def" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

	</xsl:template>
	<xsl:template match="surgical">
		<fo:table-row>

			<fo:table-cell>
				<fo:block>
					Splenectomy YN:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="Splenectomy_YN" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
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

		<fo:table-row>
			<fo:table-cell>
				<fo:block>
					age_onset_symptoms:
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>


					<fo:external-graphic>
						<xsl:attribute name="src"><xsl:value-of
							select="encodedImage" /></xsl:attribute>
					</fo:external-graphic>

				</fo:block>
			</fo:table-cell>

		</fo:table-row>


	</xsl:template>
</xsl:stylesheet>