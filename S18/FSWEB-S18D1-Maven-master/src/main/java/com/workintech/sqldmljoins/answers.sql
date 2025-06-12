SELECT * FROM kitap;
SELECT * FROM islem;
SELECT * FROM ogrenci;
SELECT * FROM yazar;
SELECT * FROM tur;

--1
SELECT * FROM kitap WHERE turno IN( SELECT turno FROM tur WHERE ad IN('Dram', 'Hikaye'));

--2
SELECT * FROM ogrenci WHERE ogrno IN(SELECT ogrno FROM islem); --bu aslında doğru

SELECT o.* FROM ogrenci AS o 
INNER JOIN islem AS i
ON o.ogrno=i.ogrno;

--3
SELECT ogrno, ad, soyad FROM ogrenci WHERE ogrno NOT IN(SELECT ogrno FROM islem);

--4
--- first try -> didn't pass the test
SELECT 
    o.sinif,
    COUNT(i.kitapno) AS kitap_sayisi
FROM ogrenci AS o
INNER JOIN islem AS i ON o.ogrno = i.ogrno
WHERE o.sinif IN ('10A', '10B')
GROUP BY o.sinif;

-- use LEFT JOIN instead
SELECT o.sinif, COUNT(i.kitapno)
FROM ogrenci o
LEFT JOIN islem i ON o.ogrno = i.ogrno
WHERE o.sinif IN ('10A', '10B')
GROUP BY o.sinif;

--5
SELECT COUNT(ogrno) FROM ogrenci 

--6
SELECT COUNT(DISTINCT ad) FROM ogrenci;

--7
SELECT ad, COUNT(ad) FROM ogrenci
GROUP BY ad

--8
SELECT sinif, COUNT(ogrno) FROM ogrenci
GROUP BY sinif;

--9
SELECT o.ad, o.soyad, COUNT(i.kitapno) FROM ogrenci AS o
INNER JOIN islem as i ON o.ogrno= i.ogrno
GROUP BY o.ad, o.soyad; --o.ogrno;

--10
SELECT AVG(puan) FROM kitap;




