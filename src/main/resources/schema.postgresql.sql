CREATE TABLE IF NOT EXISTS postings (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    company TEXT NOT NULL,
    position TEXT NOT NULL,
    location TEXT NOT NULL,
    desc TEXT NOT NULL,
    exp TEXT NOT NULL,
    industry TEXT NOT NULL,
    benefits TEXT,
    logo URL,
    qualifications TEXT,

)