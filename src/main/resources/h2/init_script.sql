-- used for portal_db.mv.db file content

drop table if exists article;

create table article
(
    id                bigint auto_increment,
    title             varchar(80),
    description       varchar(200),
    content           varchar(2000),
    created_timestamp timestamp
);

insert into article (title, description, content, created_timestamp)
values ('Your most unhappy customers are your greatest source of learning.',
        'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.',
        'test', current_timestamp);

insert into article (title, description, content, created_timestamp)
values ('Your most unhappy customers are your greatest source of learning.',
        'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.',
        'test', current_timestamp);