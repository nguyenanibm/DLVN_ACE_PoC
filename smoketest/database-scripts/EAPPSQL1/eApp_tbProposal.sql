create table dbo.eApp_tbProposal
(
	ProposalID int identity
		constraint PK_eApp_tbProposal
			primary key,
	AgentID nvarchar(10),
	AgentName nvarchar(250),
	CSOfficeCode nvarchar(30),
	CSOffice nvarchar(50),
	ProposalNo nvarchar(15),
	IllustrationID nvarchar(30),
	WorkflowID nvarchar(30),
	POID int,
	POName nvarchar(150),
	LIName nvarchar(150),
	Status nvarchar(30),
	Progress int,
	Description nvarchar(150),
	Frequency nvarchar(15),
	PremiumAmt decimal(18,4),
	ActualPremium decimal(18,4),
	[Option] nvarchar(6),
	ConfirmDate datetime,
	UpdatedDate datetime,
	CreatedDate datetime,
	OtherWFID nvarchar(30),
	AgentBranch nvarchar(150),
	FlagIAA nvarchar(2),
	ProposalNoDate datetime,
	SubmittedDate datetime,
	PaymentDate datetime,
	PaymentMethod nvarchar(150),
	ProductCode nvarchar(15),
	ProductName nvarchar(300),
	REFNo varchar(50),
	BranchCode varchar(30),
	PartnerCode varchar(100)
)
go

create index IDX_eApp_tbProposal_1
	on dbo.eApp_tbProposal (AgentID, IllustrationID)
go

create index IDX_eapp_tbProposal_2
	on dbo.eApp_tbProposal (WorkflowID) include (ProposalID, AgentID, ProposalNo, Status, FlagIAA)
go

create index IDX_eApp_tbProposal_3
	on dbo.eApp_tbProposal (ProposalNo)
go

create index IDX_eApp_tbProposal_4
	on dbo.eApp_tbProposal (AgentID, Status)
go

create index IDX_eApp_tbProposal_REFNo
	on dbo.eApp_tbProposal (REFNo)
go

