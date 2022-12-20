DROP TABLE Product;

create TABLE Product (
	ProductNo Integer,
	ProductName nvarchar(20), 
	Price INTEGER DEFAULT 0,
	CategoryNo INTEGER,
	 
	Constraint pk_Product PRIMARY KEY(ProductNo),
    CONSTRAINT fk_Product_Category FOREIGN KEY(CategoryNo) REFERENCES Category(CategoryNo)
		ON DELETE ON ACTION
 );