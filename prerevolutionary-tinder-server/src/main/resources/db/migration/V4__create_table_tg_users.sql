CREATE TABLE IF NOT EXISTS "tg_users" (
  "id" uuid,
  "telegram_id" varchar,
  PRIMARY KEY ("id", "telegram_id")
);

CREATE INDEX ON "tg_users" ("telegram_id");

ALTER TABLE "tg_users" ADD FOREIGN KEY ("id") REFERENCES "users" ("id");