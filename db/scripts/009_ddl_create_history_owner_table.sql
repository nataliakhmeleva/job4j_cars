create table history_owner
(
    id serial   primary key,
    startAt     TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    endAt       TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    driver_id   int not null references driver(id),
    car_id      int not null references car(id)
);