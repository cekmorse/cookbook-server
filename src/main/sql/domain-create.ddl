USE cookbook;
CREATE TABLE recipe (
  id        VARCHAR(255) NOT NULL,
  name      VARCHAR(255) NOT NULL,
  createdAt DATETIME,
  updatedAt DATETIME,
  author    VARCHAR(255),
  sourceDoc VARCHAR(255),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;