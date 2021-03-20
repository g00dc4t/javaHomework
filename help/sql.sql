-- primer ot prepoda (nerabochaya huita)
SELECT name as course_name,
COUNT(student_name) / (SELECT COUNT(DISTINCT MONTH(subscription_date)) FROM purchaselist) as avg_count 
FROM courses
JOIN purchaselist ON courses.name = purchaselist.course_name
GROUP BY courses.name
ORDER BY subscription_date;

-- moy variant resheniya
SELECT course_name,COUNT(course_name) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) AS avg_number_purchase_at_month 
FROM purchaselist 
GROUP BY 1;

-- perviy variant resheniya normVlada (wrong)
SELECT course_name,COUNT(course_name) / TIMESTAMPDIFF(MONTH,min(subscription_date),max(subscription_date)) AS Month 
FROM purchaselist 
GROUP BY course_name;

-- vtoroy variant resheniya normVlada (right)
SELECT name AS Courses,
SUM(Grp.count_all) / COUNT(Grp.date) AS AVG_inMonth 
FROM Courses 
JOIN (SELECT course_name, MONTH(subscription_date) date, COUNT(*) count_all FROM PurchaseList GROUP BY course_name, date) Grp ON name = course_name
GROUP BY name;

