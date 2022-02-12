CREATE TABLE BANK
(
    BANK_ID   uuid,
    BANK_NAME varchar(255),
    PRIMARY KEY (BANK_ID)
);
INSERT INTO BANK (BANK_ID, BANK_NAME)
values ('11a80fb6-1ca4-435c-8fb3-2215d145db41', 'Первый банк'),
       ('21a80fb6-1ca4-435c-8fb3-2215d145db41', 'Второй банк'),
       ('31a80fb6-1ca4-435c-8fb3-2215d145db41', 'Третий банк'),
       ('41a80fb6-1ca4-435c-8fb3-2215d145db41', 'Четвертый банк');

CREATE TABLE CREDIT
(
    CREDIT_ID         uuid not null,
    TYPE_OF_CREDIT    varchar(255),
    LIMIT_OF_MONEY    numeric(19, 2),
    CREDIT_PERCENTAGE numeric(19, 2),
    PRIMARY KEY (CREDIT_ID),
    BANK_ID           uuid
        CONSTRAINT FK_CREDIT_BANK_ID REFERENCES BANK (BANK_ID)

);
INSERT INTO CREDIT (CREDIT_ID, TYPE_OF_CREDIT, LIMIT_OF_MONEY, CREDIT_PERCENTAGE, BANK_ID)

values ('51a10fb6-1ca7-435c-8fb3-2215d145db41', 'Ипотека', 18000000, 8, '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('61a20fb6-1ca8-435c-8fb3-2215d135db41', 'Микро займ', 800000, 30, '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('71a30fb6-1ca3-435c-8fb3-2215d245db41', 'Авто кредит', 20000000, 15, '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('81a40fb6-1ca1-435c-8fb3-2215d745db41', 'Кредит на ремонт', 150000, 6, '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('51a80fb6-1ca9-425c-8fb3-2315d145db41', 'Ипотека', 19000000, 10, '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('61a80fb6-1ca4-415c-8fb3-2615d145db41', 'Микро займ', 700000, 32, '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('71a80fb6-1ca4-495c-8fb3-2715d145db41', 'Авто кредит', 10000000, 25, '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('81a80fb6-1ca4-435c-8fb3-2815d145db41', 'Кредит на ремонт', 160000, 7, '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('51a80fb6-1ca4-435c-8fb3-2215d195db41', 'Ипотека', 19000000, 9, '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('61a80fb6-1ca4-435c-8fb3-2215d155db41', 'Микро займ', 900000, 27, '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('71a80fb6-1ca4-435c-8fb3-2215d115db41', 'Авто кредит', 20000000, 21, '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('81a80fb6-1ca4-435c-8fb3-2215d125db41', 'Кредит на ремонт', 160000, 9, '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('51a20fb6-1ca4-435c-8fb3-2215d145db41', 'Ипотека', 19000000, 11, '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('61a30fb6-1ca4-435c-8fb3-2215d145db41', 'Микро займ', 900000, 28, '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('71a40fb6-1ca4-435c-8fb3-2215d145db41', 'Авто кредит', 20000000, 16, '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('81a50fb6-1ca4-435c-8fb3-2215d145db41', 'Кредит на ремонт', 160000, 8, '41a80fb6-1ca4-435c-8fb3-2215d145db41');


CREATE TABLE CLIENT
(
    CLIENT_ID       uuid,
    LAST_NAME       varchar(255),
    FIRST_NAME      varchar(255),
    MIDDLE_NAME     varchar(255),
    PHONE_NUMBER    varchar(255),
    EMAIL           varchar(255),
    PASSPORT_NUMBER varchar(255),
    PRIMARY KEY (CLIENT_ID),
    BANK_ID         uuid
        CONSTRAINT FK_CLIENT_BANK_ID REFERENCES BANK (BANK_ID)


);

INSERT INTO CLIENT(CLIENT_ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, PHONE_NUMBER, EMAIL, PASSPORT_NUMBER, BANK_ID)

values ('91a80fb6-1ca4-435c-8fb3-3215d145db41', 'Климов', 'Денис', 'Владимирович', '89123456789',
        'klimov-dimi@gmail.com', '7656-998273', '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('91a80fb6-1ca4-435c-8fb3-1215d145db41', 'Климов', 'Андрей', 'Владиславович', '89123456789',
        'klimov-vladislavovich@gmail.com', '7656-998274', '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('91a80fb6-1ca4-435c-8fb3-2215d145db41', 'Климов', 'Евгений', 'Александрович', '89123456789',
        'klimov-jeka@gmail.com', '7656-998275', '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('91a80fb6-1ca4-435c-8fb3-4214d145db41', 'Климов', 'Петя', 'Петрович', '89123456789',
        'klimov-petrynya@gmail.com', '7656-998276', '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('91a80fb6-1ca4-435c-8fb3-8213d145db41', 'Климов', 'Илья', 'Кириллович', '89123456789', 'klimov-ilya@gmail.com',
        '7656-998263', '11a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('62a80fb6-1ca4-435c-8fb3-2115d145db41', 'Климов', 'Евгений', 'Евгеньевич', '89123456789',
        'klimov-evgenya@gmail.com', '7656-998277', '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('62a80fb6-1ca4-435c-8fb3-2815d145db41', 'Климов', 'Макс', 'Максимов', '89123456789', 'klimov-maks@gmail.com',
        '7656-998278', '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('62a80fb6-1ca4-435c-8fb3-2715d145db41', 'Климов', 'Игорь', 'Игоревич', '89123456789', 'klimov-igor@gmail.com',
        '7656-998279', '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('62a80fb6-1ca4-435c-8fb3-2315d145db41', 'Климов', 'Фома', 'Фомович', '89123456789', 'klimov-fedya@gmail.com',
        '7656-992273', '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('62a80fb6-1ca4-435c-8fb3-1215d145db41', 'Климов', 'Василий', 'Денисович', '89123456789',
        'klimov-vasya@gmail.com', '7656-991273', '21a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('73a90fb6-1ca4-435c-8fb3-9215d145db41', 'Климов', 'Владимир', 'Сергеевич', '89123456789',
        'klimov-vladimir@gmail.com', '7656-998273', '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('73a10fb6-1ca4-435c-8fb3-4215d145db41', 'Климов', 'Андре', 'Мазгенович', '89123456789', 'klimov-mozg@gmail.com',
        '7656-998253', '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('73a30fb6-1ca4-435c-8fb3-3215d145db41', 'Климов', 'Дмитрий', 'Сергеевич', '89123456789',
        'klimov-sergeyevich@gmail.com', '7656-998243', '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('73a20fb6-1ca4-435c-8fb3-1215d145db41', 'Климов', 'Иван', 'Андреевич', '89123456789',
        'klimov-andreyevich@gmail.com', '7656-998233', '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('73a50fb6-1ca4-435c-6fb3-9215d145db41', 'Климов', 'Глеб', 'Глебович', '89123456789', 'klimov-gleb@gmail.com',
        '7656-998223', '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('73a60fb6-1ca4-435c-8fb3-8215d145db41', 'Климов', 'Клим', 'Константинович', '89123456789',
        'klimov-klim@gmail.com', '7656-998213', '31a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('84a80fb6-2ca4-435c-8fb3-2215d145db41', 'Климов', 'Юрий', 'Юрьевич', '89123456789', 'klimov-yra@gmail.com',
        '7656-998473', '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('84a10fb6-2ca4-435c-8fb3-2215d145db41', 'Климов', 'Николай', 'Денисович', '89123456789',
        'klimov-nikolay@gmail.com', '7656-998573', '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('84a20fb6-2ca4-435c-8fb3-2215d145db41', 'Климов', 'Максим', 'Денисович', '89123456789',
        'klimov-maxim@gmail.com', '7656-998673', '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('84a80fb6-2ca4-435c-8fb3-5215d145db41', 'Климов', 'Святослав', 'Олегович', '89123456789',
        'klimov-svyat@gmail.com', '7656-998773', '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('84a80fb6-3ca4-435c-8fb3-7215d145db41', 'Климов', 'Вася', 'Леонидович', '89123456789', 'klimov-vasya@gmail.com',
        '7656-998873', '41a80fb6-1ca4-435c-8fb3-2215d145db41'),
       ('84a80fb6-2ca4-435c-8fb3-8215d145db41', 'Климов', 'Димка', 'Сергеевич', '89123456789',
        'klimov-dmitry@gmail.com', '7656-998973', '41a80fb6-1ca4-435c-8fb3-2215d145db41');

CREATE TABLE OFFER_OF_CREDIT
(
    OFFER_OF_CREDIT_ID uuid not null,
    NAME_OF_CREDIT     varchar(255),
    SUM_OF_CREDIT      numeric(19, 2),
    CREDIT_TERM        integer,
    FIRST_PAYMENT      numeric(19, 2),
    SUM_OF_PERCENT     numeric(19, 2),
    PRIMARY KEY (OFFER_OF_CREDIT_ID),
    BANK_ID            uuid
        CONSTRAINT FK_CREDIT_OFFER_BANK_ID REFERENCES BANK (BANK_ID),
    CLIENT_ID          uuid
        CONSTRAINT FK_CREDIT_OFFER_CLIENT_ID REFERENCES CLIENT (CLIENT_ID),
    CREDIT_ID          uuid
        CONSTRAINT FK_CREDIT_OFFER_CREDIT_ID REFERENCES CREDIT (CREDIT_ID)
);
INSERT INTO OFFER_OF_CREDIT(OFFER_OF_CREDIT_ID, NAME_OF_CREDIT, SUM_OF_CREDIT, CREDIT_TERM, FIRST_PAYMENT,
                            SUM_OF_PERCENT, BANK_ID, CREDIT_ID, CLIENT_ID)

values ('91a80fb6-1ca4-435c-8fb3-2216d145db41', 'Первый', 100500, 4, 10, 8, '11a80fb6-1ca4-435c-8fb3-2215d145db41',
        '51a10fb6-1ca7-435c-8fb3-2215d145db41', '91a80fb6-1ca4-435c-8fb3-3215d145db41'),
       ('62a80fb6-1ca4-435c-8fb3-2217d145db41', 'Второй', 150100, 4, 10, 30, '21a80fb6-1ca4-435c-8fb3-2215d145db41',
        '81a80fb6-1ca4-435c-8fb3-2815d145db41', '62a80fb6-1ca4-435c-8fb3-2815d145db41'),
       ('73a80fb6-1ca4-435c-8fb3-2218d145db41', 'Третий', 150600, 4, 10, 15, '31a80fb6-1ca4-435c-8fb3-2215d145db41',
        '71a80fb6-1ca4-435c-8fb3-2215d115db41', '73a60fb6-1ca4-435c-8fb3-8215d145db41'),
       ('84a80fb6-1ca4-435c-8fb3-2219d145db41', 'Четвертый', 180400, 4, 10, 6, '41a80fb6-1ca4-435c-8fb3-2215d145db41',
        '81a50fb6-1ca4-435c-8fb3-2215d145db41', '84a80fb6-2ca4-435c-8fb3-8215d145db41');


create table SCHEDULE_OF_PAYMENT
(
    SCHEDULE_OF_PAYMENT_ID      uuid,
    AMOUNT_OF_PAYMENT_PER_BODY  numeric(19, 2),
    AMOUNT_OF_REPAYMENT_PERCENT numeric(19, 2),
    AMOUNT_OF_PAYMENT           numeric(19, 2),
    DATE_OF_PAYMENT             date,
    BALANCE                     numeric(19, 2),
    PRIMARY KEY (SCHEDULE_OF_PAYMENT_ID),
    OFFER_OF_CREDIT_ID          uuid
        CONSTRAINT FK_CREDIT_OFFER_ID REFERENCES Offer_of_credit (OFFER_OF_CREDIT_ID)

);
INSERT INTO SCHEDULE_OF_PAYMENT(SCHEDULE_OF_PAYMENT_ID, AMOUNT_OF_PAYMENT_PER_BODY, AMOUNT_OF_REPAYMENT_PERCENT,
                                AMOUNT_OF_PAYMENT, DATE_OF_PAYMENT, BALANCE, OFFER_OF_CREDIT_ID)

values ('91a70fb6-1ca4-435c-8fb3-2216d145db41', 10000, 5000, 15000, DATE '2020-04-01', 15000,
        '91a80fb6-1ca4-435c-8fb3-2216d145db41'),
       ('91a70fb6-1ca4-435c-8fb3-2216d115db42', 10000, 5000, 15000, DATE '2020-04-02', 0,
        '91a80fb6-1ca4-435c-8fb3-2216d145db41'),
       ('62a70fb6-1ca4-435c-8fb3-2217d195db41', 10000, 5000, 15000, DATE '2020-04-01', 15000,
        '62a80fb6-1ca4-435c-8fb3-2217d145db41'),
       ('62a70fb6-1ca4-435c-8fb3-2217d175db44', 10000, 5000, 15000, DATE '2020-04-02', 0,
        '62a80fb6-1ca4-435c-8fb3-2217d145db41'),
       ('73a70fb6-1ca4-435c-8fb3-2218d145db41', 10000, 5000, 15000, DATE '2020-04-01', 15000,
        '73a80fb6-1ca4-435c-8fb3-2218d145db41'),
       ('73a70fb6-1ca4-435c-8fb3-2218d155db49', 10000, 5000, 15000, DATE '2020-04-02', 0,
        '73a80fb6-1ca4-435c-8fb3-2218d145db41'),
       ('84a30fb6-1ca4-435c-8fb3-2219d135db41', 10000, 5000, 15000, DATE '2020-04-01', 15000,
        '84a80fb6-1ca4-435c-8fb3-2219d145db41'),
       ('84a30fb6-1ca4-435c-8fb3-2219d145db44', 10000, 5000, 15000, DATE '2020-04-02', 0,
        '84a80fb6-1ca4-435c-8fb3-2219d145db41');