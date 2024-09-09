-- USE [master]
-- CREATE DATABASE [DLVN_PoC]
-- GO

USE [DLVN_PoC]
CREATE LOGIN dlvnpoc WITH PASSWORD = 'P@ssw0rd'
GO
CREATE USER [dlvnpoc] FOR LOGIN [dlvnpoc]
GO

EXEC sp_addrolemember N'db_owner', N'dlvnpoc'
GO

-- USE [DLVN_PoC]
-- DROP USER [dlvnpoc]
-- GO

-- DROP LOGIN [dlvnpoc]
-- GO

-- USE [master]
-- DROP DATABASE [DLVN_PoC]