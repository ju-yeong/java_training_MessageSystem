1. ȸ�������� ������ ������ �� �ִ� 'web_member'���̺��� ����ÿ�.
   �÷��� : email / pw / tel / address

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

insert into web_message values (web_num.nextval, '�ٳ�������', 'libvio', '�߸Ծ����ϴ�.', sysdate)
insert into web_message values (web_num.nextval, '���ֵ�', '������','����� ��������?',sysdate)

select * from web_message



