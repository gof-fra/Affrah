CREATE TABLE Category (
    id IDENTITY,
    name varchar(255),
    description varchar(255),
    image_url varchar(5),
    is_active BOOLEAN,
    
    CONSTRAINT pk_category_id PRIMARY KEY (id)
    
);