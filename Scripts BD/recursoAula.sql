--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-11-27 21:49:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 174 (class 1259 OID 16419)
-- Name: recursoAula; Type: TABLE; Schema: public; Owner: sis2; Tablespace: 
--

CREATE TABLE "recursoAula" (
    "idAula" integer NOT NULL,
    "nombreAula" text,
    "disponAula" integer,
    "costoAula" double precision,
    "origenAula" integer,
    "listaRecursos" integer
);


ALTER TABLE public."recursoAula" OWNER TO sis2;

--
-- TOC entry 1949 (class 0 OID 16419)
-- Dependencies: 174
-- Data for Name: recursoAula; Type: TABLE DATA; Schema: public; Owner: sis2
--

COPY "recursoAula" ("idAula", "nombreAula", "disponAula", "costoAula", "origenAula", "listaRecursos") FROM stdin;
\.


-- Completed on 2014-11-27 21:49:14

--
-- PostgreSQL database dump complete
--

