CREATE KEYSPACE IF NOT EXISTS TicketsBooker
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 };

USE TicketsBooker;

CREATE TABLE Ticket(

)

CREATE TABLE Client(

)

CREATE TABLE Sector(

)

CREATE TABLE Event(

)

CREATE TABLE Tickets_Company(

)

CREATE TABLE Tickets_Delivery(

)
