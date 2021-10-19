create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

select * from fauna;

insert into fauna(name, avg_age, discovery_date)
values ('Уж', 100, date '2000-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('Белка', 200, date '1000-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('Лев', 1000, date '1100-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('Слон', 50, date '2020-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('Кит', 300, date '100-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('Змея', 400, date '200-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('рыба_fish', 400, date '200-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('осетр_fish', 400, date '200-09-01');

insert into fauna(name, avg_age, discovery_date)
values ('Змея1', 10100, date '200-09-01');
insert into fauna(name, avg_age, discovery_date)
values ('Змея2', 20100, date '200-09-01');

insert into fauna(name, avg_age, discovery_date)
values ('Змея3', 1010, null);
insert into fauna(name, avg_age, discovery_date)
values ('Змея4', 2010, null);


1) Извлечение данных, у которых имя name содержит подстроку fish
select * from fauna where name like '%fish%' ;
2) Извлечение данных, у которых сред. 
продолжительность жизни находится в диапазоне 10 000 и 21 000
select * from fauna where avg_age > 10000 and avg_age < 21000;
3) Извлечение данных, у которых дата открытия не известна (null)
select * from fauna where discovery_date is null;
4) Извлечение данных видов, у которых дата открытия раньше 1950 года
select * from fauna where discovery_date < '1950-01-01';