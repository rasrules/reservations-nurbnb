CREATE TYPE IF NOT EXISTS "reservation_status" AS ENUM (
  'PENDING',
  'CONFIRMED',
  'TERMINATED',
  'CANCELLED'
);

CREATE TYPE IF NOT EXISTS "reservation_payment_type" AS ENUM (
  'CASH',
  'UNDEFINED',
  'CREDIT'
);

CREATE TABLE IF NOT EXISTS "client" (
  "client_id" varchar(80) PRIMARY KEY,
  "name" varchar(80),
  "email" varchar(150)
);

CREATE TABLE IF NOT EXISTS "reservation" (
  "reservation_id" BIGINT PRIMARY KEY,
  "reservation_number" VARCHAR(255) UNIQUE NOT NULL,
  "created_at" DATE NOT NULL,
  "start_date" DATE NOT NULL
  "end_date" DATE NOT NULL
  "status" reservation_status,
  "payment_type" reservation_payment_type,
  "client_id" varchar(80),
  "lodging_id" varchar(80)
);

CREATE TABLE IF NOT EXISTS "lodging" (
  "lodging_id" varchar(80),
  "dateExecuted" DATE NOT NULL,
  "lodgingData" varchar(255)
);

ALTER TABLE "reservation" ADD FOREIGN KEY ("client_id") REFERENCES "client" ("client_id");

ALTER TABLE "reservation" ADD FOREIGN KEY ("lodging_id") REFERENCES "lodging" ("lodging_id");
