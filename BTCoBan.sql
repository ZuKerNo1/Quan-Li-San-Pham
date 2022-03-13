create database BTCoBan2
go
use BTCoBan2
--
create table Product
(
	idSP int identity(1,1) not null primary key,
	TenSP nvarchar(50),
	SoLuong int,
	GiaTien decimal
)
--
create table Account
(
	UserName varchar(50) primary key,
	Pass varchar(50)
)