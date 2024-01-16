DROP TABLE IF EXISTS sensor, parameter, sensor_data;

CREATE TABLE sensor (
    sensor_id SERIAL PRIMARY KEY,
    sensor_name TEXT NOT NULL,
    is_active BOOLEAN NOT NULL,
    sensor_description TEXT NOT NULL
);

CREATE TABLE parameter (
    parameter_id SERIAL PRIMARY KEY,
    sensor_name TEXT NOT NULL
);

CREATE TABLE sensor_data (
    id SERIAL PRIMARY KEY,
    sensor_id INTEGER NOT NULL,
    parameter_id INTEGER NOT NULL,
    Month INTEGER NOT NULL,
    Year INTEGER NOT NULL,
    pH DECIMAL NOT NULL,
    Pb_mg DECIMAL NOT NULL,
    Mn_mg DECIMAL NOT NULL,
    Cu_mg DECIMAL NOT NULL,
	Fe_mg DECIMAL NOT NULL
);