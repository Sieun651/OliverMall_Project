create table users(
    name varchar2(10) not null,     -- �̸�
    id varchar2(20) not null,   -- ���̵�
    pw varchar2(20)not null,    -- ��й�ȣ
    tel varchar2(20),       -- ��ȭ��ȣ
    gender varchar2(10),             -- ����
    birth varchar2(10),        -- �������
    email varchar2(30),             -- �̸���
    primary key (id) 
);  
-- ��ǰ
CREATE TABLE item (
    itemno number(5) PRIMARY KEY,      -- ��ǰ��ȣ
    name VARCHAR2(200) DEFAULT '0',    -- ��ǰ�̸�
    cost NUMBER(7) DEFAULT 0,          -- ����
    sale NUMBER(7) DEFAULT 0,          -- �ǸŰ�
    profit NUMBER(7) DEFAULT 0,        -- ����
    discount NUMBER(7) DEFAULT 0,      -- ����
    -- ��ǰ ī�װ�
    kind CHAR(1),                       --  ��ǰ ����(1: ��Ų�ɾ�, 2:����Ʈ����ũ��, 3: ���̽�����ũ��, 4: ���ɾ�)
    content VARCHAR(200) DEFAULT '0'
);
--SELECT * FROM item WHERE itemno=2;
-- order(�ֹ�) ���̺�
create table orders (
    orderno varchar2(20) not null,      -- �ֹ���ȣ
    orderadate varchar2(20) not null,  -- �ֹ�����
    orderstatus varchar2(20),   -- �ֹ�����
    itemno NUMBER not null,
    id varchar2(20) not null,
    primary key (orderno),
    constraint fk_item FOREIGN KEY(itemno) REFERENCES item(itemno),
    constraint fk_id FOREIGN KEY(id) REFERENCES users(id)
);
-- ��ٱ���
create table cart (
    cartno NUMBER(8) PRIMARY KEY,    -- ��ٱ��� ��ȣ
    itemno NUMBER(5),                -- ��ǰ ��ȣ
    quantity NUMBER(5) DEFAULT 1,      -- ��� ����
    indate DATE DEFAULT SYSDATE,        -- īƮ ���� ��¥
    constraint fk_cartitem FOREIGN KEY(itemno) REFERENCES item(itemno)
);
create table review (
    reviewno number,  -- ���� ��ȣ
    title varchar2(20), -- ���� ����
    content varchar2(1000), -- ���� ����
    itemno number(5), -- ��ǰ ��ȣ
    id varchar(20), -- ���� ���̵�
    regDate date, -- �ۼ� ����
    primary key(reviewno), 
    constraint fk_reviewitem FOREIGN KEY(itemno) REFERENCES item(itemno),
    constraint fk_reviewuser FOREIGN KEY(id) REFERENCES users(id)
);
create table admin (
  adminid varchar2(20) primary key,
  password varchar2(20) not null
);


---
insert into users values ('�׽�Ʈ', 'test', '1234', '010-1234-5678', '��', '1999-08-15', 'test@naver.com');
insert into users values ('�׽�Ʈ2', 'test2', '1234', '010-1234-5679', '��', '2000-04-15', 'test2@naver.com');
--delete item where itemno = 1;
insert into item values (1, '�Ĺ����� ���� ��ũ��', 10000, 9500, 1000, 500, 4, '�Ǿ�� ���� ��ũ��\n�Ϻ��� ���ɾ� �Ĺ����� ��ũ��\n�����ֽ� ������ �߰��Ǿ� ������Ǿ����ϴ�.\n���� ��밨�� ������ �����մϴ�');
insert into item values (2, '������ ���� ���� ũ��', 11000, 9000, 1000, 2000, 1, '���� ���� ����ũ��\n��ο��� ��� �޴� 1�� ũ��\n�ΰ��Ǻθ� �����ϰ� ������\n���ڱ� ���� ���� ũ��');
insert into item values (3, '����� �׿� ���', 30000, 20000, 1000, 10000, 3, '������ �� ������\n�׿��� ��-����\n������ ������ �� �Ϻ�����\nĿ�������� ������ Bye');
insert into item values (4, 'Ŭ���� �潽 ���̶��̳�', 11000, 7000, 1000, 3000, 2, '�����ϰ� ������\n��Ƽ ���̴� ���̶��̳�\n���ϴ� ��� ���Ÿ� ����\n7���� ���彦�̵�\n�ֱ��� �÷� �߰�');
insert into item values (5, 'Ŭ���� ų���� ����ī��', 18000, 12000, 1000, 6000, 2, '��ħ ���� ���� �ڿ�������\n�Ӵ��� �Ѹ����� ������ źź�� ��\n�������� �Ƿ��ϰ� ǥ���� �ִ�\nų ���� ����ī�� �Ƿ� ��');
insert into item values (6, 'Ŭ���� ų��ο� ���̺�ο�', 20000, 17000, 1000, 3000, 2, '���� �ڿ������� ų��ο츸�� ���� ���ķ�\n�� �۽��� �÷�ó��\n�� �ٴ� ��ο� �÷�\n�߰��� ������ �ε巯�� �߻�');
INSERT INTO item VALUES (7,'�ʸ��и� �Ŀ� Ŀ�� �䷯', 9500, 8100, 1400, 14, 2, '�ϸ��� Ŀ���� �����\n�Ӵ��� �Ѹ����� ���� �ø� ����\n������ 1mm�� ã���ִ� �Ϻ� ���\n�浵 ���� �Ǹ������� �����ڱ��ּ�ȭ');
INSERT INTO item VALUES (8,'���ٵ� ��� ���� ��ũ��', 25000, 19900, 5100, 20, 4, '��������, �����â�� ����� �Ǻθ� ����\n��ũ��+���̽��� �� ���� �ذ����ִ�\n��.��.���� ��ũ��\nSPF50+/PA++++');
INSERT INTO item VALUES(9,'���� ���۷��� �� ƾƮ', 20000, 12600, 7400, 37, 2, '������ ���� ������ ����,\n���������� �۷��� ƾƮ\n��� ���� ������� ���� ���� ��ƾƮ\nù �߻��� �������� ���� �����մϴ�.');
INSERT INTO item VALUES(10, '�긵�׸� ��������ũ',3000,1500,1500, 50, 1, '3�� ������ ��Ʈ �� �忡!\n3�� ���� ����ũ\n�Ǻο� ��� �������� ���۵Ǵ� �ﰢ ��� ���� ȿ��\n���� �Ǻ� S.O.S');
INSERT INTO item VALUES(11, 'Ŭ���� ���������� ���̳�', 18000, 12600, 5400, 30,2, '���� ���� ���� ����ϰ�!\nƯ�� �ʸ� ���Ӹ� ����Ͽ�, ���̶����� �׸� �Ŀ���\n���� ���� ���� �����ϰ�!');

INSERT INTO orders VALUES ('Y230998','2024-01-09', '����Ȯ��', 1, 'test'); 
INSERT INTO orders VALUES ('Y567889', '2024-02-22', '����Ȯ��',3, 'test'); 
INSERT INTO orders VALUES ('Y267889', '2024-04-22', '����Ȯ��',6, 'test'); 
INSERT INTO orders VALUES ('Z987547', '2024-05-06', '�����',4, 'test');
INSERT INTO orders VALUES ('Q678904', '2024-05-05', '��ۿϷ�',5, 'test');
INSERT INTO orders VALUES ('Q678907', '2024-05-05', '�����',10, 'test');
INSERT INTO orders VALUES ('Q678917', '2024-05-09', '�����',7, 'test2');
INSERT INTO orders VALUES ('Y254900', '2024-01-19', '����Ȯ��',4, 'test2');
INSERT INTO orders VALUES ('Z300912', '2024-02-14', '����Ȯ��',11, 'test2');
-- select * from item;
commit;