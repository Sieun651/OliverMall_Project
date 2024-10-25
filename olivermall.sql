create table users(
    name varchar2(10) not null,     -- 이름
    id varchar2(20) not null,   -- 아이디
    pw varchar2(20)not null,    -- 비밀번호
    tel varchar2(20),       -- 전화번호
    gender varchar2(10),             -- 성별
    birth varchar2(10),        -- 생년월일
    email varchar2(30),             -- 이메일
    primary key (id) 
);  
-- 상품
CREATE TABLE item (
    itemno number(5) PRIMARY KEY,      -- 상품번호
    name VARCHAR2(200) DEFAULT '0',    -- 상품이름
    cost NUMBER(7) DEFAULT 0,          -- 원가
    sale NUMBER(7) DEFAULT 0,          -- 판매가
    profit NUMBER(7) DEFAULT 0,        -- 이익
    discount NUMBER(7) DEFAULT 0,      -- 할인
    -- 상품 카테고리
    kind CHAR(1),                       --  상품 종류(1: 스킨케어, 2:포인트메이크업, 3: 베이스메이크업, 4: 선케어)
    content VARCHAR(200) DEFAULT '0'
);
--SELECT * FROM item WHERE itemno=2;
-- order(주문) 테이블
create table orders (
    orderno varchar2(20) not null,      -- 주문번호
    orderadate varchar2(20) not null,  -- 주문일자
    orderstatus varchar2(20),   -- 주문상태
    itemno NUMBER not null,
    id varchar2(20) not null,
    primary key (orderno),
    constraint fk_item FOREIGN KEY(itemno) REFERENCES item(itemno),
    constraint fk_id FOREIGN KEY(id) REFERENCES users(id)
);
-- 장바구니
create table cart (
    cartno NUMBER(8) PRIMARY KEY,    -- 장바구니 번호
    itemno NUMBER(5),                -- 상품 번호
    quantity NUMBER(5) DEFAULT 1,      -- 재고 수량
    indate DATE DEFAULT SYSDATE,        -- 카트 담은 날짜
    constraint fk_cartitem FOREIGN KEY(itemno) REFERENCES item(itemno)
);
create table review (
    reviewno number,  -- 리뷰 번호
    title varchar2(20), -- 리뷰 제목
    content varchar2(1000), -- 리뷰 내용
    itemno number(5), -- 상품 번호
    id varchar(20), -- 유저 아이디
    regDate date, -- 작성 일자
    primary key(reviewno), 
    constraint fk_reviewitem FOREIGN KEY(itemno) REFERENCES item(itemno),
    constraint fk_reviewuser FOREIGN KEY(id) REFERENCES users(id)
);
create table admin (
  adminid varchar2(20) primary key,
  password varchar2(20) not null
);


---
insert into users values ('테스트', 'test', '1234', '010-1234-5678', '남', '1999-08-15', 'test@naver.com');
insert into users values ('테스트2', 'test2', '1234', '010-1234-5679', '여', '2000-04-15', 'test2@naver.com');
--delete item where itemno = 1;
insert into item values (1, '식물나라 수분 선크림', 10000, 9500, 1000, 500, 4, '뽀얀쌀 생기 선크림\n완벽한 선케어 식물나라 선크림\n백진주쌀 성분이 추가되어 리뉴얼되었습니다.\n기존 사용감과 색상은 동일합니다');
insert into item values (2, '닥터지 수분 수딩 크림', 11000, 9000, 1000, 2000, 1, '진정 강한 수분크림\n모두에게 사랑 받는 1위 크림\n민감피부를 촉촉하게 잠재우는\n저자극 수분 진정 크림');
insert into item values (3, '라네즈 네오 쿠션', 30000, 20000, 1000, 10000, 3, '가볍게 더 빛나게\n네오로 초-밀착\n여전히 얇지만 더 완벽해진\n커버력으로 붉은기 Bye');
insert into item values (4, '클리오 펜슬 아이라이너', 11000, 7000, 1000, 3000, 2, '섬세하고 슬림한\n멀티 라이닝 아이라이너\n원하는 대로 눈매를 연출\n7가지 무드쉐이드\n애교살 컬러 추가');
insert into item values (5, '클리오 킬래쉬 마스카라', 18000, 12000, 1000, 6000, 2, '뭉침 걱정 없이 자연스럽게\n속눈썹 뿌리부터 끝까지 탄탄한 컬\n강하지만 또렷하게 표현해 주는\n킬 래쉬 마스카라 또렷 컬');
insert into item values (6, '클리오 킬브로우 아이브로우', 20000, 17000, 1000, 3000, 2, '쉽고 자연스럽게 킬브로우만의 유일 포뮬러\n내 퍼스널 컬러처럼\n딱 붙는 브로우 컬러\n견고한 강도와 부드러운 발색');
INSERT INTO item VALUES (7,'필리밀리 파워 커링 뷰러', 9500, 8100, 1400, 14, 2, '완만한 커브형 곡선으로\n속눈썹 뿌리부터 깊은 컬링 연출\n숨겨진 1mm를 찾아주는 완벽 곡률\n경도 높은 실리콘으로 눈가자극최소화');
INSERT INTO item VALUES (8,'에뛰드 톤업 수정 선크림', 25000, 19900, 5100, 20, 4, '톤팡질팡, 결망진창인 당신의 피부를 위한\n선크림+베이스를 한 번에 해결해주는\n톤.결.수정 선크림\nSPF50+/PA++++');
INSERT INTO item VALUES(9,'딘토 블러글로이 립 틴트', 20000, 12600, 7400, 37, 2, '끈적임 없는 유리알 광택,\n여리여리한 글로이 틴트\n기분 좋은 산뜻함을 지닌 물먹 립틴트\n첫 발색의 여리함을 오래 유지합니다.');
INSERT INTO item VALUES(10, '브링그린 세럼마스크',3000,1500,1500, 50, 1, '3일 세럼이 시트 한 장에!\n3일 세럼 마스크\n피부에 닿는 순간부터 시작되는 즉각 고민 개선 효과\n예민 피부 S.O.S');
INSERT INTO item VALUES(11, '클리오 수퍼프루프 라이너', 18000, 12600, 5400, 30,2, '번짐 걱정 없이 깔끔하게!\n특수 필름 포머를 사용하여, 아이라인을 그린 후에도\n번짐 걱정 없이 선명하게!');

INSERT INTO orders VALUES ('Y230998','2024-01-09', '구매확정', 1, 'test'); 
INSERT INTO orders VALUES ('Y567889', '2024-02-22', '구매확정',3, 'test'); 
INSERT INTO orders VALUES ('Y267889', '2024-04-22', '구매확정',6, 'test'); 
INSERT INTO orders VALUES ('Z987547', '2024-05-06', '배송중',4, 'test');
INSERT INTO orders VALUES ('Q678904', '2024-05-05', '배송완료',5, 'test');
INSERT INTO orders VALUES ('Q678907', '2024-05-05', '배송중',10, 'test');
INSERT INTO orders VALUES ('Q678917', '2024-05-09', '배송중',7, 'test2');
INSERT INTO orders VALUES ('Y254900', '2024-01-19', '구매확정',4, 'test2');
INSERT INTO orders VALUES ('Z300912', '2024-02-14', '구매확정',11, 'test2');
-- select * from item;
commit;