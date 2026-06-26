CREATE TABLE ids_schema.transaction_audit (

id BIGSERIAL PRIMARY KEY,

request_id varchar(100) NOT NULL,

correlation_id VARCHAR(100),

api_name VARCHAR(100),

status VARCHAR(50),

transaction_reference VARCHAR(100),

amount NUMERIC(18, 2),

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE ids_schema.request_log (

id BIGSERIAL PRIMARY KEY,

request_id VARCHAR(100),

channel_name VARCHAR(100),

endpoint VARCHAR(255),

request_payload TEXT,

response_payload TEXT,

status VARCHAR(50),

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE ids_schema.workflow_execution (

id BIGSERIAL PRIMARY KEY.

workflow_id VARCHAR(200),

workflow_name VARCHAR(200),

execution_status VARCHAR(50),

started_at TIMESTAMP,

completed_at TIMESTAMP

);