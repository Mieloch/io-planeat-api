CREATE TABLE recipes (
  `id`                      BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(255) NOT NULL,
  `prepare_time_minutes`           TIMESTAMP    NOT NULL DEFAULT now(),
  `difficulty`        VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)