CREATE TABLE IF NOT EXISTS postings (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    company TEXT NOT NULL,
    position TEXT NOT NULL,
    location TEXT NOT NULL,
    "desc" TEXT NOT NULL,
    exp TEXT NOT NULL,
    industry TEXT NOT NULL,
    date DATE NOT NULL,
    benefits TEXT,
    logo TEXT NOT NULL,
    qualifications TEXT,
    hireSite TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS comments (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    comment TEXT NOT NULL,
    date DATE NOT NULL,
    postId INTEGER REFERENCES postings
);

ALTER TABLE postings OWNER TO "bcca";
GRANT ALL ON TABLE postings TO "bcca";
ALTER TABLE comments OWNER TO "bcca";
GRANT ALL ON TABLE comments TO "bcca";
GRANT ALL PRIVILEGES ON DATABASE "bcca-employment" TO "bcca";