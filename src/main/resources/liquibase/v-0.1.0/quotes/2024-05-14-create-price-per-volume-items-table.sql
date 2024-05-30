
create table price_per_volume_items
(
    uuid                        varchar                     not null,
    client_quote_id             varchar                     not null,
    min_volume                  decimal                     not null,
    max_volume                  decimal                     not null,
    bid                         decimal                     not null,
    ask                         decimal                     not null,

    primary key (uuid),
    foreign key (client_quote_id) references client_quotes(uuid)
);

alter table price_per_volume_items add constraint price_per_volume_items_min_volume_non_negative_constraint check (min_volume >= 0);
alter table price_per_volume_items add constraint price_per_volume_items_max_volume_non_negative_constraint check (max_volume >= 0);
alter table price_per_volume_items add constraint price_per_volume_items_uk_id_uuid_version unique (uuid);

commit;