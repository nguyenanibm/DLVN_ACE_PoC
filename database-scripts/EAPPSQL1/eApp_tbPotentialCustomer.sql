create table dbo.eApp_tbPotentialCustomer
(
	PotentialID int identity
		constraint PK_eApp_tbPersonal
			primary key,
	ProposalID int
		constraint FK_eApp_tbPotentialCustomer_eApp_tbProposal
			references dbo.eApp_tbProposal,
	PotentialType nvarchar(15),
	Relationship nvarchar(50),
	FullName nvarchar(100),
	BirthDate nvarchar(30),
	BirthPlace nvarchar(150),
	Age int,
	Gender nvarchar(15),
	IDNum nvarchar(30),
	IDDateCreated nvarchar(30),
	IDPlaceCreated nvarchar(150),
	Nationality nvarchar(30),
	Maturity nvarchar(15),
	OccupationClass int,
	OccupationCode nvarchar(15),
	Occupation nvarchar(150),
	OccupationDetail nvarchar(300),
	OtherOccCode nvarchar(15),
	OtherOcc nvarchar(150),
	OtherOccDetail nvarchar(300),
	TaxID nvarchar(30),
	Income decimal(18,4),
	OtherIncome decimal(18,4),
	IsTaxAmerican bit constraint DF_eApp_tbPotentialCustomer_IsTaxAmerican default 0,
	CellPhone nvarchar(15),
	HomePhone nvarchar(15),
	BusinessPhone nvarchar(15),
	Email nvarchar(150),
	Address nvarchar(250),
	AddressCode nvarchar(30),
	BusinessAddress nvarchar(250),
	BusinessAddressCode nvarchar(30),
	IsCompany bit constraint DF_eApp_tbCustomer_IsCompany default 0,
	BankAccount nvarchar(30),
	BankBranch nvarchar(150),
	IsCompleteUpdate bit constraint DF_eApp_tbPotentialCustomer_IsCompleteUpdate default 0,
	IsSMS bit constraint DF_eApp_tbPotentialCustomer_IsSMS default 1,
	ClassSchool nvarchar(50),
	School nvarchar(150),
	AdmissionDate datetime,
	IsPOAddress bit constraint DF_eApp_tbPotentialCustomer_IsPOAddress default 0,
	IsOtherAddress bit constraint DF_eApp_tbPotentialCustomer_IsOtherAddress default 0,
	IsPOSameLI bit constraint DF_eApp_tbPotentialCustomer_SamePOLI default 0,
	IsPrivateDone bit constraint DF_eApp_tbPotentialCustomer_IsPrivateDone default 0,
	IsHealthDone bit constraint DF_eApp_tbPotentialCustomer_IsHealthDone default 0,
	IsBenefitDone bit constraint DF_eApp_tbPotentialCustomer_IsBenefitDone default 0,
	IsDocumentDone bit constraint DF_eApp_tbPotentialCustomer_IsDocumentDone default 0,
	ClientIsExist nvarchar(15),
	UpdatedDate datetime,
	CreatedDate datetime,
	IsLIS bit,
	PORelationValue nvarchar(50),
	OccupationClassCurrent int,
	OtherOccupationClass int,
	PositionFreeText nvarchar(400)
)
go

create index IDX_eApp_tbPotentialCustomer_1
	on dbo.eApp_tbPotentialCustomer (ProposalID, PotentialType)
go

