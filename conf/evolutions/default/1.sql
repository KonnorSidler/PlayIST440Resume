# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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

create table resume (
  resume_id                     bigint auto_increment not null,
  resume_s3_path                varchar(255),
  resume_upload_date            timestamp,
  constraint pk_resume primary key (resume_id)
);

create table user_account (
  user_id                       bigint auto_increment not null,
  user_email                    varchar(255),
  user_name                     varchar(255),
  constraint pk_user_account primary key (user_id)
);


# --- !Downs

drop table if exists company;

drop table if exists database_test;

drop table if exists favorite_map;

drop table if exists resume;

drop table if exists user_account;

