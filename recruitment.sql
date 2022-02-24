create table jobapplicant 
(
   applicantid          serial                        not null,
   name                 varchar(254)                   null,
   phone                varchar(254)                   null,
   email                varchar(254)                   null,
   password             varchar(254)                   null,
   dob                  timestamp                      null,
   status               varchar(254)                   null,
   city                 varchar(254)                   null,
   country              varchar(254)                   null,
   applicantImage       varchar(254)                   null, 
   constraint pk_jobapplicant primary key (applicantid)
);

create table company 
(
   companyid            serial                        not null,
   companyname          varchar(254)                   null,
   companypassword      varchar(254)                   null,
   companyemail         varchar(254)                   null,
   companyphone         varchar(254)                   null,
   companycity          varchar(254)                   null,
   companycountry       varchar(254)                   null,
   companylogin         varchar(254)                   null,
   companylocation      integer                        null,
   companydescription   integer                        null,
   companyImage         varchar(254)                    null,
   constraint pk_company primary key (companyid)
);

create table applicantcompany 
(
   applicantcategoryid  integer                        not null,
   companyid            integer                        not null,
   applicantid          serial                        not null,
   messages             varchar                        null,
   constraint pk_applicantcompany primary key (applicantcategoryid),
   constraint fk_applican_associati_jobappli foreign key (applicantid)
      references jobapplicant (applicantid)
        on update restrict
        on delete restrict,
   constraint fk_applican_associati_company foreign key (companyid)
      references company (companyid)
        on update restrict
        on delete restrict
);

create unique index applicantcompany_pk on applicantcompany (
applicantcategoryid asc
);

create index association5_fk on applicantcompany (
applicantid asc
);

create index association5_fk2 on applicantcompany (
companyid asc
);

create table joboffer 
(
   jobofferid           serial                        not null,
   companyid            integer                        not null,
   offername            varchar(254)                   null,
   jobofferImage        varchar(254)                   null,
   description          varchar(254)                   null,
   status               varchar(254)                   null,
   constraint pk_joboffer primary key (jobofferid),
   constraint fk_joboffer_associati_company foreign key (companyid)
      references company (companyid)
        on update restrict
        on delete restrict
);

create table applicantoffer 
(
   jobofferid           integer                        not null,
   applicantid          integer                        not null,
   constraint fk_applican_associati_jobappli foreign key (applicantid)
      references jobapplicant (applicantid)
        on update restrict
        on delete restrict,
   constraint fk_applican_associati_joboffer foreign key (jobofferid)
      references joboffer (jobofferid)
        on update restrict
        on delete restrict
);

create index association3_fk on applicantoffer (
applicantid asc
);

create index applicantoffer_fk on applicantoffer (
jobofferid asc
);

create unique index jobprovider_pk on company (
companyid asc
);

create unique index jobapplicant_pk on jobapplicant (
applicantid asc
);

create table jobapplication 
(
   jobappid             serial                        not null ,
   applicantid          integer                        not null,
   jobapptitle          varchar(254)                   null,
   jobappcv             varchar(254)                   null,
   jobappletter         varchar(254)                   null,
   jobappdate           timestamp                      null,
   jobappdocs           varchar(254)                   null,
   constraint pk_jobapplication primary key (jobappid),
   constraint fk_jobappli_associati_jobappli foreign key (applicantid)
      references jobapplicant (applicantid)
        on update restrict
        on delete restrict
);

create unique index jobapplication_pk on jobapplication (
jobappid asc
);

create index association4_fk on jobapplication (
applicantid asc
);

create table jobcategory 
(
   jobcategoryid        serial                        not null,
   jcname               varchar(254)                   null,
   jcdesc               varchar(254)                   null,
   constraint pk_jobcategory primary key (jobcategoryid)
);

create unique index jobcategory_pk on jobcategory (
jobcategoryid asc
);

create unique index joboffer_pk on joboffer (
jobofferid asc
);

create index association2_fk on joboffer (
companyid asc
);

create table "message" 
(
   messageid            serial                        not null,
   applicantcategoryid  integer                        null,
   messagecontent       varchar(254)                   null,
   constraint pk_message primary key (messageid),
   constraint fk_message_associati_applican foreign key (applicantcategoryid)
      references applicantcompany (applicantcategoryid)
        on update restrict
        on delete restrict
);

create unique index message_pk on "message" (
messageid asc
);

create index association10_fk on "message" (
applicantcategoryid asc
);

create table offercategoory 
(
   jobcategoryid        integer                        not null,
   jobofferid           integer                        not null,
   constraint fk_offercat_associati_joboffer foreign key (jobofferid)
      references joboffer (jobofferid)
        on update restrict
        on delete restrict,
   constraint fk_offercat_associati_jobcateg foreign key (jobcategoryid)
      references jobcategory (jobcategoryid)
        on update restrict
        on delete restrict
);

create index association6_fk on offercategoory (
jobofferid asc
);

create index association7_fk on offercategoory (
jobcategoryid asc
);

