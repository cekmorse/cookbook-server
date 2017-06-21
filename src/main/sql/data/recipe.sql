BEGIN;
INSERT INTO recipe (id, name, createdAt, updatedAt, author, sourceDoc) VALUES ('6afe78ce-a44f-48c1-9f8e-de361d918ee3', 'Sample #1', '2016-05-19 13:27:16', '2016-05-19 13:27:16', 'BillyBob', 'Mother Goose');
INSERT INTO recipe (id, name, createdAt, updatedAt, author, sourceDoc) VALUES ('442e9bb9-9620-45ce-84f6-b4a69d62eb2c', 'Sample #2', '2016-05-20 13:27:16', '2016-05-20 13:27:16', 'Joe', 'Crab Shack');
COMMIT;