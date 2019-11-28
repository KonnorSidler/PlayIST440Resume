# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table clubs (
  club_id                       bigserial not null,
  linked_resume                 bigint not null,
  club_name                     varchar(255),
  club_description              varchar(255),
  constraint pk_clubs primary key (club_id)
);

create table company (
  company_id                    bigserial not null,
  company_name                  varchar(255),
  constraint pk_company primary key (company_id)
);

create table database_test (
  id                            bigserial not null,
  database_message              varchar(255),
  constraint pk_database_test primary key (id)
);

create table favorite_map (
);

create table interning (
  internship_id                 bigserial not null,
  linked_resume                 bigint not null,
  intern_company                varchar(255),
  position                      varchar(255),
  description                   varchar(255),
  constraint pk_interning primary key (internship_id)
);

create table resume (
  resume_id                     bigserial not null,
  company_id                    bigint not null,
  constraint pk_resume primary key (resume_id)
);

create table schooling (
  school_id                     bigserial not null,
  linked_resume                 bigint not null,
  school_name                   varchar(255),
  major                         varchar(255),
  constraint pk_schooling primary key (school_id)
);

create table skills (
  skills_id                     bigserial not null,
  linked_resume                 bigint not null,
  skill_field                   varchar(255),
  constraint pk_skills primary key (skills_id)
);

create table user_account (
  user_id                       bigserial not null,
  user_email                    varchar(255),
  user_name                     varchar(255),
  constraint pk_user_account primary key (user_id)
);


# --- !Downs

drop table if exists clubs cascade;

drop table if exists company cascade;

drop table if exists database_test cascade;

drop table if exists favorite_map cascade;

drop table if exists interning cascade;

drop table if exists resume cascade;

drop table if exists schooling cascade;

drop table if exists skills cascade;

drop table if exists user_account cascade;

