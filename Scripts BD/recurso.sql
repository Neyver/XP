--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-11-27 21:48:46

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
-- TOC entry 173 (class 1259 OID 16413)
-- Name: recurso; Type: TABLE; Schema: public; Owner: sis2; Tablespace: 
--

CREATE TABLE recurso (
    "idRecurso" integer NOT NULL,
    "nobreRecurso" text,
    "estadoRecurso" integer,
    disponibilidad integer,
    "costoRecurso" double precision,
    "origenRecurso" integer
);


ALTER TABLE public.recurso OWNER TO sis2;

--
-- TOC entry 1949 (class 0 OID 16413)
-- Dependencies: 173
-- Data for Name: recurso; Type: TABLE DATA; Schema: public; Owner: sis2
--

COPY recurso ("idRecurso", "nobreRecurso", "estadoRecurso", disponibilidad, "costoRecurso", "origenRecurso") FROM stdin;
\.


-- Completed on 2014-11-27 21:48:46

--
-- PostgreSQL database dump complete
--

