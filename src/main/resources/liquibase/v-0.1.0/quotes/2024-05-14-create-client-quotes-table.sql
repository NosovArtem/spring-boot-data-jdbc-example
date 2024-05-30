
create table client_quotes
(
    uuid                    varchar                     not null,
    version                 bigint                      not null,
    trade_rule_id           varchar                     not null,
    market_quote_id         varchar                     not null,
    symbol                  varchar                     not null,
    date_time               varchar                     not null,

    primary key (uuid)
);

alter table client_quotes add constraint client_quotes_uk_id_uuid_version unique (uuid, version);
create index client_quotes_idx_symbol_date_time_quotes on client_quotes (symbol, date_time asc);

commit;