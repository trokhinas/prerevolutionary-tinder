CREATE TYPE "preferences_type" AS ENUM (
  'male',
  'female',
  'any'
);

CREATE TYPE "gender_type" AS ENUM (
  'male',
  'female'
);

CREATE TABLE IF NOT EXISTS "users" (
  "id" uuid PRIMARY KEY,
  "gender" gender_type NOT NULL,
  "name" varchar(50) NOT NULL,
  "header" varchar(50) NOT NULL,
  "description" varchar(500),
  "preferences" preferences_type NOT NULL DEFAULT 'any',
  "created_at" timestamptz,
  "updated_at" timestamptz
);

CREATE TABLE IF NOT EXISTS "tg_users" (
  "id" uuid,
  "telegram_id" varchar,
  PRIMARY KEY ("id", "telegram_id")
);

CREATE TABLE IF NOT EXISTS "likes" (
  "initiator_id" uuid,
  "target_id" uuid,
  PRIMARY KEY ("initiator_id", "target_id")
);

CREATE INDEX ON "tg_users" ("telegram_id");

ALTER TABLE "tg_users" ADD FOREIGN KEY ("id") REFERENCES "users" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("initiator_id") REFERENCES "users" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("target_id") REFERENCES "users" ("id");