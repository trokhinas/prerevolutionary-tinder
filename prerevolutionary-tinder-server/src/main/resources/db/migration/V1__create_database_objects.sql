CREATE TYPE "preferences_type" AS ENUM (
  'male',
  'female',
  'any'
);

CREATE TYPE "gender_type" AS ENUM (
  'male',
  'female'
);

CREATE TABLE "anketas" (
  "id" uuid PRIMARY KEY,
  "user_id" uuid,
  "gender" gender_type NOT NULL,
  "name" varchar(50) NOT NULL,
  "header" varchar(50) NOT NULL,
  "description" varchar(500),
  "preferences" preferences_type NOT NULL DEFAULT 'any',
  "created_at" timestamptz not null default now(),
  "updated_at" timestamptz not null default now()
);

CREATE TABLE "users" (
  "id" uuid PRIMARY KEY
);

CREATE TABLE "tg_users" (
  "id" uuid,
  "telegram_id" varchar,
  PRIMARY KEY ("id", "telegram_id")
);

CREATE TABLE "likes" (
  "initiator_id" uuid,
  "target_id" uuid,
  PRIMARY KEY ("initiator_id", "target_id")
);

CREATE INDEX ON "anketas" ("user_id");

CREATE INDEX ON "tg_users" ("telegram_id");

ALTER TABLE "anketas" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "tg_users" ADD FOREIGN KEY ("id") REFERENCES "users" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("initiator_id") REFERENCES "users" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("target_id") REFERENCES "users" ("id");