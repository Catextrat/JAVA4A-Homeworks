-- 26. Stokta bulunmayan ürünlerin ürün listesiyle birlikte tedarikçilerin ismi ve iletişim numarasını (`ProductID`, `ProductName`, `CompanyName`, `Phone`) almak için bir sorgu yazın.

SELECT p.product_id AS ProductID, p.product_name AS ProductName, s.company_name AS CompanyName, s.phone AS Phone FROM products p
INNER JOIN suppliers s ON p.supplier_id = s.supplier_id
WHERE p.units_in_stock = 0;
 
-- 27. 1998 yılı mart ayındaki siparişlerimin adresi, siparişi alan çalışanın adı, çalışanın soyadı

SELECT o.order_id, o.ship_address AS Address, e.first_name AS EmployeeFirstName, e.last_name AS EmployeeLastName FROM orders o
JOIN employees e ON o.employee_id = e.employee_id
WHERE EXTRACT(YEAR FROM order_date) = 1998 AND EXTRACT(MONTH FROM order_date) = 3;

-- 28. 1997 yılı şubat ayında kaç siparişim var?

SELECT COUNT(*) AS num_orders FROM orders
WHERE EXTRACT(YEAR FROM order_date) = 1997 AND EXTRACT(MONTH FROM order_date) = 2;

-- 29. London şehrinden 1998 yılında kaç siparişim var?

SELECT COUNT(*) AS num_orders
FROM orders o
JOIN customers c ON o.customer_id = c.customer_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1998 AND c.city = 'London';

-- 30. 1997 yılında sipariş veren müşterilerimin contactname ve telefon numarası

SELECT DISTINCT c.contact_name, c.phone FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997;

-- 31. Taşıma ücreti 40 üzeri olan siparişlerim

SELECT * FROM orders WHERE freight > 40;

-- 32. Taşıma ücreti 40 ve üzeri olan siparişlerimin şehri, müşterisinin adı

SELECT o.ship_city AS City, c.company_name AS CustomerName FROM orders o
JOIN customers c ON o.customer_id = c.customer_id
WHERE o.freight >= 40;

-- 33. 1997 yılında verilen siparişlerin tarihi, şehri, çalışan adı -soyadı ( ad soyad birleşik olacak ve büyük harf),

SELECT o.order_date AS "Tarih", o.ship_city AS "Şehir", CONCAT(UPPER(e.first_name), ' ', UPPER(e.last_name)) AS "Çalışan Adı-Soyadı" FROM orders o
JOIN employees e ON o.employee_id = e.employee_id WHERE EXTRACT(YEAR FROM o.order_date) = 1997;

-- 34. 1997 yılında sipariş veren müşterilerin contactname i, ve telefon numaraları ( telefon formatı 2223322 gibi olmalı )

SELECT DISTINCT c.contact_name AS "İletişim Adı", REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(c.phone, '(', ''), ')', ''), '-', ''), ' ', ''), '+', '') 
AS "Telefon Numarası" FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997;

-- 35. Sipariş tarihi, müşteri contact name, çalışan ad, çalışan soyad

SELECT o.order_date AS "Sipariş Tarihi", c.contact_name AS "Müşteri İletişim Adı", e.first_name AS "Çalışan Adı", e.last_name AS "Çalışan Soyadı"
FROM orders o
JOIN customers c ON o.customer_id = c.customer_id
JOIN employees e ON o.employee_id = e.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997;

-- 36. Geciken siparişlerim?

SELECT * FROM orders WHERE shipped_date > required_date;

-- 37. Geciken siparişlerimin tarihi, müşterisinin adı

SELECT o.order_date AS "Sipariş Tarihi", c.contact_name AS "Müşteri Adı" FROM orders o
JOIN customers c ON o.customer_id = c.customer_id WHERE o.shipped_date > o.required_date;


-- 38. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi

SELECT p.product_name AS "Ürün Adı", c.category_name AS "Kategori Adı", od.quantity AS "Adet" FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE o.order_id = 10248;

-- 39. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı

SELECT p.product_name, s.company_name AS supplier_name FROM order_details od
JOIN products p ON od.product_id = p.product_id
JOIN suppliers s ON p.supplier_id = s.supplier_id
WHERE od.order_id = 10248;

-- 40. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti

SELECT p.product_name, SUM(od.quantity) AS total_quantity FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN employees e ON o.employee_id = e.employee_id
WHERE e.employee_id = 3 AND EXTRACT(YEAR FROM o.order_date) = 1997 GROUP BY p.product_name;

-- 41. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad

SELECT e.employee_id, e.first_name || ' ' || e.last_name AS employee_name, COUNT(o.order_id) AS total_orders FROM employees e
JOIN orders o ON e.employee_id = o.employee_id 
WHERE EXTRACT(YEAR FROM o.order_date) = 1997 GROUP BY e.employee_id, e.first_name, e.last_name ORDER BY COUNT(o.order_id) DESC
LIMIT 1;

-- 42. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad **** 

SELECT e.employee_id, e.first_name || ' ' || e.last_name AS employee_name, COUNT(o.order_id) AS total_orders
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY COUNT(o.order_id) DESC
LIMIT 1;

-- 43. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?

SELECT p.product_name, p.unit_price, c.category_name
FROM products p
JOIN categories c ON p.category_id = c.category_id
ORDER BY p.unit_price DESC
LIMIT 1;

-- 44. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre

SELECT e.first_name, e.last_name, o.order_date, o.order_id FROM orders o
JOIN employees e ON o.employee_id = e.employee_id
ORDER BY o.order_date;

-- 45. Son 5 siparişimin ortalama fiyatı ve orderid nedir?

SELECT AVG(od.unit_price * od.quantity) AS average_price, o.order_id FROM orders o
JOIN order_details od ON o.order_id = od.order_id
GROUP BY o.order_id
ORDER BY o.order_date DESC
LIMIT 5;

-- 46. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?

SELECT p.product_name, c.category_name, SUM(od.quantity) AS total_sales FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE EXTRACT(MONTH FROM o.order_date) = 1 -- Ocak ayı
AND EXTRACT(YEAR FROM o.order_date) = EXTRACT(YEAR FROM CURRENT_DATE) -- Aktif yıl
GROUP BY p.product_name, c.category_name;

-- 47. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?

WITH average_sales AS (SELECT AVG(quantity) AS avg_sales FROM order_details)
SELECT od.order_id, od.quantity
FROM order_details od
CROSS JOIN average_sales
WHERE od.quantity > (SELECT avg_sales FROM average_sales);

-- 48. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı

SELECT p.product_name, c.category_name, s.company_name AS supplier_name FROM products p
JOIN categories c ON p.category_id = c.category_id
JOIN suppliers s ON p.supplier_id = s.supplier_id
JOIN (SELECT product_id, SUM(quantity) AS total_quantity FROM order_details GROUP BY product_id ORDER BY total_quantity DESC LIMIT 1) 
AS top_product ON p.product_id = top_product.product_id;

-- 49. SELECT COUNT(DISTINCT country) AS country_count FROM customers;
 
-- 50. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?

SELECT SUM(od.quantity * od.unit_price) AS total_sales FROM orders o
JOIN order_details od ON o.order_id = od.order_id
WHERE o.employee_id = 3
AND o.order_date >= DATE_TRUNC('month', CURRENT_DATE) 
AND o.order_date <= CURRENT_DATE;

-- 51. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi

SELECT p.product_name, c.category_name, od.quantity FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE o.order_id = 10248;

-- 52. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı


SELECT p.product_name, s.company_name AS supplier_name FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN suppliers s ON p.supplier_id = s.supplier_id
WHERE o.order_id = 10248;

-- 53. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti

SELECT p.product_name, od.quantity FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
WHERE o.employee_id = 3
AND EXTRACT(YEAR FROM o.order_date) = 1997;

-- 54. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad

SELECT e.employee_id, e.first_name || ' ' || e.last_name AS employee_name, COUNT(o.order_id) AS total_orders
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY COUNT(o.order_id) DESC
LIMIT 1;

-- 55. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****

SELECT e.employee_id, e.first_name || ' ' || e.last_name AS employee_name, COUNT(o.order_id) AS total_orders
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY COUNT(o.order_id) DESC
LIMIT 1;

-- 56. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?

SELECT p.product_name, p.unit_price, c.category_name FROM products p
JOIN categories c ON p.category_id = c.category_id
ORDER BY p.unit_price DESC
LIMIT 1;

-- 57. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre

SELECT e.first_name, e.last_name, o.order_date, o.order_id FROM orders o
JOIN employees e ON o.employee_id = e.employee_id
ORDER BY o.order_date;

-- 58. SON 5 siparişimin ortalama fiyatı ve orderid nedir?

SELECT AVG(od.unit_price * od.quantity) AS average_price, o.order_id FROM orders o
JOIN order_details od ON o.order_id = od.order_id
GROUP BY o.order_id ORDER BY o.order_date DESC
LIMIT 5;

-- 59. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?

SELECT p.product_name, c.category_name, SUM(od.quantity) AS total_sales FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
WHERE EXTRACT(MONTH FROM o.order_date) = 1 -- Ocak ayı
AND EXTRACT(YEAR FROM o.order_date) = EXTRACT(YEAR FROM CURRENT_DATE) -- Aktif yıl
GROUP BY p.product_name, c.category_name;

-- 60. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?

WITH average_sales AS (SELECT AVG(quantity) AS avg_sales FROM order_details)
SELECT od.order_id, od.quantity
FROM order_details od
CROSS JOIN average_sales
WHERE od.quantity > (SELECT avg_sales FROM average_sales);

-- 61. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı

SELECT p.product_name, c.category_name, s.company_name AS supplier_name FROM products p
JOIN categories c ON p.category_id = c.category_id
JOIN suppliers s ON p.supplier_id = s.supplier_id
JOIN (SELECT product_id, SUM(quantity) AS total_quantity FROM order_details GROUP BY product_id ORDER BY total_quantity DESC LIMIT 1)
AS top_product ON p.product_id = top_product.product_id;

-- 62. Kaç ülkeden müşterim var

SELECT COUNT(DISTINCT country) AS country_count FROM customers;

-- 63. Hangi ülkeden kaç müşterimiz var

SELECT country, COUNT(*) AS customer_count FROM customers
GROUP BY country ORDER BY customer_count DESC;

-- 64. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?

SELECT SUM(od.quantity * od.unit_price) AS total_sales FROM orders o
JOIN order_details od ON o.order_id = od.order_id
WHERE o.employee_id = 3
AND o.order_date >= DATE_TRUNC('month', CURRENT_DATE) AND o.order_date <= CURRENT_DATE;

-- 65. 10 numaralı ID ye sahip ürünümden son 3 ayda ne kadarlık ciro sağladım?

SELECT SUM(od.quantity * od.unit_price) AS total_revenue FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id WHERE p.product_id = 10
AND o.order_date >= DATE_TRUNC('month', CURRENT_DATE - INTERVAL '2 month') 
AND o.order_date <= CURRENT_DATE;

-- 66. Hangi çalışan şimdiye kadar toplam kaç sipariş almış..?

SELECT e.employee_id, e.first_name, e.last_name, COUNT(o.order_id) AS total_orders FROM employees e
LEFT JOIN orders o ON e.employee_id = o.employee_id
GROUP BY e.employee_id, e.first_name, e.last_name ORDER BY total_orders DESC;

-- 67. 91 müşterim var. Sadece 89’u sipariş vermiş. Sipariş vermeyen 2 kişiyi bulun

SELECT customer_id, company_name FROM customers
WHERE customer_id NOT IN (SELECT DISTINCT customer_id FROM orders);

-- 68. Brazil’de bulunan müşterilerin Şirket Adı, TemsilciAdi, Adres, Şehir, Ülke bilgileri

SELECT company_name, contact_name AS representative_name, address, city, country
FROM customers WHERE country = 'Brazil';

-- 69. Brezilya’da olmayan müşteriler

SELECT company_name, country FROM customers
WHERE country != 'Brazil' OR country IS NULL;

-- 70. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler

SELECT company_name, country FROM customers
WHERE country IN ('Spain', 'France', 'Germany');

-- 71. Faks numarasını bilmediğim müşteriler

SELECT company_name, fax FROM customers
WHERE fax IS NULL OR fax = '';

-- 72. Londra’da ya da Paris’de bulunan müşterilerim

SELECT company_name, city FROM customers
WHERE city IN ('London', 'Paris');

-- 73. Hem Mexico D.F’da ikamet eden HEM DE ContactTitle bilgisi ‘owner’ olan müşteriler

SELECT company_name, city, contact_title FROM customers
WHERE city = 'Mexico D.F' AND contact_title = 'Owner';
 
-- 74. C ile başlayan ürünlerimin isimleri ve fiyatları

SELECT product_name, unit_price FROM products
WHERE product_name LIKE 'C%'

-- 75. Adı (FirstName) ‘A’ harfiyle başlayan çalışanların (Employees); Ad, Soyad ve Doğum Tarihleri

SELECT first_name AS ad, last_name AS soyad, birth_date AS doğum_tarihi
FROM employees WHERE first_name LIKE 'A%';

-- 76. İsminde ‘RESTAURANT’ geçen müşterilerimin şirket adları

SELECT company_name FROM customers WHERE company_name LIKE '%RESTAURANT%';

-- 77. 50$ ile 100$ arasında bulunan tüm ürünlerin adları ve fiyatları

SELECT product_name, unit_price FROM products WHERE unit_price BETWEEN 50 AND 100;

-- 78. 1 temmuz 1996 ile 31 Aralık 1996 tarihleri arasındaki siparişlerin (Orders), SiparişID (OrderID) ve SiparişTarihi (OrderDate) bilgileri

SELECT order_id AS "Sipariş ID", order_date AS "Sipariş Tarihi" FROM orders
WHERE order_date BETWEEN '1996-07-01' AND '1996-12-31';

-- 79. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler

SELECT * FROM customers WHERE country IN ('Spain', 'France', 'Germany');

-- 80. Faks numarasını bilmediğim müşteriler

SELECT * FROM customers WHERE fax IS NULL OR fax = '';

-- 81. Müşterilerimi ülkeye göre sıralıyorum:

SELECT * FROM customers ORDER BY country;

-- 82. Ürünlerimi en pahalıdan en ucuza doğru sıralama, sonuç olarak ürün adı ve fiyatını istiyoruz

SELECT product_name, unit_price FROM products ORDER BY unit_price DESC;

-- 83. Ürünlerimi en pahalıdan en ucuza doğru sıralasın, ama stoklarını küçükten-büyüğe doğru göstersin sonuç olarak ürün adı ve fiyatını istiyoruz

SELECT product_name, unit_price FROM products ORDER BY unit_price DESC, units_in_stock ASC;

-- 84. 1 Numaralı kategoride kaç ürün vardır..?

SELECT COUNT(*) AS num_of_products FROM products WHERE category_id = 1;

-- 85. Kaç farklı ülkeye ihracat yapıyorum..?

SELECT COUNT(DISTINCT country) AS num_of_countries FROM customers;

-- 86. Bu ülkeler hangileri..?

SELECT DISTINCT country FROM customers;

-- 87. En Pahalı 5 ürün

SELECT product_name, unit_price FROM products ORDER BY unit_price DESC
LIMIT 5;

-- 88. ALFKI CustomerID’sine sahip müşterimin sipariş sayısı..?

SELECT COUNT(*) AS num_orders FROM orders WHERE customer_id = 'ALFKI';

-- 89. Ürünlerimin toplam maliyeti

SELECT SUM(unit_price * units_in_stock) AS total_cost FROM products;

-- 90. Şirketim, şimdiye kadar ne kadar ciro yapmış..?

SELECT SUM(od.unit_price * od.quantity) AS total_revenue FROM order_details od
INNER JOIN orders o ON od.order_id = o.order_id;

-- 91. Ortalama ürün fiyatım

SELECT AVG(unit_price) AS average_price FROM products;

-- 92. En Pahalı Ürünün Adı

SELECT product_name FROM products ORDER BY unit_price DESC LIMIT 1;

-- 93. En az kazandıran sipariş

SELECT o.order_id, SUM(od.unit_price * od.quantity) AS total_price FROM orders o
JOIN order_details od ON o.order_id = od.order_id
GROUP BY o.order_id ORDER BY total_price ASC LIMIT 1;

-- 94. Müşterilerimin içinde en uzun isimli müşteri

SELECT company_name FROM customers ORDER BY LENGTH(company_name) DESC LIMIT 1;

-- 95. Çalışanlarımın Ad, Soyad ve Yaşları

SELECT first_name AS ad, last_name AS soyad, DATE_PART('year', AGE(CURRENT_DATE, birth_date)) AS yas FROM employees;

-- 96. Hangi üründen toplam kaç adet alınmış..?

SELECT product_id, SUM(quantity) AS total_quantity FROM order_details GROUP BY product_id;

-- 97. Hangi siparişte toplam ne kadar kazanmışım..?

SELECT order_id, SUM(unit_price * quantity) AS total_revenue FROM order_details GROUP BY order_id;

-- 98. Hangi kategoride toplam kaç adet ürün bulunuyor..?

SELECT category_id, COUNT(*) AS total_products FROM products GROUP BY category_id;

-- 99. 1000 Adetten fazla satılan ürünler?

SELECT product_id, SUM(quantity) AS total_quantity FROM order_details GROUP BY product_id
HAVING SUM(quantity) > 1000;

-- 100. Hangi Müşterilerim hiç sipariş vermemiş..?

SELECT c.customer_id, c.company_name FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id WHERE o.customer_id IS NULL;