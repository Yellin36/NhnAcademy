ALTER TABLE Customer ENGINE=INNODB;

CREATE TABLE Orders (
        OrderNo int,
        OrderDate Date,
        CustomerNo int,
CONSTRAINT pk_Order PRIMARY KEY(OrderNo),
CONSTRAINT fk_Order_Customer FOREIGN KEY(CustomerNo) REFERENCES Customer(CustomerNo) );

CREATE TABLE OrderDetail ( ProductNo int, OrderNo int,
Quantity int,
        CONSTRAINT pk_OrderDetail PRIMARY KEY(ProductNo, OrderNo),
        CONSTRAINT fk_OrderDetail_Order FOREIGN KEY(OrderNo) REFERENCES Orders(OrderNo)
);
