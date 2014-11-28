--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-11-27 21:50:21

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
-- TOC entry 170 (class 1259 OID 16395)
-- Name: charla; Type: TABLE; Schema: public; Owner: sis2; Tablespace: 
--

CREATE TABLE charla (
    "idCharla" integer NOT NULL,
    horario time with time zone,
    fecha date,
    aula text,
    expositor integer,
    colaborador integer,
    tema text
);


ALTER TABLE public.charla OWNER TO sis2;

--
-- TOC entry 1949 (class 0 OID 16395)
-- Dependencies: 170
-- Data for Name: charla; Type: TABLE DATA; Schema: public; Owner: sis2
--

COPY charla ("idCharla", horario, fecha, aula, expositor, colaborador, tema) FROM stdin;
\.


-- Completed on 2014-11-27 21:50:21

--
-- PostgreSQL database dump complete
--

