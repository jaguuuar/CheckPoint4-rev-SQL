select name from customers where gender = 'Female';

select round(sum(net_value + (net_value * tax_rate/100)), 2)  as money_spent from sales;

select * from customers where strftime('%Y','now') - birthyear  > 18;

select * from customers order by surname;

select * from sales where product_name like '%a%';

select * from sales where net_value > 500;

select count(*) as Total_number_of_customers from customers;

select count(*) as Total_number_of_sales from sales;

select round(sum(net_value + (net_value * tax_rate/100)), 2)  as money_spent_by_customer_7 from sales where customer_id = 7;

select 
	Customers.name, customers.id,
	round(sum(Sales.net_value + (Sales.net_value * tax_rate)/ 100), 2) as money_spent
from Customers
	inner join Sales on Customers.id = Sales.customer_id
group by Customers.id;









