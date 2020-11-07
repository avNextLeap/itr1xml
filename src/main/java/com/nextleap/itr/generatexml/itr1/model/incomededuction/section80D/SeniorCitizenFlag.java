package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

public enum SeniorCitizenFlag {
	
	YES("1"),
	NO("2"),
	NOT_CLAIM_SELF_FAMILY("3"),
	NO_CLAIM_FOR_PARENTS("4"),
	UNKNOWN("-1");
	
	String seniorCitizenflag;
	SeniorCitizenFlag(String seniorCitizenflag){
		this.seniorCitizenflag=seniorCitizenflag;
	}
	
	private String getSeniorCitizenFlag(){
		return seniorCitizenflag;
	}
	public static  SeniorCitizenFlag getSeniorCitizenFlag(String seniorCitizenflag){
		for(SeniorCitizenFlag flag:SeniorCitizenFlag.values()){
			if(flag.getSeniorCitizenFlag().equals(seniorCitizenflag)){
				return flag;
			}
		}
		
		return UNKNOWN;
	}
}
