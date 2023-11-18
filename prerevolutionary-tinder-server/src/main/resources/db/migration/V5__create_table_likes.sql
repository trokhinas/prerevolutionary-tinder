CREATE TABLE IF NOT EXISTS "likes" (
  "initiator_id" uuid,
  "target_id" uuid,
  PRIMARY KEY ("initiator_id", "target_id")
);

ALTER TABLE "likes" ADD FOREIGN KEY ("initiator_id") REFERENCES "users" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("target_id") REFERENCES "users" ("id");