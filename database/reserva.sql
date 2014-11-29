/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     20/11/2014 10:36:24 a.m.                     */
/*==============================================================*/


drop index RESERVA_PK;

drop table RESERVA;

/*==============================================================*/
/* Table: RESERVA                                               */
/*==============================================================*/
create table RESERVA (
   ID_PARTICIPANTE      INT4                 not null,
   ID_CONFERENCIA       INT4                 not null,
   FECHA                DATE                 not null,
   ESTADO               CHAR(30)             not null,
   constraint PK_RESERVA primary key (ID_PARTICIPANTE, ID_CONFERENCIA)
);

/*==============================================================*/
/* Index: RESERVA_PK                                            */
/*==============================================================*/
create unique index RESERVA_PK on RESERVA (
ID_PARTICIPANTE,
ID_CONFERENCIA
);

