-- Q1
--SELECT * FROM tur;

INSERT INTO tur(ad)
VALUES('Biyografi');
	-- DELETE
  	--DELETE FROM tur WHERE ad = 'Biyografi';
	--SELECT pg_get_serial_sequence('tur', 'turno');
	--SELECT setval('public.tur_turno_seq', (SELECT MAX(turno) FROM tur), true);

--SELECT * FROM tur;

-- Q2
--SELECT * FROM yazar;

INSERT INTO yazar(ad,soyad)
VALUES ('Nurettin','Belek');

--SELECT * FROM yazar;

-- Q3
--SELECT * FROM ogrenci;

UPDATE ogrenci
SET sinif = '10C'
WHERE sinif = '10B';

--SELECT * FROM ogrenci;

-- Q4
--SELECT * FROM kitap;

UPDATE kitap
SET puan = puan + 5;

--SELECT * FROM kitap;

-- Q5
--SELECT * FROM yazar;

DELETE FROM yazar
WHERE ad = 'Mehmet';

--SELECT * FROM yazar;

-- Q6
--SELECT * FROM tur;

INSERT INTO tur(ad)
VALUES('Kişisel Gelişim');

--SELECT * FROM tur;

-- Q7
--SELECT * FROM kitap;
--SELECT * FROM tur;

UPDATE kitap
SET turno = (SELECT turno FROM tur WHERE ad = 'Kişisel Gelişim' )
WHERE ad = 'Benim Üniversitelerim';

--SELECT * FROM kitap;

-- Q8
CREATE OR REPLACE FUNCTION public.ogrencilistesi()
RETURNS SETOF ogrenci
LANGUAGE sql
AS $BODY$
    SELECT * FROM ogrenci;
$BODY$;

/*
CREATE OR REPLACE FUNCTION ogrencilistesi()
RETURNS TABLE (
    ogrno bigint,
    ad varchar,
    soyad varchar,
    cinsiyet varchar,
    sinif varchar,
    puan integer,
    dtarih varchar
)
LANGUAGE sql
AS $BODY$
    SELECT * FROM ogrenci;
$BODY$;
*/

--SELECT * FROM ogrenci;
--SELECT COUNT(*) FROM ogrenci;
--SELECT * FROM ogrencilistesi();

-- Q9
--SELECT * FROM kitap;

CREATE OR REPLACE PROCEDURE public.ekle(
IN new_ad character varying,
IN new_puan integer,
IN new_yazarno bigint,
IN new_turno bigint
)
LANGUAGE sql
AS $BODY$
	INSERT INTO public.kitap(ad, puan, yazarno, turno)
	VALUES (new_ad, new_puan, new_yazarno, new_turno);
$BODY$;

-- Q10
--SELECT * FROM ogrenci;

CREATE OR REPLACE PROCEDURE public.sil(given_ogrno bigint)
LANGUAGE sql
AS $BODY$
	DELETE FROM ogrenci WHERE ogrno = given_ogrno;
 $BODY$;

/*
CALL sil(10);
SELECT * FROM ogrenci;
*/

