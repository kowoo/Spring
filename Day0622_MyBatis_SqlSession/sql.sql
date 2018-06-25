create table board(
    num number primary key,
    title varchar2(50) not null,
    name varchar2(30),
    pass varchar2(30),
    email varchar2(50),
    content varchar2(500),
    readCount number default 0,
    writeDate Date default sysdate
);

create table board(
    num number,
    title varchar2(50),
    name varchar2(30),
    password varchar2(30),
    email varchar2(50),
    content varchar2(500),
    readCount number,
    writeDate Date
);

drop table board;
commit;
select * from board;

create sequence board_seq start with 1 increment by 1 maxvalue 9999 cycle;
desc board_seq;

select * from student;
select * from message;
select * from member;

