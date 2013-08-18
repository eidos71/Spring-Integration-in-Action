-- ========================================================================
-- Copyright 2012 the original author or authors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--      http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- ========================================================================

drop table clubcalendars if exists;
drop table clubs if exists;

create table clubs (
  ID BIGINT NOT NULL PRIMARY KEY,
  NAME VARCHAR(100),
  BALANCE DECIMAL (8,2)
);

create table clubcalendars (
   ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
   PAYEE BIGINT NOT NULL,
   RECIPIENT BIGINT NOT NULL,
   AMOUNT DECIMAL (8,2),
   PAY_DATE DATE
);


INSERT INTO CLUBS (ID, NAME, BALANCE) VALUES (1, 'Club Zero', 0);
INSERT INTO CLUBS (ID, NAME, BALANCE) VALUES (2, 'Industry', 0);
INSERT INTO CLUBS (ID, NAME, BALANCE) VALUES (3, 'Energy', 0);
INSERT INTO CLUBS (ID, NAME, BALANCE) VALUES (4, 'Mishas Club', 0);
INSERT INTO CLUBS (ID, NAME, BALANCE) VALUES (5, 'Montecristo Await', 0);