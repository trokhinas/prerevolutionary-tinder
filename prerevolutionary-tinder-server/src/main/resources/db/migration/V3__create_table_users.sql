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