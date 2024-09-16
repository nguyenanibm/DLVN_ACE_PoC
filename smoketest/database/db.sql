USE [master]
CREATE DATABASE [DLVN_PoC]
GO
CREATE DATABASE [DLVN_PoC1]
GO

USE [DLVN_PoC]
CREATE LOGIN dlvnpoc WITH PASSWORD = 'P@ssw0rd'
GO
CREATE USER [dlvnpoc] FOR LOGIN [dlvnpoc]
GO
EXEC sp_addrolemember N'db_owner', N'dlvnpoc'
GO

USE [DLVN_PoC1]
CREATE LOGIN dlvnpoc1 WITH PASSWORD = 'P@ssw0rd'
GO
CREATE USER [dlvnpoc1] FOR LOGIN [dlvnpoc1]
GO
EXEC sp_addrolemember N'db_owner', N'dlvnpoc1'
GO

-- USE [DLVN_PoC]
-- DROP USER [dlvnpoc]
-- GO
-- DROP LOGIN [dlvnpoc]
-- GO
-- USE [DLVN_PoC1]
-- DROP USER [dlvnpoc1]
-- GO
-- DROP LOGIN [dlvnpoc1]
-- GO
-- USE [master]
-- DROP DATABASE [DLVN_PoC]