create table book(
  id serial primary key not null,
  title varchar(256) not null,
  isbn varchar(32) not null,
  number_of_copies integer not null default 1
);

create table author(
  id serial primary key not null,
  firstname varchar(128) not null,
  lastname varchar(128) not null
);

create table book_author(
  book_id integer not null,
  author_id integer not null,
  primary key (book_id, author_id)
);

create table address(
	id serial primary key not null,
	street_and_number varchar(128) not null,
	city varchar(128) not null,
	postcode varchar(128) not null
);

create table member(
	id serial primary key not null,
	firstname varchar(128) not null,
	lastname varchar(128) not null,
	oib varchar(11) not null,
	date_of_birth timestamptz not null,
	address_id integer references address(id)
);

create table membership(
	id serial primary key not null,
	member_id integer not null references member(id),
	amount decimal(10,2) not null,
	created_at timestamptz not null default now(),
	valid_thru timestamptz not null
);

create table book_loan(
	id serial primary key not null,
	book_id integer not null references book(id),
	member_id integer not null references member(id),
	loaned_at timestamptz not null default now(),
	returned_at timestamptz
);
