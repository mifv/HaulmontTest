CREATE TABLE Bank (
                      bank_id uuid,
                      bank_name varchar(255),
                      PRIMARY KEY (bank_id)
);


create table Credit (
                        credit_id uuid not null,
                        type_of_credit varchar(255),
                        limit_of_money numeric(19, 2),
                        credit_percentage numeric(19, 2),
                        PRIMARY KEY (credit_id),
                        bank_id uuid
                        CONSTRAINT FK_CREDIT_BANK_ID REFERENCES BANK(BANK_ID)

);

CREATE TABLE Client (
                        client_id uuid,
                        last_name varchar(255),
                        first_name varchar(255),
                        middle_name varchar(255),
                        phone_number varchar(255),
                        email varchar(255),
                        passport_number varchar(255),
                        PRIMARY KEY (client_id),
                        bank_id uuid
                        CONSTRAINT fk_client_bank_id REFERENCES BANK(BANK_ID)


);


create table Offer_of_credit (
                                 offer_of_credit_id uuid not null,
                                 name_of_credit varchar(255),
                                 sum_of_credit numeric(19, 2),
                                 credit_term integer,
                                 first_payment numeric(19, 2),
                                 sum_of_percent numeric(19, 2),
                                 PRIMARY KEY (offer_of_credit_id),
                                 Bank_id uuid
                                     CONSTRAINT FK_CREDIT_OFFER_BANK_ID REFERENCES BANK(BANK_ID),
                                 Client_id uuid
                                     CONSTRAINT FK_CREDIT_OFFER_CLIENT_ID REFERENCES CLIENT(CLIENT_ID),
                                 Credit_id uuid
                                     CONSTRAINT FK_CREDIT_OFFER_CREDIT_ID REFERENCES CREDIT(CREDIT_ID)

);

create table Schedule_of_payment (
                                     schedule_of_payment_id uuid,
                                     amount_of_payment_per_body numeric(19, 2),
                                     amount_of_repayment_percent numeric(19, 2),
                                     amount_of_payment numeric(19, 2),
                                     date_of_payment date,
                                     balance numeric(19, 2),
                                     PRIMARY KEY (schedule_of_payment_id),
                                     offer_of_credit_id uuid
                                         CONSTRAINT FK_CREDIT_OFFER_ID REFERENCES Offer_of_credit(offer_of_credit_id)

);