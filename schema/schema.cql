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
  
