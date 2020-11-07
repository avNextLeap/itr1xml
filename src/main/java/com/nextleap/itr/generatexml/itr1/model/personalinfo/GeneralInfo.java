package com.nextleap.itr.generatexml.itr1.model.personalinfo;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.annotation.ITR1XMLMaping;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.seventhprovision139.SeventhProvisio139;
import com.nextleap.itr.utilities.ITRXMLLogger;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeneralInfo{

	ITRXMLLogger logger = ITRXMLLogger.getLogger(GeneralInfo.class);
	
	@ITR1XMLMaping(key="itr.itr1.personalInfo.pan")
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.assesseeName.firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.assesseeName.middleName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.assesseeName.surNameOrOrgName")
	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.aadhaarCardNo")
	public String getAadharCardNo() {
		return aadharCardNo;
	}

	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.aadhaarEnrolmentId")
	public String getAadhaarEnrolmentId() {
		return aadhaarEnrolmentId="";
	}

	public void setAadhaarEnrolmentId(String aadhaarEnrolmentId) {
		this.aadhaarEnrolmentId = aadhaarEnrolmentId;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.dob")
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountryCodeMobile() {
		return countryCodeMobile;
	}

	public void setCountryCodeMobile(String countryCodeMobile) {
		this.countryCodeMobile = countryCodeMobile;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.emailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.residenceNo")
	public String getResidenceNo() {
		return residenceNo;
	}

	public void setResidenceNo(String residenceNo) {
		this.residenceNo = residenceNo;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.residenceName")
	public String getResidenceName() {
		return residenceName;
	}

	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.roadOrStreet")
	public String getRoadOrStreet() {
		return roadOrStreet;
	}

	public void setRoadOrStreet(String roadOrStreet) {
		this.roadOrStreet = roadOrStreet;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.localityOrArea")
	public String getLocalityOrArea() {
		return localityOrArea;
	}

	public void setLocalityOrArea(String localityOrArea) {
		this.localityOrArea = localityOrArea;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.cityOrTownOrDistrict")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.stateCode")
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.pincodee")
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@ITR1XMLMaping(key="itr.itr1.personalInfo.employerCategory")
	public String getEmployerCategory() {
		return employerCategory.getCategory().name();
	}

	public void setEmployerCategory(EmplorerCategory employerCategory) {
		this.employerCategory = employerCategory;
	}

	@ITR1XMLMaping(key="itr.itr1.filingStatus.returnFileSec")
	public String getReturnFileSec() {
		return returnFileSec.getFileType();
	}

	public void setReturnFileSec(ReturnFileSec returnFileSec) {
		this.returnFileSec = returnFileSec;
	}

	@ITR1XMLMaping(key="itr.itr1.filingStatus.returnType")
	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	@ITR1XMLMaping(key="itr.itr1.filingStatus.returnType")
	public String getPortugeseCC5A() {
		return portugeseCC5A;
	}

	public void setPortugeseCC5A(String portugeseCC5A) {
		this.portugeseCC5A = portugeseCC5A;
	}

	@ITR1XMLMaping(key="itr.itr1.filingStatus.returnType")
	public String getPanOfSpouse() {
		return panOfSpouse;
	}

	public void setPanOfSpouse(String panOfSpouse) {
		this.panOfSpouse = panOfSpouse;
	}


	public boolean isSeniorCitizen(){
		try{
			String dobStr = getDob();
			SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
			Date dob = form.parse(dobStr);
			if (dob == null) {
				Calendar cal = Calendar.getInstance();
				cal.set(11, 0);
				cal.set(12, 0);
				cal.set(13, 0);
				cal.set(14, 0);

				dob = cal.getTime();
			}

			SimpleDateFormat form1 = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
			Date d1 = form1.parse(dob.toString());
			String d2 = form.format(d1);
			Date date1 = form.parse(d2);
			if ((date1.before(form.parse("01/04/1960"))) || (date1.equals(form.parse("01/04/1960")))) {
				return true;
			}
		}catch(Exception ex){

		}
		return false;
	}

	public void updateProperties(){
		// set the default property
		OnChangeCommonUtil.setElementValueByTargetName("itr.itr1.personalInfo.assesseeName.firstName", this.getFirstName());
		OnChangeCommonUtil.setElementValueByTargetName("itr.itr1.personalInfo.assesseeName.surNameOrOrgName", this.getSurName());
		OnChangeCommonUtil.setElementValueByTargetName("itr.itr1.personalInfo.assesseeName.middleName", this.getMiddleName());
		Method methods []=  this.getClass().getDeclaredMethods();
		for(Method method:methods){
			ITR1XMLMaping mapping = method.getAnnotation(ITR1XMLMaping.class);
			if(mapping !=null){
				String key  = mapping.key();
				try {
					String value = ((String)method.invoke(this)).trim();
					GenerateXMLUtility.setElementValueByTargetName(key,value);
				} catch (Exception ex){
					logger.error("[updateProperties] failed to update the property ", ex);
				}
			}
		}
		//update country code.. since on the state change the country code is set to -1
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.personalInfo.address.countryCode", getCountryCode());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.personalInfo.address.countryCodeMobile", getCountryCodeMobile());
		// update the seventhProvision139
		seventhProvisio139.updateProperties();
		
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public SeventhProvisio139 getSeventhProvisio139() {
		return seventhProvisio139;
	}

	public void setSeventhProvisio139(SeventhProvisio139 seventhProvisio139) {
		this.seventhProvisio139 = seventhProvisio139;
	}

	
	@ITR1XMLMaping(key="itr.itr1.personalInfo.address.zipCode")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@JsonProperty(value="pan")
	private String pan="";

	@JsonProperty(value="firstName")
	private String firstName="";

	@JsonProperty(value="middleName")
	private String middleName="";

	@JsonProperty(value="surNameOrOrgName")
	private String surName="";

	@JsonProperty(value="aadhaarCardNo")
	private String aadharCardNo="";

	@JsonProperty(value="aadhaarEnrolmentId")
	private String aadhaarEnrolmentId;

	@JsonProperty(value="dob")
	private String dob="";

	@JsonProperty(value="countryCodeMobile")
	private String countryCodeMobile="91";

	@JsonProperty(value="mobileNo")
	private String mobileNo="";

	@JsonProperty(value="emailAddress")
	private String emailAddress="";

	@JsonProperty(value="residenceNo")
	private String residenceNo="";

	@JsonProperty(value="residenceName")
	private String residenceName="";

	@JsonProperty(value="roadOrStreet")
	private String roadOrStreet="";

	@JsonProperty(value="localityOrArea")
	private String localityOrArea="";

	@JsonProperty(value="cityOrTownOrDistrict")
	private String city="";

	@JsonProperty(value="stateCode")
	private String stateCode="";

	@JsonProperty(value="countryCode")
	private String countryCode="91";

	@JsonProperty(value="pincode")
	private String pincode="";

	@JsonProperty(value="zipcode")
	private String zipcode="";

	@JsonProperty(value="employerCategory")
	private EmplorerCategory employerCategory=new EmplorerCategory();

	@JsonProperty(value="returnFileSec")
	private ReturnFileSec returnFileSec= new ReturnFileSec();

	@JsonProperty(value="returnType")
	private String returnType="O";

	@JsonProperty(value="portugeseCC5A")
	private String portugeseCC5A="N";

	@JsonProperty(value="panOfSpouse" )
	private String panOfSpouse="";

	@JsonProperty(value="seventhProvision139")
	private SeventhProvisio139 seventhProvisio139 = new SeventhProvisio139();

}
