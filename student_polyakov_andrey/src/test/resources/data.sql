INSERT INTO classifiers(title, description)
VALUES('RISK_TYPE', 'Risk type classifier');

INSERT INTO classifiers(title, description)
VALUES('COUNTRY', 'Country classifier');

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'TRAVEL_MEDICAL',
    'Medical risk during travel'
FROM classifiers as cl
WHERE cl.title = 'RISK_TYPE';


INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'TRAVEL_CANCELLATION',
    'Trip cancellation risk during travel'
FROM classifiers as cl
WHERE cl.title = 'RISK_TYPE';


INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'TRAVEL_LOSS_BAGGAGE',
    'Baggage lose risk type'
FROM classifiers as cl
WHERE cl.title = 'RISK_TYPE';


INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'TRAVEL_THIRD_PARTY_LIABILITY',
    'Third party liability risk during travel'
FROM classifiers as cl
WHERE cl.title = 'RISK_TYPE';


INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'TRAVEL_EVACUATION',
    'Evacuation risk during travel'
FROM classifiers as cl
WHERE cl.title = 'RISK_TYPE';


INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'TRAVEL_SPORT_ACTIVITIES',
    'Sport activities risk during travel'
FROM classifiers as cl
WHERE cl.title = 'RISK_TYPE';

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'LATVIA',
    'Country Latvia'
FROM classifiers as cl
WHERE cl.title = 'COUNTRY';

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'SPAIN',
    'Country Spain'
FROM classifiers as cl
WHERE cl.title = 'COUNTRY';

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'JAPAN',
    'Country Japan'
FROM classifiers as cl
WHERE cl.title = 'COUNTRY';


INSERT INTO country_default_day_rate(country_ic, default_day_rate)
VALUES('LATVIA', 1.00);

INSERT INTO country_default_day_rate(country_ic, default_day_rate)
VALUES('SPAIN', 2.50);

INSERT INTO country_default_day_rate(country_ic, default_day_rate)
VALUES('JAPAN', 3.50);


INSERT INTO age_coefficient(age_from, age_to, coefficient)
VALUES(0, 5, 1.1);

INSERT INTO age_coefficient(age_from, age_to, coefficient)
VALUES(6, 10, 0.7);

INSERT INTO age_coefficient(age_from, age_to, coefficient)
VALUES(11, 17, 1.0);

INSERT INTO age_coefficient(age_from, age_to, coefficient)
VALUES(18, 40, 1.1);

INSERT INTO age_coefficient(age_from, age_to, coefficient)
VALUES(41, 65, 1.2);

INSERT INTO age_coefficient(age_from, age_to, coefficient)
VALUES(65, 150, 1.5);


INSERT INTO classifiers(title, description)
VALUES('MEDICAL_RISK_LIMIT_LEVEL', 'Medical Risk limit level classifier');

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'LEVEL_10000',
    'Medical Risk 10000 euro limit level'
FROM classifiers as cl
WHERE cl.title = 'MEDICAL_RISK_LIMIT_LEVEL';

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'LEVEL_15000',
    'Medical Risk 15000 euro limit level'
FROM classifiers as cl
WHERE cl.title = 'MEDICAL_RISK_LIMIT_LEVEL';

INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'LEVEL_20000',
    'Medical Risk 20000 euro limit level'
FROM classifiers as cl
WHERE cl.title = 'MEDICAL_RISK_LIMIT_LEVEL';


INSERT INTO classifier_values(
    classifier_id,
    ic,
    description)
SELECT
    cl.id,
    'LEVEL_50000',
    'Medical Risk 50000 euro limit level'
FROM classifiers as cl
WHERE cl.title = 'MEDICAL_RISK_LIMIT_LEVEL';