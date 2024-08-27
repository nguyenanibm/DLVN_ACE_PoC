package vn.com.dlvn.utils;

import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.ibm.broker.plugin.MbPolicy;

public class getPolicies {
    public static String getUserDefVal(String policyName, String propName) {
	
    	org.slf4j.Logger logger = LoggerFactory.getLogger(getPolicies.class);
	
    	String propVal = null;
    	
		try {
			MbPolicy myPol = MbPolicy.getPolicy("UserDefined", policyName);
		    if (myPol != null) {
		    	propVal = myPol.getPropertyValueAsString(propName);
		    	logger.info(propName + ": " + propVal);
		    }
		} catch (Exception ex) {
		    logger.error(ExceptionUtils.getStackTrace(ex));
		}
		
		return propVal;
	}
}