insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Vrbas', 'Dr Milana Cekica Vrbas',5600000);

insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Sombor', 'Vojvodjanska 75',5000000)

insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Pancevo', 'Milosa Trebinjca 11',6000000)

insert into bolnica(id,naziv,adresa,budzet)
values (nextval('BOLNICA_SEQ'), 'Bolnica Sremska Mitrovica', 'Stari Sor 65',6800000)

select * from bolnica;

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Trudnoca', 'Vestacko zacece','O00 O99')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti koze i potkoznog tkiva', 'Dijagnostikovan vitiligo','L00 L99')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Zarazne i parazitne bolesti ', 'Pozitivan COVID-19 test','A00')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti mokracno-polnog sistema', 'Zapaljenje urinarnog trakta','N00 N99')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti perinatalnog perioda', 'Porodjajna trauma','P10 P15')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti perinatalnog perioda', 'Infekcije u perinatalnom periodu','P35 P39')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti koze i potkoznog tkiva', 'Uritkarija i eritrem','L50 L54')

insert into dijagnoza(id,naziv,opis,oznaka)
values (nextval('DIJAGNOZA_SEQ'), 'Bolesti koze i potkoznog tkiva', 'Dermatitis i ekcemi','L20 L30')

SELECT * FROM DIJAGNOZA