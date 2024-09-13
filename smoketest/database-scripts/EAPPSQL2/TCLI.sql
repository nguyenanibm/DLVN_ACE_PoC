create table dbo.TCLI
(
	CO_ID nvarchar(2) not null,
	CLI_ID nvarchar(15) not null,
	CLI_SEX_CD nvarchar(3),
	CLI_TAX_ID nvarchar(15),
	OCCP_ID nvarchar(15),
	CLI_SUR_NM nvarchar(150),
	CLI_GIV_NM nvarchar(150),
	CLI_CO_ENTR_NM nvarchar(150),
	CLI_BTH_DT datetime,
	CLI_MARIT_STAT_CD nvarchar(3),
	CLI_INDV_TITL_TXT nvarchar(50),
	CLI_BTH_LOC_CD nvarchar(10),
	CLI_INDV_SFX_NM nvarchar(30),
	CLI_ID_NUM nvarchar(50),
	CLI_CTZN_CTRY_CD nvarchar(5)
)
go

create clustered index [ClusteredIndex-20161026-105319]
	on dbo.TCLI (CLI_ID)
go

create index IDX_TCLI_01
	on dbo.TCLI (CO_ID, CLI_ID)
go

