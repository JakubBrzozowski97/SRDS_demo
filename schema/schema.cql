CREATE KEYSPACE IF NOT EXISTS TicketsBooker
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

USE TicketsBooker;

--Kazda tabela ma pole ID jako uuid


CREATE TABLE Tickets(
TicketID uuid,
PassID uuid,
ClientID uuid,
PlaceID int,
PRIMARY KEY((TicketID), ClientID, PlaceID, PassID)
);

CREATE TABLE Passes(
PassID uuid,
ClientID uuid,
Pass_typeID uuid,
remained_times int,
PRIMARY KEY((PassID), ClientID, Pass_typeID)
);

CREATE TABLE Pass_types(
Pass_typeID uuid,
EventID uuid,
pass_name varchar,
number_of_events int,
PRIMARY KEY((Pass_typeID), EventID)
--taki worek na karnety
);

CREATE TABLE Clients(
ClientID uuid,
name varchar,
surname varchar,
login varchar,
email varchar,
password varchar,
Credit_cardsID uuid,
tel_number varchar,
PRIMARY KEY((ClientID), Credit_cardsID)
);

CREATE TABLE Places(
PlaceID UUID,
sector varchar,
PRIMARY KEY(PlaceID)
);

CREATE TABLE Events(
EventID uuid,
event_name varchar,
event_type varchar,
event_start timestamp,
event_stop timestamp,
Tickets_CompanyID int,
PRIMARY KEY((EventID), Tickets_CompanyID)
);

CREATE TABLE Tickets_Companies(
Tickets_CompanyID int,
company_name varchar,
NIP varchar,
address varchar,
email varchar,
PRIMARY KEY(Tickets_CompanyID)
);

CREATE TABLE Chart_elements(
Chart_elementsID uuid,
TicketID uuid,
PassID uuid,
ClientID uuid,
PRIMARY KEY((Chart_elementsID), TicketID, PassID, ClientID)
);

CREATE TABLE Credit_cards(
Credit_cardsID uuid,
ClientID uuid,
back_code varchar,
valid_data varchar,
PRIMARY KEY((Credit_cardsID), ClientID)
);
