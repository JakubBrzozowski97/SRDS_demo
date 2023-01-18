USE TicketsBooker;


INSERT INTO Tickets_Company (Tickets_CompanyID, company_name, NIP, address, email) VALUES (1,'TicketPro', '6666', 'Chujewo', 'malpa@gmail.com');
INSERT INTO Ticket (TicketID, nr, PassID, ClientID, PlaceID) VALUES (1, '2', 1, 1,1);
INSERT INTO Pass (PassID, ClientID, Pass_typeID, remained_times) VALUES(1,1,1,50);
INSERT INTO Pass_type (Pass_typeID, EventID, karnet_name, number_of_events) VALUES (1,1,'dlugi',1);
INSERT INTO Client (ClientID, name, surname, login, email, Credit_cardsID, tel_number) VALUES (1,'Jakub', 'Brzozowski', 'JBL', 'jebl@gmail.com',1 ,'605777654');
INSERT INTO Place (PlaceID, sector, code_place) VALUES (1, 'A', 'AAX');
INSERT INTO Event (EventID, event_name, event_type, event_start, event_stop, Tickets_CompanyID) VALUES (1, 'Meczyk', 'Mecz', '2011-02-03', '2011-02-04', 1);
INSERT INTO Chart_elements (Chart_elementsID, TicketID, PassID, ClientID) VALUES (1, 1, 1, 1);
INSERT INTO Credit_card (Credit_cardsID, ClientID, nr_karty, back_code, valid_data) VALUES (1,1,'1','1234','2024-05-01');