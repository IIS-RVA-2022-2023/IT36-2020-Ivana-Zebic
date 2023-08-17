insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Vrbas', 'Dr Milana Cekica Vrbas',5600000);

insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Sombor', 'Vojvodjanska 75',5000000);

insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Pancevo', 'Milosa Trebinjca 11',6000000);

insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Sremska Mitrovica', 'Stari Sor 65',6800000);



insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Trudnoca', 'Vestacko zacece','O00 O99');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti koze i potkoznog tkiva', 'Dijagnostikovan vitiligo','L00 L99');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Zarazne i parazitne bolesti ', 'Pozitivan COVID-19 test','A00');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti mokracno-polnog sistema', 'Zapaljenje urinarnog trakta','N00 N99');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti perinatalnog perioda', 'Porodjajna trauma','P10 P15');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti perinatalnog perioda', 'Infekcije u perinatalnom periodu','P35 P39');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti koze i potkoznog tkiva', 'Uritkarija i eritrem','L50 L54');

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti koze i potkoznog tkiva', 'Dermatitis i ekcemi','L20 L30');



insert into odeljenje(id,lokacija, naziv, bolnica)
values (nextval('ODELJENJE_SEQ'),'Centralna bolnica','gerijatrija', 2);
insert into odeljenje(id,lokacija, naziv, bolnica)
values (nextval('ODELJENJE_SEQ'),'Dom zdravlja','pedijatrija', 1);
insert into odeljenje(id,lokacija, naziv, bolnica)
values (nextval('ODELJENJE_SEQ'),'Centralna bolnica','pedijatrija', 2);
insert into odeljenje(id,lokacija, naziv, bolnica)
values (nextval('ODELJENJE_SEQ'),'Centralna bolnica','neurologija', 3);
insert into odeljenje(id,lokacija, naziv, bolnica)
values (nextval('ODELJENJE_SEQ'),'Centralna bolnica','ortopedija', 2);


insert into pacijent(id,datum_rodjenja,ime,prezime, zdr_osiguranje,dijagnoza,odeljenje)
values (nextval('PACIJENT_SEQ'),'10-10-1988','Isidora','Japundza',true,4,1);
insert into pacijent(id,datum_rodjenja,ime,prezime, zdr_osiguranje,dijagnoza,odeljenje)
values (nextval('PACIJENT_SEQ'),'10-10-1976','Ivana','Zebic',true,3,2);
insert into pacijent(id,datum_rodjenja,ime,prezime, zdr_osiguranje,dijagnoza,odeljenje)
values (nextval('PACIJENT_SEQ'),'10-10-2011','Stefana','Kokic',true,2,3);
insert into pacijent(id,datum_rodjenja,ime,prezime, zdr_osiguranje,dijagnoza,odeljenje)
values (nextval('PACIJENT_SEQ'),'10-10-2009','Marko','Jovic',true,1,3);
insert into pacijent(id,datum_rodjenja,ime,prezime, zdr_osiguranje,dijagnoza,odeljenje)
values (nextval('PACIJENT_SEQ'),'10-10-1999','Marko','Stevic',true,4,2);
insert into pacijent(id,datum_rodjenja,ime,prezime, zdr_osiguranje,dijagnoza,odeljenje)
values (nextval('PACIJENT_SEQ'),'10-10-1996','Janko','Jovic',true,4,2);