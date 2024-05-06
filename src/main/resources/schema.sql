
create table BRANDS(
  ID int not null,
  NAME varchar(80) not null,
  PRIMARY KEY ( ID )
);

create table PRODUCTS(
  ID int not null,
  NAME varchar(80) not null,
  PRIMARY KEY ( ID )
);

create table PRICES(
  BRAND_ID int not null,
  START_DATE TIMESTAMP not null,
  END_DATE TIMESTAMP not null,
  PRICE_LIST int not null AUTO_INCREMENT,
  PRODUCT_ID int not null,
  PRIORITY int not null,
  PRICE real not null,
  CURR varchar(3) not null,
  PRIMARY KEY ( PRICE_LIST )
);

 ALTER TABLE PRICES
    ADD FOREIGN KEY (BRAND_ID)
    REFERENCES BRANDS(ID);

 ALTER TABLE PRICES
    ADD FOREIGN KEY (PRODUCT_ID)
    REFERENCES PRODUCTS(ID);
