CREATE KEYSPACE IF NOT EXISTS TicketsBooker
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 };

USE TicketsBooker;
#Kazda tabela ma pole ID jako uuid


CREATE TABLE Ticket(
#nr
#key->Karnet moze nie musi
#key->Client 
#key->Place
)

CREATE TABLE Karnet(
#key->Client
#key->Karnet_type
#remained_times
)  

CREATE TABLE Karnet_type(
#karnet_name
#key->event
#number_of_events
--taki worek na karnety
)

CREATE TABLE Client(
#name
#surname
#login
#email  
#key->Card  
#tel_number  
)

/*
CREATE KEYSPACE IF NOT EXISTS TicketsBooker
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

USE TicketsBooker;

--Kazda tabela ma pole ID jako uuid


CREATE TABLE Ticket(
TicketID int,
nr varchar,
PassID int,
ClientID int,
PlaceID int,
PRIMARY KEY((TicketID), ClientID, PlaceID, PassID)
);

CREATE TABLE Pass(
PassID int,
ClientID int,
Pass_typeID int,
remained_times int,
PRIMARY KEY((PassID), ClientID, Pass_typeID)
);

CREATE TABLE Pass_type(
Pass_typeID int,
EventID int,
karnet_name text,
number_of_events int,
PRIMARY KEY((Pass_typeID), EventID)
--taki worek na karnety
);

CREATE TABLE Client(
ClientID int,
name varchar,
surname varchar,
login varchar,
email varchar,
Credit_cardsID int,
tel_number varchar,
PRIMARY KEY((ClientID), Credit_cardsID)
);

CREATE TABLE Place(
PlaceID int,
sector varchar,
code_place varchar,
PRIMARY KEY(PlaceID)
);

CREATE TABLE Event(
EventID int,
event_name varchar,
event_type varchar,
event_start timestamp,
event_stop timestamp,
Tickets_CompanyID int,
PRIMARY KEY((EventID), Tickets_CompanyID)
);

CREATE TABLE Tickets_Company(
Tickets_CompanyID int,
company_name varchar,
NIP varchar,
address varchar,
email varchar,
PRIMARY KEY(Tickets_CompanyID)
);

CREATE TABLE Chart_elements(
Chart_elementsID int,
TicketID int,
PassID int,
ClientID int,
PRIMARY KEY((Chart_elementsID), TicketID, PassID, ClientID)
);

CREATE TABLE Credit_card(
Credit_cardsID int,
ClientID int,
nr_karty varchar,
back_code varchar,
valid_data varchar,
PRIMARY KEY((Credit_cardsID), ClientID)
);



*/

CREATE TABLE Place(
#sector varchar
#code_place
)

CREATE TABLE Event(
#event_name
#event_type
#event_start datetime
#event_stop datetime
#key->Ticket_Company
)

CREATE TABLE Tickets_Company(
#company_name
#NIP
#Address
#Email  
)

CREATE TABLE chart_elements(
#key->Ticket
#key->Karnet
#key->Client
)

CREATE TABLE Credit_cards(
#nr_karty  
#owner
#back_code
#valid_data
)
  
