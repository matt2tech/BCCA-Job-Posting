CREATE TABLE IF NOT EXISTS postings (
    id SERIAL PRIMARY KEY,
    name TEXT,
    company TEXT,
    position TEXT,
    location TEXT,
    desc TEXT,
    exp TEXT,
    employment TEXT,
    benefits TEXT,
    logo URL,
)