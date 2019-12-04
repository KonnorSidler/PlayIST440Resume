# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table clubs (
  club_id                       bigint auto_increment not null,
  linked_resume                 bigint not null,
  club_name                     varchar(255),
  club_description              varchar(255),
  constraint pk_clubs primary key (club_id)
);

create table company (
  company_id                    bigint auto_increment not null,
  company_name                  varchar(255),
  constraint pk_company primary key (company_id)
);

create table database_test (
  id                            bigint auto_increment not null,
  database_message              varchar(255),
  constraint pk_database_test primary key (id)
);

create table favorite_map (
);

create table interning (
  internship_id                 bigint auto_increment not null,
  linked_resume                 bigint not null,
  intern_company                varchar(255),
  position                      varchar(255),
  description                   varchar(255),
  constraint pk_interning primary key (internship_id)
);

create table resume (
  resume_id                     bigint auto_increment not null,
  company_id                    bigint not null,
  constraint pk_resume primary key (resume_id)
);

create table resume_pdf (
  pdf_id                        bigint auto_increment not null,
  linked_resume                 bigint not null,
  bucket_name                   varchar(255),
  key_name                      varchar(255),
  pdf_awspath                   varchar(255),
  constraint pk_resume_pdf primary key (pdf_id)
);

create table schooling (
  school_id                     bigint auto_increment not null,
  linked_resume                 bigint not null,
  school_name                   varchar(255),
  major                         varchar(255),
  constraint pk_schooling primary key (school_id)
);

create table skills (
  skills_id                     bigint auto_increment not null,
  linked_resume                 bigint not null,
  skill_field                   varchar(255),
  constraint pk_skills primary key (skills_id)
);

create table user_account (
  user_id                       bigint auto_increment not null,
  user_email                    varchar(255),
  user_name                     varchar(255),
  constraint pk_user_account primary key (user_id)
);


# --- !Downs

drop table if exists clubs;

drop table if exists company;

drop table if exists database_test;

drop table if exists favorite_map;

drop table if exists interning;

drop table if exists resume;

drop table if exists resume_pdf;

drop table if exists schooling;

drop table if exists skills;

drop table if exists user_account;

