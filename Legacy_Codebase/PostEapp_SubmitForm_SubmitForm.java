import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicReference;

import model.daiichi.com.vn.CPResult;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbJSON;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
import common.daiichi.com.vn.Util;
import common.daiichi.com.vn.eAppCommon;

import eapp.daiichi.com.vn.PotentialCustomer;
import eapp.daiichi.com.vn.ProposalInfo;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class PostEapp_SubmitForm_SubmitForm extends MbJavaComputeNode {
	
	public static Logger log = Logger.getLogger(PostEapp_SubmitForm_SubmitForm.class);

	@SuppressWarnings("unused")
	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		MbMessageAssembly outAssembly = null;
		String response = "";
		try {
			// create new message as a copy of the input
			MbMessage outMessage = new MbMessage(inMessage);
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			// ----------------------------------------------------------
			// Add user code below
			String Action = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Action");			
			String AgentId = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/AgentID");
			String Project = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Project");
			String IllustrationID = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/IllustrationID");
			
			/*if(!ReadProperties.isRead_Log){
				log.info("Class PostEapp_SubmitForm_SubmitForm:  Read Properties Config Log: " + ReadProperties.isRead_Log);
			}
			ReadProperties.IsReadConfigLog();*/
			
			/*if(!ReadProperties.isRead_Config){
				log.info("Class PostEapp_SubmitForm_SubmitForm: Read Properties Config Connection: " + ReadProperties.isRead_Config);
			}
			ReadProperties.IsReadConfig();*/
			
			Gson gson = new Gson();
			AtomicReference<String> sError = new AtomicReference<String>();
			
			if(Action.equalsIgnoreCase("SubmitCustomerInfo"))
			{					
				String PotentialType = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/PotentialType");
				String Relationship = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Relationship");
				String FullName = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/FullName");
				String BirthDate = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BirthDate");
				String BirthPlace = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BirthPlace");
				String Age = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Age");
				String Gender = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Gender");
				String IDNum = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/IDNum");
				String Nationality = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Nationality");
				String Maturity = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Maturity");
				String Occupation = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Occupation");
				String OccupationCode = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OccupationCode");
				String OccupationDetail = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OccupationDetail");
				String OtherOccCode = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OtherOccCode");
				String OtherOcc = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OtherOcc");
				String OtherOccDetail = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OtherOccDetail");
				String TaxID = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/TaxID");
				String Income = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Income");
				String IsTaxAmerican = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/IsTaxAmerican");
				String CellPhone = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/CellPhone");
				String HomePhone = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/HomePhone");
				String BusinessPhone = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BusinessPhone");
				String Email = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Email");
				String Address = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/Address");
				String AddressCode = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/AddressCode");
				String BusinessAddress = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BusinessAddress");
				String BusinessAddressCode = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BusinessAddressCode");
				String IsCompany = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/IsCompany");		
				String BankAccount = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BankAccount");
				String BankBranch = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/BankBranch");
				String ProposalID = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/ProposalID");
				String PotentialID = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/PotentialID");
				String isPOAddress = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/isPOAddress");
				String IsOtherAddress = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/IsOtherAddress");
				String ClassSchool = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/ClassSchool");
				String School = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/School");
				String OtherIncome = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OtherIncome");
				String IsSMS = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/IsSMS");
				
				String OccupationClassCurrent = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OccupationClassCurrent");
				String OtherOccupationClass  = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/OtherOccupationClass");
				//String isRiskJob = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/isRiskJob");
				String PositionFreeText  = Util.GetValueFromMbMessage(inMessage, "/JSON/Data/PositionFreeText");
								
				if(isPOAddress.equalsIgnoreCase("true") || isPOAddress.equalsIgnoreCase("1"))
				{
					PotentialCustomer potentialCustomer = eAppCommon.GetCustomerPO(ProposalID);	
					//if(!potentialCustomer.getPotentialType().equals("PO")) // Chi update tu PO => LI,AL,...
					//{
						Address = potentialCustomer.getAddress();
						AddressCode = potentialCustomer.getAddressCode();
					//s}
				}
				
				PotentialCustomer cus = new PotentialCustomer();
				cus.setPotentialID(PotentialID);
				cus.setPotentialType(PotentialType);
				cus.setRelationship(Relationship);
				cus.setFullName(FullName);
				cus.setBirthDate(BirthDate);
				cus.setBirthPlace(BirthPlace);
				cus.setAge(Age);
				cus.setGender(Gender);
				cus.setIDNum(IDNum);
				cus.setNationality(Nationality);
				cus.setMaturity(Maturity);
				cus.setOccupation(Occupation);
				cus.setOccupationCode(OccupationCode);
				cus.setOccupationDetail(OccupationDetail);
				cus.setOtherOcc(OtherOcc);
				cus.setOtherOccCode(OtherOccCode);
				cus.setOtherOccDetail(OtherOccDetail);
				cus.setTaxID(TaxID);
				cus.setIncome(Income);
				cus.setIsTaxAmerican(IsTaxAmerican);
				cus.setCellPhone(CellPhone);
				cus.setHomePhone(HomePhone);
				cus.setBusinessPhone(BusinessPhone);
				cus.setEmail(Email);
				cus.setAddress(Address);
				cus.setAddressCode(AddressCode);
				cus.setBusinessAddress(BusinessAddress);
				cus.setBusinessAddressCode(BusinessAddressCode);
				cus.setIsCompany(IsCompany);			
				cus.setBankAccount(BankAccount);
				cus.setBankBranch(BankBranch);
				cus.setProposalID(ProposalID);
				cus.setIsPOSameLI("0");
				cus.setIsPOAddress(isPOAddress);
				cus.setIsOtherAddress(IsOtherAddress);
				cus.setSchool(School);
				cus.setClassSchool(ClassSchool);
				cus.setOtherIncome(OtherIncome);
				cus.setIsSMS(IsSMS);
				
				cus.setOccupationClassCurrent(OccupationClassCurrent);
				cus.setOtherOccupationClass(OtherOccupationClass);
				//cus.setisRiskJob(isRiskJob);
				cus.setPositionFreeText(PositionFreeText);
								
				
				try	{
					eAppCommon.InsertLogChange(AgentId, gson.toJson(cus), sError);
					//CP_Common.InsertLogChange(ClientID, "", gson.toJson(req)+ "-" + gson.toJson(lstDeath), "Claim", sError);
				}catch(Exception ex){}
				
				response = eApp_SubmitCustomerInfo(cus);
			}
			
			// End of user code
			// ----------------------------------------------------------
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		}
		
		MbMessage outMessage = new MbMessage();
		outAssembly = new MbMessageAssembly(inAssembly, outMessage);
		MbElement outRoot =  outMessage.getRootElement();
		//MbElement p = outRoot.createElementAsLastChildFromBitstream(response.getBytes(),MbJSON.PARSER_NAME, "", "", "", 0, 0, 0);
		try {
			MbElement p = outRoot.createElementAsLastChildFromBitstream(response.getBytes("UTF-8"),MbJSON.PARSER_NAME, "", "", "", 0, 1208, 0);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out = getOutputTerminal("out");
		
		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);
	}
	
	// only add new customer
	private String eApp_SubmitCustomerInfo(PotentialCustomer cus)
	{
		Gson gson = new Gson();
		CPResult re = new CPResult();
		
		try
		{
			if (cus.getFullName().equalsIgnoreCase(""))
			{
				re.setResult("false");
				re.setErrLog("EMPTY");
				re.setsNewAPIToken("");				
				return gson.toJson(re);
			}
			
			// Check dk neu status khac Initial thi khong cho cap nhat
			ProposalInfo prop = eAppCommon.GetProposalInfo(cus.getProposalID());
			if(!prop.getStatus().trim().equalsIgnoreCase("Initial"))
			{				
				re.setResult("false");
				re.setErrLog("EMPTY");
				re.setsNewAPIToken("");				
				return gson.toJson(re);
			}
			
			AtomicReference<String> sError = new AtomicReference<String>();
			// tao customer
			
			//cus.setBirthDate(eAppCommon.formatDate(cus.getBirthDate()));
			
			int PotentialID = eAppCommon.SubmitPotentialCustomer(cus, sError);
			if(PotentialID < 0) 
			{
				re.setResult("false");
	            re.setErrLog("Customer is not saved successfull.");
	            re.setsNewAPIToken("");
	            return gson.toJson(re);
	     	}
			
			PotentialCustomer cusPotential = eAppCommon.GetCustomer(cus.getProposalID(), cus.getPotentialID());
			
			String PoID = eAppCommon.GetElseSamePOLI(cus.getProposalID(), cus.getPotentialID());
			if(!PoID.equalsIgnoreCase("") && (cusPotential.getPotentialType().equalsIgnoreCase("LI") || cusPotential.getPotentialType().equalsIgnoreCase("PO"))) // LI || PO
			{
				cus.setPotentialID(PoID);					
				//cus.setPotentialType(cus.getPotentialType().trim().equalsIgnoreCase("PO") ? "LI" : "PO");
				eAppCommon.SubmitPotentialCustomer(cus, sError);
			}				
			// truong hop cap nhat Address PO => update xuong cac LI,AL ... co IsPOAddress = 1 hay IsOtherAddress 
			if(cusPotential != null)
			{
				if(cusPotential.getPotentialType().equalsIgnoreCase("PO"))
				{
					eAppCommon.UpdateCustomerIsPoAddress(cus.getProposalID(), cus.getAddress(), cus.getAddressCode());
				}
			}
						
			re.setResult("true");
            re.setErrLog("Submit Customer is saved successfull.");
            re.setMessage(String.valueOf(PotentialID));
            re.setsNewAPIToken("");
    	}
		catch(Exception ex)
		{
			re.setResult("false");
            re.setErrLog(ex.getMessage());
            re.setsNewAPIToken("");
		}
		return gson.toJson(re);
	}
}
