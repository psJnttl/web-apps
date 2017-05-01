CREATE TABLE employee (
    id           BIGSERIAL PRIMARY KEY,
    first_name   VARCHAR(100),
    family_name  VARCHAR(100),
    city         VARCHAR(100),
    employer     VARCHAR(100),
    title        VARCHAR(100),
    salary DOUBLE PRECISION
);
CREATE TABLE employer (
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(100),
    y_code        VARCHAR(100)
);
