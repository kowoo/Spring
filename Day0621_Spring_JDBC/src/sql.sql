select * from member;
drop table member;
create table member(
    num number(10),
    gender varchar2(10),
    name varchar2(20),
    age number(10));
commit;

select * from message;
desc message;

drop table message;

create table message (
    id number(10) not null,
    password varchar2(50) not null,
    name varchar2(30),
    message varchar2(500)
);