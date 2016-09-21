--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-09-21 09:38:15

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2188 (class 1262 OID 81922)
-- Name: dreams_job; Type: DATABASE; Schema: -; Owner: dreams_job
--

CREATE DATABASE dreams_job WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE dreams_job OWNER TO dreams_job;

\connect dreams_job

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 98463)
-- Name: comments; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE comments (
    id integer NOT NULL,
    projects_id bigint NOT NULL,
    created timestamp(0) without time zone DEFAULT now(),
    author_id bigint NOT NULL,
    title character varying(255),
    description text,
    comment_id bigint NOT NULL,
    status character varying(10)
);


ALTER TABLE comments OWNER TO dreams_job;

--
-- TOC entry 187 (class 1259 OID 98484)
-- Name: comments_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE comments_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_comment_id_seq OWNER TO dreams_job;

--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 187
-- Name: comments_comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE comments_comment_id_seq OWNED BY comments.comment_id;


--
-- TOC entry 185 (class 1259 OID 98461)
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO dreams_job;

--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 185
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- TOC entry 189 (class 1259 OID 98501)
-- Name: messages; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE messages (
    id integer NOT NULL,
    author_id bigint NOT NULL,
    title character varying(255) NOT NULL,
    description text,
    reader_id bigint NOT NULL,
    status character varying(10)
);


ALTER TABLE messages OWNER TO dreams_job;

--
-- TOC entry 188 (class 1259 OID 98499)
-- Name: messages_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE messages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE messages_id_seq OWNER TO dreams_job;

--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 188
-- Name: messages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE messages_id_seq OWNED BY messages.id;


--
-- TOC entry 184 (class 1259 OID 98451)
-- Name: projects; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE projects (
    id integer NOT NULL,
    user_id bigint NOT NULL,
    title character varying(255) NOT NULL,
    description text,
    created timestamp without time zone DEFAULT now(),
    status character varying(10),
    update timestamp(0) without time zone DEFAULT now() NOT NULL
);


ALTER TABLE projects OWNER TO dreams_job;

--
-- TOC entry 183 (class 1259 OID 98449)
-- Name: project_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE project_id_seq OWNER TO dreams_job;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 183
-- Name: project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE project_id_seq OWNED BY projects.id;


--
-- TOC entry 197 (class 1259 OID 99795)
-- Name: project_image; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE project_image (
    id integer NOT NULL,
    project_id bigint,
    big character varying(255),
    small character varying(255),
    status character varying(255),
    created timestamp(0) without time zone DEFAULT now(),
    user_id bigint
);
ALTER TABLE ONLY project_image ALTER COLUMN id SET STATISTICS 0;


ALTER TABLE project_image OWNER TO dreams_job;

--
-- TOC entry 196 (class 1259 OID 99793)
-- Name: project_image_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE project_image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE project_image_id_seq OWNER TO dreams_job;

--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 196
-- Name: project_image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE project_image_id_seq OWNED BY project_image.id;


--
-- TOC entry 195 (class 1259 OID 98841)
-- Name: project_reply; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE project_reply (
    id integer NOT NULL,
    project_id bigint NOT NULL,
    reply text NOT NULL,
    user_id bigint NOT NULL,
    parent_id bigint,
    reader_id bigint NOT NULL,
    status character varying(10)
);


ALTER TABLE project_reply OWNER TO dreams_job;

--
-- TOC entry 194 (class 1259 OID 98839)
-- Name: project_reply_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE project_reply_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE project_reply_id_seq OWNER TO dreams_job;

--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 194
-- Name: project_reply_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE project_reply_id_seq OWNED BY project_reply.id;


--
-- TOC entry 191 (class 1259 OID 98699)
-- Name: roles; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE roles OWNER TO dreams_job;

--
-- TOC entry 190 (class 1259 OID 98697)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE roles_id_seq OWNER TO dreams_job;

--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 190
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 182 (class 1259 OID 98433)
-- Name: users; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE users (
    id integer NOT NULL,
    login character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    created timestamp without time zone DEFAULT now(),
    status character varying(10),
    big_image character varying(255),
    small_image character varying(255)
);


ALTER TABLE users OWNER TO dreams_job;

--
-- TOC entry 181 (class 1259 OID 98431)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO dreams_job;

--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 181
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 193 (class 1259 OID 98709)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: dreams_job
--

CREATE TABLE users_roles (
    id integer NOT NULL,
    "user" bigint NOT NULL,
    role character varying(20) NOT NULL
);


ALTER TABLE users_roles OWNER TO dreams_job;

--
-- TOC entry 192 (class 1259 OID 98707)
-- Name: users_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: dreams_job
--

CREATE SEQUENCE users_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_roles_id_seq OWNER TO dreams_job;

--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 192
-- Name: users_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dreams_job
--

ALTER SEQUENCE users_roles_id_seq OWNED BY users_roles.id;


--
-- TOC entry 2036 (class 2604 OID 98466)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- TOC entry 2038 (class 2604 OID 98486)
-- Name: comment_id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY comments ALTER COLUMN comment_id SET DEFAULT nextval('comments_comment_id_seq'::regclass);


--
-- TOC entry 2039 (class 2604 OID 98504)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY messages ALTER COLUMN id SET DEFAULT nextval('messages_id_seq'::regclass);


--
-- TOC entry 2043 (class 2604 OID 99798)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY project_image ALTER COLUMN id SET DEFAULT nextval('project_image_id_seq'::regclass);


--
-- TOC entry 2042 (class 2604 OID 98844)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY project_reply ALTER COLUMN id SET DEFAULT nextval('project_reply_id_seq'::regclass);


--
-- TOC entry 2033 (class 2604 OID 98454)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY projects ALTER COLUMN id SET DEFAULT nextval('project_id_seq'::regclass);


--
-- TOC entry 2040 (class 2604 OID 98702)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2031 (class 2604 OID 98436)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2041 (class 2604 OID 98712)
-- Name: id; Type: DEFAULT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY users_roles ALTER COLUMN id SET DEFAULT nextval('users_roles_id_seq'::regclass);


--
-- TOC entry 2054 (class 2606 OID 98472)
-- Name: comments_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- TOC entry 2056 (class 2606 OID 98509)
-- Name: messages_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 99804)
-- Name: project_image_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY project_image
    ADD CONSTRAINT project_image_pkey PRIMARY KEY (id);


--
-- TOC entry 2052 (class 2606 OID 98460)
-- Name: project_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 98849)
-- Name: project_reply_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY project_reply
    ADD CONSTRAINT project_reply_pkey PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 98706)
-- Name: roles_name_key; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_name_key UNIQUE (name);


--
-- TOC entry 2060 (class 2606 OID 98704)
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2046 (class 2606 OID 98446)
-- Name: users_email_key; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 2048 (class 2606 OID 98444)
-- Name: users_login_key; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_login_key UNIQUE (login);


--
-- TOC entry 2050 (class 2606 OID 98442)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 98714)
-- Name: users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 98479)
-- Name: comments_fk; Type: FK CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_fk FOREIGN KEY (projects_id) REFERENCES projects(id);


--
-- TOC entry 2069 (class 2606 OID 98494)
-- Name: comments_fk1; Type: FK CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_fk1 FOREIGN KEY (comment_id) REFERENCES comments(id);


--
-- TOC entry 2067 (class 2606 OID 98474)
-- Name: project_fk; Type: FK CONSTRAINT; Schema: public; Owner: dreams_job
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT project_fk FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-09-21 09:38:15

--
-- PostgreSQL database dump complete
--

