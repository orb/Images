CREATE TABLE images (
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   content_type VARCHAR NOT NULL,
   content bytea);
   