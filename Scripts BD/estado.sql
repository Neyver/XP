--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-11-27 21:47:55

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
-- TOC entry 171 (class 1259 OID 16401)
-- Name: estado; Type: TABLE; Schema: public; Owner: sis2; Tablespace: 
--

CREATE TABLE estado (
    "idEstado" integer NOT NULL,
    "nombreEstado" text
);


ALTER TABLE public.estado OWNER TO sis2;

--
-- TOC entry 1949 (class 0 OID 16401)
-- Dependencies: 171
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: sis2
--

COPY estado ("idEstado", "nombreEstado") FROM stdin;
1	Malo
2	Regular
3	Bueno
\.


-- Completed on 2014-11-27 21:47:55

--
-- PostgreSQL database dump complete
--

