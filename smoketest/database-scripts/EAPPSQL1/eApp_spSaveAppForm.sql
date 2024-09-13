CREATE procedure [dbo].[eApp_spSaveAppForm] @Action as nvarchar(50) = null,
                                            @ProposalID int,
                                            @PotentialType nvarchar(15),
                                            @Relationship nvarchar(50),
                                            @FullName nvarchar(300),
                                            @BirthDate nvarchar(30),
                                            @BirthPlace nvarchar(150),
                                            @Age int,
                                            @Gender nvarchar(15),
                                            @IDNum nvarchar(30),
                                            @Nationality nvarchar(30),
                                            @Maturity nvarchar(15),
                                            @Occupation nvarchar(150),
                                            @OccupationDetail nvarchar(300),
                                            @OtherOcc nvarchar(150),
                                            @Income decimal(18, 4),
                                            @IsTaxAmerican bit,
                                            @CellPhone nvarchar(15),
                                            @HomePhone nvarchar(15),
                                            @BusinessPhone nvarchar(15),
                                            @Email nvarchar(150),
                                            @Address nvarchar(250),
                                            @AddressCode nvarchar(30),
                                            @BusinessAddress nvarchar(250),
                                            @BusinessAddressCode nvarchar(30),
                                            @IsCompany bit,
                                            @BankAccount nvarchar(30),
                                            @BankBranch nvarchar(150),
                                            @OtherOccDetail nvarchar(300),
                                            @TaxID nvarchar(30),
                                            @IsPOSameLI int,
                                            @ClassSchool nvarchar(50),
                                            @School nvarchar(150),
                                            @OtherIncome decimal(18, 4),
                                            @IsPOAddress bit,
                                            @IsOtherAddress bit,
                                            @IsSMS bit = 1,
                                            @ClientIsExist nvarchar(15),
                                            @OccupationCode nvarchar(15),
                                            @OtherOccCode nvarchar(15),
                                            @OccupationClass int,
                                            @PotentialID int,
                                            @IsLIS int,
                                            @PORelationValue nvarchar(50),
                                            @OccupationClassCurrent int,
                                            @OtherOccupationClass int,
                                            @PositionFreeText nvarchar(400),
                                            @OutputID int = 0 output
as
begin

    if @Action = 'PotentialCustomer'
        begin
            INSERT INTO [dbo].[eApp_tbPotentialCustomer]
            ( ProposalID, [PotentialType], [Relationship], [FullName], [BirthDate], [BirthPlace], [Age]
            , [Gender], [IDNum], [Nationality], [Maturity], OccupationClass, [Occupation], [OccupationDetail]
            , [OtherOcc], [Income], [IsTaxAmerican]
            , [CellPhone], [HomePhone], [BusinessPhone], [Email], [Address], [AddressCode], [BusinessAddress]
            , [BusinessAddressCode], [IsCompany], [BankAccount], [BankBranch], [OtherOccDetail], [TaxID], IsSMS
            , IsPOSameLI, [ClassSchool], [School], OtherIncome, IsPOAddress, IsOtherAddress, ClientIsExist
            , [UpdatedDate], [CreatedDate], [IsLIS], [PORelationValue], [OccupationClassCurrent]
            , [OtherOccupationClass], [PositionFreeText])
            VALUES (@ProposalID, @PotentialType, @Relationship, @FullName, @BirthDate, @BirthPlace, @Age,
                    @Gender, @IDNum, @Nationality, @Maturity, @OccupationClass, @Occupation, @OccupationDetail,
                    @OtherOcc, @Income, @IsTaxAmerican,
                    @CellPhone, @HomePhone, @BusinessPhone, @Email, @Address, @AddressCode, @BusinessAddress,
                    @BusinessAddressCode, @IsCompany, @BankAccount, @BankBranch, @OtherOccDetail, @TaxID,
                    @IsSMS, @IsPOSameLI, @ClassSchool, @School, @OtherIncome, @IsPOAddress, @IsOtherAddress,
                    @ClientIsExist, getdate(), getdate(), @IsLIS, @PORelationValue, @OccupationClassCurrent,
                    @OtherOccupationClass, @PositionFreeText);
            if @@error <> 0
                begin
                    set @OutputID = '-1'
                    return
                end
            set @OutputID = @@IDENTITY

        end
    else
        if @Action = 'UpdateCustomer'
            begin
                update [dbo].[eApp_tbPotentialCustomer]
                set BirthPlace             = @BirthPlace,
                    IDNum                  = @IDNum,
                    Nationality            = @Nationality,
                    BirthDate              = @BirthDate,
                    FullName               = @FullName,
                    Age                    = @Age,
                    Maturity               = @Maturity,
                    Occupation             = @Occupation,
                    OccupationDetail       = @OccupationDetail,
                    OtherOcc               = @OtherOcc,
                    Income                 = @Income,
                    IsTaxAmerican          = @IsTaxAmerican,
                    CellPhone              = @CellPhone,
                    HomePhone              = @HomePhone,
                    BusinessPhone          = @BusinessPhone,
                    Email                  = @Email,
                    [Address]              = @Address,
                    AddressCode            = @AddressCode,
                    BusinessAddress        = @BusinessAddress,
                    BusinessAddressCode    = @BusinessAddressCode,
                    IsCompany              = @IsCompany,
                    ClientIsExist          = @ClientIsExist,
                    BankAccount            = @BankAccount,
                    BankBranch             = @BankBranch,
                    OtherOccDetail         = @OtherOccDetail,
                    TaxID                  = @TaxID,
                    ClassSchool            = @ClassSchool,
                    School                 = @School,
                    OtherIncome            = @OtherIncome,
                    IsPOAddress            = @IsPOAddress,
                    IsOtherAddress         = @IsOtherAddress,
                    Relationship           = @Relationship,
                    UpdatedDate            = GETDATE(),
                    OccupationClassCurrent = @OccupationClassCurrent,
                    OtherOccupationClass   = @OtherOccupationClass
                where PotentialID = @PotentialID
                set @OutputID = @PotentialID

            end
end


go

