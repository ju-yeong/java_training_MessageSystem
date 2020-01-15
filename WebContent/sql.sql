1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : email / pw / tel / address

drop table web_member;

create table web_member(
	email varchar2(100) primary key, 
	pw varchar2(100) not null,
	tel varchar2(100),
	address varchar2(200)
)


select * from web_member;


drop table web_message;

create table web_message(
	num number,
	send_name varchar2(100),
	receive_email varchar2(100),
	content varchar2(1000),
	day date
)


create sequence web_num start with 1 increment by 1

insert into web_message values (web_num.nextval, '바나나우유', 'libvio', '잘먹었습니다.', sysdate)
insert into web_message values (web_num.nextval, '오주돋', '오코은','우엉차 먹을래요?',sysdate)

select * from web_message



